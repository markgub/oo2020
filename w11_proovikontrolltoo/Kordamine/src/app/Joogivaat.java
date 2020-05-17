package app;

import java.util.ArrayList;
import java.util.List;

public class Joogivaat {

    private double volume;
    private Jook drink;
    private double howMuchLeft;

    public Joogivaat(double volume){
        this.volume = volume;
        drink = null;
        howMuchLeft = 0;
    }

    public Jook getDrink(){
        return drink;
    }

    public double getVolume(){
        return volume;
    }

    public double getInside(){
        return howMuchLeft;
    }

    public void fillBarrel(Jook drink){
        this.drink = drink;
        howMuchLeft = volume;
    }

    public void fillBottle(Joogipudel bottle){
        if(bottle.getInside() != 0) {
            if(howMuchLeft >= bottle.getCapacity()){
                bottle.fillBottle(drink);
                howMuchLeft -= bottle.getCapacity();
            } else {
                bottle.addDrinkCustom(drink, howMuchLeft);
                howMuchLeft = 0;
                //System.out.println("Vaadis pole piisavalt jooki, et täita pudelit");
            }
        } else {
            System.out.println("Pudelis on juba olemas jook");
        }
    }

    public List<Joogipudel> fillAllToBottles(){
        List<Joogipudel> bottles = new ArrayList<>();
        if(howMuchLeft != 0){
            while(howMuchLeft != 0){
                Joogipudel bottle = new Joogipudel(1, BottleType.PlASTIC, 0.1);
                fillBottle(bottle);
                bottles.add(bottle);
            }
        }
        return bottles;
    }

}