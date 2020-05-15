package app;

/*import java.util.ArrayList;
import java.util.List;*/

public class Board {

    //List<Piece> pieces = new ArrayList<>();
    private Piece[][] pieces = new Piece[3][3];

    public Board(){

    }

    public void getPieces(){
        /*Piece test = new Circle();
        pieces[1][1] = test;*/
        int whicOneX;
        int whicOneY = 0;
        for(int i = 0; i < pieces.length; i ++){
            whicOneX = 0;
            for(int j = 0; j < pieces.length; j ++){
                if(pieces[i][j] != null){
                    System.out.print(pieces[i][j].getSymbol());
                    if(whicOneX < 2){
                        System.out.print(" | ");
                        whicOneX ++;
                    }
                } else {
                    System.out.print(whicOneY*3 + j + 1);
                    if(whicOneX < 2){
                        System.out.print(" | ");
                        whicOneX ++;
                    }
                }
            }
            if(whicOneY < 2) {
                System.out.println();
                for(int y = 0; y < 10; y ++){
                    System.out.print("—");
                }
            }
            whicOneY ++;
            System.out.println();
        }
    }

    public void addPiece(int place, Piece piece){
        place --;
        int placeY = place/3;
        int placeX = place%3;
        pieces[placeY][placeX] = piece;
    }

    public Piece getPiece(int place){
        place --;
        int placeY = place/3;
        int placeX = place%3;
        System.out.println(placeY + " " + placeX);
        return pieces[placeY][placeX];
    }
}