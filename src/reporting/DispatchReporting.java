package reporting;

import org.jetbrains.annotations.NotNull;
import product.Product;

public class DispatchReporting extends Reporting<Product> {

    @Override
    public void addProduct(@NotNull Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(@NotNull String name) {
        products.removeIf(it -> it.getName().equals(name));
    }

    @Override
    public void printAll() {
        products.forEach(it -> System.out.println("\t" + it.getName() + "\t" + it.getQuantity() + "\t" + it.getUnit().getValue()));
    }
}
