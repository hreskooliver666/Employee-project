package hu.nyirszikszi.classictomodern;

import hu.nyirszikszi.model.Category;
import hu.nyirszikszi.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<Category, Integer> totalPriceByCategory(List<String> cartSkus){
        Map<Category, Integer> map = new HashMap<>();

        for(String sku : cartSkus){
            if(sku == null) continue;
            String trimmed = sku.trim();
            if(trimmed.isEmpty()) continue;

            Product found = null;
            int i = 0;
            boolean foundIf = false;
            while (i<catalog.size() && ! foundIf)
                if(catalog.get(i).getSku() != null && catalog.get(i).getSku().equalsIgnoreCase(trimmed)){
                    found = catalog.get(i);
            }
            i++;
        }
    }


}
