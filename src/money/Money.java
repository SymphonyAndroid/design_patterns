package money;

public class Money {

    public Money(int value, int cents) {
        this.value = value;
        this.cents = cents;
    }

    public Money(float price) {
        this.value = (int) price;
        float fractionalPart = price - value;
        this.cents = Math.round(fractionalPart * 100);
    }

    private final int value;

    private final int cents;

    public int getValue() {
        return value;
    }

    public int getCents() {
        return cents;
    }

    public char getCurrency() {
        if (this instanceof Dollar) return '$';
        else if (this instanceof Euro) return '€';
        else if (this instanceof Gryvnia) return '₴';
        else throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return value + "," + cents;
    }
}
