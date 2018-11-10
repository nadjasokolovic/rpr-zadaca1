package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void move() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C3")
        );

    }

    @Test
    void illegalPosition() {
        Knight k = new Knight("g1", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("3b")
        );
    }

    @Test
    void moveUpOrDown() {
        Knight k = new Knight("d4", ChessPiece.Color.WHITE);
        assertAll(
                () -> assertThrows(
                    IllegalChessMoveException.class,
                        () -> k.move("d5")
                ),
                () -> assertThrows(
                    IllegalChessMoveException.class,
                        () -> k.move("d3")
                )
        );
    }

    @Test
    void someLegalMoves() {
        Knight k = new Knight("d4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                ()-> {
                    k.move("e6");
                    k.move("g5");
                    k.move("f3");
                    k.move("e5");
                }
        );


    }
}