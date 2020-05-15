package app;

public abstract class MartialArtist {
    String name;
    int kickPower;
    int punchPower;

    public abstract void punchObject(String objectName, int requiredPow);
    public abstract void kickObject(String objectName, int requiredPow);
    public abstract void getInfo();
}