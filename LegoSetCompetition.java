<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Scanner;

public class LegoSetCompetition{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Lego Set Competition!");
        
        ArrayList<String> legosets = new ArrayList<String>();
        ArrayList<Integer> pieces = new ArrayList<Integer>();

        String currentName = "";
        int currentPieces = 0;

        boolean gameOn = true;
        
        int player1 = 0;
        int player2 = 0;

        String player1completed = "";
        String player2completed = "";
        String player1incompleted = "";
        String player2incompleted = "";

        int winner = 0;

        int days = 1;


        ArrayList<String> allPlayerOneComplete = new ArrayList<String>();
        ArrayList<String> allPlayerTwoComplete = new ArrayList<String>();
        ArrayList<String> allPlayerOneIncomplete = new ArrayList<String>();
        ArrayList<String> allPlayerTwoIncomplete = new ArrayList<String>();

        

        while(gameOn){
            for (int u = 1; u < 4; u++){
                System.out.println("Enter the name of Lego Set " + u);
                currentName = scan.nextLine();
                System.out.println("Enter the number of pieces of Lego Set " + u);
                currentPieces = scan.nextInt();
                scan.nextLine();
                legosets.add(currentName);
                pieces.add(currentPieces);
            }
        

            int total = pieces.get(0) + pieces.get(1) + pieces.get(2);

            ArrayList<String> player1complete = new ArrayList<String>();
            ArrayList<String> player2complete = new ArrayList<String>();
            ArrayList<String> player1incomplete = new ArrayList<String>(legosets);
            ArrayList<String> player2incomplete = new ArrayList<String>(legosets);

            int player1game = 0;
            int player2game = 0;

            boolean gamePlay = true;

            while(gamePlay){
                System.out.println("Enter the number of pieces player 1 used for building on day " + days);
                player1game = player1game + scan.nextInt();
                //player1 = player1 + player1game;
                System.out.println("Enter the number of pieces player 2 used for building on day " + days);
                player2game = player2game + scan.nextInt();
                //player2 = player2 + player2game;
                days++;


                if (player1game >= total || player2game >= total){
                    gameOn = false;
                    player1 = player1 + player1game;
                    player2 = player2 + player2game;
                    if (player1game >= pieces.get(0)){
                        player1complete.add(legosets.get(0));
                        player1incomplete.remove(0);
                        if (player1game >= pieces.get(0) + pieces.get(1)){
                            player1complete.add(legosets.get(1));
                            player1incomplete.remove(0);
                            if (player1game >= pieces.get(0) + pieces.get(1) + pieces.get(2)){
                                player1complete.add(legosets.get(2));
                                player1incomplete.remove(0);
                            }
                        } 
                    }

                    if (player2game >= pieces.get(0)){
                        player2complete.add(legosets.get(0));
                        player2incomplete.remove(0);
                        if (player2game >= pieces.get(0) + pieces.get(1)){
                            player2complete.add(legosets.get(1));
                            player2incomplete.remove(0);
                            if (player2game >= pieces.get(0) + pieces.get(1) + pieces.get(2)){
                                player2complete.add(legosets.get(2));
                                player2incomplete.remove(0);
                            }
                        } 
                    }

                    for (int x = 0; x < player1complete.size(); x++){
                        allPlayerOneComplete.add(player1complete.get(x));
                    }

                    for (int x = 0; x < player2complete.size(); x++){
                        allPlayerTwoComplete.add(player2complete.get(x));
                    }

                    for (int x = 0; x < player1incomplete.size(); x++){
                        allPlayerOneIncomplete.add(player1incomplete.get(x));
                    }

                    for (int x = 0; x < player2incomplete.size(); x++){
                        allPlayerTwoIncomplete.add(player2incomplete.get(x));
                    }

                
                    if (player1game >= total){
                        //if player 1 wins
                        winner = 1;
                        gameOn = false;
                        gamePlay = false;
                    } 

                    else if (player2game >= total){
                        //if player 2 wins
                        winner = 2;
                        gameOn = false;
                        gamePlay = false;
                    }

                    if (player1game >= total && player2game >= total){
                        //only keep days and completed sets
                        gameOn = true;
                        gamePlay = false;
                        System.out.println("The competition ended in a tie! There will be a tiebreaker round");
                        player1game = 0;
                        player2game = 0;
                        scan.nextLine();
                        legosets.removeAll(legosets);
                        pieces.removeAll(pieces);
                        player1complete.removeAll(player1complete);
                        player2complete.removeAll(player2complete);
                        player1incomplete.removeAll(player1incomplete);
                        player2complete.removeAll(player2complete); 
                    }
                }
            }

            

            //formatting

            for (int x = 0; x < allPlayerOneComplete.size(); x++){
                player1completed = player1completed + allPlayerOneComplete.get(x) + ", ";
            }

            for (int y = 0; y < allPlayerTwoComplete.size(); y++){
                player2completed = player2completed + allPlayerTwoComplete.get(y) + ", ";
            }

            for (int t = 0; t < allPlayerOneIncomplete.size(); t++){
                player1incompleted = player1incompleted + allPlayerOneIncomplete.get(t) + ", ";
            }


            for (int x = 0; x < allPlayerTwoIncomplete.size(); x++){
                player2incompleted = player2incompleted + allPlayerTwoIncomplete.get(x) + ", ";
            }
        }

        if(player1completed.isEmpty()){
            player1completed = "None";
        }


        else{
            player1completed = player1completed.substring(0, player1completed.length() - 2);
        }

        if(player2completed.isEmpty()){
            player2completed = "None";
        }

        else{
            player2completed = player2completed.substring(0, player2completed.length() - 2);
        }

        if(player1incompleted.isEmpty()){
            player1incompleted = "None";
        }

        else{
            player1incompleted = player1incompleted.substring(0, player1incompleted.length() - 2);
        }

=======
public class LegoSetCompetition(){
    public static void main(String[] args){
>>>>>>> d8ce904 (my changes)
        
        if(player2incompleted.isEmpty()){
            player2incompleted = "None";
        }

        else{
            player2incompleted = player2incompleted.substring(0, player2incompleted.length() - 2);
        }

        CompetitionLog playerOne = new CompetitionLog(1, player1completed, player1incompleted, player1);
        CompetitionLog playerTwo = new CompetitionLog(2, player2completed, player2incompleted, player2);

        System.out.println("Congratulations to player " + winner + " for winning the Lego Set Competition!\nAdditional information about the competition results is below");
        System.out.println(playerOne);
        System.out.println(playerTwo);

        days--;
        System.out.println("The competition lasted " + days + " days");

    }
}