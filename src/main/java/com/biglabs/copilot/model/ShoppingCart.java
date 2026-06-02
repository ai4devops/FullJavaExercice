package com.biglabs.copilot.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private final String customerId;
    private final boolean vip;
    private final String couponCode;
    private final List<CartLine> lines;

    public ShoppingCart(String customerId, boolean vip, String couponCode, List<CartLine> lines) {
        this.customerId = customerId;
        this.vip = vip;
        this.couponCode = couponCode;
        this.lines = new ArrayList<>(lines);
    }

    public String getCustomerId() {
        return customerId;
    }

    public boolean isVip() {
        return vip;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public List<CartLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int totalItemCount() {
        int total = 0;
        for (CartLine line : lines) {
            total += line.getQuantity();
        }
        return total;
    }
}