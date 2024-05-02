package product;

import money.Money;
import org.jetbrains.annotations.NotNull;

public class ArrivalProduct extends Product {

    @NotNull
    private Money price;

    public ArrivalProduct(Product product, @NotNull Money price) {
        super(product.getName(), product.getQuantity(), product.getUnit());
        this.price = price;
    }

    public @NotNull Money getPrice() {
        return price;
    }

    public void setPrice(@NotNull Money price) {
        this.price = price;
    }

    //    public void reducePrice(float amount) {
//        float it = getPrice().getValue() - amount;
//        editPrice().setValue(it > 0 ? it: 0);
//    }
//
//    public void increasePrice(float amount) {
//        float it = getPrice().getValue() + amount;
//        editPrice().setValue(it > 0 ? it: 0);
//    }

}
