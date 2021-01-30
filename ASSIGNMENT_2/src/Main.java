public class Main {

    //Function which makes the input, checking and drawing
    public static void creator(Ships s, Board b){
        String pos = s.input();

        while(!b.checking(pos, s.getSize())){
            System.out.println("Specified input is invalid");
            pos =s.input();
        }
        b.drawShip(pos, s.getSize(), s.getType());
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!! \n");

        //init of Board
        Board b = new Board();


        Carrier c = new Carrier();
        creator(c, b);

        Battleship b1 = new Battleship();
        creator(b1, b);

        Battleship b2 = new Battleship();
        creator(b2, b);

        Submarine s1 = new Submarine();
        creator(s1, b);

        Submarine s2 = new Submarine();
        creator(s2, b);

        Submarine s3 = new Submarine();
        creator(s3, b);

        Patrol_Boat p1 = new Patrol_Boat();
        creator(p1, b);

        Patrol_Boat p2 = new Patrol_Boat();
        creator(p2, b);

        Patrol_Boat p3 = new Patrol_Boat();
        creator(p3, b);

        Patrol_Boat p4 = new Patrol_Boat();
        creator(p4, b);

        //Print the board
        b.printBoard();

    }
}




