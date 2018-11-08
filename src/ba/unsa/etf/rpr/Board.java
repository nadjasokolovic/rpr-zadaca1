package ba.unsa.etf.rpr;

import java.util.ArrayList;
import ba.unsa.etf.rpr.ChessPiece.Color;

public class Board {
    private ArrayList<ChessPiece> figure;

    private boolean provjeraIspravnosti(String position) {
        //pozicija van table
        String pomocni = new String(position);
        pomocni.toUpperCase();
        if(pomocni.charAt(0) < 'A' || pomocni.charAt(0) > 'H' || Character.getNumericValue(pomocni.charAt(1)) < 1 || Character.getNumericValue(pomocni.charAt(1)) > 8)
            return false;
        //ako je neispravan format, tj ide nesto sto nije slovo, pa onda nesto sto nije broj, ili samo jedno od ovoga
        if(!(pomocni.charAt(0) >= 'A' && pomocni.charAt(0) <= 'Z') || !(Character.getNumericValue(pomocni.charAt(1)) >= 1 || Character.getNumericValue(pomocni.charAt(1)) <= 9))
            return false;

        return true;
    }

    private boolean trebaLiPojestiFiguru(ArrayList<ChessPiece> figure, String pozicija, ChessPiece.Color boja) {
        for(ChessPiece jednaFigura : figure) {
            if(jednaFigura.getPosition().equals(pozicija) && !jednaFigura.getColor().equals(boja))
                return true;
        }
        return false;
    }

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
        if(!provjeraIspravnosti(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        int kraj = 0;
        for(ChessPiece jednaFigura : figure) {
            if(jednaFigura.getClass() == type && jednaFigura.getColor().equals(color)) {
                try {
                    jednaFigura.move(position);
                    //provjeriti je li pojela neku figuru
                    if(trebaLiPojestiFiguru(figure, position, color)) {
                        for(ChessPiece f : figure) {
                            if (f.getPosition().equals(position)) {
                                figure.remove(f);
                                break;
                            }
                        }
                    }
                } catch (IllegalChessMoveException izuzetak) {
                    if(kraj == figure.size() - 1)
                        throw new IllegalChessMoveException("Nema niti jedna figura za koju je pozicija ispravna");
                }
            }
            kraj++;
        }
    }

    public boolean isCheck(Color color) { return true; }
}
