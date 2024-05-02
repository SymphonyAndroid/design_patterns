package product;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SavedProduct extends ArrivalProduct {

    @NotNull
    private final Calendar lastArrival;

    public SavedProduct(ArrivalProduct product, @NotNull Calendar calendar) {
        super(product, product.getPrice());
        this.lastArrival = calendar;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Назва: ")
                .append(getName())
                .append("\t")
                .append("Кількість: ")
                .append(getQuantity())
                .append("\t")
                .append("Одиниця виміру: ")
                .append(getUnit().getValue())
                .append("\t")
                .append("Ціна: ")
                .append(getPrice())
                .append(Character.SPACE_SEPARATOR)
                .append(getPrice().getCurrency())
                .append("\t")
                .append("Дата останнього завозу: ")
                .append(new SimpleDateFormat("dd MMMM yyyy HH:mm").format(lastArrival.getTime()))
                .toString();
    }

}
