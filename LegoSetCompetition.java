import java.util.Scanner;

//fix coding style
//fix sample test 3 winning sets
//add complete and incomplete sets

public class LegoSetCompetition{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Lego Set Competition!");
        System.out.println("Enter the name of Lego Set 1");
        String legoset1 = scan.nextLine();
        System.out.println("Enter the number of pieces in Lego Set 1");
        int legoset1t = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the name of Lego Set 2");
        String legoset2 = scan.nextLine();
        System.out.println("Enter the number of pieces in Lego Set 2");
        int legoset2t = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the name of Lego Set 3");
        String legoset3 = scan.nextLine();
        System.out.println("Enter the number of pieces in Lego Set 3");
        int legoset3t = scan.nextInt();
        scan.nextLine();
        int days = 0;
        boolean notDone = true;
        int totalPieces = legoset1t + legoset2t + legoset3t;
        int player1 = totalPieces;
        int player2 = totalPieces;
        String completedSetsPlayerOne = "";
        String completedSetsPlayerTwo = "";
        int completedPlayerOne = 0;
        int completedPlayerTwo = 0;
        boolean repeated = false;
        int dayplayerOne = 0;
        int dayplayerTwo = 0;
        int player1RELOADED = 0;
        int player2RELOADED = 0;
        int winningPlayer = 0;
                
        while(notDone){
            days++;
            System.out.println("Enter the number of pieces player 1 used for building on day " + days);
            dayplayerOne = scan.nextInt(); 
            System.out.println("Enter the number of pieces player 2 used for building on day " + days);
            dayplayerTwo = scan.nextInt();
            
            completedPlayerOne = completedPlayerOne + dayplayerOne;
            completedPlayerTwo = completedPlayerTwo + dayplayerTwo;
            
            player1 = player1 - dayplayerOne;
            player2 = player2 - dayplayerTwo;
            
            if (player1 <= 0 || player2 <= 0){
                notDone = false;        
            }
            
            if (player1 <= 0 && player2 <= 0){
                notDone = false;
                repeated = true;
                //create another while loop here for another run of the program with conditions for both
                
                boolean tryAgain = true;
                while (tryAgain){
                    scan.nextLine();
                    System.out.println("The competition ended in a tie! There will be a tiebreaker round");
                    System.out.println("Enter the name of Lego Set 1");
                    String legoset1to = scan.nextLine();
                    System.out.println("Enter the number of pieces of Lego Set 1");
                    int legoset1int = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter the name of Lego Set 2");
                    String legoset2to = scan.nextLine();
                    System.out.println("Enter the number of pieces of Lego Set 2");
                    int legoset2int = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter the name of Lego Set 3");
                    String legoset3to = scan.nextLine();
                    System.out.println("Enter the number of pieces of Lego Set 3");
                    int legoset3int = scan.nextInt();
                    scan.nextLine();
                    boolean notDoneRELOADED = true;
                    player1RELOADED = legoset1int + legoset2int + legoset3int;
                    player2RELOADED = legoset1int + legoset2int + legoset3int;
                    while(notDoneRELOADED){
                        days++;
                        System.out.println("Enter the number of pieces player 1 used for building on day " + days);
                        dayplayerOne = scan.nextInt(); 
                        System.out.println("Enter the number of pieces player 2 used for building on day " + days);
                        dayplayerTwo = scan.nextInt();
            
                        completedPlayerOne = completedPlayerOne + dayplayerOne;
                        completedPlayerTwo = completedPlayerTwo + dayplayerTwo;
            
                        player1RELOADED = player1RELOADED - dayplayerOne;
                        player2RELOADED = player2RELOADED - dayplayerTwo;
                
                        if (player1RELOADED <= 0 || player2RELOADED <= 0){
                            notDoneRELOADED = false;    
                            tryAgain = false;
                        }
            
                        if (player1RELOADED <= 0 && player2RELOADED <= 0){
                            notDoneRELOADED = false;
                            tryAgain = true;
                
                        }
                    }
                }
            }
        }
        
        if (repeated == true){
            if (player1RELOADED <= 0){
                winningPlayer = 1;    
            }
            else if (player2RELOADED <= 0){
                winningPlayer = 2;    
            }
        }
        else {
            if (player1 <= 0){
                winningPlayer =  1;   
            }
        
            else if (player2 <= 0){
                winningPlayer = 2;    
            }    
        }
        
        System.out.println("Congratulations to player " + winningPlayer + " for winning the Lego Set Competition!");
        
        System.out.println("Additional information about the competition results is below");
        
        String playerOneCompletedSets = "None";
        String playerTwoCompletedSets = "None";
        String playerOneIncompletedSets = "None";
        String playerTwoIncompletedSets = "None";
        
        
        
        
        CompetitionLog playerOnep = new CompetitionLog(1, playerOneCompletedSets, playerOneIncompletedSets, completedPlayerOne);
        CompetitionLog playerTwop = new CompetitionLog(2, playerTwoCompletedSets, playerTwoIncompletedSets, completedPlayerTwo);
        
        System.out.println(playerOnep);
        System.out.println(playerTwop);
        
        System.out.println("The competition lasted " + days + " days");
    }
}