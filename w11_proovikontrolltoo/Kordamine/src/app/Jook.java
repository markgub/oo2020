package app;

public class Jook {

    private String name;
    private double lPrice;
    private double rDensity;

    public Jook(String name, double lPrice, double rDensity) {
        this.name = name;
        this.lPrice = lPrice;
        this.rDensity = rDensity;
    }

    public String getDrinkName(){
        return name;
    }

    public double getDensity(){
        return rDensity;
    }

    public double getLPrice(){
        return lPrice;
    }
}