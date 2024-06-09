package mainFrame.Controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.*;
import com.mongodb.client.*;
import mainFrame.Controller.Objects.Account;
import org.bson.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import mainFrame.Controller.Threading;
import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    List<Account> accounts = new ArrayList<>();
    String uri = "mongodb+srv://kurtquejada:mLSQY9y1Zl1CmtLj@cluster0.nzqbdss.mongodb.net/";


    public  MongoDB(){ MongoController();}

    public void MongoController() {

        // Replace the placeholder with your Atlas connection string
        // Construct a ServerApi instance using the ServerApi.builder() method
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server

        Threading myThread = new Threading(settings, accounts);
        myThread.start();
        accounts = myThread.getAccounts();
        /*
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("Account");
            MongoCollection<Document> collection = database.getCollection("account");

            FindIterable<Document> JSON_STRING = collection.find();
            ObjectMapper mapper = new ObjectMapper();

            MongoCursor<Document> cursor = collection.find().iterator();
            while (cursor.hasNext()) {
                JsonNode node = mapper.readTree(cursor.next().toJson());
                String username = node.get("username").asText();
                String name = node.get("name").asText();
                String email = node.get("email").asText();
                String password = node.get("password").asText();
                accounts.add(new Account(username, name, email, password));
            }

            //JsonNode node = mapper.readTree(JSON_STRING[0]);


        }catch(Exception e){
            System.err.println(e);
        }
        */
    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
