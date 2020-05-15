package app;

public class Boxer extends MartialArtist{
    public Boxer(String name, int kickPower, int punchPower){
        this.kickPower = kickPower;
        this.punchPower = punchPower;
        this.name = name;
    }
    
    @Override
    public void getInfo() {
        System.out.println("See on poksja " + name + ".");
        System.out.println("Ta käe löögi võimsus on " + punchPower + " ja jala löögi võimsus on " + kickPower);
    }

    @Override
    public void punchObject(String objectName, int requiredPow) {
        System.out.println(name + " kasutab täie jõuga lööki vastu objekti " + objectName);
        if(punchPower >= requiredPow){
            System.out.println(name + " tegi objekti " + objectName + " katki!");
        } else {
            System.out.println(objectName + "jäi terveks, mida ei saa öelda poksja enesekindluse kohta.");
        }
    }

    @Override
    public void kickObject(String objectName, int requiredPow) {
        System.out.println(name + " kasutab tavalist jala lööki vastu objekti " + objectName);
        if(kickPower >= requiredPow){
            System.out.println(name + " tegi objekti " + objectName + " päris ilusasti katki!");
        } else {
            System.out.println("Kahjuks läks katki mitte " + objectName + ", vaid ta jalg.");
        }
    }
}