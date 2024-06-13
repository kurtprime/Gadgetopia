package mainFrame.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mainFrame.Controller.Objects.Account;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import static java.util.Collections.emptyList;

public class MongoAdd {

    List<Account> accounts = new ArrayList<>();
    String uri = "mongodb+srv://kurtquejada:mLSQY9y1Zl1CmtLj@cluster0.nzqbdss.mongodb.net/";
    private final String username;
    private final String name;
    private final String email;
    private final String password;

    public MongoAdd(String username, String name, String email, String password){
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        MongoController();
    }

    public void MongoController(){

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("account");
            try {
                // Inserts a sample document describing a movie into the collection
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("username", username)
                        .append("name", name)
                        .append("email", email)
                        .append("password", password)
                        .append("cart", emptyList())
                );
                // Prints the ID of the inserted document
                System.out.println("Success! Inserted document id: " + result.getInsertedId());

                // Prints a message if any exceptions occur during the operation
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }

    }
}
