package money;

public class Dollar extends Money {

    public Dollar(int value, int cents) {
        super(value, cents);
    }

    public Dollar(float price) {
        super(price);
    }
}
