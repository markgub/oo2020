package app;

public class Animal {

    private AnimalClass aClass;
    private AnimalGenus genus;
    private String species;
    private AnimalSize size;

    public Animal(AnimalClass aClass, AnimalGenus genus, AnimalSize size, String species){
        this.aClass = aClass;
        this.genus = genus;
        this.species = species;
        this.size = size;
    }
    
    public AnimalClass getAnimalClass(){
        return aClass;
    }

    public AnimalGenus getAnimalGenus(){
        return genus;
    }

    public String getAnimalSpecies(){
        return species;
    }

    public AnimalSize getAnimalSize(){
        return size;
    }
}