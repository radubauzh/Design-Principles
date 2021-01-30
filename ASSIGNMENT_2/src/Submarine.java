import java.util.Scanner;

public class Submarine implements Ships{

    //If this class gets initialized, the counter is +=1. This is important for the output!
    private static int counter = 0;

    //Constructor
    public Submarine(){
        counter+=1; //If in main new Submarine(), then the counter is +=1
    }


    public String input(){
        Scanner MyScanner = new Scanner(System.in);
        System.out.print("Please enter the position of your Submarine " + counter + ": ");
        String ship = MyScanner.nextLine();
        return ship;
    }

    public int getSize(){
        return 3;
    }

    public String getType(){
        //This will be in the Board
        return "S";
    }
}
