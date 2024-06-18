package mainFrame.Controller.Objects;

public class Cart {
    String name;
    String pathFile;
    Integer quantity;
    Integer price;

    public Cart(String name, String pathFile,  Integer quantity, Integer price) {
        this.name = name;
        this.pathFile = pathFile;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean equalsByName(String otherName) {
        return name.equals(otherName);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                ", pathFile='" + pathFile + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}
