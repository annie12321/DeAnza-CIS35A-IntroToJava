public class Money {

    private int dollars, cents;

    public Money() {
        this.dollars = 0;
        this.cents = 0;
    }

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money add(Money m) {
        int temp = cents + m.cents;
        int newCents = (cents + m.cents) % 100;
        int newDollars = dollars + m.dollars + temp / 100;
        return new Money(newDollars, newCents);
    }

    public Money subtract(Money m) {
        int newCents = cents - m.cents;
        int newDollars = dollars;
        if(newCents < 0) {
            newCents += 100;
            newDollars = dollars - 1;
        }
        newDollars -= m.dollars;
        return new Money(newDollars, newCents);
    }

    public Money multiply(int m) {
        int temp = cents * m;
        int newCents = temp % 100;
        int newDollars = dollars * m + temp / 100;
        return new Money(newDollars, newCents);
    }

    public static Money[] multiply(Money[] moneys, int amt) {
        Money[] tempArray = new Money[moneys.length];
        for(int i = 0; i < moneys.length; i ++) {
            tempArray[i] = new Money();
            int temp = moneys[i].cents * amt;
            tempArray[i].cents = temp % 100;
            tempArray[i].dollars = moneys[i].dollars * amt + temp / 100;
        }
        return tempArray;
    }

    public boolean equals(Money money) {
        return dollars == money.dollars && cents == money.cents;
    }

    public String toString() {
        return dollars + "." + cents;
    }

}
