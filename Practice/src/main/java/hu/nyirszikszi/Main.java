package hu.nyirszikszi;

import hu.nyirszikszi.model.Category;
import hu.nyirszikszi.model.Product;
import hu.nyirszikszi.moderntoclassic.CartPracticeClassicSolution;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Product> catalog = List.of(
                new Product("BK-001", "Clean Code", 4500, Category.BOOK),
                new Product("BK-001", "Effective Java", 5200, Category.BOOK),
                new Product("BK-001", "Apple", 300, Category.FOOD),
                new Product("BK-001", "Laptop", 250000, Category.ELECTRONICS),
                new Product("BK-001", "Mouse", 8000, Category.ELECTRONICS),
                new Product("BK-001", "Lego", 15000, Category.TOY)
        );

        List<String> cartSkus = Arrays.asList(
                " bk-001",
                "EL-002",
                "FD-001",
                "EL-002", // duplikáció
                "UNKNOWN", //nem létező
                " ", //blank
                null
        );

        CartPracticeClassicSolution cart = new CartPracticeClassicSolution(catalog);

        System.out.println("=== Cart product names ===");
        try{
            cart.validateCartOrThrow(cartSkus);
            List<String> names = cart.cartProductNameUniqueSorted(cartSkus);
            System.out.println(names);
        }catch (Exception e){
            System.out.println("ERROR " + e.getMessage());
        }
        System.out.println("\n=== Cheapest electronics ===");
        cart.find
    }



}
