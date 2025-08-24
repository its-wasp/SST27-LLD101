import java.util.*;
public class ShippingStrategyRegistry {
    private static final Map<String, ShippingStrategy> strategies = new HashMap<>();
    static {
        strategies.put("STANDARD", new StandardShipping());
        strategies.put("EXPRESS", new ExpressShipping());
        strategies.put("OVERNIGHT", new OvernightShipping()); }
    public static ShippingStrategy getStrategy(String type) {
        ShippingStrategy strategy = strategies.get(type);
        if(strategy == null)
            throw new IllegalArgumentException("Unknown Shipping Strategy: " + type);

        return strategy;
    }

}
