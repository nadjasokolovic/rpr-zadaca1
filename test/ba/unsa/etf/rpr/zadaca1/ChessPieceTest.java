package ba.unsa.etf.rpr.zadaca1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessPieceTest {

    @Test
    void testProvjeraIspravnosti() {
        ChessPiece c = new King("a1", ChessPiece.Color.BLACK);
        assertFalse(c.provjeraIspravnostiPozicije("9o"));

    }

    @Test
    void testProvjeraIspravnosti2() {
        ChessPiece c = new King("a1", ChessPiece.Color.BLACK);
        assertFalse(c.provjeraIspravnostiPozicije(""));

    }

   @Test
    void testlijevoDesno() {
       ChessPiece c = new Rook("a1", ChessPiece.Color.BLACK);
        assertTrue(c.pomjeraLiLijevoDesno("a3", "c3"));
   }

    @Test
    void testlijevoDesno2() {
        ChessPiece c = new Rook("a1", ChessPiece.Color.BLACK);
        assertFalse(c.pomjeraLiLijevoDesno("a3", "a1"));
    }

    @Test
    void testGoreDole() {
        ChessPiece c = new Rook("a1", ChessPiece.Color.BLACK);
        assertFalse(c.pomjeraLiGoreDole("a3", "b7"));
    }

    @Test
    void testGoreDole2() {
        ChessPiece c = new Rook("a1", ChessPiece.Color.BLACK);
        assertTrue(c.pomjeraLiGoreDole("a3", "a1"));
    }


}