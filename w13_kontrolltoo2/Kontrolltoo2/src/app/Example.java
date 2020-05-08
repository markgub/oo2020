package app;

public class Example {
    public static void main(String[] args) throws Exception {
        //Esimese ülesande näide
        IonClass H = new IonClass("H", 1, 1);
        IonClass NO3 = new IonClass("NO3", 62, -1);
        System.out.println("Nimetus: " + H.getName() + " Mass: " + H.getAMass() + " Laeng: " + H.getCharge());
        System.out.println("Nimetus: " + NO3.getName() + " Mass: " + NO3.getAMass() + " Laeng: " + NO3.getCharge());
    }
}