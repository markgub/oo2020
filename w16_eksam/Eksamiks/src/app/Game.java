package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private String fileToRead;
    public Game(String fileToRead){
        this.fileToRead = fileToRead;
    }

    public void play() throws IOException{
        AnimalList mammals = new Mammals();
        AnimalList amphibians = new Amphibians();
        AnimalList birds = new Birds();
        AnimalList reptiles = new Reptiles();
        AnimalList invertebrates = new Invertebrates();
        AnimalList fish = new Fish();
        List<AnimalList> allAnimals = new ArrayList<>();
        allAnimals.add(mammals);
        allAnimals.add(amphibians);
        allAnimals.add(birds);
        allAnimals.add(reptiles);
        allAnimals.add(invertebrates);
        allAnimals.add(fish);
        BufferedReader reader = new BufferedReader(new FileReader(fileToRead));

        String line = reader.readLine();

        while(line != null){
            String[] lineContents = line.split("; ");
            Animal animal = new Animal(AnimalClass.valueOf(lineContents[0]), AnimalGenus.valueOf(lineContents[1]), AnimalSize.valueOf(lineContents[2]), lineContents[3]);
            for(int i = 0; i < allAnimals.size(); i ++) {
                if(allAnimals.get(i).getForWhom() == animal.getAnimalClass()){
                    allAnimals.get(i).addAnimal(animal);
                    //System.out.println(allAnimals.get(i));
                    break;
                }
            }
            /*System.out.println(animal.getAnimalClass());
            System.out.println(animal.getAnimalGenus());
            System.out.println(animal.getAnimalSize());
            System.out.println(animal.getAnimalSpecies());*/
            line = reader.readLine();
        }
        reader.close();

        boolean win = false;
        boolean yes;
        AnimalClass whichClass = null;
        AnimalGenus whichGenus = null;
        AnimalSize whichSize = null;
        String whichSpecies = "";
        int whichClassIndex = 0;
        String sentence = "";
        while(!win){
            System.out.println("Tervist! Antud programm proovib ära arvata Teie valitud looma");
            Scanner in = new Scanner(System.in);
            if(whichClass == null){
                for(int i = 0; i < allAnimals.size(); i ++) {
                    sentence = "Kas antud loom kuulub klassi ";
                    System.out.println(sentence + allAnimals.get(i).getForWhom().name() + "? [true/false]");
                    yes = in.nextBoolean();
                    if(yes){
                        whichClass = allAnimals.get(i).getForWhom();
                        whichClassIndex = i;
                        break;
                    }
                }
                if(whichClass == null){
                    System.out.println("Antud klassiga loom puudub.");
                    break;
                }
                yes = false;
            }
            if(whichGenus == null){
                List<AnimalGenus> notGenusList = new ArrayList<>();
                boolean notGenus = false;
                for(int i = 0; i < allAnimals.get(whichClassIndex).getSize(); i ++) {
                    for(int j = 0; j < notGenusList.size(); j ++){
                        if(notGenusList.get(j) == allAnimals.get(whichClassIndex).getAnimal(i).getAnimalGenus()) {
                            allAnimals.get(whichClassIndex).removeAnimal(i);
                            notGenus = true;
                            break;
                        }
                    }
                    if(!notGenus){
                        sentence = "Kas antud loom kuulub perekonda ";
                        System.out.println(sentence + allAnimals.get(whichClassIndex).getAnimal(i).getAnimalGenus().name() + "? [true/false]");
                        yes = in.nextBoolean();
                        if(yes){
                            whichGenus = allAnimals.get(whichClassIndex).getAnimal(i).getAnimalGenus();
                            break;
                        } else {
                            notGenusList.add(allAnimals.get(whichClassIndex).getAnimal(i).getAnimalGenus());
                            allAnimals.get(whichClassIndex).removeAnimal(i);
                            i --;
                        }
                    } else {
                        i--;
                        notGenus = false;
                    }
                }
                if(whichGenus == null){
                    System.out.println("Antud perekonnaga loom puudub.");
                    break;
                }
                yes = false;
            }
            if(whichSize == null){
                List<AnimalSize> wrongSizeList = new ArrayList<>();
                boolean wrongSize = false;
                for(int i = 0; i < allAnimals.get(whichClassIndex).getSize(); i ++) {
                    if(whichGenus == allAnimals.get(whichClassIndex).getAnimal(i).getAnimalGenus()) {
                        for(int j = 0; j < wrongSizeList.size(); j ++){
                            if(wrongSizeList.get(j) == allAnimals.get(whichClassIndex).getAnimal(i).getAnimalSize()) {
                                allAnimals.get(whichClassIndex).removeAnimal(i);
                                wrongSize = true;
                                break;
                            }
                        }
                        if(!wrongSize){
                            sentence = "Kas antud looma suurus on ";
                            System.out.println(sentence + allAnimals.get(whichClassIndex).getAnimal(i).getAnimalSize().name() + "? [true/false]");
                            yes = in.nextBoolean();
                            if(yes){
                                whichSize = allAnimals.get(whichClassIndex).getAnimal(i).getAnimalSize();
                                break;
                            } else {
                                wrongSizeList.add(allAnimals.get(whichClassIndex).getAnimal(i).getAnimalSize());
                                allAnimals.get(whichClassIndex).removeAnimal(i);
                                i --;
                            }
                        } else {
                            i--;
                            wrongSize = false;
                        }
                    } else {
                        allAnimals.get(whichClassIndex).removeAnimal(i);
                        i --;
                    }
                }
                if(whichSize == null){
                    System.out.println("Antud perekonnaga loom puudub.");
                    break;
                }
                yes = false;
            }
            if(whichSpecies == ""){
                for(int i = 0; i < allAnimals.get(whichClassIndex).getSize(); i ++) {
                    if(whichGenus == allAnimals.get(whichClassIndex).getAnimal(i).getAnimalGenus() && whichSize == allAnimals.get(whichClassIndex).getAnimal(i).getAnimalSize()) {
                        sentence = "Kas antud looma on ";
                        System.out.println(sentence + allAnimals.get(whichClassIndex).getAnimal(i).getAnimalSpecies() + "? [true/false]");
                        yes = in.nextBoolean();
                        if(yes){
                            whichSpecies = allAnimals.get(whichClassIndex).getAnimal(i).getAnimalSpecies();
                            win = true;
                            break;
                        } else {
                            allAnimals.get(whichClassIndex).removeAnimal(i);
                            i --;
                        }
                    } else {
                        allAnimals.get(whichClassIndex).removeAnimal(i);
                        i --;
                    }
                }
                if(whichSpecies == ""){
                    System.out.println("Antud loom puudub.");
                    break;
                }
            }
            in.close();
            if(win){
                System.out.println("Teie loomaks oli " + whichSpecies + " suurusega " + whichSize + ", perekonnast " + whichGenus + " ja klassist " + whichClass);
            }
        }
    }
}