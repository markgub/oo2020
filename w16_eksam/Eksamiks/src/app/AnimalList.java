package app;


public interface AnimalList {
    public void addAnimal(Animal animal);
    public void removeAnimal(int i);
    public Animal getAnimal(int i);
    public AnimalClass getForWhom();
    public int getSize();
}