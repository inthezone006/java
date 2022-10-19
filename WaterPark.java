import java.util.ArrayList;

public class WaterPark extends Object implements Park{
    private double admissionCost;
    private boolean indoor;
    private double land;
    private boolean lazyRiver;
    private String name;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;
    private boolean wavePool;

    public WaterPark(String name, double admissionCost, double land, ArrayList<Ride> rides, boolean indoor, boolean outdoor, boolean lazyRiver, boolean wavePool, boolean[] seasons){
        this.admissionCost = admissionCost;
        this.indoor = indoor;
        this.land = land;
        this.lazyRiver = lazyRiver;
        this.name = name;
        this.outdoor = outdoor;
        this.rides = rides;
        this.seasons = seasons;
        this.wavePool = wavePool;
    }

    public void addRide(Ride ride){

    }

    public void close(){

    }

    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor){

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

    public boolean isIndoor(){
        return indoor;
    }

    public boolean isLazyRiver(){
        return lazyRiver;
    }

    public boolean isOutdoor(){
        return outdoor;
    }

    public boolean isWavePool(){
        return wavePool;
    }

    public void modifyRide(Ride ride, String newName, String newColor, int newMinHeight, int newMaxRiders, double newSplashDepth){

    }

    public void removeRide(Ride ride){

    }

    public void setAdmissionCost(double admissionCost){
        this.admissionCost = admissionCost;
    }

    public void setLazyRiver(boolean lazyRiver){
        this.lazyRiver = lazyRiver;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSeasons(boolean[] seasons){
        this.seasons = seasons;
    }

    public void setWavePool(boolean wavePool){
        this.wavePool = wavePool;
    }
}
