package app;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game("src/app/Loomad.txt");
        game.play();
    }
}