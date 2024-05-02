import money.Dollar;
import money.Euro;
import money.Gryvnia;
import money.Money;
import product.ArrivalProduct;
import product.Product;
import reporting.ArrivalReporting;
import reporting.DispatchReporting;
import reporting.Reporting;
import util.ConsoleUtil;
import warehouse.Warehouse;

import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        mainMenu(warehouse);
    }

    public static void mainMenu(Warehouse warehouse) {
        int choice = ConsoleUtil.printMenu(
                "\t Меню",
                "1. Реєстрація надходження товару",
                "2. Відвантаження товару",
                "3. Звіт по залишкам на складі",
                "4. Переглянути історію накладних",
                "5. Вихід"
        );

        switch (choice){
            case 1: arrivalMenu(new ArrivalReporting(), warehouse::addReporting); break;
            case 2: dispatchMenu(new DispatchReporting(), warehouse::addReporting); break;
            case 3: warehouse.addReporting(null); break;
            case 4: warehouse.showReporting(); break;
            case 5: return;
        }
        mainMenu(warehouse);
    }

    private static void arrivalMenu(ArrivalReporting reporting, Consumer<ArrivalReporting> action) {
        int choice = ConsoleUtil.printMenu(
                "\t Меню надходження",
                "1. Додати продукт до накладної",
                "2. Видалити продукт з накладної",
                "3. Переглянути накладну надходження",
                "4. Підтвердити накладну",
                "5. Повернутися до головного меню");

        switch (choice){
            case 1: addArrivalProduct(reporting); break;
            case 2: removeProduct(reporting); break;
            case 3: reporting.printAll(); break;
            case 4: action.accept(reporting); return;
            case 5: return;
        }
         arrivalMenu(reporting, action);
    }

    private static void dispatchMenu(DispatchReporting reporting, Consumer<DispatchReporting> action) {
        int choice = ConsoleUtil.printMenu(
                "\t Меню відгрузки",
                "1. Додати продукт до накладної",
                "2. Видалити продукт з накладної",
                "3. Переглянути накладну відгрузки",
                "4. Підтвердити накладну",
                "5. Повернутися до головного меню");
        switch (choice){
            case 1: addDispatchProduct(reporting); break;
            case 2: removeProduct(reporting); break;
            case 3: reporting.printAll(); break;
            case 4: action.accept(reporting); return;
            case 5: return;
        }
        dispatchMenu(reporting, action);
    }

    private static void addArrivalProduct(ArrivalReporting reporting) {
        Product product = createProduct();
        System.out.println("Введіть ціну продукту");
        float price = ConsoleUtil.scanFloat();
        System.out.println("Введіть ціну продукту");
        Money money = new Money(price);
        ArrivalProduct arrivalProduct = new ArrivalProduct(product, checkCurrency(money));
        reporting.addProduct(arrivalProduct);
    }

    private static Money checkCurrency(Money price) {
        int choice = ConsoleUtil.printMenu(
                "1. Гривні",
                "2. Доллар",
                "3. Євро");
        switch (choice){
            case 1: return new Gryvnia(price.getValue(), price.getCents());
            case 2: return new Dollar(price.getValue(), price.getCents());
            case 3: return new Euro(price.getValue(), price.getCents());
            default: return price;
        }
    }

    private static void addDispatchProduct(DispatchReporting reporting) {
        reporting.addProduct(createProduct());
    }

    private static void removeProduct(Reporting<?> reporting) {
        System.out.println("Введіть назву продукту для видалення");
        String name = new Scanner(System.in).nextLine();
        reporting.removeProduct(name);
    }

    private static Product createProduct() {
        System.out.println("Введіть назву продукту");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Введіть кількість продукту");
        int quantity = ConsoleUtil.scanInt();
        System.out.println("Введіть одиницю виміру продукту (1 - шт., 2 - кг, 3 - літри)");
        int unit = ConsoleUtil.scanInt(1, 3) - 1;
        return new Product(name, quantity, Product.Unit.values()[unit]);
    }

}