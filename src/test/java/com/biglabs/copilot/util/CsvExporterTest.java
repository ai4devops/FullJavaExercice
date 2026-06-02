package com.biglabs.copilot.util;

import com.biglabs.copilot.model.CartLine;
import com.biglabs.copilot.model.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.util.List;

class CsvExporterTest {

    private final CsvExporter exporter = new CsvExporter();

    @Test
    void shouldExportEmptyStringForNullCoupon() {
        ShoppingCart cart = new ShoppingCart(
            "cust-001",
            false,
            null,
            List.of(new CartLine("A-1", "books", 1_000, 1))
        );

        // TODO complete assertion
    }

    @Test
    void shouldQuoteValuesContainingCommaOrQuote() {
        ShoppingCart cart = new ShoppingCart(
            "customer,01",
            false,
            "SAVE\"NOW",
            List.of(new CartLine("A-1", "office,desk", 1_000, 1))
        );

        // TODO complete assertion
    }
}