import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cart {

    Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, Integer amount) {
        items.merge(product, amount, Integer::sum);
    }

    public void removeProduct(Product product, Integer amount) {
        if (items.get(product) == null) return;

        items.merge(product, amount, ((integer, integer2) -> Math.max(0, integer - integer2)))
    }

    public Map<String, Integer> showItems() {
        return items.entrySet().stream()
                .filter(productIntegerEntry -> productIntegerEntry.getValue() > 0)
                .collect(Collectors.toMap(entry -> entry.getKey().getName(), Map.Entry::getValue));
    }
}
