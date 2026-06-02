package com.biglabs.copilot.model;

public class CartLine {
    private final String sku;
    private final String category;
    private final int unitPriceCents;
    private final int quantity;

    public CartLine(String sku, String category, int unitPriceCents, int quantity) {
        this.sku = sku;
        this.category = category;
        this.unitPriceCents = unitPriceCents;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public String getCategory() {
        return category;
    }

    public int getUnitPriceCents() {
        return unitPriceCents;
    }

    public int getQuantity() {
        return quantity;
    }

    public int lineTotalCents() {
        return unitPriceCents * quantity;
    }
}