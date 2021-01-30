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
