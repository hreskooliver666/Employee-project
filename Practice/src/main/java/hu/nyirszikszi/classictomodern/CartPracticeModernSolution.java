package hu.nyirszikszi.classictomodern;

import hu.nyirszikszi.model.Category;
import hu.nyirszikszi.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CartPracticeModernSolution {
    private final List<Product> catalog;

    public CartPracticeModernSolution(List<Product> catalog) {
        this.catalog = catalog;
    }

    public Optional<Product> findCheapestInCategory(Category category){
        return catalog.stream()
                .filter(p -> p.getCategory() == category)
                .min(Comparator.comparingInt(Product::getPrice));
    }

}
