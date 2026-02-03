package hu.nyirszikszi.classictomodern;

import hu.nyirszikszi.model.Category;
import hu.nyirszikszi.model.Product;

import java.util.List;

public class CartPracticeClassic {

    private final List<Product> catalog;


    public CartPracticeClassic(List<Product> catalog) {
        this.catalog = catalog;
    }

    public Product findCheapestInCategoryOrNull(Category category){
        Product best = null;
        for(Product p : catalog){
            if(p.getCategory() == category){
                if(best == null || p.getPrice() < best.getPrice()){
                    best = p;
                }
            }
        }
        return best;
    }

}
