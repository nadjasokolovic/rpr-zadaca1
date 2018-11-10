package ba.unsa.etf.rpr.zadaca1;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }

    @org.junit.jupiter.api.Test
    void illegalPosition() {
        Pawn p = new Pawn("d2", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalArgumentException.class,
                ()-> p.move("n9")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor() {
        assertThrows(
          IllegalArgumentException.class,
          ()-> new Pawn("8f", ChessPiece.Color.BLACK)
        );
    }

}