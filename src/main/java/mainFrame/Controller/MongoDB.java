package mainFrame.Controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.*;
import com.mongodb.client.*;
import mainFrame.Controller.Objects.Account;
import mainFrame.Controller.Objects.Cart;
import org.bson.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import mainFrame.Controller.Threading;
import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    List<Account> accounts = new ArrayList<>();
    String uri = "mongodb+srv://kurtquejada:mLSQY9y1Zl1CmtLj@cluster0.nzqbdss.mongodb.net/";
    MongoClientSettings settings;
    Threading myThread;

    public  MongoDB(boolean haveDelay){
        MongoController(haveDelay);

    }

    public void MongoController(boolean wantDelay) {
        // Replace the placeholder with your Atlas connection string
        // Construct a ServerApi instance using the ServerApi.builder() method
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server

        myThread = new Threading(settings, accounts);
        myThread.start();

        if(wantDelay)
            while(myThread.isAlive())
                accounts = myThread.getAccounts();
    }

    public void addCartToAccount(String username, Cart cart ){
        myThread.addCartToAccount(username, cart);
    }

    public  void removeCartByName(String username, String cartName){
        myThread.removeCartByName(username, cartName);

    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
