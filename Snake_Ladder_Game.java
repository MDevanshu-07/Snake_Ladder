import java.util.Scanner;
public class Snake_Ladder_Game {
    static Scanner sc=new Scanner(System.in);
    public int ladder(int x) {
        switch (x) {
            case 2 -> {
                return 23;
            }
            case 8 -> {
                return 34;
            }
            case 20 -> {
                return 77;
            }
            case 32 -> {
                return 68;
            }
            case 41 -> {
                return 79;
            }
            case 74 -> {
                return 88;
            }
            case 82 -> {
                return 100;
            }
            case 85 -> {
                return 95;
            }
            default -> {
                return x;
            }
        }
    }

    public int snake(int x) {
        switch (x) {
            case 29 -> {
                return 9;
            }
            case 38 -> {
                return 15;
            }
            case 47 -> {
                return 5;
            }
            case 53 -> {
                return 33;
            }
            case 62 -> {
                return 37;
            }
            case 86 -> {
                return 54;
            }
            case 92 -> {
                return 70;
            }
            case 97 -> {
                return 25;
            }
            default -> {
                return x;
            }
        }
    }

    public int roll() {
        return (int)(Math.random()*6 +1);
    }

    public int update(int pos, int play){

        int val,update; //val stores dice value, update stores position update after ladder or snake
        String ch; // ch for rolling the dice
        play+=1; // Player Identification

        System.out.println(); // just for better presentation of output
        System.out.println("Press R to Roll The Dice Player "+play);
        ch=sc.next();

        if (ch.equalsIgnoreCase("R")){
            val=roll(); // Calling roll() for a random value between 1 and 6

            if(val<=100-pos){ // Checks whether the dice value is not greater than the required value to reach 100
                pos+=val; // Updating of position according the value got on rolling the Dice
                System.out.println("You got "+val);
                System.out.println("Current Position of Player "+play+" is "+pos);

                if(pos<100) { // Checks whether the position is less than 100 or not
                    update = ladder(pos); // Calling ladder() to check for a ladder at current position

                    if (update == pos) { // If no update is there then we check for snake()
                        update = snake(pos);

                        if (update != pos) { // Update position due to snake()
                            System.out.println("You got bit by a snake");
                            pos = update;
                            System.out.println("Now the current Position of Player " + play + " is " + pos);
                        }
                    } else { //Update position due to ladder()
                        pos = update;
                        System.out.println("You got up a ladder");
                        System.out.println("Now the current Position Player " + play + " is " + pos);
                    }
                }
            }
            else{ // Value on Dice is greater than the required value
                System.out.println("Try getting a Smaller Value on Dice");
            }
        }
        else{
            System.out.println("Wrong Input! Try Again After");
        }
        return pos; // returning final updated position after (dice roll -> ladder check -> snake check)
    }

    static void main(String[] args) {
        Snake_Ladder_Game obj=new Snake_Ladder_Game();

        int choice; // Modes of Playing
        int[] players; // Each player position status record
        int num,i=0; // 'num' stores number of player, 'i' extract each player chance

        System.out.println("Press 1 to Play Offline");
        choice=sc.nextInt();

        if(choice==1){ // Multiplayer Choice
            System.out.println("Enter numbers of player you want to play with");
            num=sc.nextInt();
            players=new int[num]; // Allocating room for each player position

            while(players[i]<100){ // Checking player position
                players[i]=obj.update(players[i],i); // Calling Update function for position update

                if(players[i]>=100){ // Checking player position after Updating position
                    System.out.println("You Won Player "+(i+1));
                    break;
                }
                i++; // Changing to next Player

                if(i==num){ // Restart from player 1 after all the players rolls the dice
                    i=0;
                }

            }
        }
        else{ // This choice is not Available Yet!
            System.out.println("Invalid Choice");
        }

    }
}
