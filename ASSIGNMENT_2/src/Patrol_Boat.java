import java.util.Scanner;

public class Patrol_Boat implements Ships{

    //If this class gets initialized, the counter is +=1. This is important for the output!
    private static int counter = 0;

    //Constructor
    public Patrol_Boat(){
        counter+=1; //If in main new Patrol_Boat(), then the counter is +=1
    }

    public String input(){
        Scanner MyScanner = new Scanner(System.in);
        System.out.print("Please enter the position of your Patrol Boat " + counter + ": ");
        String ship = MyScanner.nextLine();
        return ship;
    }


    public int getSize(){
        return 2;
    }

    public String getType(){
        //This will be in the Board
        return "P";
    }
}
