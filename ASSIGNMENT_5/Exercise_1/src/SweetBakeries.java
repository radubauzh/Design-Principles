public class SweetBakeries extends BakeriesLeaf{

    public SweetBakeries(String name, String address, int postalCode, String city) {
        super(name, address, postalCode, city);
    }

    /**
     * gives a new Cake
     * @return Cake
     */
    public Cake getCake(){
        return new Cake();
    }

    /**
     * gives new Strawberries back or an AssertionError
     * @param Menue which will be at the end Sandwich
     * @return Strawberries
     */
    public Strawberries getStrawberries(Menue m){
        if (m.getRecognizeNum() == 2){
            throw new AssertionError();
        }
        return new Strawberries(m);
    }

    /**
     * gives new Cream back or an AssertionError
     * @param Menue which will be at the end Sandwich
     * @return Cream
     */
    public Cream getCream(Menue m){
        if (m.getRecognizeNum() == 2){
            throw new AssertionError();
        }
        return new Cream(m);
    }

    /**
     * gives new Chocolate back or an AssertionError
     * @param Menue which will be at the end Sandwich
     * @return Chocolate
     */
    public Chocolate getChocolate(Menue m){
        if (m.getRecognizeNum() == 2){
            throw new AssertionError();
        }
        return new Chocolate(m);
    }

    /**
     * prints the prcie of the whole menue
     * @param Menue which will be at the end Sandwich
     */
    public void printPrice(Menue m){
        System.out.println(m.getPrice());
    }

}