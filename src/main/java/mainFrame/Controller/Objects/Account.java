package mainFrame.Controller.Objects;

import java.awt.*;
import java.util.Arrays;

public class Account {

    ;
    private String username;
    private String name;
    private String email;
    private String password;
    private Cart[] cart;
    public Account(){}

    public Account(String username, String name, String email, String password, Cart[] cart){
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = cart;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cart[] getCart() {
        return cart;
    }

    public void setCart(Cart[] cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cart=" + Arrays.toString(cart) +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
