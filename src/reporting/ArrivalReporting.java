package reporting;

import org.jetbrains.annotations.NotNull;
import product.ArrivalProduct;

public class ArrivalReporting extends Reporting<ArrivalProduct> {

    @Override
    public void addProduct(@NotNull ArrivalProduct product) {
        products.add(product);
    }

    @Override
    public void removeProduct(@NotNull String name) {
        products.removeIf(it -> it.getName().equals(name));
    }

    @Override
    public void printAll() {
        products.forEach(it -> System.out.println(
                "\t" + it.getName() +
                "\t" + it.getQuantity() +
                "\t" + it.getUnit().getValue() +
                "\t" + " за ціною " + it.getPrice() + Character.SPACE_SEPARATOR +
                it.getUnit().getValue())
        );
    }
}
