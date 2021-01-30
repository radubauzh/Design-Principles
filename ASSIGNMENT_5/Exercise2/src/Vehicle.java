public abstract class Vehicle {
    private String carName;
    private Speed speed;
    private Fuel fuel;
    private String bagsAllowed;
    private String price;

    public Vehicle(String carName, Speed speed, Fuel fuel, String bagsAllowed, String price){
        this.carName = carName;
        this.speed = speed;
        this.fuel = fuel;
        this.bagsAllowed = bagsAllowed;
        this.price = price;
    }

    public void setSpeed(Speed speed){ this.speed = speed; }
    public void setFuel(Fuel fuel){
        this.fuel = fuel;
    }
    public void setBagsAllowed(String bagsAllowed){
        this.bagsAllowed = bagsAllowed;
    }
    public void setPrice(String price){
        this.price = price;
    }

    public Speed getSpeed(){
        return this.speed;
    }
    public Fuel getFuel(){
        return this.fuel;
    }
    public String getBagsAllowed(){
        return this.bagsAllowed;
    }
    public String getPrice(){
        return this.price;
    }


    /**
     * gives the string about the ride information
     * @return carName; bagsAllowed; speed; price
     */
    public String getRideInformation(){
     return this.carName + "; " + this.bagsAllowed + "; " + this.speed.getSpeed() + "; " + this.price;
    }


}
