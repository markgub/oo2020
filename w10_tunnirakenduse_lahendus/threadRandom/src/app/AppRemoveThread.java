package app;

public class AppRemoveThread implements Runnable{

    private String tName;
    private AppSystem aSystem;

    private Thread thread;

    public AppRemoveThread(String name, AppSystem aSystem){
        tName = name;
        this.aSystem = aSystem;
    }

    @Override
    public void run() {
        try{
            while(aSystem.isRunning()){
                for(int i = 0; i < aSystem.getNumbers().size(); i++){
                     if(aSystem.getNumbers().get(i) < 0){
                        System.out.println("Negatiivne number " + aSystem.getNumbers().get(i) + "sai eemaldatud");
                          aSystem.getNumbers().remove(i);
                     }
                }
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + tName + " dead");
        }
    }

    public void start(){
        System.out.println("Thread " + tName + " starting");
        if(thread == null){
            thread = new Thread(this, tName);
            thread.start();
        }
    }   
}