package product;

import org.jetbrains.annotations.NotNull;

public class Product {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    private float quantity;

    @NotNull
    private final Unit unit;

    public Product(@NotNull String name, float quantity, @NotNull Unit unit) {
        this.id = name + "/" + unit.name();
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public final @NotNull String getId() {
        return id;
    }

    public final @NotNull String getName() {
        return name;
    }

    public final float getQuantity() {
        return quantity;
    }

    public final @NotNull Unit getUnit() {
        return unit;
    }

    public final void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public enum Unit {
        PIECE("шт."),
        WEIGHT("кг."),
        VOLUME("л.");

        private final String value;

        Unit(String value) {
            this.value = value;
        }
        public final String getValue() {
            return value;
        }
    }
}
