import java.util.Random;
import java.util.Scanner;

// This class is a Singleton
public class Game {

//INIT OF SINGLETON:

    //In this variable is the one Game instance saved
    private static Game uniqueInstance;

    private Carrier c;
    private Battleship b1;
    private Battleship b2;
    private Submarine s1;
    private Submarine s2;
    private Submarine s3;
    private Patrol_Boat p1;
    private Patrol_Boat p2;
    private Patrol_Boat p3;
    private Patrol_Boat p4;

    private Carrier cAi;
    private Battleship b1Ai;
    private Battleship b2Ai;
    private Submarine s1Ai;
    private Submarine s2Ai;
    private Submarine s3Ai;
    private Patrol_Boat p1Ai;
    private Patrol_Boat p2Ai;
    private Patrol_Boat p3Ai;
    private Patrol_Boat p4Ai;

    private int amountBoatsPlayer = 1;
    private int amountBoatsAi = 1;

    private int recognizePlayer = 1;
    private int recognizeAI=2;
    private int testingint=0;

    //private because we cannot create a instance outside of this class
    private Game(){}

    //create the one class
    public static Game getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Game();
        }
        return uniqueInstance;
    }

//CODE:

    //That is the main function!!!
    public void playGameHumanVsAi(){

        //User Board
        Board userBoard = new Board(); //init of user Board
        placementUser(userBoard); //Makes the User Board

        //AI Board
        Board aiBoard = new Board(); //init of ai Board
        placementAI(aiBoard);

        while(amountBoatsPlayer != 0 && amountBoatsAi != 0){ //true noch mit siegesbedingung ersetzen!!!
            userBoard.printBoard(); //Print the User Board
            //aiBoard.printBoard(); //CHEAT!
            aiBoard.printAIBoard(); //Print the AI Board

            userAttack(aiBoard);
            amountBoatsAi = aiBoard.observerCheck(cAi, b1Ai, b2Ai, s1Ai, s2Ai, s3Ai, p1Ai, p2Ai, p3Ai, p4Ai, recognizeAI);
            getSentence(aiBoard.getMissHitDestroyVar());

            aiAttack(userBoard);
            amountBoatsPlayer = userBoard.observerCheck(c, b1, b2, s1, s2, s3, p1, p2, p3, p4, recognizePlayer);
            getSentence(userBoard.getMissHitDestroyVar());

            printScoreboard(amountBoatsPlayer, amountBoatsAi);
        }

        if (amountBoatsPlayer == 0){
            System.out.println("Sorry, you lost!");
        }
        else{
            System.out.println("Congratulations, you won!");
        }
    }

    private void getSentence(int mhd){
        switch (mhd){
            case 0:
                System.out.println("Miss");
                break;
            case 1:
                System.out.println("You hit a boat!");
                break;
            case 2:
                System.out.println("The computer missed");
                break;
            case 3:
                System.out.println("Your boat was hit!");
                break;
            case 4:
                System.out.println("You destroyed a Carrier");
                break;
            case 5:
                System.out.println("Your Carrier was destroyed");
                break;
            case 6:
                System.out.println("You destroyed a Battleship 1");
                break;
            case 7:
                System.out.println("Your Battleship 1 was destroyed");
                break;
            case 8:
                System.out.println("You destroyed a Battleship 2");
                break;
            case 9:
                System.out.println("Your Battleship 2 was destroyed");
                break;
            case 10:
                System.out.println("You destroyed a Submarine 1");
                break;
            case 11:
                System.out.println("Your Submarine 1 was destroyed");
                break;
            case 12:
                System.out.println("You destroyed a Submarine 2");
                break;
            case 13:
                System.out.println("Your Submarine 2 was destroyed");
                break;
            case 14:
                System.out.println("You destroyed a Submarine 3");
                break;
            case 15:
                System.out.println("Your Submarine 3 was destroyed");
                break;
            case 16:
                System.out.println("You destroyed a Patrol Boat 1");
                break;
            case 17:
                System.out.println("Your Patrol Boat 1 was destroyed");
                break;
            case 18:
                System.out.println("You destroyed a Patrol Boat 2");
                break;
            case 19:
                System.out.println("Your Patrol Boat 2 was destroyed");
                break;
            case 20:
                System.out.println("You destroyed a Patrol Boat 3");
                break;
            case 21:
                System.out.println("Your Patrol Boat 3 was destroyed");
                break;
            case 22:
                System.out.println("You destroyed a Patrol Boat 4");
                break;
            case 23:
                System.out.println("Your Patrol Boat 4 was destroyed");
                break;
        }
    }

    public void printScoreboard(int player, int ai){
        System.out.println("\nYour Scoreboard:");
        System.out.println("   -  Player remaining boats: " + String.format("%d", player));
        System.out.println("   -  Enemy boats destroyed:  " + String.format("%d", 10-ai));
    }

    //Function which makes the input, checking and drawing
    private void creatorUserBoard(Ships s, Board b){
        String pos = s.input();

        //ONLY FOR TESTING!!! After testing: make //
        //pos = testing();

        while(!b.checking(pos, s.getSize())){
            System.out.println("Specified input is invalid");
            pos =s.input();
        }
        b.drawShip(pos, s.getSize(), s.getType());
    }

    private void creatorAIBoard(Ships s, Board b){
        Random cube = new Random();
        String letters = "ABCDEFGHIJ                                ";
        String pos;
        do{
            char second_letter;
            int second_number;
            int number_for_char = cube.nextInt(10);

            int coincidence = cube.nextInt(10);
            char first_letter = letters.charAt(number_for_char);
            int first_number = cube.nextInt(10);

            if(coincidence%2==0){
                second_letter = first_letter;
                second_number=first_number+s.getSize()-1;
            }
            else{
                second_number = first_number;
                second_letter = letters.charAt(number_for_char+s.getSize()-1);
            }
            pos = ""+first_letter+first_number+" "+second_letter+second_number;
        }while(!b.checking(pos, s.getSize()));
        b.drawShip(pos, s.getSize(), s.getType());


    }

    //Function which asks USER for placement
    private void placementUser(Board b) {
        this.c = new Carrier();
        creatorUserBoard(c, b);

        this.b1 = new Battleship();
        creatorUserBoard(b1, b);

        this.b2 = new Battleship();
        creatorUserBoard(b2, b);

        this.s1 = new Submarine();
        creatorUserBoard(s1, b);

        this.s2 = new Submarine();
        creatorUserBoard(s2, b);

        this.s3 = new Submarine();
        creatorUserBoard(s3, b);

        this.p1 = new Patrol_Boat();
        creatorUserBoard(p1, b);

        this.p2 = new Patrol_Boat();
        creatorUserBoard(p2, b);

        this.p3 = new Patrol_Boat();
        creatorUserBoard(p3, b);

        this.p4 = new Patrol_Boat();
        creatorUserBoard(p4, b);

        b.createBoardList(this.c,this.b1,this.b2,this.s1,this.s2,this.s3,this.p1,this.p2,this.p3,this.p4);
    }


    //Function which makes the placement of AI
    private void placementAI(Board b){
        this.cAi = new Carrier();
        creatorAIBoard(cAi, b);

        this.b1Ai = new Battleship();
        creatorAIBoard(b1Ai, b);

        this.b2Ai = new Battleship();
        creatorAIBoard(b2Ai, b);

        this.s1Ai = new Submarine();
        creatorAIBoard(s1Ai, b);

        this.s2Ai = new Submarine();
        creatorAIBoard(s2Ai, b);

        this.s3Ai = new Submarine();
        creatorAIBoard(s3Ai, b);

        this.p1Ai = new Patrol_Boat();
        creatorAIBoard(p1Ai, b);

        this.p2Ai = new Patrol_Boat();
        creatorAIBoard(p2Ai, b);

        this.p3Ai = new Patrol_Boat();
        creatorAIBoard(p3Ai, b);

        this.p4Ai = new Patrol_Boat();
        creatorAIBoard(p4Ai, b);

        b.createBoardList(this.cAi,this.b1Ai,this.b2Ai,this.s1Ai,this.s2Ai,this.s3Ai,this.p1Ai,this.p2Ai,this.p3Ai,this.p4Ai);
    }

    //Function attacks the AI with user input
    private void userAttack(Board b){
        System.out.print("Enter a position you want to attack: ");
        Scanner MyScanner = new Scanner(System.in);
        String attack_pos = MyScanner.nextLine();
        while(!(b.attackPosChecker(attack_pos))){ //Checker
            System.out.println("Specified input is invalid");
            System.out.print("Enter a position you want to attack: ");
            attack_pos = MyScanner.nextLine();
        }
        b.drawXorOUserAttack(attack_pos); //draw the field
    }

    //Function attacks user Board
    private void aiAttack(Board b){
        Random cube = new Random();
        String letters = "ABCDEFGHIJ";
        char letter;
        int number;
        String pos;
        do {
            letter = letters.charAt(cube.nextInt(10));
            number = cube.nextInt(10);
            pos=""+letter+number;
        }while (!(b.attackPosChecker(pos)));
        System.out.println("The computer attacks position "+pos);
        b.drawXorOAIAttack(pos);
    }

    //This method is for the testing! Then you dont have to put the coords of your boats every time.
    //ATTENTION: MAKE // TO creatorUserBoard IF YOU ARE FINISHED zeile 177
    private String testing(){
        String frs = null;
        switch(testingint){
            case 0:
                testingint++;
                frs = "A1 A6";
                break;
            case 1:
                testingint++;
                frs = "E3 H3";
                break;
            case 2:
                testingint++;
                frs = "C1 C4";
                break;
            case 3:
                testingint++;
                frs = "A8 C8";
                break;
            case 4:
                testingint++;
                frs = "D4 D6";
                break;
            case 5:
                testingint++;
                frs = "E9 G9";
                break;
            case 6:
                testingint++;
                frs = "H1 H2";
                break;
            case 7:
                testingint++;
                frs = "I8 J8";
                break;
            case 8:
                testingint++;
                frs = "I2 J2";
                break;
            case 9:
                testingint++;
                frs = "H6 I6";
                break;

        }
        return frs;
    }


}
