package ba.unsa.etf.rpr;

import java.util.*;

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

    private boolean imaLiFiguraNaPoziciji(String position) {
        for(ChessPiece f : figure) {
            if(f.getPosition().equals(position))
                return true;
        }
        return false;
    }

    private String kojiJeSmjerKretanja(String trenutnaPozicija, String odredisnaPozicija) {
        String s = new String();
        if(trenutnaPozicija.charAt(0) == odredisnaPozicija.charAt(0) && Character.getNumericValue(trenutnaPozicija.charAt(1)) < Character.getNumericValue(odredisnaPozicija.charAt(1)))
            s += "gore";
        else if(trenutnaPozicija.charAt(0) == odredisnaPozicija.charAt(0) && Character.getNumericValue(trenutnaPozicija.charAt(1)) > Character.getNumericValue(odredisnaPozicija.charAt(1)))
            s += "dole";
        else if(trenutnaPozicija.charAt(0) < odredisnaPozicija.charAt(0) && Character.getNumericValue(trenutnaPozicija.charAt(1)) < Character.getNumericValue(odredisnaPozicija.charAt(1)))
            s += "dijagonalno gore desno";
        else if(trenutnaPozicija.charAt(0) > odredisnaPozicija.charAt(0) && Character.getNumericValue(trenutnaPozicija.charAt(1)) < Character.getNumericValue(odredisnaPozicija.charAt(1)))
            s += "dijagonalno gore lijevo";
        else if(trenutnaPozicija.charAt(0) < odredisnaPozicija.charAt(0) && Character.getNumericValue(trenutnaPozicija.charAt(1)) > Character.getNumericValue(odredisnaPozicija.charAt(1)))
            s += "dijagonalno dole desno";
        else if(trenutnaPozicija.charAt(0) > odredisnaPozicija.charAt(0) && Character.getNumericValue(trenutnaPozicija.charAt(1)) > Character.getNumericValue(odredisnaPozicija.charAt(1)))
            s += "dijagonalno dole lijevo";
        else if(trenutnaPozicija.charAt(0) < odredisnaPozicija.charAt(0) && Character.getNumericValue(trenutnaPozicija.charAt(1)) == Character.getNumericValue(odredisnaPozicija.charAt(1)))
            s += "desno";
        else if(trenutnaPozicija.charAt(0) > odredisnaPozicija.charAt(0) && Character.getNumericValue(trenutnaPozicija.charAt(1)) == Character.getNumericValue(odredisnaPozicija.charAt(1)))
            s += "lijevo";

        return s;
    }

    private boolean daLiJeBlokirana(String pocetnaPozicija, String odredisnaPozicija, String smjer) {
        boolean blokira = false;
        char pocetnaSlovo = pocetnaPozicija.charAt(0);
        int pocetnaBroj = Character.getNumericValue(pocetnaPozicija.charAt(1));
        char odredisnaSlovo = odredisnaPozicija.charAt(0);
        int odredisnaBroj = Character.getNumericValue(odredisnaPozicija.charAt(1));

        if(smjer.equals("gore")) {
            while(pocetnaBroj < odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    blokira = true;
                    break;
                }
                 pocetnaBroj++;
            }
        }
        else if(smjer.equals("dole")) {
            while(pocetnaBroj > odredisnaBroj) {
                String poz = new String();
                poz += pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    blokira = true;
                    break;
                }
                pocetnaBroj--;
            }
        }
        else if(smjer.equals("lijevo")) {
            while(pocetnaSlovo > odredisnaSlovo) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    blokira = true;
                    break;
                }
                pocetnaSlovo--;
            }
        }
        else if(smjer.equals("desno")) {
            while(pocetnaSlovo < odredisnaSlovo) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    blokira = true;
                    break;
                }
                pocetnaSlovo++;
            }
        }
        else if(smjer.equals("dijagonalno gore desno")) {
            while(pocetnaSlovo < odredisnaSlovo && pocetnaBroj < odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    blokira = true;
                    break;
                }
                pocetnaSlovo++;
                pocetnaBroj++;
            }
        }
        else if(smjer.equals("dijagonalno gore lijevo")) {
            while(pocetnaSlovo > odredisnaSlovo && pocetnaBroj < odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    blokira = true;
                    break;
                }
                pocetnaSlovo--;
                pocetnaBroj++;
            }
        }
        else if(smjer.equals("dijagonalno dole lijevo")) {
            while(pocetnaSlovo > odredisnaSlovo && pocetnaBroj > odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    blokira = true;
                    break;
                }
                pocetnaSlovo--;
                pocetnaBroj--;
            }
        }
        else if(smjer.equals("dijagonalno dole desno")) {
            while(pocetnaSlovo < odredisnaSlovo && pocetnaBroj > odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    blokira = true;
                    break;
                }
                pocetnaSlovo++;
                pocetnaBroj--;
            }
        }
        return  blokira;
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
        boolean krajPetlje = false;
        for(ChessPiece jednaFigura : figure) {
            if(jednaFigura.getClass() == type && jednaFigura.getColor().equals(color)) {
                try {
                    //ovdje provjeriti da li je blokira neka, ako blokira ne igramo sa njom nego sa continue preskocimo na sljedecu iteraciju
                    //figura.getPosition() je pocetna pozicija
                    //position je krajnja pozicija
                    if(!(jednaFigura instanceof Knight || jednaFigura instanceof King) && daLiJeBlokirana(jednaFigura.getPosition(), position, kojiJeSmjerKretanja(jednaFigura.getPosition(), position)))
                        continue;
                    jednaFigura.move(position);
                    //provjeriti je li pojela neku figuru
                    if(trebaLiPojestiFiguru(figure, position, color)) {
                        for(ChessPiece f : figure) {
                            if (f.getPosition().equals(position)) {
                                //provjeriti da li je na ovoj pozicijji figura iste boje
                                if(f.getColor().equals(color))
                                    throw new IllegalChessMoveException("Na odredisnoj poziciji je figura iste boje");
                                //ako nije iste boje treba je pojesti
                                figure.remove(f);
                                krajPetlje = true;
                                break;
                            }
                        }
                    }
                } catch (IllegalChessMoveException izuzetak) {
                    kraj++;
                    if(kraj == figure.size() - 1)
                        throw new IllegalChessMoveException("Nema niti jedna figura za koju je pozicija ispravna");
                    continue;
                }
            }
            if(krajPetlje) break;
            kraj++;
            if(kraj == figure.size() - 1)
                throw new IllegalChessMoveException("Nema niti jedna figura za koju je pozicija ispravna");
        }
    }


    public boolean isCheck(Color color) { return true; }
}
