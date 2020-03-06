//Kontrolltöö 6. variant  Karp ja vurrud (Kuid ilma karpi ja vurrusid)

//Impordin funktsioone faili lugemiseks ja kirjutamiseks
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

//Impordin funktsioone ArrayListi jaoks ja ka tavalise array kirjutamiseks
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class KarpJaVurrud{

    //Variandi esimene punkt: massiivi sorteerimise funktsioon
    public static void arraySorting(int[] array){
        boolean change = true;
        int N = array.length;
        int temporary;

        //Kasutan mullimeetodisorteerimist
        while(change){
            change = false;
            N --;
            for(int i = 0; i < N; i++){
                if(array[i] > array[i+1]){
                    temporary = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temporary;
                    change = true;
                }
            }
        }

        //Prindin välja järjestatud massiivi
        System.out.println("Array on nüüd järjestatud:");
        System.out.println(Arrays.toString(array));
        //Prindin välja selle suurima ja väiksema väärtust
        System.out.println("Selle suurim väärtus on " + array[array.length-1] + " ja vähim on " + array[0]);
    }

    //Variandi teine punkt: täiendatud massiivi sorteerimise funktsioon
    public static void arraySortingUpgraded(int[] array){
        boolean change = true;
        int N = array.length;
        int temporary;

        //Kasutan taaskord mullimeetodisorteerimist
        while(change){
            change = false;
            N --;
            for(int i = 0; i < N; i++){
                if(array[i] > array[i+1]){
                    temporary = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temporary;
                    change = true;
                }
            }
        }

        System.out.println("Array on nüüd järjestatud:");
        System.out.println(Arrays.toString(array));
        //Täiendatud osa (sain aru, et need print-käsud on liigsed, aga ma juba kirjutasin neid, seega jättan alles)
        System.out.println("Selle suurim väärtus on " + array[array.length-1] + " ja vähim on " + array[0]);
        System.out.println("25% massiivi arvudest on väiksem kui " + (array.length/4+1) + ". massiivi arv " + array[array.length/4]);
        System.out.println("50% massiivi arvudest on väiksem kui " + (array.length/2+1) + ". massiivi arv " + array[array.length/2]);
        System.out.println("75% massiivi arvudest on väiksem kui " + (array.length*3/4+1) + ". massiivi arv " + array[array.length*3/4]);
        //Massiiv koos nende väärtustega
        int[] newArray = {array[0], array[array.length/4], array[array.length/2], array[array.length*3/4], array[array.length-1]};
        System.out.println(Arrays.toString(newArray));
    }

    //Variandi kolmas punkt: failist lugemine ja sissekirjutamine
    public static void boxWhisker(String input, String output) throws IOException{
        boolean change = true;
        int temporary;
        //See kord kasutan ArrayListi
        List<Integer> array = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line = reader.readLine();
        
        //Täidan seda listi
        while(line != null){
            array.add(Integer.parseInt(line));
            line = reader.readLine();
        }
        reader.close();
        int N = array.size();

        //Kasutan ikka vana head mullimeetodit
        while(change){
            change = false;
            N --;
            for(int i = 0; i < N; i++){
                if(array.get(i) > array.get(i+1)){
                    temporary = array.get(i);
                    array.set(i, array.get(i+1));
                    array.set(i+1, temporary);
                    change = true;
                }
            }
        }

        //List nendega, mis on väiksem kui 50%
        int[] halfArray = new int[array.size()/2];
        for(int i = 0; i < halfArray.length; i++){
            halfArray[i] = array.get(i);
        }

        //Nendega, mis on 25% ja 75% vahel
        int[] betweenArray = new int[array.size()*3/4-array.size()/4];
        for(int i = 0; i < betweenArray.length; i++){
            betweenArray[i] = array.get(array.size()/4+i);
        }

        //List nendega, mis on suurem kui 25% arvudest
        int[] moreThan25Array = new int[array.size()-array.size()/4];
        for(int i = 0; i < moreThan25Array.length; i++){
            moreThan25Array[i] = array.get(array.size()/4+i);
        }

        //List algarvudega (Kasutn ArrayList, kuna niimooodi on mugavam)
        List<Integer> primeArray = new ArrayList<>();
        for(int j = 0; j < array.size(); j++){
            boolean notPrime = false;
            if(array.get(j) > 1){
                for(int i = 2; i < array.get(j)/2+1; i++){
                    if(array.get(j) % i == 0){
                        notPrime = true;
                        break;
                    }
                }
                if(!notPrime) primeArray.add(array.get(j));
            }
        }

        //Kirjutan faili sisse vastused
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        writer.write("Arvud, mis on alla 50%: " + Arrays.toString(halfArray)  + "\n");
        writer.write("Arvud, mis on 25% ja 75% vahel: " + Arrays.toString(betweenArray)  + "\n");
        writer.write("Arvud, mis on suurem kui 25%: " + Arrays.toString(moreThan25Array)  + "\n");
        writer.write("Arvud, mis on algarvud : [");
        for(int i = 0; i < primeArray.size(); i++) {
            writer.write(Integer.toString(primeArray.get(i)));
            if(i != primeArray.size()-1) writer.write(", ");
        }
        writer.write("]");
        writer.close();
    }

    public static void main(String[] args) throws IOException{
        //Näidis array
        int[] array = {4, 11, 8, 1, 7, 6, 10, 9, 0};
        //Esimese punkti näide
        arraySorting(array);
        System.out.println();
        //Esimese punkti näide
        arraySortingUpgraded(array);
        System.out.println();
        //Kolmanda punkti näide
        boxWhisker("Input.txt", "Output.txt");
    }
}