public class Rollercoaster extends Ride {
    private boolean simulated;

    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated){
        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Rollercoaster){
            if (super.getName().equals(o.getName()) && super.getColor().equals(o.getColor()) && super.getMinHeight() == o.getMinHeight() && super.getMaxRiders() == o.getMaxRiders()){
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
