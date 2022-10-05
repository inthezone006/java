import java.util.Scanner;

/**
 * Lego Set Competition
 *
 * This stimulates a lego set competition
 *
 * @author Rahul Menon, CS180
 *
 * @version 10/04/2022
 *
 */

public class LegoSetCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Lego Set Competition!");
        System.out.println("Enter the name of Lego Set 1");
        String legoset1name = scan.nextLine();
        System.out.println("Enter the number of pieces in Lego Set 1");
        int legoset1pieces = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the name of Lego Set 2");
        String legoset2name = scan.nextLine();
        System.out.println("Enter the number of pieces in Lego Set 2");
        int legoset2pieces = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the name of Lego Set 3");
        String legoset3name = scan.nextLine();
        System.out.println("Enter the number of pieces of Lego Set 3");
        int legoset3pieces = scan.nextInt();
        int player1pieces = 0;
        int player2pieces = 0;
        boolean maingameloop = true;
        int days = 0;
        
        ArrayList<String> player1completed = new ArrayList<String>();
        ArrayList<String> player2completed = new ArrayList<String>();
        
        ArrayList<String> allSets = new ArrayList<String>();
        
        allSets.add(legoset1name);
        addSets.add(legoset2name);
        addSets.add(legoset3name);
        
        while (maingameloop) {
            System.out.println("Enter the number of pieces player 1 used for building on day " + days);
            player1pieces = player1pieces + scan.nextInt();
            System.out.println("Enter the number of pieces player 2 used for building on day " + days);
            player2pieces = player2pieces + scan.nextInt();
            
            
            if (player1pieces > legoset1pieces + legoset2pieces + legoset3pieces) {
                maingameloop = false;    
            }
            
            if (player2pieces > legotset1pieces + legoset2pieces + legoset3pieces) {
                maingameloop = false;    
            }
        }
        
        if (player1pieces > legoset1pieces){
            player1completed.add(legoset1name);                     
        }
        
        if (player1pieces > legoset2pieces){
             player1completed.add(legoset1name);
             player1completed.add(legoset2name);  
        }
        
        if (player1pieces > legoset3pieces){
            player1completed.add(legoset1name);
            player1completed.add(legoset2name);
            player1completed.add(legoset3name);
        }
        
        for (int x = 0; x < allsets.size(); x++){
            
        }
        
    }
}
        
        
        