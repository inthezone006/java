import java.util.ArrayList;

public class AmusementPark extends Object implements Park{
    private double admissionCost;
    private boolean arcade;
    private boolean bowling;
    private boolean indoor;
    private double land;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;

    public AmusementPark(String name, double admissionCost, double land, ArrayList<Ride> rides, boolean indoor, boolean outdoor, boolean arcade, boolean bowling, boolean[] seasons){
        this.admissionCost = admissionCost;
        this.arcade = arcade;
        this.bowling = bowling;
        this.indoor = indoor;
        this.land = land;
        this.name = name;
        this.outdoor = outdoor;
        this.rides = rides;
        this.seasons = seasons;
    }

    public void addRide(Ride ride) throws WrongRideException{
        if(ride instanceof Rollercoaster){
            rides.add(ride); 
        }
        
        else{
            throw new WrongRideException("An amusement park can only have rollercoaster rides!");
        }
    }

    public void close(){
        name = "";
        admissionCost = 0;
        land = 0;
        rides = null;
        seasons = null;
        indoor = false;
        outdoor = false;
        arcade = false;
        bowling = false;
    }

    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException{
        land = land + addedLand;
        
        if (land > maxLand){
            throw new SpaceFullException("There is no more land to use for this park!");
        }

        if (addedOutdoor == true && outdoor == false){
            outdoor = true;
        }

        if (addedIndoor == true && indoor == false){
            indoor = true;
        }
    }

    public double getAdmissionCost(){
        return admissionCost;
    }

    public double getLand(){
        return land;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Ride> getRides(){
        return rides;
    }

    public boolean[] getSeasons(){
        return seasons;
    }

    public boolean isArcade(){
        return arcade;
    }

    public boolean isBowling(){
        return bowling;
    }

    public boolean isIndoor(){
        return indoor;
    }

    public boolean isOutdoor(){
        return outdoor;
    }

    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight, int newMaxRides, boolean newSimulated){
        int theIndex = rides.indexOf(ride);
        rides.set(theIndex, new Rollercoaster(newName, newColor, newMinHeight, newMaxRides, newSimulated));
    }

    public void removeRide(Ride ride){
        int myIndex = rides.indexOf(ride);
        rides.remove(myIndex);
    }

    public void setAdmissionCost(double admissionCost){
        this.admissionCost = admissionCost;
    }

    public void setArcade(boolean arcade){
        this.arcade = arcade;
    }

    public void setBowling(boolean bowling){
        this.bowling = bowling;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSeasons(boolean[] seasons){
        this.seasons = seasons;
    }
}
