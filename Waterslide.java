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
        if(o instanceof Ride){
            if (name.equals(o.getName()) && color.equals(o.getColor()) && minHeight == o.getMinHeight() && maxRiders == o.getMaxRiders() && splashDepth == o.getSplashDepth()){
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
