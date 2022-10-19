import java.util.ArrayList;

public interface Park {
    public void addRide(Ride ride) throws WrongRideException;
    public void close();
    public void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException;
    public double getAdmissionCost();
    public double getLand();
    public String getName();
    public ArrayList<Ride> getRides();
    public boolean[] getSeasons();
    public boolean isIndoor();
    public boolean isOutdoor();
    public void removeRide(Ride ride);
    public void setAdmissionCost(double admissionCost);
    public void setName(String name);
    public void setSeasons(boolean[] seasons);
}
