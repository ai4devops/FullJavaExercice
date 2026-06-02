package com.biglabs.copilot;

import com.biglabs.copilot.model.CartLine;
import com.biglabs.copilot.model.ShoppingCart;
import com.biglabs.copilot.service.CustomerInsights;
import com.biglabs.copilot.service.LegacyPricingService;
import com.biglabs.copilot.util.CsvExporter;

import java.util.List;

public class App {

    public static void main(String[] args) {
        ShoppingCart firstCart = new ShoppingCart(
            "cust-001",
            true,
            "WELCOME10",
            List.of(
                new CartLine("A-100", "books", 4_000, 2),
                new CartLine("B-200", "office", 1_500, 3)
            )
        );

        ShoppingCart secondCart = new ShoppingCart(
            "cust-002",
            false,
            null,
            List.of(
                new CartLine("C-300", "books", 2_500, 1),
                new CartLine("D-400", "kitchen", 3_000, 2)
            )
        );

        LegacyPricingService pricingService = new LegacyPricingService();
        CustomerInsights insights = new CustomerInsights();
        CsvExporter csvExporter = new CsvExporter();

        System.out.println(pricingService.finalPriceCents(firstCart));
        System.out.println(insights.topCategories(List.of(firstCart, secondCart), 2));
        System.out.println(insights.buildMonthlySummary(List.of(firstCart, secondCart)));
        System.out.println(csvExporter.exportCart(firstCart));
    }
}