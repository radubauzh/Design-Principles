import java.util.Scanner;

public class Submarine extends Ships{

    //If this class gets initialized, the counter is +=1. This is important for the output!
    private static int counter = 0;

    //Constructor
    public Submarine(){
        counter+=1; //If in main new Submarine(), then the counter is +=1
        setSize(3);
        setType("S");
        setIsAlive(true);
    }


    public String input(){
        Scanner MyScanner = new Scanner(System.in);
        System.out.print("Please enter the position of your Submarine " + counter + ": ");
        String ship = MyScanner.nextLine();
        return ship;
    }

}
