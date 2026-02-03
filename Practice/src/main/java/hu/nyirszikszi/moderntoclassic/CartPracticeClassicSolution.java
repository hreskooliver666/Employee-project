package hu.nyirszikszi.moderntoclassic;

import hu.nyirszikszi.model.Product;

import java.util.List;
import java.util.Locale;

public class CartPracticeClassicSolution {
    private final List<Product> catalog;

    public CartPracticeClassicSolution(List<Product> catalog) {
        this.catalog = catalog;
    }

    public Product findBySkuIgnoreCaseOrNull(String sku){
        if(sku == null) return null;
        String needle = sku.trim().toLowerCase(Locale.ROOT);

        for(Product p : catalog){
            if(p.getSku() != null) {
                String stored = p.getSku().trim().toLowerCase(Locale.ROOT);
                if(stored.equals(needle)) return p;
            }
        }
        return null;
    }

    


}
