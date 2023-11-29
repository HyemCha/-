import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class CartApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Long key = 0L;
        String productName = "";
        int price = 0;
        int quantity = 0;

        Set<Product> productSet = new HashSet<>();

        while (true){
            System.out.println("등록할 상품을 입력하세요 (이름, 가격) (등록 끝내기: end입력) >> ");
            productName = s.nextLine();
            if(Objects.equals(productName, "end")) break;
            price = Integer.parseInt(s.nextLine());
            key++;

            productSet.add(new Product(key, productName, price));
        }

        showProductList(productSet);

        Cart cart = new Cart();


        while (true) {
            System.out.println("품목과 개수를 입력하세요 (그만 담기: end 입력)>>");
            productName = s.nextLine();
            if(Objects.equals(productName, "end")) break;
            quantity = Integer.parseInt(s.nextLine());

            cart.addProduct(productName, quantity);
        }

        cart.showItems();

        while (true) {
            System.out.println("뺄 품목과 개수를 입력하세요 (그만 빼기: end 입력)>>");
            productName = s.nextLine();
            if(Objects.equals(productName, "end")) break;
            quantity = Integer.parseInt(s.nextLine());

            cart.removeProduct(productName, quantity);
        }

        cart.showItems();
    }

    private static void showProductList(Set<Product> productSet) {
        System.out.println("상품 목록:");
        for (Product product :
                productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }
        System.out.println();
    }
}