package mainFrame.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import mainFrame.Controller.Objects.Account;
import mainFrame.Controller.Objects.Cart;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class Threading extends Thread {
    private final MongoClientSettings settings;
    private final List<Account> accounts;
    private final ObjectMapper mapper = new ObjectMapper();

    public Threading(MongoClientSettings settings, List<Account> accounts) {
        this.settings = settings;
        this.accounts = accounts;
    }

    @Override
    public void run() {
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("account");

            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String username = doc.getString("username");
                String name = doc.getString("name");
                String email = doc.getString("email");
                String password = doc.getString("password");

                List<Document> cartDocuments = (List<Document>) doc.get("cart");
                Cart[] carts = new Cart[cartDocuments.size()];
                for (int i = 0; i < cartDocuments.size(); i++) {
                    Document cartDoc = cartDocuments.get(i);
                    String cartName = cartDoc.getString("name");
                    String pathFile = cartDoc.getString("pathFile");
                    Integer quantity = cartDoc.getInteger("quantity");
                    Integer price = cartDoc.getInteger("price");
                    carts[i] = new Cart(cartName, pathFile, quantity, price);
                }

                Account account = new Account(username, name, email, password, carts);
                synchronized (accounts) {
                    accounts.add(account);
                }
            }

        } catch (Exception e) {
            System.err.println("Error retrieving accounts from MongoDB: " + e);
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public synchronized void addCartToAccount(String username, Cart newCart) {
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("account");

            for (Account account : accounts) {
                if (username.equals(account.getUsername())) {
                    Cart[] currentCarts = account.getCart();
                    if (currentCarts == null) {
                        currentCarts = new Cart[0];
                    }

                    boolean cartExists = false;
                    for (Cart cart : currentCarts) {
                        if (cart.getName().equals(newCart.getName())) {
                            cart.setQuantity(cart.getQuantity() + newCart.getQuantity());
                            cartExists = true;
                            break;
                        }
                    }

                    if (!cartExists) {
                        Cart[] updatedCarts = new Cart[currentCarts.length + 1];
                        System.arraycopy(currentCarts, 0, updatedCarts, 0, currentCarts.length);
                        updatedCarts[currentCarts.length] = newCart;
                        currentCarts = updatedCarts;
                    }

                    account.setCart(currentCarts);

                    // Update the account in the database
                    List<Document> cartDocuments = new ArrayList<>();
                    for (Cart cart : currentCarts) {
                        Document cartDoc = new Document("name", cart.getName())
                                .append("pathFile", cart.getPathFile())
                                .append("quantity", cart.getQuantity())
                                .append("price", cart.getPrice());
                        cartDocuments.add(cartDoc);
                    }
                    collection.updateOne(eq("username", username), set("cart", cartDocuments));
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error updating account in MongoDB: " + e);
        }
    }

    public synchronized void removeCartByName(String username, String cartName) {
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("account");

            for (Account account : accounts) {
                if (username.equals(account.getUsername())) {
                    Cart[] currentCarts = account.getCart();
                    if (currentCarts == null) {
                        return; // No carts to remove
                    }

                    List<Cart> updatedCarts = new ArrayList<>();
                    boolean cartRemoved = false;
                    for (Cart cart : currentCarts) {
                        if (cart.getName().equals(cartName)) {
                            cartRemoved = true;
                            // Skip adding this cart to updatedCarts
                        } else {
                            updatedCarts.add(cart);
                        }
                    }

                    if (cartRemoved) {
                        // Update account with updated cart list
                        account.setCart(updatedCarts.toArray(new Cart[0]));

                        // Update the account in the database
                        List<Document> cartDocuments = new ArrayList<>();
                        for (Cart cart : updatedCarts) {
                            Document cartDoc = new Document("name", cart.getName())
                                    .append("pathFile", cart.getPathFile())
                                    .append("quantity", cart.getQuantity())
                                    .append("price", cart.getPrice());
                            cartDocuments.add(cartDoc);
                        }
                        collection.updateOne(eq("username", username), set("cart", cartDocuments));
                    }

                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error removing cart from account in MongoDB: " + e);
        }
    }
}
