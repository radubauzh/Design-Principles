public class Tuna extends ToppingsDecorator{

    public Tuna(Menue menue) {
        super(menue);
        setRecognizeNum(1);
    }

    /**
     * gives the price of this Topping with all other topping prices
     * @return double
     */
    public double getPrice() {
        double a = menue.getPrice();
        return a + 3;
    }
}