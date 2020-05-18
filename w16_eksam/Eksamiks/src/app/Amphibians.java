package app;

import java.util.ArrayList;
import java.util.List;

public class Amphibians implements AnimalList{

    private List<Animal> animals = new ArrayList<>();
    private AnimalClass forWhom = AnimalClass.AMPHIBIAN;

    public Amphibians(){

    }

    @Override
    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    @Override
    public void removeAnimal(int i){
        animals.remove(i);
    }

    @Override
    public Animal getAnimal(int i){
        return animals.get(i);
    }

    @Override
    public AnimalClass getForWhom() {
        return forWhom;
    }
    
    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return animals.size();
    }
}