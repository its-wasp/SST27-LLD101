package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Immutable Order aggregate built via Builder.
 * - No setters
 * - Lines are copied defensively at construction
 * - getLines() returns an unmodifiable DEEP copy to prevent external mutation
 */
public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder b) {
        this.id = b.id;
        this.customerEmail = b.customerEmail;
        this.discountPercent = b.discountPercent;
        this.expedited = b.expedited;
        this.notes = b.notes;
        // deep defensive copy of lines on construction
        this.lines = deepCopyLines(b.lines);
    }

    public static final class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        // Required: id, customerEmail
        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            if (line != null) this.lines.add(line);
            return this;
        }

        public Builder addLines(List<OrderLine> lines) {
            if (lines != null) {
                for (OrderLine l : lines) {
                    if (l != null) this.lines.add(l);
                }
            }
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            if (!PricingRules.isValidEmail(customerEmail))
                throw new IllegalArgumentException("Invalid email");
            if (!PricingRules.isValidDiscount(discountPercent))
                throw new IllegalArgumentException("Invalid discount: must be 0..100 or null");
            if (id == null || id.isBlank())
                throw new IllegalArgumentException("id must not be blank");
            if (lines.isEmpty())
                throw new IllegalArgumentException("order must have at least one line");

            return new Order(this);
        }
    }
    // setters
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    // deep copying

    public List<OrderLine> getLines() {
        return Collections.unmodifiableList(deepCopyLines(this.lines));
    }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    private static List<OrderLine> deepCopyLines(List<OrderLine> src) {
        List<OrderLine> copy = new ArrayList<>(src.size());
        for (OrderLine l : src) {
            copy.add(new OrderLine(l.getSku(), l.getQuantity(), l.getUnitPriceCents()));
        }
        return copy;
    }
}
