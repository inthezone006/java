public class runcar {
    /**
     * @param args
     */
    public static void main(String[] args){
        Vehicle firstCar = new Vehicle("Toyota", "Camry", 2000, 120.00, 3, 9500.00, 500.00);
        Vehicle secondCar = new Vehicle("Toyota", "GR86", 2022, 150.00, 10, 35000.00, 30000.00);
        Vehicle thirdCar = new Vehicle("Toyota", "Supra", 1998, 200.00, 50, 100000.00, 1000000.00);
        
        Vehicle fourthCar = new Vehicle("Toyota", "Camry", 2000, 120.00, 3, 9500.00, 500.00);
        RacecarTeam myteam = new RacecarTeam(firstCar, secondCar, thirdCar);
        System.out.println(myteam.removeVehicle(fourthCar));

    }


}
