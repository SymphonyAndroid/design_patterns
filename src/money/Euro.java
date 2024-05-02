package money;

public class Euro extends Money {

    public Euro(int value, int cents) {
        super(value, cents);
    }

    public Euro(float price) {
        super(price);
    }
}
