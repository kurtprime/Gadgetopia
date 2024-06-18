package mainFrame.Controller.Objects;

import java.util.Arrays;
import java.util.Objects;

public class ProductDetails {

    String name;
    String brand;
    String category;
    String about;
    Integer price;
    Integer[] reviews;
    Integer[] color;
    Integer stocks;
    String[] pathFile;

    public ProductDetails(
        String name,
        String brand,
        String category,
        String about,
        Integer price,
        Integer[] reviews,
        Integer[] color,
        Integer stocks,
        String[] pathFile
    ){
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.about = about;
        this.price = price;
        this.reviews = reviews;
        this.color = color;
        this.stocks = stocks;
        this.pathFile = pathFile;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPathFile() {
        return pathFile;
    }

    public void setPathFile(String[] pathFile) {
        this.pathFile = pathFile;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    public Integer[] getColor() {
        return color;
    }

    public void setColor(Integer[] color) {
        this.color = color;
    }

    public Integer[] getReviews() {
        return reviews;
    }

    public void setReviews(Integer[] reviews) {
        this.reviews = reviews;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", about='" + about + '\'' +
                ", price=" + price +
                ", reviews=" + Arrays.toString(reviews) +
                ", color=" + Arrays.toString(color) +
                ", stocks=" + stocks +
                ", pathFile=" + Arrays.toString(pathFile) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetails that = (ProductDetails) o;
        return Objects.equals(name, that.name) && Objects.equals(brand, that.brand) && Objects.equals(category, that.category) && Objects.equals(about, that.about) && Objects.equals(price, that.price) && Objects.deepEquals(reviews, that.reviews) && Objects.deepEquals(color, that.color) && Objects.equals(stocks, that.stocks) && Objects.deepEquals(pathFile, that.pathFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, category, about, price, Arrays.hashCode(reviews), Arrays.hashCode(color), stocks, Arrays.hashCode(pathFile));
    }
}
