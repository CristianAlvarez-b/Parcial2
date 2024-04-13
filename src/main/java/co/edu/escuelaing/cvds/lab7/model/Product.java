package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "RATING")
    private int rating ;
    @Column(name = "PRICE")
    private int price ;


    @Column(name = "QUANTITY")
    private int quantity ;

    public Product() {
    }

    public Product(int productId, String name, String description, Category category, int rating, int price,int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
