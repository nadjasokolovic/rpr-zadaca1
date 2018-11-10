package ba.unsa.etf.rpr.zadaca1;

import java.util.Scanner;

public class Program {

    private static Class odrediTip(String unos) {
        Class type = null;
        if (unos.length() == 2) {
            type = Pawn.class;
        } else if (unos.length() == 3) {
            char tip = unos.charAt(0);
            switch (tip) {
                case 'K':
                    type = King.class;
                    break;
                case 'Q':
                    type = Queen.class;
                    break;
                case 'R':
                    type = Rook.class;
                    break;
                case 'B':
                    type = Bishop.class;
                    break;
                case 'N':
                    type = Knight.class;
                    break;
            }
        }
        return type;
    }

    public static void main(String[] args) {
        Board ploca = new Board();
        Scanner input = new Scanner(System.in);
        boolean white = true;

        Class type = null;
        ChessPiece.Color color = null;
        String pozicija = null;
        for (; ; ) {
            if (white) {
                System.out.print("White move: ");
                //unos pozicije
                String unos = input.nextLine();
                if (unos.compareTo("X") == 0 || unos.compareTo("x") == 0)
                    break;
                color = ChessPiece.Color.WHITE;
                try {
                    //odredi poziciju
                    if (unos.length() == 2)
                        pozicija = unos;
                    else if (unos.length() == 3)
                        pozicija = unos.substring(1);
                    //odredi tip
                    type = odrediTip(unos);

                    ploca.move(Rook.class, ChessPiece.Color.BLACK, "H6");

                    ploca.move(type, color, pozicija);
                    if(ploca.isCheck(ChessPiece.Color.BLACK))
                        System.out.println("CHECK!!!");

                    //kada je bijeli zavrsio potez stavi ga na false. Ako je illegal move onda ostaje true.
                    white = false;
                } catch (IllegalArgumentException e) {
                    System.out.println("Illegal move");
                }
            } else {
                System.out.print("Black move: ");
                String unos = input.nextLine();
                if (unos.compareTo("X") == 0 || unos.compareTo("x") == 0)
                    break;
                color = ChessPiece.Color.BLACK;
                try {
                    if (unos.length() == 2)
                        pozicija = unos;
                    else if (unos.length() == 3)
                        pozicija = unos.substring(1);
                    type = odrediTip(unos);

                    ploca.move(type, color, pozicija);
                    if(ploca.isCheck(ChessPiece.Color.WHITE))
                        System.out.println("CHECK!!!");

                    white = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Illegal move");
                }
            }
        }

    }
}
