package ca.ulaval.glo2003;

import jakarta.json.bind.annotation.JsonbProperty;

import java.time.LocalDateTime;

public class ComplexProduct
{
    private String title;

    @JsonbProperty("description")
    private String description;

    @JsonbProperty("price")
    private float price;

    @JsonbProperty("sold")
    private boolean sold;

    private LocalDateTime dateTime;

    public ComplexProduct() {}

    public ComplexProduct(String title, String description, float price, boolean sold, LocalDateTime dateTime)
    {
        this.title = title;
        this.description = description;
        this.price = price;
        this.sold = sold;
        this.dateTime = dateTime;
    }

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

    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
