package hu.nyirszikszi.moderntoclassic;

import com.sun.jdi.request.StepRequest;
import hu.nyirszikszi.model.Product;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<String> cartProductNameUniqueSorted(List<String> cartSkus){
         List<String> names = new ArrayList<>();

         for(String sku : cartSkus) {
             if(sku == null) continue;

             String trimmedSku = sku.trim();
             if(trimmedSku.isEmpty()) continue;

             Product product = findBySkuIgnoreCaseOrNull(trimmedSku);
             if(product == null) continue;

             String name = product.getName();
             if(name == null) continue;

             String trimmedName = name.trim();
             if(trimmedName.isEmpty()) continue;

             if(!names.contains(trimmedName)) { //distinct
                 names.add(trimmedName);
             }
         }

        Collections.sort(names);
         return names;
    }

    public void validateCartOrThrow(List<String> cartSkus){
        for (String sku : cartSkus){
            if(sku == null) continue;

            String trimmedSku = sku.trim();
            if(trimmedSku.isEmpty()) continue;

            Product product = findBySkuIgnoreCaseOrNull(trimmedSku);
            if(product == null){
                throw new IllegalArgumentException("Unknown Sku " + sku);
            }
        }
    }




}
