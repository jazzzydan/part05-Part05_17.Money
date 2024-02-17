
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        // create a new Money object that has the correct worth
        // Money newMoney = new Money(this.euros + addition.euros, this.cents + addition.cents);

        // If cents exceed 100, adjust euros and cents accordingly
        // if (newMoney.cents >= 100) {
        //     newMoney.euros += newMoney.cents / 100;
        //     newMoney.cents %= 100;
        // }

        // return the new Money object
        // return newMoney;

        // As newMoney.euros and newMoney.cents are "final" it can not be resolved as described above.

        int totalEuros = this.euros + addition.euros;
        int totalCents = this.cents + addition.cents;

        // If cents exceed 100, adjust euros and cents accordingly
        if (totalCents >= 100) {
            totalEuros ++;
            totalCents %= 100;
        }

        return new Money(totalEuros, totalCents);
    }

    public boolean lessThan(Money compared) {
        // Calculate the total value of the money-object on which the method is called
        int thisTotalCents = this.euros * 100 + this.cents;

        // Calculate the total value of the money object given as a parameter
        int comparedTotalCents = compared.euros * 100 + compared.cents;

        // Compare the total values and return true if the money-object on which the method is called has a lesser value
        return thisTotalCents < comparedTotalCents;
    }

    public Money minus(Money decreaser) {
        int totalEuros = this.euros - decreaser.euros;
        int totalCents = this.cents - decreaser.cents;

        // If cents are negative, borrow from euros
        if (totalCents < 0) {
            totalEuros--;
            totalCents += 100;
        }

        // If euros are negative, set both euros and cents to 0
        if (totalEuros < 0) {
            totalEuros = 0;
            totalCents = 0;
        }

        return new Money(totalEuros, totalCents);
    }
}
