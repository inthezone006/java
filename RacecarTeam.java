public class RacecarTeam{
    private Vehicle vehicleOne;
    private Vehicle vehicleTwo;
    private Vehicle vehicleThree;
    
    public RacecarTeam(Vehicle vehicleOne, Vehicle vehicleTwo, Vehicle vehicleThree){
        this.vehicleOne = vehicleOne;
        this.vehicleTwo = vehicleTwo;
        this.vehicleThree = vehicleThree;
    }
    
    public RacecarTeam(){
            
    }
    
    public boolean addVehicle(Vehicle vehicle){
        boolean returnValue = false;
        if (vehicleOne == null){
            this.vehicleOne = vehicle;
            returnValue = true;
        }
        
        if (vehicleTwo == null){
            this.vehicleTwo = vehicle;
            returnValue = true;
        }
        
        if (vehicleThree == null){
            this.vehicleThree = vehicle;
            returnValue = true;
        }
        
        return returnValue;
    }
    
    public boolean removeVehicle(Vehicle vehicle){
        boolean anotherreturnvalue = false;
        if (vehicleOne.getMake().equals(vehicle.getMake()) && vehicleOne.getModel().equals(vehicle.getModel()) && vehicleOne.getYear() == vehicle.getYear()){
            vehicleOne = null;
            anotherreturnvalue = true;
        }
        
        if (vehicleTwo.getMake().equals(vehicle.getMake()) && vehicleTwo.getModel().equals(vehicle.getModel()) && vehicleTwo.getYear() == vehicle.getYear()){
            vehicleTwo = null;
            anotherreturnvalue = true;
        }
        
        if (vehicleThree.getMake().equals(vehicle.getMake()) && vehicleThree.getModel().equals(vehicle.getModel()) && vehicleThree.getYear() == vehicle.getYear()){
            vehicleThree = null;
            anotherreturnvalue = true;
        }
        
        return anotherreturnvalue;
        
    }
    
    public int getOpenings(){
        int number = 0;
        if (vehicleOne == null){
            number++;
        }
        
        if (vehicleTwo == null){
            number++;    
        }
        
        if (vehicleThree == null){
            number++;    
        }
        
        return number;
           
    }
    
    public int getVehicleCount(){
        int vehicles = 3;
        
        if (vehicleOne == null){
            vehicles--;    
        }
        
        if (vehicleTwo == null){
            vehicles--;    
        }
        
        if (vehicleThree == null){
            vehicles--;    
        }
        
        return vehicles;
    }
    
    public double calculateAverageCostPerWin(){
        double totalPrice = 0.00;
        int allWins = 0;
        
        if (vehicleOne != null){
            totalPrice = totalPrice + vehicleOne.getPurchasePrice();
            allWins = allWins + vehicleOne.getWins();
        }
        if (vehicleTwo != null){
            totalPrice = totalPrice + vehicleTwo.getPurchasePrice();
            allWins = allWins + vehicleTwo.getWins();
        }
        if (vehicleThree != null){
            totalPrice = totalPrice + vehicleThree.getPurchasePrice();
            allWins = allWins + vehicleThree.getWins();
        }  
        
        double totaltotal = totalPrice / allWins;
        return totaltotal;
    }
    
    public double getFastestSpeed(){
        double highestSpeed = 0.00;
        if (vehicleOne != null){
            if (vehicleOne.getTopSpeed() > highestSpeed){
                highestSpeed = vehicleOne.getTopSpeed();        
            }
        }
        if (vehicleTwo != null){
            if (vehicleTwo.getTopSpeed() > highestSpeed){
                highestSpeed = vehicleTwo.getTopSpeed();        
            }
        }
        if (vehicleThree != null){
            if (vehicleThree.getTopSpeed() > highestSpeed){
                highestSpeed = vehicleThree.getTopSpeed();        
            }
        }
        
        return highestSpeed;
            
    }
    
    
}