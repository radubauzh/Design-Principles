public class Customer {
    private String name;
    private String date;

    public void setName(String name) {
        this.name = name;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }
    public String getDate(){
        return date;
    }

    /**
     * lets a customer have a ride
     * @param vehicle
     */
    public void ride(Vehicle vehicle){
        try{
            String info = vehicle.getRideInformation();
            System.out.println(info);
        }catch (Exception e){
            throw new AssertionError();
        }
    }
}
