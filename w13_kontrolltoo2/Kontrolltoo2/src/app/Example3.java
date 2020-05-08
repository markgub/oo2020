package app;

public class Example3 {
    public static void main(String[] args) {
        //Kolmanda ülensande näide
        IonClass Ca = new IonClass("Ca", 40.07, 2);
        IonClass Cl = new IonClass("Cl", 35.45, -1);
        IonClass[] ions1= {Ca, Cl, Cl};
        IonClass[] ions2= {Ca, Cl, Cl, Ca};
        MatterClassArray matter1 = new MatterClassArray(ions1);
        System.out.println(matter1.getName() + " " + matter1.getMass());
        MatterClassArray matter2 = new MatterClassArray(ions2);
        System.out.println(matter2.getName() + " " + matter2.getMass());
    }
}