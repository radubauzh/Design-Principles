
# Software Construction - Assigment 3

- Dubach Rafael (18-755-140)
- Hoffmann Felix (14-591-549)
- Wäspi Raphael (18-918-938)

## Singleton
The Singleton Design Pattern was used in the class Game. We created a private static variable "uniqueInstance", a private Game constructor and a public static method "getInstance". In the variable is the one Game instance saved. The Game constructor was implemented as private because we should only be able to create this class in the class itself. No other class is allowed to create a Game class. For this reason we have create the method which creates a new Game instance when there is none. This method must be public and static because we must be able to call this method in the main with no existing Game class. The advantage of this Singleton is that there can only exist one Game class.     

## Observer
The Observer Design Pattern was implemented in the Class Board. Using an observer Array that monitors the hits the Method observerCheck knows when a Boat will sink and how many boats remain. We chose this design pattern at this place to ensure a stable and efficient monitoring of the status of each boat.

## Iterator
The Iterator Design Pattern was implemented using an Iterator Interface and a BoatList class. In the Board class the Iterator was used to iterate over the array in the bl object to get the already destroyed boats. We do not see a benefit in using the Iterator Design Pattern over a for loop, however it was a blast implementing it! 

## Code
### Main Class
    public class Main {
    
        public static void main(String[] args) {
            System.out.println("Welcome to Battleship!! \n");
            Game g1 = Game.getInstance();
            g1.playGameHumanVsAi();
    
        }
    }
### Game Class (Singleton)
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
### Board CLass
    //package src;
    //import Game.java;
    
    
    import java.sql.SQLOutput;
    
    public class Board {
    
        //init two dim array with spaces
        private String[][] arr = {{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},};
        private String[][] ai_arr = {{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},};
        private String[] observer = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ", " "};
        private String[] observer_backup = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ", " "};
        private int missHitDestroy;
        private BoatList bl;
    
        public void createBoardList(Carrier c, Battleship b1, Battleship b2, Submarine s1, Submarine s2, Submarine s3,
                                    Patrol_Boat p1, Patrol_Boat p2, Patrol_Boat p3, Patrol_Boat p4){
            Ships[] listing = {c, b1, b2, s1, s2, s3, p1, p2, p3, p4};
            this.bl = new BoatList(listing);
        }
    
    
        //Prints the Board
        public void printBoard(){
    
            System.out.println("\n");
            System.out.println("Your board is:  \n" );
            //System.out.println("\n");
    
            System.out.println("   |[A][B][C][D][E][F][G][H][I][J]");
            System.out.println("---|------------------------------");
            for (int i=0;i<10;i++) {
                System.out.print("[" + i + "]|");
                for (int j = 0; j < 10; j++) {
                    System.out.print("[" + arr[i][j] + "]");
                }
                System.out.println();
            }
            System.out.println("---|------------------------------\n");
    
            //System.out.println("\n");
            System.out.println("The opponent's board is: \n");
    
            //System.out.println("\n");
            //for (int n=0; n < 31; n++){
                //System.out.print(observer[n] + " ");
            }
            //System.out.println();
        //}
    
        public void printAIBoard(){
            System.out.println("   |[A][B][C][D][E][F][G][H][I][J]");
            System.out.println("---|------------------------------");
            for (int i=0;i<10;i++) {
                System.out.print("[" + i + "]|");
                for (int j = 0; j < 10; j++) {
                    System.out.print("[" + ai_arr[i][j] + "]");
                }
                System.out.println();
            }
        }
    
    
        //Switch String to Int Array
        public int[] p(String s){
            int[] position = new int[5];
            for (int i = 0; i < 5; i++){
                char character = s.charAt(i);
                int ascii = (int) character;
                if (ascii >= 65 && ascii < 75){
                    position[i] = ascii - 65;
                } else if(ascii >= 48 && ascii < 58){
                    position[i] = ascii - 48;
                }
                else{ position[i] = 666;}
            }
            return position;
    
        }
    
    
        //Switch String to Int Array
        public int[] p_for_attack(String s){
            int[] position = new int[2];
            for (int i = 0; i < 2; i++){
                char character = s.charAt(i);
                int ascii = (int) character;
                if (ascii >= 65 && ascii < 75){
                    position[i] = ascii - 65;
                } else if(ascii >= 48 && ascii < 58){
                    position[i] = ascii - 48;
                }
                else{ position[i] = 666;}
            }
            return position;
    
        }
    
        //Draw the type in the Board. Input: String, int, String.
        public void drawShip(String s, int size, String type){
            int[] place = p(s);
    
            //If the column stays the same
            if (place[0] == place[3]){
                for (int i=0;i<size;i++){
                    arr[place[1]+i][place[0]] = type;
                    //adding position in string (f.e. A1 -> "01") to observer at fist free position
                    int j = 0;
                    while(observer[j]!=" ") { ++j; }
                    String ob =  String.format("%d",place[0]) + String.format("%d",place[1]+i);
                    observer[j]= ob;
                    observer_backup[j]= ob;
                }
            }
            //If the row stays the same
            else{
                for (int i=0;i<size;i++){
                    arr[place[1]][place[0]+i] = type;
                    int j = 0;
                    while(observer[j]!=" ") { ++j; }
                    String ob =  String.format("%d",place[0]+i) + String.format("%d",place[1]);
                    observer[j]= ob;
                    observer_backup[j]= ob;
                }
    
            }
        }
    
        //Draw X or O in ai_arr
        public void drawXorOUserAttack(String s){
            String o = "O";
            int[] pos = p_for_attack(s);
            if(arr[pos[1]][pos[0]]==" "){
                ai_arr[pos[1]][pos[0]]=o;
                missHitDestroy = 0;
            }
            else{
                if(!o.equals(arr[pos[1]][pos[0]])){
                    ai_arr[pos[1]][pos[0]]="X";
                    missHitDestroy = 1;
                    add_to_observer(String.format("%d",pos[0]) + String.format("%d",pos[1]));
    
                }
            }
        }
        public void drawXorOAIAttack(String s){
            String o = "O";
            int[] pos = p_for_attack(s);
            if(arr[pos[1]][pos[0]]==" "){
                arr[pos[1]][pos[0]]=o;
                missHitDestroy = 2;
            }
            else{
                if(!o.equals(arr[pos[1]][pos[0]])){
                    arr[pos[1]][pos[0]]="X";
                    missHitDestroy = 3;
                    add_to_observer(String.format("%d",pos[0]) + String.format("%d",pos[1]));
                }
            }
        }
    
        //replace hit in observer with X
        public void add_to_observer(String x){
            for (int n = 0; n < 31; n++){
                if(x.equals(observer[n])){
                    observer[n] = "X";
                }
            }
        }
    
        //check observer if full ship is hit
        public int observerCheck(Carrier c, Battleship b1, Battleship b2, Submarine s1, Submarine s2, Submarine s3,
                                  Patrol_Boat p1, Patrol_Boat p2, Patrol_Boat p3, Patrol_Boat p4, int recognize){
            Ships[] listing = {c, b1, b2, s1, s2, s3, p1, p2, p3, p4};
            String x = "X";
            if (c.getIsAlive()){
                if (x.equals(observer[0]) && x.equals(observer[1]) && x.equals(observer[2]) && x.equals(observer[3]) && x.equals(observer[4]) && x.equals(observer[5]) ){
                    c.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=4;
                        for (int i = 0; i<6;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= c.getType();
                        }
                    }
                    else{
                        missHitDestroy=5;
                    }
                }
            }
            if (b1.getIsAlive()) {
                if (x.equals(observer[6]) && x.equals(observer[7]) && x.equals(observer[8]) && x.equals(observer[9])) {
                    b1.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=6;
                        for (int i = 6; i<10;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= b1.getType();
                        }
                    }
                    else{
                        missHitDestroy=7;
                    }
                }
            }
            if (b2.getIsAlive()) {
                if (x.equals(observer[10]) && x.equals(observer[11]) && x.equals(observer[12]) && x.equals(observer[13])) {
                    b2.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=8;
                        for (int i = 10; i<14;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= b2.getType();
                        }
                    }
                    else{
                        missHitDestroy=9;
                    }
                }
            }
            if (s1.getIsAlive()) {
                if (x.equals(observer[14]) && x.equals(observer[15]) && x.equals(observer[16])) {
                    s1.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=10;
                        for (int i = 14; i<17;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= s1.getType();
                        }
                    }
                    else{
                        missHitDestroy=11;
                    }
                }
            }
            if (s2.getIsAlive()) {
                if (x.equals(observer[17]) && x.equals(observer[18]) && x.equals(observer[19])) {
                    s2.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=12;
                        for (int i = 17; i<20;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= s2.getType();
                        }
                    }
                    else{
                        missHitDestroy=13;
                    }
                }
            }
            if (s3.getIsAlive()) {
                if (x.equals(observer[20]) && x.equals(observer[21]) && x.equals(observer[22])) {
                    s3.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=14;
                        for (int i = 20; i<23;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= s3.getType();
                        }
                    }
                    else{
                        missHitDestroy=15;
                    }
                }
            }
            if (p1.getIsAlive()) {
                if (x.equals(observer[23]) && x.equals(observer[24])) {
                    p1.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=16;
                        for (int i = 23; i<25;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= p1.getType();
                        }
                    }
                    else{
                        missHitDestroy=17;
                    }
                }
            }
            if (p2.getIsAlive()) {
                if (x.equals(observer[25]) && x.equals(observer[26])) {
                    p2.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=18;
                        for (int i = 25; i<27;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= p2.getType();
                        }
                    }
                    else{
                        missHitDestroy=19;
                    }
                }
            }
            if (p3.getIsAlive()) {
                if (x.equals(observer[27]) && x.equals(observer[28])) {
                    p3.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=20;
                        for (int i = 27; i<29;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= p3.getType();
                        }
                    }
                    else{
                        missHitDestroy=21;
                    }
                }
            }
            if (p4.getIsAlive()) {
                if (x.equals(observer[29]) && x.equals(observer[30])) {
                    p4.setIsAlive(false);
                    if (recognize == 2){
                        missHitDestroy=22;
                        for (int i = 29; i<31;i++){
                            String part1 = observer_backup[i].substring(0,1);
                            String part2 = observer_backup[i].substring(1,2);
                            int pos1 = Integer.parseInt(part1);
                            int pos2 = Integer.parseInt(part2);
                            ai_arr[pos2][pos1]= p4.getType();
                        }
                    }
                    else{
                        missHitDestroy=23;
                    }
                }
            }
    /*
            int counterPlayer = 10;
            for(int i=0; i<10; i++){
                if(!listing[i].getIsAlive()) {
                    counterPlayer --;}
            }
    /*
            for(int i=0; i<31; i++){
                System.out.print(observer[i] + " ");
            }*/
    
            int counterPlayer = 10;
            this.bl.setCounter();
            while(this.bl.hasNext()){
                Ships p = this.bl.next();
                if (!p.getIsAlive()){
                    counterPlayer --;
                }
            }
    
            System.out.println(" ");
            return counterPlayer;
    
        }
    
        public int getMissHitDestroyVar(){
            return missHitDestroy;
        }
    
    //PUT ALL CHECKS HERE:
    
        //This method checks the Input of the user. MAIN of checking. TRUE if everything is valid
        public boolean checking(String s, int size){
            try{
                int[] intarr = p(s); //A1 A5 -> [0,1,666,0,5]
                String[] words=s.split(" ");
    
                //used to check if there is a space between the input words
                String[] characters=s.split("");
                assert size == 6 ;
                //if there are more or less than two string --> false
                if (words.length!=2){return false;}
    
                //if one of the word has more or less than 2 chars --> false
                else if((words[0].length() != 2) || (words[1].length() != 2)){return false;}
    
                //Checks if the words are the same
                else if(words[0].equals(words[1])){return false;}
    
                //Checks if all words start with A or B ...
                else if(!(checkStartChar(words[0]) && checkStartChar(words[1]))){return false;}
    
                //Checks if all words end with a number
                else if(!(checkEndsNumber(words[0]) && checkEndsNumber(words[1]))){return false;}
    
                //Checks if the words are the same
                else if(words[0].equals(words[1])){return false;}
    
    
                //changed the greedy method ends & starts with...
    
                //check if first alphabetical letter is in range of 1-9
                else if(intarr[0] > 9 || intarr[0] < 0){return false;}
    
                //check if first number of input is in range of 1-9
                else if(intarr[1] > 9 || intarr[1] < 0){return false;}
    
                //check if there is a space and not another character between
                else if(!characters[2].equals(" ")){return false;}
    
                //check if second alphabetical letter is in range of 1-9
                else if(intarr[3] > 9 || intarr[3] < 0){return false;}
    
                //check if second number of input is in range of 1-9
                else if(intarr[4] > 9 || intarr[4] < 0){return false;}
    
                //checks if not diagonal
                else if(intarr[0] == intarr[3] && !(intarr[4] - intarr[1] + 1 == size)){return false;}
                else if(intarr[0] !=(intarr[3]) && intarr[1] != intarr[4]){return false;}
                else if(!(intarr[3] - intarr[0] + 1 == size) && intarr[1] == intarr[4]){return false;}
    
                else if(intarr[0] == intarr[3]){
                    for(int i=0; i<size;i++){
                        if (arr[intarr[1]+i][intarr[0]] != " "){return false;}}
                }
    
                else{
                    for(int i=0; i<size;i++){
                        if (arr[intarr[1]][intarr[0]+i] != " "){return false;}
                    }
                }
    
                return true;
            }
            catch(Exception e){
                return false;
            }
    
        }
    
    
    
        //True if the String is valid example E3 or A1
        public boolean attackPosChecker(String s){
            return (checkEndsNumber(s) && checkStartChar(s) && checkLengthOfAttackPosition(s) && checkFieldAlreadyChosen(s));
        }
    
        //True if String start with A or B or C usw
        private boolean checkStartChar(String s){
            if (s.startsWith("A")){return true;}
            else if (s.startsWith("B")){return true;}
            else if (s.startsWith("C")){return true;}
            else if (s.startsWith("D")){return true;}
            else if (s.startsWith("E")){return true;}
            else if (s.startsWith("F")){return true;}
            else if (s.startsWith("G")){return true;}
            else if (s.startsWith("H")){return true;}
            else if (s.startsWith("I")){return true;}
            else if (s.startsWith("J")){return true;}
            else{
                return false;
            }
    
        }
    
        //True if String ends with a number <10
        private boolean checkEndsNumber(String s){
            if (s.endsWith("0")){return true;}
            else if (s.endsWith("1")){return true;}
            else if (s.endsWith("2")){return true;}
            else if (s.endsWith("3")){return true;}
            else if (s.endsWith("4")){return true;}
            else if (s.endsWith("5")){return true;}
            else if (s.endsWith("6")){return true;}
            else if (s.endsWith("7")){return true;}
            else if (s.endsWith("8")){return true;}
            else if (s.endsWith("9")){return true;}
            else{return false;}
        }
    
        //True if String has a length of 2
        private boolean checkLengthOfAttackPosition(String s){
            int len = s.length();
            if (len==2){ return true; }
            else{ return false; }
        }
    
        //True if Field is playable
        private boolean checkFieldAlreadyChosen(String s){
            int[] pos = p_for_attack(s);
            if(ai_arr[pos[1]][pos[0]]==" " && arr[pos[1]][pos[0]]!="X" && arr[pos[1]][pos[0]]!="O"){
                return true;
            }
            else {return false;}
        }
    
    }

### Ships Abstract Class
    public abstract class Ships {
    
        private int size;
        private String type;
        private Boolean isAlive;
    
        public void setSize(int size) {
            this.size = size;
        }
    
        public void setIsAlive(Boolean isalive) {
            this.isAlive = isalive;
        }
    
        public void setType(String type) {
            this.type = type;
        }
    
        //Encapsulation for the size of the ships
        public int getSize(){
            return size;
        }
    
    
        public Boolean getIsAlive(){
            return isAlive;
        }
    
        //Get the Type of the ship (B or C or S or P). This will be in the Board!
        public String getType(){
            //This will be in the Board
            return type;
        }
    
        //Asks for the input. Returns the position of the ship
        public abstract String input();
    
    }
### Carrier Class 
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
### Battleship Class
    import java.util.Scanner;
    
    public class Battleship extends Ships{
    
        //This is important for the output!
        private static int counter = 0;
    
        //Constructor
        public Battleship(){
            counter+=1; //If in main new Battleship(), then the counter is +=1
            setSize(4);
            setType("B");
            setIsAlive(true);
        }
    
        public String input(){
            Scanner MyScanner = new Scanner(System.in);
            System.out.print("Please enter the position of your BattleShip " + counter + ": ");
            String ship = MyScanner.nextLine();
            return ship;
        }
    
    }
### Submarine Class
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

### Patrol_Boat Class
    import java.util.Scanner;
    
    public class Patrol_Boat extends Ships{
    
        //If this class gets initialized, the counter is +=1. This is important for the output!
        private static int counter = 0;
    
        //Constructor
        public Patrol_Boat(){
            counter+=1; //If in main new Patrol_Boat(), then the counter is +=1
            setSize(2);
            setType("P");
            setIsAlive(true);
        }
    
        public String input(){
            Scanner MyScanner = new Scanner(System.in);
            System.out.print("Please enter the position of your Patrol Boat " + counter + ": ");
            String ship = MyScanner.nextLine();
            return ship;
        }
    }
### BoardList Class
    public class BoatList implements Iterator{
        private Ships[] bl;
        int position = 0;
    
        public BoatList(Ships[] bl){
            this.bl = bl; }
    
        public Ships next(){
            Ships output = bl[position];
            position = position+1;
            return output;
        }
    
        public void setCounter(){
            this.position = 0;
        }
    
        public boolean hasNext(){
             /*if(position<10){
                return true;
            }else {
                return false;
            }*/
    
            if(position >= bl.length || bl[position] == null){
                return false;
            }else{
                return true;}
    
        }
    }

### Iterator Interface
    public interface Iterator {
        public boolean hasNext();
        public Object next();
        public void setCounter();
    
    }

