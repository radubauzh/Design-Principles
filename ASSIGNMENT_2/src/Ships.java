public interface Ships {
    //All methods which must be in every ship

    //Asks for the input. Returns the position of the ship
    public String input();

    //Encapsulation for the size of the ships
    public int getSize();

    //Get the Type of the ship (B or C or S or P). This will be in the Board!
    public String getType();

}
