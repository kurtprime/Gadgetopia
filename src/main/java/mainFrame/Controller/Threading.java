package mainFrame.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.*;
import com.mongodb.client.*;
import mainFrame.Controller.Objects.Account;
import org.bson.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Threading extends  Thread{
    MongoClientSettings settings;
    List<Account> accounts;

    //public Threading(){}

    public Threading(MongoClientSettings settings ,  List<Account> accounts){
        this.settings = settings;
        this.accounts = accounts;
    }

    @Override
    public void run(){
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
    }
    public List<Account> getAccounts(){
        return accounts;
    }

}
