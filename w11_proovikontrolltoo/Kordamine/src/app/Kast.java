package app;

import java.util.ArrayList;
import java.util.List;

public class Kast {

    private List<Joogipudel> bottlesInCrate = new ArrayList<>();
    private CrateType crateType;
    private double mass;
    private double price;
    private int sockets;
    private int freeSockets;


    public Kast(CrateType crateType, double price, int sockets){
        this.crateType = crateType;
        this.price = price;
        freeSockets = sockets;
        this.sockets = sockets;
        setMass();
    }

    public int getAllSockets(){
        return sockets;
    }

    public int getFreeSockets(){
        return freeSockets;
    }

    public double getPrice(){
        return price;
    }

    public double getMass(){
        return mass;
    }

    public CrateType getType(){
        return crateType;
    }

    public void addBottle(Joogipudel bottle){
        if(freeSockets > 0){
            bottlesInCrate.add(bottle);
            freeSockets --;
        } else {
            System.out.println("Kastis pole vabu pesasid");
        }
    }

    public double wholeMass(){
        double wholeMass = mass;
        for(Joogipudel bottle: bottlesInCrate){
            wholeMass += bottle.wholeMass();
        }
        return wholeMass;
    }

    public double fullPrice(){
        double fullPrice = price;
        for(Joogipudel bottle: bottlesInCrate){
            fullPrice += bottle.fullPrice();
        }
        return fullPrice;
    }

    public void fillAllBottles(Joogivaat barrel){
        for(Joogipudel bottle: bottlesInCrate) barrel.fillBottle(bottle);
    }

    public void setMass(){
        if(crateType == CrateType.WOOD){
            mass = 16;
        } else {
            mass = 8;
        }
    }
}