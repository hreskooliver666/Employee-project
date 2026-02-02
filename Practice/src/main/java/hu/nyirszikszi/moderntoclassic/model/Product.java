package hu.nyirszikszi.moderntoclassic.model;

public class Product {

    private final String sku;
    private final String name;
    private Category category;
    private final int price;

    public Product(String sku, String name, Category category, int price) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
