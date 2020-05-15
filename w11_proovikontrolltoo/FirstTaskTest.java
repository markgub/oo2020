public class FirstTaskTest{

    public static void main(String[] args) {
        int[] xCordinates = {4, 5, 6};
        int[] yCordinates = {5, -2, 1};

        FirstTask triangle1 = new FirstTask(xCordinates, yCordinates);
        FirstTask triangle2 = new FirstTask();

        triangle1.getInfo();
        System.out.println();
        triangle2.getInfo();
    }
}