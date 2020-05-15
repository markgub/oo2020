package app;

public class KungFuFighter extends MartialArtist{
    
    public KungFuFighter(String name, int kickPower, int punchPower){
        this.kickPower = kickPower;
        this.punchPower = punchPower;
        this.name = name;
    }
    
    @Override
    public void getInfo() {
        System.out.println("See on kung fu võistleja " + name + ".");
        System.out.println("Ta käe löögi võimsus on " + punchPower + " ja jala löögi võimsus on " + kickPower);
    }

    @Override
    public void punchObject(String objectName, int requiredPow) {
        System.out.println(name + " kasutab kiirt lööki vastu objekti " + objectName);
        if(punchPower >= requiredPow){
            System.out.println(name + "tegi objekti " + objectName + " fantastiliselt katki!");
        } else {
            System.out.println("Kahjuks see polnud efektiivne ja nüüd ta käsi valutab.");
        }
    }

    @Override
    public void kickObject(String objectName, int requiredPow) {
        System.out.println(name + " kasutab 360 kraadi front kickit vastu objekti " + objectName);
        if(kickPower >= requiredPow){
            System.out.println(name + " tegi objekti" + objectName + " katki oma jalaga!");
        } else {
            System.out.println("Kahjuks " + objectName + " ei läinud katki, ent kick oli päris stiilne");
        }
    }
}