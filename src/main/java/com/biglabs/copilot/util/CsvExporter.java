package com.biglabs.copilot.util;

import com.biglabs.copilot.model.CartLine;
import com.biglabs.copilot.model.ShoppingCart;

public class CsvExporter {

    public String exportCart(ShoppingCart cart) {
        StringBuilder categories = new StringBuilder();

        for (int index = 0; index < cart.getLines().size(); index++) {
            CartLine line = cart.getLines().get(index);
            if (index > 0) {
                categories.append('|');
            }
            categories.append(line.getCategory());
        }

        return escape(cart.getCustomerId()) + ","
            + escape(cart.getCouponCode()) + ","
            + escape(categories.toString());
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }

        return value.replace(",", "\\,");
    }
}