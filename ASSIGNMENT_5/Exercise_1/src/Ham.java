public class Ham extends ToppingsDecorator{

    public Ham(Menue menue) {
        super(menue);
        setRecognizeNum(2);

    }

    /**
     * gives the price of this Topping with all other topping prices
     * @return double
     */
    public double getPrice() {
        double a = menue.getPrice();
        return a + 2;
    }
}