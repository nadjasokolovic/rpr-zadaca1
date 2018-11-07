package ba.unsa.etf.rpr;

import java.util.ArrayList;
import ba.unsa.etf.rpr.ChessPiece.Color;

public class Board {
    private ArrayList<ChessPiece> figure;

    public Board() {
        figure = new ArrayList<>();
        figure.add(new King("D8", ChessPiece.Color.BLACK));
        figure.add(new King("D1", ChessPiece.Color.WHITE));
        figure.add(new Queen("E8", ChessPiece.Color.BLACK));
        figure.add(new Queen("E1", ChessPiece.Color.WHITE));
        figure.add(new Bishop("C8", ChessPiece.Color.BLACK));
        figure.add(new Bishop("F8", ChessPiece.Color.BLACK));
        figure.add(new Bishop("C1", ChessPiece.Color.WHITE));
        figure.add(new Bishop("F1", ChessPiece.Color.WHITE));
        figure.add(new Knight("B8", ChessPiece.Color.BLACK));
        figure.add(new Knight("G8", ChessPiece.Color.BLACK));
        figure.add(new Knight("B1", ChessPiece.Color.WHITE));
        figure.add(new Knight("G1", ChessPiece.Color.WHITE));
        figure.add(new Rook("A8", ChessPiece.Color.BLACK));
        figure.add(new Rook("H8", ChessPiece.Color.BLACK));
        figure.add(new Rook("A1", ChessPiece.Color.WHITE));
        figure.add(new Rook("H1", ChessPiece.Color.WHITE));
        char slovo = 'A';
        int j = 0;
        for(int i = 0; i < 8; i++) {
            String poz = new String();
            slovo += j;
            poz += slovo;
            poz += 7;
            figure.add(new Pawn(poz, ChessPiece.Color.BLACK));
            j++;
        }
        slovo = 'A';
        j = 0;
        for(int i = 0; i < 8; i++) {
            String poz = new String();
            slovo += j;
            poz += slovo;
            poz += 2;
            figure.add(new Pawn(poz, ChessPiece.Color.WHITE));
            j++;
        }

    }

    public void move(Class type, ChessPiece.Color color, String position) {

    }

    public boolean isCheck(Color color) { return true; }
}
