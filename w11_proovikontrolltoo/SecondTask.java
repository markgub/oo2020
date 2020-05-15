import java.util.Arrays;

public class SecondTask{

    private int[] xCordinates= {1, 2, 3};
    private int[] yCordinates= {1, 2, 3};

    public SecondTask(int x1, int y1, int x2, int y2, int x3, int y3){
        xCordinates[0] = x1;
        xCordinates[1] = x2;
        xCordinates[2] = x3;

        yCordinates[0] = y1;
        yCordinates[1] = y2;
        yCordinates[2] = y3;
    }

    public SecondTask(int[] xCordinates, int[] yCordinates){
        for(int i = 0; i < xCordinates.length; i++){
            this.xCordinates[i] = xCordinates[i];
            this.yCordinates[i] = yCordinates[i];
        }
    }

    public SecondTask(){
    }

    public void getInfo(){
        System.out.println("X-kordinaadid:");
        System.out.print(Arrays.toString(xCordinates));
        System.out.println();
        System.out.println("Y-kordinaadid:");
        System.out.print(Arrays.toString(yCordinates));
        System.out.println();
    }

    public void equilateralControll(){
        double a = Math.sqrt((xCordinates[1] - xCordinates[0])*(xCordinates[1] - xCordinates[0]) + (yCordinates[1] - yCordinates[0])*(yCordinates[1] - yCordinates[0]));
        double b = Math.sqrt((xCordinates[2] - xCordinates[1])*(xCordinates[2] - xCordinates[1]) + (yCordinates[2] - yCordinates[1])*(yCordinates[2] - yCordinates[1]));
        double c = Math.sqrt((xCordinates[0] - xCordinates[2])*(xCordinates[0] - xCordinates[2]) + (yCordinates[0] - yCordinates[2])*(yCordinates[0] - yCordinates[2]));

        if(Math.round(a) == Math.round(b) && Math.round(a) == Math.round(c)){
            System.out.println("Antud kolmnurk on võrdkülgne");
        } else System.out.println("Antud kolmnurk ei ole võrdkülgne");
    }
}