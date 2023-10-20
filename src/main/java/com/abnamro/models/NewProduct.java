package com.abnamro.models;

public class NewProduct extends Product {
    public NewProduct(int id, String prdTitle, String prdDescription, double prdPrice, double prdDiscountPercentage,
            double prdRating, int prdStockAvailable, String prdBrand, String prdCategory, String prdThumbnail,
            String[] prdImages) {
        super(prdTitle, prdDescription, prdPrice, prdDiscountPercentage, prdRating, prdStockAvailable, prdBrand, prdCategory,
                prdThumbnail, prdImages);
    }

    int id;

    public void setPrdID(int prdID) {
        this.id = prdID;
    }

    public int getPrdID() {
        return id;
    }
}
