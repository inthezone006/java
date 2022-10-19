public class Rollercoaster extends Ride {
    private boolean simulated;

    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated){
        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;
    }

    @Override
    public boolean equals(Object o){
        Rollercoaster b = (Rollercoaster) o;
        if(o instanceof Rollercoaster){
            if (super.getName().equals(b.getName()) && super.getColor().equals(b.getColor()) && super.getMinHeight() == b.getMinHeight() && super.getMaxRiders() == b.getMaxRiders()){
                return true;
            }

            else{
                return false;
            }
        }

        else{
            return false;
        }
    }

    public boolean isSimulated(){
        return simulated;
    }

    public void setSimulated(boolean simulated){
        this.simulated = simulated;
    }

    @Override
    public String toString(){
        return "Name: " + super.getName() + "\nColor: " + super.getColor() + "\nMinHeight: " + super.getMinHeight() + " inches\nMaxRiders: " + super.getMaxRiders() + "\nSimulated: " + simulated;
    }
}
