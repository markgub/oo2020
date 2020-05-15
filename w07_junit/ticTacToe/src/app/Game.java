package app;

import java.util.Scanner;

public class Game {

    private Board board = new Board();
    private int numberOfPieces = 0;
    private Scanner in = new Scanner(System.in);

    public Game(){

    }

    public void twoPlayerGame(){
        int whichPlayer = 1;
        boolean win = false;
        while(!win && numberOfPieces < 9){
            board.getPieces();
            System.out.println("Mängija" + whichPlayer + " kirjutage koha numbrit, kuhu tahate panna nuppu:");
            int place = in.nextInt();
            while(board.getPiece(place) != null){
                System.out.println("Antud koht on hõivatud. Valige uut palun:");
                place = in.nextInt();
            }
            if(whichPlayer == 1){
                Piece piece = new Cross();
                whichPlayer = 2;
                board.addPiece(place, piece);
            } else {
                Piece piece = new Circle();
                whichPlayer = 1;
                board.addPiece(place, piece);
            }

            String[] symbols = {"a", "b", "c"};
            for(int i = 0; i < 3; i ++){
                if(board.getPiece(i*3 + (place-1)%3 + 1) == null){
                    break;
                }
                System.out.println("4");
                symbols[i] = board.getPiece(i*3 + (place-1)%3 + 1).getSymbol();
            } 
            win = checkSymbols(symbols);

            if(!win) {
                for(int i = 0; i < 3; i ++){
                    if(board.getPiece(((place-1)/3)*3 + i + 1) == null){
                        break;
                    }
                    System.out.println("3");
                    symbols[i] = board.getPiece(((place-1)/3)*3 + i + 1).getSymbol();
                }
                win = checkSymbols(symbols);
            }

            if((place == 1 || place == 9 || place == 5) && !win){
                for(int i = 0; i < 3; i ++){
                    if(board.getPiece(i*3 + i + 1) == null){
                        break;
                    }
                    System.out.println("2");
                    symbols[i] = board.getPiece(i*3 + i + 1).getSymbol();
                }
                win = checkSymbols(symbols);
            }

            if((place == 3 || place == 7 || place == 5) && !win){
                for(int i = 0; i < 3; i ++){
                    if(board.getPiece(i*2 + 3) == null){
                        break;
                    }
                    System.out.println("1");
                    symbols[i] = board.getPiece(i*2 + 3).getSymbol();
                }
                win = checkSymbols(symbols);
            }
            
            numberOfPieces ++;
        }

        board.getPieces();
        if(win){
            if(whichPlayer == 1) whichPlayer = 2; else whichPlayer = 1;
            System.out.println("Mängija" + whichPlayer + " võitis!");
        } else {
            System.out.println("Mäng lõppes viigiga!");
        }
    }

    public boolean checkSymbols(String[] symbols){
        return (symbols[0] == symbols[1] && symbols[1] == symbols[2]);
    }

    public int getNumberOfPieces(){
        return numberOfPieces;
    }
}