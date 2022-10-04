public class Vehicle{

    private String make;
    private String model;
    private int year;
    private double topSpeed;
    private int wins;
    private double purchasePrice;
    private double sellPrice;
    
    public Vehicle (String make, String model, int year, double topSpeed, int wins, double purchasePrice, double sellPrice){
        this.make = make;
        this.model = model;
        this.year = year;
        this.topSpeed = topSpeed;
        this.wins = wins;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }
    
    public String getMake(){
        return make;    
    }
    
    public String getModel(){
        return model;
    }
    
    public int getYear(){
        return year;    
    }
    
    public double getTopSpeed(){
        return topSpeed;    
    }
    
    public int getWins(){
        return wins;    
    }
    
    public double getPurchasePrice(){
        return purchasePrice;    
    }
    
    public double getSellPrice(){
        return sellPrice;    
    }
    
    public void setMake(String make){
        this.make = make;
    }
    
    public void setModel(String model){
        this.model = model;    
    }
    
    public void setYear(int year){
        this.year = year;    
    }
    
    public void setTopSpeed(double topSpeed){
        this.topSpeed = topSpeed;    
    }
    
    public void setWins(int wins){
        this.wins = wins;    
    }
    
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;    
    }
    
    public void setSellPrice(double sellPrice){
        this.sellPrice = sellPrice;    
    }
    
    public String toString(){
        
        String str1 = String.format("%.2f", topSpeed);
        String str2 = String.format("%.2f", purchasePrice);
        String str3 = String.format("%.2f", sellPrice);
        return "Vehicle<make=" + make + ", model=" + model + ", year=" + year + ", topSpeed=" + str1 + ", wins=" + wins + ", purchasePrice=" + str2 + ", sellingPrice=" + str3 + ">"; 
    }
}