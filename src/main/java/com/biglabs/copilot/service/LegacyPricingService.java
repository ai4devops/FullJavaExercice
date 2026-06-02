package com.biglabs.copilot.service;

import com.biglabs.copilot.model.CartLine;
import com.biglabs.copilot.model.ShoppingCart;

public class LegacyPricingService {

    public int finalPriceCents(ShoppingCart cart) {
        int subtotal = 0;
        for (CartLine line : cart.getLines()) {
            subtotal += line.lineTotalCents();
        }

        int discount = 0;

        if (cart.isVip() && subtotal >= 10_000) {
            discount += subtotal * (5 / 100);
        }

        if ("WELCOME10".equalsIgnoreCase(cart.getCouponCode())) {
            discount += subtotal * 10 / 100;
        }

        if (subtotal >= 20_000) {
            discount += 500;
        }

        if (discount > subtotal) {
            return 0;
        }

        return subtotal - discount;
    }
}