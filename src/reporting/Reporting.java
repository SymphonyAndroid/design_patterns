package reporting;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Reporting<T> {

    @NotNull
    private final Calendar createdAt;
    @NotNull
    public List<T> products;

    public Reporting() {
        this.createdAt = Calendar.getInstance();
        this.products = new ArrayList<>();
    }

    public @NotNull List<T> getProducts() {
        return products;
    }

    public @NotNull Calendar getCreatedAt() {
        return createdAt;
    }

    @NotNull
    public String getType() {
        if (this instanceof ArrivalReporting) return "Прибуткова накладна";
        else if (this instanceof DispatchReporting) return "Видаткова накладна";
        else return "Накладна";
    }

    public abstract void addProduct(@NotNull T product);

    public abstract void removeProduct(@NotNull String name);

    public abstract void printAll();

}
