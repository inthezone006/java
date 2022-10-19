public class Ride extends Object{
    private String color;
    private int maxRiders;
    private int minHeight;
    private String name;

    public Ride(){
        name = "";
        color = "";
        minHeight = 0;
        maxRiders = 0;
    }

    public Ride(String name, String color, int minHeight, int maxRiders){
        this.color = color;
        this.name = name;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getColor(){
        return color;
    }

    public int getMinHeight(){
        return minHeight;
    }

    public int getMaxRiders(){
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders){
        this.maxRiders = maxRiders;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Ride){
            if (name.equals(o.getName()) && color.equals(o.getColor()) && minHeight == o.getMinHeight() && maxRiders == o.getMaxRiders()){
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
        return "Name: " + name + "\nColor: " + color + "\nMinHeight: " + minHeight + " inches\nMaxRiders: " + maxRiders;
    }
}
