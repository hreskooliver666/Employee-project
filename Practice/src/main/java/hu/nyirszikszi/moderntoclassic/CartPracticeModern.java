package hu.nyirszikszi.moderntoclassic;

import hu.nyirszikszi.moderntoclassic.model.Product;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class CartPracticeModern {

    private final List<Product> catalog;

    public CartPracticeModern(List<Product> catalog) {
        this.catalog = catalog;
    }

    Optional<Product> findBySkuIgnoreCase(String sku){
        if(sku == null) return Optional.empty();
        String needle = sku.toLowerCase(Locale.ROOT);

        return catalog.stream()
                .filter(p -> p.getSku() != null)
                .filter(p -> p.getSku() .trim().toLowerCase(Locale.ROOT).equals(needle))
                .findFirst();

    }

    public List<String> csrtProductNameUniqueSorted(List<String> cartSkus){
        return cartSkus.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> s.isBlank())
                .map(this::findBySkuIgnoreCase)
                .flatMap(Optional::stream)
                .map(Product::getName)
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .distinct()
                .sorted()
                .toList();

    }


}
