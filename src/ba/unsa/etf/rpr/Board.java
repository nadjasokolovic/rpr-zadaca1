package ba.unsa.etf.rpr;

public class Board {
    private ChessPiece[] figure;

    public Board() {
        figure = new ChessPiece[32];
        figure[0] = new King("D8", ChessPiece.Color.BLACK);
        figure[1] = new King("D1", ChessPiece.Color.WHITE);
        figure[2] = new Queen("E8", ChessPiece.Color.BLACK);
        figure[3] = new Queen("E1", ChessPiece.Color.WHITE);
        figure[4] = new Bishop("C8", ChessPiece.Color.BLACK);
        figure[5] = new Bishop("F8", ChessPiece.Color.BLACK);
        figure[6] = new Bishop("C1", ChessPiece.Color.WHITE);
        figure[7] = new Bishop("F1", ChessPiece.Color.WHITE);
        figure[8] = new Knight("B8", ChessPiece.Color.BLACK);
        figure[9] = new Knight("G8", ChessPiece.Color.BLACK);
        figure[10] = new Knight("B1", ChessPiece.Color.WHITE);
        figure[11] = new Knight("G1", ChessPiece.Color.WHITE);
        figure[12] = new Rook("A8", ChessPiece.Color.BLACK);
        figure[13] = new Rook("H8", ChessPiece.Color.BLACK);
        figure[14] = new Rook("A1", ChessPiece.Color.WHITE);
        figure[15] = new Rook("H1", ChessPiece.Color.WHITE);
        char slovo = 'A';
        int j = 0;
        for(int i = 16; i <= 23; i++) {
            String poz = new String();
            slovo += j;
            poz += slovo;
            poz += 7;
            figure[i] = new Pawn(poz, ChessPiece.Color.BLACK);
            j++;
        }
        slovo = 'A';
        j = 0;
        for(int i = 24; i <= 31; i++) {
            String poz = new String();
            slovo += j;
            poz += slovo;
            poz += 2;
            figure[i] = new Pawn(poz, ChessPiece.Color.WHITE);
            j++;
        }
    }

    public void move(Class type, ChessPiece.Color color, String position) {

    }
}
