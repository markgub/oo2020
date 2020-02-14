import java.util.Random;
import java.util.Arrays;

public class T1ul6ja7{

    //Genereerib eri suurustega arrayd ja täidab neid erisuuruste arvudega
    public static int[] arrayGenerator(){
        Random r = new Random();
        //Array loomine
        int arrayLength = r.nextInt(990) + 10;
        int[] newArray = new int[arrayLength];
        
        //Array täitmine
        for(int i = 0; i < arrayLength; i++){
            newArray[i] = r.nextInt(9990) + 10;
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] newArray = arrayGenerator();
        System.out.println("Sorteerimata array:");
        System.out.print(Arrays.toString(newArray));
        //System.out.println(newArray.length);

        //Sorteerime arrayt
        boolean change = true;
        int N = newArray.length;
        int temporary;

        while(change){
            change = false;
            N --;
            for(int i = 0; i < N; i++){
                if(newArray[i] > newArray[i+1]){
                    temporary = newArray[i];
                    newArray[i] = newArray[i+1];
                    newArray[i+1] = temporary;
                    change = true;
                }
            }
        }
        //Prindime välja sorteeritut array
        System.out.printf("%n%nSorteeritud array:%n");
        System.out.print(Arrays.toString(newArray));
    }
}