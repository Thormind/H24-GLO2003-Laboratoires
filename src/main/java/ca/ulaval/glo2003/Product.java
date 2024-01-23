package ca.ulaval.glo2003;

import jakarta.json.bind.annotation.JsonbProperty;

public class Product {
    @JsonbProperty("title")
    private String title;

    @JsonbProperty("description")
    private String description;

    @JsonbProperty("price")
    private float price;

    @JsonbProperty("sold")
    private boolean sold;

    public Product() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public boolean isSold() {
        return sold;
    }
}
