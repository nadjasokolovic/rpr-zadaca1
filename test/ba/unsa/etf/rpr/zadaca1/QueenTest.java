package ba.unsa.etf.rpr.zadaca1;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @org.junit.jupiter.api.Test
    void constructor() {
        assertAll(
                ()-> assertThrows(
                        IllegalArgumentException.class,
                        ()-> new Queen("e9", ChessPiece.Color.BLACK)
                ),

                ()-> assertThrows(
                    IllegalArgumentException.class,
                    ()-> new Queen("2d", ChessPiece.Color.BLACK)
                ),

                () -> assertThrows(
                    IllegalArgumentException.class,
                    ()->new Queen(" ", ChessPiece.Color.WHITE)
                )
        );
    }

    @org.junit.jupiter.api.Test
    void someLegalMoves() {
        Queen q = new Queen("b4", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                ()-> {
                    q.move("b8");
                    q.move("h8");
                    q.move("a1");
                }
        );
    }

    @org.junit.jupiter.api.Test
    void illegalMove() {
        Queen q = new Queen("f1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                ()-> q.move("m11")
        );
    }

}