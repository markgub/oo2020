package app;

public class Example2 {
    public static void main(String[] args) {
        //Teise ülesande näide
        IonClass H = new IonClass("H", 1, 1);
        IonClass NO3 = new IonClass("NO3", 62, -1);
        MatterClass HNO3 = new MatterClass(H, NO3);
        System.out.println(HNO3.getName() + " " + HNO3.getMass());

        IonClass Ca = new IonClass("Ca", 40.07, 2);
        IonClass Cl = new IonClass("Cl", 35.45, -1);
        MatterClass CaCl = new MatterClass(Ca, Cl);
        System.out.println(CaCl.getName() + " " + CaCl.getMass());
    }
    
}