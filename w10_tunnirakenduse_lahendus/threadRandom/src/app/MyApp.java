package app;

public class MyApp {
    
    private AppSystem aSystem = new AppSystem();
    private AppNewNumThread addThread;
    private AppRemoveThread removeThread;

    public MyApp() {
        addThread = new AppNewNumThread("Add thread", aSystem);
        removeThread = new AppRemoveThread("Info thread", aSystem);
    }

    public void start() {
        addThread.start();
        removeThread.start();
    }
}