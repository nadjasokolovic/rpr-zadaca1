package ba.unsa.etf.rpr.zadaca1;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    @org.junit.jupiter.api.Test
    void  illegalMove() {
        Rook r = new Rook("h1", ChessPiece.Color.WHITE);
        assertThrows(
            IllegalChessMoveException.class,
            ()-> r.move("d5")
        );
    }

    @org.junit.jupiter.api.Test
    void illegalPosition() {
        Rook r = new Rook("h1", ChessPiece.Color.WHITE);
        assertThrows(
            IllegalArgumentException.class,
            ()-> r.move("m16")
        );
    }

    @org.junit.jupiter.api.Test
    void setter() {
        Rook r = new Rook("d1", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                ()-> {
                    r.setPosition("b2");
                    r.setPosition("h3");
                    r.setPosition("c2");
                }
        );
    }

    @org.junit.jupiter.api.Test
    void setter2() {
        Rook r = new Rook("d1", ChessPiece.Color.BLACK);
        assertThrows(
            IllegalArgumentException.class,
            ()->  r.setPosition("m12")
        );
    }

    @org.junit.jupiter.api.Test
    void setter3() {
        Rook r = new Rook("d1", ChessPiece.Color.BLACK);
        r.setPosition("a1");
        assertTrue(r.getPosition().equals("a1"));
    }

    @org.junit.jupiter.api.Test
    void setter4() {
        Rook r = new Rook("d1", ChessPiece.Color.BLACK);
        assertThrows(
            IllegalArgumentException.class,
            ()-> r.setPosition("m11")
        );

    }



}