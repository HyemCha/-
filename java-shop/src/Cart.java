import java.util.ArrayList;
import java.util.*;

public class Cart {

    private Map<String, Integer> items = new HashMap<>();

    public void showItems() {
        System.out.println("장바구니 목록:");
        for (String key :
                items.keySet()) {
            System.out.println(key + " " + items.get(key) + "개");
        }
    }

    public void addProduct(String product, int quantity) {
        items.put(product, quantity);
    }

    public void removeProduct(String productName, int minusQuantity) {
        Integer oldQuantity = items.get(productName);
        items.replace(productName, oldQuantity, (oldQuantity - minusQuantity));
    }


}
