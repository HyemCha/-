import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Product> products = new HashSet<>();

        Product p1 = new Product("1", "치약", 1000);
        Product p2 = new Product("2", "칫솔", 1800);
        Product p3 = new Product("3", "샴푸", 2000);
        Product p4 = new Product("4", "린스", 1500);

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        for (Product product :
                products) {
            System.out.println(product.getName());
        }

        Cart myCart = new Cart();
        myCart.addProduct(p1, 1);
        myCart.addProduct(p2, 1);
        myCart.removeProduct(p1, 2);


    }
}