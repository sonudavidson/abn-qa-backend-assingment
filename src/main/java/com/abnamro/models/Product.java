package com.abnamro.models;

public class Product {

    private String title;
    private String description;
    private double price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    private String[] images;

    public String getPrdTitle() {
        return title;
    }

    public String getPrdDesc() {
        return description;
    }

    public double getPrdPrice() {
        return price;
    }

    public double getPrdDiscountPercentage() {
        return discountPercentage;
    }

    public double getPrdRating() {
        return rating;
    }

    public int getPrdStockAvailable() {
        return stock;
    }

    public String getPrdBrand() {
        return brand;
    }

    public String getPrdCategory() {
        return category;
    }

    public String getPrdThumbnail() {
        return thumbnail;
    }

    public String[] getPrdImages() {
        return images;
    }

    public void setPrdTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setPrdDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setPrdPrice(double newPrice) {
        this.price = newPrice;
    }

    public void setPrdDiscountPercentage(double newDiscountPercentage) {
        this.discountPercentage = newDiscountPercentage;
    }

    public void setPrdRating(double newPrdRating) {
        this.rating = newPrdRating;
    }

    public void setPrdAvailableStock(int unitsInStock) {
        this.stock = unitsInStock;
    }

    public void setPrdBrand(String prdBrand) {
        this.brand = prdBrand;
    }

    public void setPrdCategory(String prdCategory) {
        this.category = prdCategory;
    }

    public void setPrdThumbnail(String prdThumbnail) {
        this.thumbnail = prdThumbnail;
    }

    public void setPrdImages(String[] imageURLs) {
        this.images = imageURLs;
    }

    public Product(String prdTitle, String prdDescription, double prdPrice, double prdDiscountPercentage, double prdRating, int prdStockAvailable, String prdBrand, String prdCategory, String prdThumbnail, String[] prdImages)
    {
        setPrdTitle(prdTitle);
        setPrdDescription(prdDescription);
        setPrdPrice(prdPrice);
        setPrdDiscountPercentage(prdDiscountPercentage);
        setPrdRating(prdRating);
        setPrdAvailableStock(prdStockAvailable);
        setPrdBrand(prdBrand);
        setPrdCategory(prdCategory);
        setPrdThumbnail(prdThumbnail);
        setPrdImages(prdImages);
    }
}
