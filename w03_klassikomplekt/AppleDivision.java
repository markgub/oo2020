import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AppleDivision{

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("jagasis.txt"));
        int allBaskets = Integer.parseInt(reader.readLine());
        int allApples = 0;
        int basketCount = 0;
        int appleCount = 0;

        for(int i = 0; i < allBaskets; i++){
            allApples += Integer.parseInt(reader.readLine());
        }
        reader.close();

        BufferedReader newReader = new BufferedReader(new FileReader("jagasis.txt"));
        int nextApples = Integer.parseInt(newReader.readLine());
        nextApples = Integer.parseInt(newReader.readLine());;

        while(appleCount < allApples/2 && appleCount + nextApples < allApples){
            appleCount += nextApples;
            basketCount++;
            nextApples = Integer.parseInt(newReader.readLine());;
        }
        newReader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter("jagaval.txt"));
        writer.write(String.valueOf(basketCount));
        writer.close();
    }
}