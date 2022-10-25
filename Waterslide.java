public class Waterslide extends Ride{
    private double splashDepth;

    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth){
        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }

    public double getSplashDepth(){
        return splashDepth;
    }

    public void setSplashDepth(double splashDepth){
        this.splashDepth = splashDepth;
    }

    @Override
    public boolean equals(Object o){
        Waterslide b = (Waterslide) o;
        if(o instanceof Waterslide){
            if (super.getName().equals(b.getName()) && super.getColor().equals(b.getColor()) && super.getMinHeight() == b.getMinHeight() && super.getMaxRiders() == b.getMaxRiders() && splashDepth == b.getSplashDepth()){
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

    @Override
    public String toString(){
        return "Name: " + super.getName() + "\nColor: " + super.getColor() + "\nMinHeight: " + super.getMinHeight() + " inches\nMaxRiders: " + super.getMaxRiders() + "\nSplashDepth: " + splashDepth + " feet";
    }
}
