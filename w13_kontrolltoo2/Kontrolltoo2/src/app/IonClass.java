package app;

import java.util.Scanner;

public class IonClass implements Ion{

    String name;
    double atomicMass;
    int charge;

    public IonClass(String name, double atomicMass, int charge){
        this.name = name;
        this.atomicMass = atomicMass;
        if(charge == 0) {
            while(charge == 0){
                Scanner in = new Scanner(System.in);
                System.out.println("Laeng ei tohi olla 0! Kirjutage uut täisarvu:");
                charge = in.nextInt();
                in.close();
            } 
        } else this.charge = charge;
    }
    
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public double getAMass() {
        // TODO Auto-generated method stub
        return atomicMass;
    }

    @Override
    public int getCharge() {
        // TODO Auto-generated method stub
        return charge;
    }
}