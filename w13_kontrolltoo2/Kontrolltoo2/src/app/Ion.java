package app;

public interface Ion {
    String name = "Iooni nimi";
    double atomicMass = 0;
    int charge = -1; 

    public String getName();
    public double getAMass();
    public int getCharge();
}