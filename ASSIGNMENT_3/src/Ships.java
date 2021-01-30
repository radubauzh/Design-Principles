public abstract class Ships {

    private int size;
    private String type;
    private Boolean isAlive;

    public void setSize(int size) {
        this.size = size;
    }

    public void setIsAlive(Boolean isalive) {
        this.isAlive = isalive;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Encapsulation for the size of the ships
    public int getSize(){
        return size;
    }


    public Boolean getIsAlive(){
        return isAlive;
    }

    //Get the Type of the ship (B or C or S or P). This will be in the Board!
    public String getType(){
        //This will be in the Board
        return type;
    }

    //Asks for the input. Returns the position of the ship
    public abstract String input();

}
