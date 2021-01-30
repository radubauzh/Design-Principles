public abstract class ToppingsDecorator extends Menue{
    protected Menue menue;

    public ToppingsDecorator(Menue menue) {
        this.menue = menue;
    }
}