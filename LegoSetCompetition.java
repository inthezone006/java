import java.util.ArrayList;
import java.util.Scanner;

public class LegoSetCompetition{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Lego Set Competition!");
        
        ArrayList<String> legosets = new ArrayList<String>();
        ArrayList<Integer> pieces = new ArrayList<Integer>();

        int i = 1;
        String currentName = "";
        int currentPieces = 0;
        while(true){
            System.out.println("Enter the name of Lego Set " + i);
            currentName = scan.nextLine();
            System.out.println("Enter the number of pieces of Lego Set " + i);
            currentPieces = scan.nextInt();
            scan.nextLine();
            legosets.add(currentName);
            pieces.add(currentPieces);
            i++;
            if (i == 4){
                break;
            }
        }

        int total = pieces.get(0) + pieces.get(1) + pieces.get(2);

        int days = 1;
        int player1 = 0;
        int player2 = 0;

        boolean gameOn = true;
        int winner = 0;

        ArrayList<String> player1complete = new ArrayList<String>();
        ArrayList<String> player2complete = new ArrayList<String>();
        ArrayList<String> player1incomplete = new ArrayList<String>(legosets);
        ArrayList<String> player2incomplete = new ArrayList<String>(legosets);


        while(gameOn){
            System.out.println("Enter the number of pieces player 1 used for building on day " + days);
            player1 = player1 + scan.nextInt();
            System.out.println("Enter the number of pieces player 2 used for building on day " + days);
            player2 = player2 + scan.nextInt();
            days++;


            if (player1 >= total || player2 >= total){
                gameOn = false;
                
                if (player1 > pieces.get(0)){
                    player1complete.add(legosets.get(0));
                    if (player1 > pieces.get(1)){
                        player1complete.add(legosets.get(1));
                        if (player1 > pieces.get(2)){
                            player1complete.add(legosets.get(2));
                        }
                    } 
                }

                if (player2 > pieces.get(0)){
                    player2complete.add(legosets.get(0));
                    if (player2 > pieces.get(1)){
                        player2complete.add(legosets.get(1));
                        if (player2 > pieces.get(2)){
                            player2complete.add(legosets.get(2));
                        }
                    } 
                }
                
                if (player1 >= total){
                    //if player 1 wins
                    winner = 1;
                } 

                else if (player2 >= total){
                    //if player 2 wins
                    winner = 2;
                }

                if (player1 >= total && player2 >= total){
                    gameOn = true;
                }
                

            }
        }

        String player1completed = "";
        String player2completed = "";
        String player1incompleted = "";
        String player2incompleted = "";

        for (int x = 0; x < player1complete.size(); x++){
            player1completed = player1completed + player1complete.get(x) + ", ";
        }


        if(player1completed.equals("")){
            player1completed = "None";
        }

        else{
            player1completed = player1completed.substring(0, player1completed.length() - 1);
        }
        

        for (int y = 0; y < player2complete.size(); y++){
            player2completed = player2completed + player2complete.get(y) + ", ";
        }

        //formatting

        if(player2completed.equals("")){
            player2completed = "None";
        }

        else{
            player2completed = player2completed.substring(0, player2completed.length() - 1);
        }

        if(player1incompleted.equals("")){
            player1incompleted = "None";
        }

        else{
            player1incompleted = player1incompleted.substring(0, player1incompleted.length() - 1);
        }

        if(player2incompleted.equals("")){
            player2incompleted = "None";
        }

        else{
            player2incompleted = player2incompleted.substring(0, player2incompleted.length() - 1);
        }

        

        CompetitionLog playerOne = new CompetitionLog(1, player1completed, player1incompleted, player1);
        CompetitionLog playerTwo = new CompetitionLog(2, player2completed, player2incompleted, player2);

        System.out.println("Congratulations to player " + winner + " for winning the Lego Set Competition!\nAdditional information about the competition results is below");
        System.out.println(playerOne);
        System.out.println(playerTwo);

        System.out.println("The competition lasted " + days + " days");

    }
}