import java.util.Scanner;

public class Carrier extends Ships{

    public Carrier(){
        setSize(6);
        setType("C");
        setIsAlive(true);
    }

    public String input(){
        Scanner MyScanner = new Scanner(System.in);
        System.out.print("Please enter the position of your Carrier: ");
        String ship = MyScanner.nextLine();
        return ship;
    }

}
