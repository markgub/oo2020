package app;

public class Circle implements Piece{
    String symbol;
    public Circle(){
        symbol = "O";
    }

    @Override
    public String getSymbol() {
        // TODO Auto-generated method stub
        return symbol;
    }
}