package com.biglabs.copilot.service;

import com.biglabs.copilot.model.CartLine;
import com.biglabs.copilot.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class CustomerInsights {

    public List<String> topCategories(List<ShoppingCart> carts, int limit) {
        List<String> categories = new ArrayList<>();
        for (ShoppingCart cart : carts) {
            for (CartLine line : cart.getLines()) {
                if (!categories.contains(line.getCategory())) {
                    categories.add(line.getCategory());
                }
            }
        }

        List<String> ordered = new ArrayList<>();
        while (ordered.size() < limit && ordered.size() < categories.size()) {
            String bestCategory = null;
            int bestScore = Integer.MAX_VALUE;

            for (String category : categories) {
                if (ordered.contains(category)) {
                    continue;
                }

                int score = 0;
                for (ShoppingCart cart : carts) {
                    for (CartLine line : cart.getLines()) {
                        if (category.equals(line.getCategory())) {
                            score++;
                        }
                    }
                }

                if (bestCategory == null || score < bestScore
                    || (score == bestScore && category.compareTo(bestCategory) < 0)) {
                    bestCategory = category;
                    bestScore = score;
                }
            }

            ordered.add(bestCategory);
        }

        return ordered;
    }

    public String buildMonthlySummary(List<ShoppingCart> carts) {
        int orderCount = carts.size();
        int vipOrders = 0;
        int revenueCents = 0;

        for (ShoppingCart cart : carts) {
            if (cart.isVip()) {
                vipOrders++;
            }

            for (CartLine line : cart.getLines()) {
                revenueCents += line.lineTotalCents();
            }
        }

        int averageBasketCents = orderCount == 0 ? 0 : revenueCents / orderCount;

        return "orders=" + orderCount
            + ";vipOrders=" + vipOrders
            + ";revenueCents=" + revenueCents
            + ";avgBasketCents=" + averageBasketCents;
    }
}