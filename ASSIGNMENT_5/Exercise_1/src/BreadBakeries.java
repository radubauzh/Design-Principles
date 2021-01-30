public class BreadBakeries extends BakeriesLeaf{

    public BreadBakeries(String name, String address, int postalCode, String city) {
        super(name, address, postalCode, city);
    }

    /**
     * gives as new Sandwich
     * @return Sandwich
     */
    public Sandwich getSandwich(){
        return new Sandwich();
    }

    /**
     * gives new Ham back or an AssertionError
     * @param Menue which will be at the end Sandwich
     * @return Ham
     */
    public Ham getHam(Menue m){
        if (m.getRecognizeNum() == 1){
            throw new AssertionError();
        }
        return new Ham(m);
    }

    /**
     * gives new Tomatoes back or an AssertionError
     * @param Menue which will be at the end Sandwich
     * @return Tomatoes
     */
    public Tomatoes getTomatoes(Menue m){
        if (m.getRecognizeNum() == 1){
            throw new AssertionError();
        }
        return new Tomatoes(m);
    }

    /**
     * gives new Cheese back or an AssertionError
     * @param Menue which will be at the end Sandwich
     * @return Cheese
     */
    public Cheese getCheese(Menue m){
        if (m.getRecognizeNum() == 1){
            throw new AssertionError();
        }
        return new Cheese(m);
    }

    /**
     * gives new Tuna back or an AssertionError
     * @param Menue which will be at the end Sandwich
     * @return Tuna
     */
    public Tuna getTuna(Menue m){
        if (m.getRecognizeNum() == 1){
            throw new AssertionError();
        }
        return new Tuna(m);
    }

    /**
     * prints the prcie of the whole menue
     * @param Menue which will be at the end Sandwich
     */
    public void printPrice(Menue m){
        System.out.println(m.getPrice());
    }

}