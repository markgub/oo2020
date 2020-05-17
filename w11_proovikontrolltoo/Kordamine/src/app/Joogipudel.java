package app;

public class Joogipudel {

    private double capacity;
    private BottleType type;
    private double mass;
    private double pPrice;
    private Jook drink;
    private double inside;

    public Joogipudel(double capacity, BottleType type, double pPrice){
        this.capacity = capacity;
        this.type = type;
        setMass();
        drink = null;
        inside= 0;
        this.pPrice = pPrice;
    }

    public double getCapacity(){
        return capacity;
    }

    public double getPrice(){
        return pPrice;
    }

    public double getMass(){
        return mass;
    }

    public double getInside(){
        return inside;
    }

    public void fillBottle(Jook drink){
        this.drink = drink;
        inside = capacity;
    }

    public void emptyBottle(){
        drink = null;
        inside = 0;
    }

    public double wholeMass(){
        if(drink == null){
            return mass;
        } else {
            return drink.getDensity()*capacity + mass;
        }
    }

    public double fullPrice(){
        if(drink == null){
            return pPrice;
        } else {
            return capacity*drink.getLPrice() + pPrice;
        }
    }

    private void setMass() {
        if (type == BottleType.GLASS) {
            mass = 65;
        } else {
            mass = 5;
        }
    }

    public void addDrinkCustom(Jook drink, double howMuch){
        this.drink = drink;
        inside = howMuch;
    }
}