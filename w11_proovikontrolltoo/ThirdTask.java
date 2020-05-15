import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class ThirdTask{

    private List<Integer> xCordinates = new ArrayList<>();
    private List<Integer> yCordinates = new ArrayList<>();
    private boolean again = true;
    Scanner in = new Scanner(System.in);

    public ThirdTask(){
        System.out.println("Sisestage punkti x-kordinaat");
        xCordinates.add(in.nextInt());
        System.out.println("Sisestage punkti y-kordinaat");
        yCordinates.add(in.nextInt());
        while(again){
            System.out.println("Sisestage veel ühte punkti x-kordinaat");
            xCordinates.add(in.nextInt());
            System.out.println("Sisestage veel ühte punkti y-kordinaat");
            yCordinates.add(in.nextInt());
            System.out.println("Tahate sisestada veel ühte punkti? [vastuseks kas 'true' või 'false' ]");
            again = in.nextBoolean();
        }
        System.out.println(xCordinates);
        System.out.println(yCordinates);
    }

    private List<Double> centerRanges = new ArrayList<>();
    public void centerControll(){
        boolean equal = true;
        System.out.println("Sisestage, keskkoha x-kordanaati:");
        int x = in.nextInt();
        System.out.println("Sisestage, keskkoha y-kordanaati:");
        int y = in.nextInt();
        System.out.println("Sisestage, kui suur saab olla lubatud veaprotsent:");
        int difference = in.nextInt();

        for(int i = 0; i < xCordinates.size(); i++){
            centerRanges.add(Math.sqrt((x - xCordinates.get(i))*(x - xCordinates.get(i)) + (y - yCordinates.get(i))*(y - yCordinates.get(i))));
        }
        for(int i = 0; i < (sides.size() - 1); i++){
            if(Math.abs(centerRanges.get(i) - centerRanges.get(i+1)*100) > difference){
                equal = false;
                break;
            }
        }
        if(equal){
            System.out.println("Antud hulknurga tipud asuvad liigikaudu samal kaugusel keskkohast");
        } else System.out.println("Antud hulknurga tipud ei asu samal kaugusel keskkohast");
    }

    private List<Double> sides = new ArrayList<>();
    public void equilateralControll(){
        boolean equal = true;
        System.out.println("Sisestage, kui suur saab olla lubatud veaprotsent:");
        int difference = in.nextInt();
        int last = 1;

        for(int i = 0; i < (xCordinates.size() - 1); i++){
            sides.add(Math.sqrt((xCordinates.get(i+1) - xCordinates.get(i))*(xCordinates.get(i+1) - xCordinates.get(i)) + (yCordinates.get(i+1) - yCordinates.get(i))*(yCordinates.get(i+1) - yCordinates.get(i))));
        }
        sides.add(Math.sqrt((xCordinates.get(0) - xCordinates.get(last))*(xCordinates.get(0) - xCordinates.get(last)) + (yCordinates.get(0) - yCordinates.get(last))*(yCordinates.get(0) - yCordinates.get(last))));
        System.out.println(sides);
        for(int i = 0; i < (sides.size() - 1); i++){
            if(Math.abs((sides.get(i) - sides.get(i+1))*100) > difference){
                equal = false;
                break;
            }
        }
        if(equal){
            System.out.println("Antud hulknurga küljed on liigikaudu sama pikad");
        } else System.out.println("Antud hulknurga küljed ei ole sama pikad");
    }
}