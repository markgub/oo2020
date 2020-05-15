package app;

import java.util.ArrayList;
import java.util.List;

public class AppSystem {

    private boolean running;
    private List<Integer> numbers = new ArrayList<>();

    public AppSystem(){
        running = true;
    }

    public boolean isRunning(){
        return running;
    }

    public void end(){
        running = false;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}