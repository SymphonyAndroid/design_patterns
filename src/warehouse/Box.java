package warehouse;

import product.ArrivalProduct;
import product.Product;
import product.SavedProduct;
import reporting.ArrivalReporting;
import reporting.DispatchReporting;
import reporting.Reporting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Box implements Warehouse {

    private final List<SavedProduct> products;
    private final List<Reporting<?>> reportings;

    public Box() {
        products = new ArrayList<>();
        reportings = new ArrayList<>();
    }

    @Override
    public void addReporting(Reporting<?> reporting) {
        if (reporting instanceof ArrivalReporting) {
            List<ArrivalProduct> newProducts = ((ArrivalReporting) reporting).getProducts();
            addProducts(newProducts);
        } else if (reporting instanceof DispatchReporting) {
            List<Product> products = ((DispatchReporting) reporting).getProducts();
            dispatchProducts(products);
        } else {
            remainingStock();
            return;
        }
        this.reportings.add(reporting);
    }

    private void addProducts(List<ArrivalProduct> newProducts) {
        if (products.isEmpty()) {
            List<SavedProduct> test = newProducts.stream().map(product -> new SavedProduct(product, Calendar.getInstance())).collect(Collectors.toList());
            products.addAll(test);
            return;
        }
        List<SavedProduct> cache = new ArrayList<>();
        Iterator<ArrivalProduct> iterator = newProducts.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            ArrivalProduct product = iterator.next();
            for (ArrivalProduct arrivalProduct : products) {
                if (arrivalProduct.getId().equals(product.getId())) {
                    arrivalProduct.setQuantity(product.getQuantity() + arrivalProduct.getQuantity());
                    arrivalProduct.setPrice(arrivalProduct.getPrice());
                    found = true;
                    break;
                }
            }
            if (!found) cache.add(new SavedProduct(product, Calendar.getInstance()));
        }
        products.addAll(cache);
    }

    private void dispatchProducts(List<Product> dispatchProducts) {
        Iterator<SavedProduct> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product item = iterator.next();
            for (Product product : dispatchProducts) {
                if (product.getId().equals(item.getId())) {
                    float newQuantity = item.getQuantity() - product.getQuantity();
                    if (newQuantity <= 0) {
                        iterator.remove();
                    } else item.setQuantity(newQuantity);
                }
            }
        }
    }

    private void remainingStock() {
        if (products.isEmpty()) System.out.println("На складі порожньо!");
        else {
            System.out.println("Наявні товари: " + products.size() + " штук");
            products.forEach(savedProduct -> System.out.println(savedProduct.toString()));
        }
    }

    @Override
    public void showReporting() {
        if (reportings.isEmpty()) System.out.println("Накладних ще не проводилось!");
        else {
            System.out.println("Історія накладних: " + reportings.size() + " штук");
            reportings.forEach(it -> System.out.println(new StringBuilder()
                    .append(it.getType())
                    .append(" від ")
                    .append(new SimpleDateFormat("dd MMMM yyyy HH:mm").format(it.getCreatedAt().getTime()))
            ));
        }
    }

}
