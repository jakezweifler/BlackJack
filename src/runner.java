import java.util.*;

public class runner {

    public static void main(String[] args) throws InterruptedException {
        boolean playing = true;

        while(playing) {
            System.out.println("Welcome to the tables! Would you like to play a game?");
            Scanner myObj = new Scanner(System.in);
            String ans = myObj.nextLine();

            if(ans.equals("no")) {
                System.out.println("ok, bye!");
                playing = false;
            }
            else {
                System.out.println("cool!");

                List<String> dealer = new ArrayList<>();
                List<String> player = new ArrayList<>();

                Deck d = new Deck();

                dealer.add(d.draw());
                dealer.add(d.draw());

                player.add(d.draw());
                player.add(d.draw());



                boolean stick = false;
                boolean bust = false;
                while(!stick) {
                    printHand(player, dealer, false);
//                    System.out.println("hand value is " + scoreEval(player));
                    System.out.println("Would you like to hit?");

                    ans = myObj.nextLine();

                    if(ans.equals("yes")) {
                        player.add(d.draw());
                    }
                    else {
                        stick = true;
                    }
                    if (scoreEval(player) > 21) {
                        stick = true;
                        bust = true;
                        printHand(player, dealer, false);
                        System.out.println("you busted :(");
                    }
                }
//                System.out.println("final hand value is " + scoreEval(player));
                if(!bust) {
                    boolean dbust = false;
                    System.out.print("Dealer's turn");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.println(".");
                    Thread.sleep(1000);
                    printHand(player, dealer, true);
                    Thread.sleep(1000);

                    while (scoreEval(dealer) <= 16) {
                        dealer.add(d.draw());
                        System.out.println("dealer hits");
                        Thread.sleep(1000);
                        printHand(player, dealer, true);
                        Thread.sleep(1000);
                    }

                    if(scoreEval(dealer) < 22) {
                        System.out.println("dealer sticks");
                    }
                    else {
                        System.out.println("dealer busted :(");
                        dbust = true;
                    }


                    if(dbust) {
                        System.out.println("player wins with " + scoreEval(player));
                    }
                    else{
                        if(scoreEval(dealer) >= scoreEval(player)) {
                            System.out.println("dealer wins with " + scoreEval(dealer));
                        }
                        else {
                            System.out.println("player wins with " + scoreEval(player));
                        }
                    }

                }
                else {
                    printHand(player, dealer, true);
                    System.out.println("dealer wins with " + scoreEval(dealer));
                }


            }

        }
    }

    public static void printHand(List<String> phand, List<String> chand, Boolean show) {
        int padding = 40; //used to center the computer text info
        String output = "Player's Hand: ";

        for(String card : phand) {
            output += card + " ";
        }
        for(int i = output.length(); i < padding; i++) {
            output += " ";
        }

        if(show) {
            output += "Computer's Hand: ";
            for(String card : chand) {
                output += card + " ";
            }
        }
        else {
            output += "Computer's Hand: ?? ";
            for(int i = 1; i < chand.size(); i++) {
                output += chand.get(i);
            }
        }
        System.out.println(output);
    }


    public static int scoreEval(List<String> hand) {
        Hashtable<String, Integer> toInt = new Hashtable<>(); //using dictionaries makes this slightly faster than a bunch of if statements
        toInt.put("A", 1);
        toInt.put("2", 2);
        toInt.put("3", 3);
        toInt.put("4", 4);
        toInt.put("5", 5);
        toInt.put("6", 6);
        toInt.put("7", 7);
        toInt.put("8", 8);
        toInt.put("9", 9);
        toInt.put("T", 10);
        toInt.put("J", 10);
        toInt.put("Q", 10);
        toInt.put("K", 10);

        List<Integer> ints = new ArrayList<>();

        for(String str : hand) {
            String val = str.substring(0, str.length() - 1);
            ints.add((Integer) toInt.get(val));
        }
        boolean ace = false; //used to check if theres an ace so score must be evaluated correctly

        for(Integer i : ints) {
            if(i == 1) {
                ace = true;
            }
        }
        int sum = 0;
        for(Integer i : ints){
            sum += (int) i;
        }

        if(ace){
            int sum1 = sum + 10; //note that sum1 > sum is the larger possible score.
            if(sum1 > 21) { //will either return the lower bad sum or a good sum
                return sum;
            }
            else {
                return sum1; //if both sums are <21, will return larger.
            }
        }

        return sum;
    }



}


