public abstract class Menue {
    private int recognizeNum = 0;

    /**
     * gives the price of all meals
     * @return double
     */
    public abstract double getPrice();

    /**
     * gives the RecognizeNumber to see what meal does the menue include
     * @return int
     */
    public int getRecognizeNum() {
        return recognizeNum;
    }

    /**
     * sets the recognizeNumber
     * @param recognizeNum which gives the meal of the menue
     */
    public void setRecognizeNum(int recognizeNum) {
        this.recognizeNum = recognizeNum;
    }
}