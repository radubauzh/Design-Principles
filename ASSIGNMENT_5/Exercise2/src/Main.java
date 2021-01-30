public class Main {
    public static void main(String args[]){
        Vehicle mini = new MicroCar();
        Customer ueli = new Customer();
        Vehicle family = new FamilyCar();
        Customer sashaGrey = new Customer();

        ueli.ride(mini);
        sashaGrey.ride(family);
    }
}
