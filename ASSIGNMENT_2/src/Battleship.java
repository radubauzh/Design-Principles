import java.util.Scanner;

public class Battleship implements Ships{

    //This is important for the output!
    private static int counter = 0;

    //Constructor
    public Battleship(){
        counter+=1; //If in main new Battleship(), then the counter is +=1
    }

    public String input(){
        Scanner MyScanner = new Scanner(System.in);
        System.out.print("Please enter the position of your BattleShip " + counter + ": ");
        String ship = MyScanner.nextLine();
        return ship;
    }

    public int getSize(){
        return 4;
    }

    public String getType(){
        return "B";
    }

}
//int[] myIntArray = new int[3];