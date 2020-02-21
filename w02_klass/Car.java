//Kõik eespool toodud sisu on tehtud õppeprogrammi ja isiklike huvide eesmärkides ning ei sisalda tõsiselt võetavad sisu
package Kodutood;

public class Car{
    private String driver;
    private String colour;
    private ParkingPlace place;
    private AutomobileMark mark;
    private boolean inFight;
    private boolean fine;
    private boolean invalid;
    private boolean occupied;

    public Car(){
        driver = "Kai Kuusepuu";
        colour = "Must";
        mark = AutomobileMark.AUDI;
    }

    public Car(String driver, String colour, AutomobileMark mark, boolean invalid){
        this.driver = driver;
        this.colour = colour;
        this.mark = mark;
        if(mark == AutomobileMark.BMW) this.invalid = true; else this.invalid = invalid;
    }

    public void getInfo(){
        System.out.println("Autojuht: " + driver);
        System.out.println("Autovärv: " + colour);
        System.out.println("Automärk: " + mark);
        if(mark != AutomobileMark.BMW && invalid) System.out.println("Autojuht on invaliid");
        if(fine) System.out.println("Autojuht omab trahvi");
        if(inFight) System.out.println("Autojuht tegeleb praegu kaklemisega");
    }

    public void parkCar(ParkingPlace place, Car[] cars){
        if(inFight){
            System.out.println(driver + " on hõivatud sellega, et üritab parkida oma rusikat teisele autojuhile näkku");
        } else if(this.place == null){
            occupied = false;
            for(int i = 0; i < cars.length; i++){
                if(cars[i].place == place) {
                    occupied = true;
                    if(cars[i].mark == AutomobileMark.BMW && mark == AutomobileMark.BMW) {
                        inFight = true;
                        cars[i].inFight = true;
                    }
                    break;
                }
            }
            if(occupied && mark == AutomobileMark.BMW){
                System.out.println(driver + " sõitis teisele autole otsa ja ta sai trahvi");
                if(inFight) System.out.println("Teisele autojuhile see ei meeldinud ning nende vahel algas kaklus");
                fine = true;
            } else if(occupied){
                System.out.println("Koht on juba hõivatud");
            } else{
                this.place = place;
                System.out.println("Auto on edukalt parkitud");
                if(place == ParkingPlace.INVALID && !invalid){
                    fine = true;
                    System.out.println("Ent " + driver + " ei tohi parkida invaliidite kohale ja ta sai trahvi");
                }
            }
        } else System.out.println("Auto on juba parkitud");
    }

    public void leave(){
        if(inFight){
            System.out.println(driver + " ei plaanigi liikuda oma autot, kuni kaklus on veel käimas");
        } else if(place == null){
            System.out.println("Auto polegi parkitud");
        } else if (mark != AutomobileMark.BMW && fine){
            System.out.println("Auto ei saa lahkuda niikaua, kui tal on maksmata trahv");
        } else {
            place = null;
            System.out.println("Auto lahkus parkimiskohast");
        }
    }

    public void payFine(){
        if(fine){
            fine = false;
            if(inFight) System.out.println(driver + " rahulikult maksis ära trahvi ning jätkas oma kaklust"); else System.out.println("Autojuht maksis trahvi");
        } else System.out.println("Autojuhil polegi trahvi");
    }
}