package app;

public class Example4 {
    public static void main(String[] args) {
        //Kolmanda ülesande äppi näide
        IonClass Ca = new IonClass("Ca", 40.07, 2);
        IonClass Cl = new IonClass("Cl", 35.45, -1);
        IonClass[] ions= {Ca, Cl, Cl};
        MatterApp app = new MatterApp(ions);
    }
}