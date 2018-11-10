package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @org.junit.jupiter.api.Test
    void outBoard() {
        Bishop b = new Bishop("e3", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("m9")
        );
    }

    @org.junit.jupiter.api.Test
    void moveUp() {
        Bishop b = new Bishop("c2", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalChessMoveException.class,
                () -> b.move("c3")
        );
    }

}