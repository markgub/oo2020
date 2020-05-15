package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class Tests {

    Board laud = new Board();
    Piece rist = new Cross();
    Piece nullike = new Circle();
    Game mäng = new Game();

    @Test
    public void test1(){
        assertEquals(rist.getSymbol(), "X");
        assertEquals(nullike.getSymbol(), "O");
    }

    @Test
    public void test2(){
        assertEquals(laud.getPiece(1), null);
        assertEquals(laud.getPiece(2), null);
        assertEquals(laud.getPiece(3), null);
        assertEquals(laud.getPiece(4), null);
        assertEquals(laud.getPiece(5), null);
        assertEquals(laud.getPiece(6), null);
        assertEquals(laud.getPiece(7), null);
        assertEquals(laud.getPiece(8), null);
        assertEquals(laud.getPiece(9), null);
    }

    @Test
    public void test3(){
        laud.addPiece(5, rist);
        laud.addPiece(1, nullike);
        assertEquals(laud.getPiece(1), nullike);
        assertEquals(laud.getPiece(2), null);
        assertEquals(laud.getPiece(3), null);
        assertEquals(laud.getPiece(4), null);
        assertEquals(laud.getPiece(5), rist);
        assertEquals(laud.getPiece(6), null);
        assertEquals(laud.getPiece(7), null);
        assertEquals(laud.getPiece(8), null);
        assertEquals(laud.getPiece(9), null);
    }

    @Test (expected=NullPointerException.class)
    public void test4(){
        laud.addPiece(5, rist);
        laud.addPiece(1, nullike);
        assertEquals(laud.getPiece(1).getSymbol(), "O");
        assertEquals(laud.getPiece(5).getSymbol(), "X");
        fail(laud.getPiece(2).getSymbol());
        fail(laud.getPiece(3).getSymbol());
        fail(laud.getPiece(4).getSymbol());
        fail(laud.getPiece(6).getSymbol());
        fail(laud.getPiece(7).getSymbol());
        fail(laud.getPiece(8).getSymbol());
        fail(laud.getPiece(9).getSymbol());
    }

    @Test
    public void test5(){
        String[] symbols = {rist.getSymbol(), rist.getSymbol(), rist.getSymbol()};
        assertEquals(mäng.checkSymbols(symbols), true);
        String[] symbols2 = {rist.getSymbol(), nullike.getSymbol(), rist.getSymbol()};
        assertEquals(mäng.checkSymbols(symbols2), false);
    }

    @Test
    public void test6(){
        laud.addPiece(1, nullike);
        laud.addPiece(2, nullike);
        laud.addPiece(3, nullike);
        String[] symbols = {laud.getPiece(1).getSymbol(), laud.getPiece(2).getSymbol(), laud.getPiece(3).getSymbol()};
        assertEquals(mäng.checkSymbols(symbols), true);
        laud.addPiece(4, rist);
        laud.addPiece(5, rist);
        laud.addPiece(6, nullike);
        String[] symbols2 = {laud.getPiece(4).getSymbol(), laud.getPiece(5).getSymbol(), laud.getPiece(6).getSymbol()};
        assertEquals(mäng.checkSymbols(symbols2), false);
    }
}