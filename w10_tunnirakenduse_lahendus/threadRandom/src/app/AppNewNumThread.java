package app;

import java.util.Random;

public class AppNewNumThread implements Runnable{
    
    private String tName;
    private AppSystem appSystem;

    private Thread thread;

    public AppNewNumThread(String name, AppSystem aSystem){
        tName = name;
        appSystem = aSystem;
    }

    @Override
    public void run() {
        Random r = new Random();
        try{
            while(appSystem.isRunning()){
                int randomNum = r.nextInt(201) - 100;
                System.out.println("Uus number: " + randomNum);
                appSystem.getNumbers().add(randomNum);
                Thread.sleep(1000);
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