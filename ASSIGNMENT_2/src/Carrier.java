import java.util.Scanner;

public class Carrier implements Ships{

    public String input(){
        Scanner MyScanner = new Scanner(System.in);
        System.out.print("Please enter the position of your Carrier: ");
        String ship = MyScanner.nextLine();
        return ship;
    }

    public int getSize(){
        return 6;
    }

    public String getType(){
        return "C";
    }

}
