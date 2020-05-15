public class SecondTaskTest{

    public static void main(String[] args) {
        int[] xCordinates = {4, 5, 6};
        int[] yCordinates = {5, -2, 1};

        SecondTask triangle1 = new SecondTask(xCordinates, yCordinates);
        SecondTask triangle2 = new SecondTask(2, 2, 2, 4, 4, 4);

        triangle1.equilateralControll();
        System.out.println();
        triangle2.equilateralControll();
    }
}