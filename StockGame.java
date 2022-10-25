import java.io.*;

public class StockGame extends Thread {
    
    
    
    private static double stockPrice = 100.00;
    private static int availableShares = 100;
    private static int tradeCount;
    private String name;
    private int numShares;
    private String fileName;
    
    public StockGame(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }
    
    
    public void run() {
        try {
            File myFile = new File(fileName);
            FileReader fr = new FileReader(myFile); 
            BufferedReader bfr = new BufferedReader(fr);
            String line = "";
            line = bfr.readLine();
            int buyorsellamount = 0;
            while (line != null) {
            
                if (line.startsWith("B")) {
                    buyorsellamount = Integer.parseInt(line.substring(4));
                    
                    if (buyorsellamount < 0){
                        System.out.println("Error, invalid input!");
                    } else {
                        System.out.println("----------");
                        System.out.println("Stock Price: " + stockPrice);
                        System.out.println("Available Shares: " + availableShares);
                        System.out.println("Trade number: " + tradeCount);
                        System.out.println("Name: " + name);
                        System.out.println("Purchasing " + buyorsellamount + " shares at " + stockPrice + "...");
                        
                        if (buyorsellamount > availableShares){
                            System.out.println("Insufficient shares available, cancelling order..."); 
                        } else {
                            numShares = numShares + buyorsellamount;
                            availableShares = availableShares - buyorsellamount;
                            stockPrice = stockPrice + (1.5 * buyorsellamount);
                            tradeCount++;
                        }
                    }
                    
                } else {
                    buyorsellamount = Integer.parseInt(line.substring(5));
                    
                    if (buyorsellamount < 0) {
                        System.out.println("Error, invalid input!");
                    } else {
                        System.out.println("----------");
                        System.out.println("Stock Price: " + stockPrice);
                        System.out.println("Available Shares: " + availableShares);
                        System.out.println("Trade number: " + tradeCount);
                        System.out.println("Name: " + name);
                        System.out.println("Selling " + buyorsellamount + " shares at " + stockPrice + "...");
                        
                        if (buyorsellamount > availableShares){
                            System.out.println("Insufficient owned shares, cancelling order..."); 
                        } else {
                            numShares = numShares - buyorsellamount;
                            availableShares = availableShares + buyorsellamount;
                            stockPrice = stockPrice - (2.0 * buyorsellamount);
                            tradeCount++;
                        }
                    }
                }
                
                line = bfr.readLine();
                
            }
            
            bfr.close();
        } catch (Exception e){
           e.printStackTrace(); 
        }
    }
    
    
    public static void main(String[] args) {       
    
        try {
            
            StockGame[] stockTraders = {new StockGame("Xander", "TraderOneMoves.txt"),
            new StockGame("Afua", "TraderTwoMoves.txt")};

            for (int i = 0; i < stockTraders.length; i++) {
                stockTraders[i].start();
            }
            
            for (int i = 0; i < stockTraders.length; i++) {
                stockTraders[i].join();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}