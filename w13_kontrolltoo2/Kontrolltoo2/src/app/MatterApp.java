package app;

import java.util.Scanner;

public class MatterApp {

    public MatterApp(IonClass[] ions){
        IonClass[] newIons = ions;
        MatterClassArray matter = new MatterClassArray(ions);
        if(matter.getMass() != 0.0){
            System.out.println("Antud ioonidest saab moodustada " + matter.getName() + " molekulmassiga " + matter.getMass());
        } else {
            System.out.println(matter.getName());
        }

        boolean yes = true;
        Scanner in = new Scanner(System.in);
        String name;
        double mass;
        int charge;
        while(yes){
            System.out.println("Tahate lisada veel ühte iooni? [true/false]");
            yes = in.nextBoolean();
            if(!yes) break;
            System.out.println("Mis on selle iooni nimetus?");
            name = in.next();
            System.out.println("Milline on selle mass?");
            mass = in.nextDouble();
            System.out.println("Missugune laeng on sellel?");
            charge = in.nextInt();
            IonClass ion = new IonClass(name, mass, charge);
            newIons = newIons(newIons, ion);
            matter = new MatterClassArray(newIons);
            if(matter.getMass() != 0.0){
                System.out.println("Antud ioonidest saab moodustada " + matter.getName() + " molekulmassiga " + matter.getMass());
            } else {
                System.out.println(matter.getName());
            }
        }
        in.close();;
    }

    public IonClass[] newIons(IonClass[] ions, IonClass ion){
        IonClass[] newIons = new IonClass[ions.length];
        for(int i = 0; i < ions.length; i ++){
            newIons[i] = ions[i];
        }
        newIons[newIons.length-1] = ion;
        return newIons;
    }
}