package com.biglabs.copilot.service;

import com.biglabs.copilot.model.CartLine;
import com.biglabs.copilot.model.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.util.List;

class LegacyPricingServiceTest {

    private final LegacyPricingService service = new LegacyPricingService();

    @Test
    void shouldApplyVipDiscountWhenThresholdIsReached() {
        ShoppingCart cart = new ShoppingCart(
            "vip-001",
            true,
            null,
            List.of(new CartLine("A-1", "books", 5_000, 2))
        );

        // TODO complete assertion
    }

    @Test
    void shouldApplyWelcomeCouponOnlyWhenAtLeastTwoItemsArePresent() {
        ShoppingCart cart = new ShoppingCart(
            "cust-001",
            false,
            "WELCOME10",
            List.of(new CartLine("A-1", "books", 15_000, 1))
        );

        // TODO complete assertion
    }

    @Test
    void shouldCapTotalDiscountAtTwentyFivePercent() {
        ShoppingCart cart = new ShoppingCart(
            "vip-002",
            true,
            "WELCOME10",
            List.of(new CartLine("A-1", "office", 12_000, 2))
        );

        // TODO complete assertion
    }
}