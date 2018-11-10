package ba.unsa.etf.rpr;

import java.util.*;

public class Board {
    private ArrayList<ChessPiece> figure;

    public boolean provjeraIspravnosti(String position) {
        //pozicija van table
        String pomocni = position.toUpperCase();

        if(pomocni.charAt(0) < 'A' || pomocni.charAt(0) > 'H' || pomocni.charAt(1) < '1' || pomocni.charAt(1) > '8')
            return false;
        //ako je neispravan format, tj ide nesto sto nije slovo ili nesto sto nije broj, ili samo jedno od ovoga
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
        int trenutnaBroj = Character.getNumericValue(trenutnaPozicija.charAt(1));
        int odredisnaBroj = Character.getNumericValue(odredisnaPozicija.charAt(1));
        char trenutnaSlovo = trenutnaPozicija.charAt(0);
        char odredisnaSlovo = odredisnaPozicija.charAt(0);
        if(trenutnaSlovo == odredisnaSlovo && trenutnaBroj < odredisnaBroj)
            s += "gore";
        else if(trenutnaSlovo == odredisnaSlovo && trenutnaBroj > odredisnaBroj)
            s += "dole";
        else if(trenutnaSlovo < odredisnaSlovo && trenutnaBroj < odredisnaBroj && (odredisnaSlovo - trenutnaSlovo) == (odredisnaBroj - trenutnaBroj))
            s += "dijagonalno gore desno";
        else if(trenutnaSlovo > odredisnaSlovo && trenutnaBroj < odredisnaBroj && (trenutnaSlovo - odredisnaSlovo) == (odredisnaBroj - trenutnaBroj))
            s += "dijagonalno gore lijevo";
        else if(trenutnaSlovo < odredisnaSlovo && trenutnaBroj > odredisnaBroj && (odredisnaSlovo - trenutnaSlovo) == (trenutnaBroj - odredisnaBroj))
            s += "dijagonalno dole desno";
        else if(trenutnaSlovo > odredisnaSlovo && trenutnaBroj > odredisnaBroj && (trenutnaSlovo - odredisnaSlovo) == (trenutnaBroj - odredisnaBroj))
            s += "dijagonalno dole lijevo";
        else if(trenutnaSlovo < odredisnaSlovo && trenutnaBroj == odredisnaBroj)
            s += "desno";
        else if(trenutnaSlovo > odredisnaSlovo && trenutnaBroj == odredisnaBroj)
            s += "lijevo";

        return s;
    }

    private boolean daLiJeBlokirana(String pocetnaPozicija, String odredisnaPozicija, String smjer) {
        char pocetnaSlovo = pocetnaPozicija.charAt(0);
        int pocetnaBroj = Character.getNumericValue(pocetnaPozicija.charAt(1));
        char odredisnaSlovo = odredisnaPozicija.charAt(0);
        int odredisnaBroj = Character.getNumericValue(odredisnaPozicija.charAt(1));

        if(smjer.equals("gore")) {
            pocetnaBroj += 1;
            while(pocetnaBroj < odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    return true;
                }
                 pocetnaBroj++;
            }
        }
        else if(smjer.equals("dole")) {
            pocetnaBroj -= 1;
            while(pocetnaBroj > odredisnaBroj) {
                String poz = new String();
                poz += pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    return true;
                }
                pocetnaBroj--;
            }
        }
        else if(smjer.equals("lijevo")) {
            pocetnaSlovo -= 1;
            while(pocetnaSlovo > odredisnaSlovo) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    return true;
                }
                pocetnaSlovo--;
            }
        }
        else if(smjer.equals("desno")) {
            pocetnaSlovo += 1;
            while(pocetnaSlovo < odredisnaSlovo) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    return true;
                }
                pocetnaSlovo++;
            }
        }
        else if(smjer.equals("dijagonalno gore desno")) {
            pocetnaBroj += 1;
            pocetnaSlovo += 1;
            while(pocetnaSlovo < odredisnaSlovo && pocetnaBroj < odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    return true;
                }
                pocetnaSlovo++;
                pocetnaBroj++;
            }
        }
        else if(smjer.equals("dijagonalno gore lijevo")) {
            pocetnaSlovo -= 1;
            pocetnaBroj += 1;
            while(pocetnaSlovo > odredisnaSlovo && pocetnaBroj < odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    return true;
                }
                pocetnaSlovo--;
                pocetnaBroj++;
            }
        }
        else if(smjer.equals("dijagonalno dole lijevo")) {
            pocetnaSlovo -= 1;
            pocetnaBroj -= 1;
            while(pocetnaSlovo > odredisnaSlovo && pocetnaBroj > odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    return true;
                }
                pocetnaSlovo--;
                pocetnaBroj--;
            }
        }
        else if(smjer.equals("dijagonalno dole desno")) {
            pocetnaSlovo += 1;
            pocetnaBroj -= 1;
            while(pocetnaSlovo < odredisnaSlovo && pocetnaBroj > odredisnaBroj) {
                String poz = new String();
                poz = pocetnaSlovo + Integer.toString(pocetnaBroj);
                if(imaLiFiguraNaPoziciji(poz)) {
                    return true;
                }
                pocetnaSlovo++;
                pocetnaBroj--;
            }
        }
        return  false;
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
        for(int i = 0; i < 8; i++) {
            String poz = new String();
            poz = slovo + Integer.toString(7);
            figure.add(new Pawn(poz, ChessPiece.Color.BLACK));
            slovo++;
        }
        slovo = 'A';
        for(int i = 0; i < 8; i++) {
            String poz = new String();
            poz = slovo + Integer.toString(2);
            figure.add(new Pawn(poz, ChessPiece.Color.WHITE));
            slovo++;
        }

    }

    public ChessPiece getFiguruNaPoziciji(String position) {
        int i = 0;
        for(i = 0; i < figure.size(); i++) {
            if(figure.get(i).getPosition().equals(position))
                break;
        }
        return figure.get(i);
    }

    public void move(Class type, ChessPiece.Color color, String position) {
        if(!provjeraIspravnosti(position)) {
            throw new IllegalArgumentException("Illegal move");
        }
        int kraj = 0;
        boolean krajPetlje = false;
        for(ChessPiece jednaFigura : figure) {
            if(jednaFigura.getClass() == type && jednaFigura.getColor().equals(color)) {
                try {
                    //ovdje provjeriti da li je blokira neka, ako blokira ne igramo sa njom nego sa continue preskocimo na sljedecu iteraciju
                    //jednaFigura.getPosition() je pocetna pozicija
                    //position je krajnja pozicija
                    if(!(jednaFigura instanceof Knight || jednaFigura instanceof King) && daLiJeBlokirana(jednaFigura.getPosition(), position, kojiJeSmjerKretanja(jednaFigura.getPosition(), position))) {
                        kraj++;
                        if(kraj == figure.size())
                            throw new IllegalChessMoveException("Illegal move");
                        continue;
                    }
                    //ako je pijun dodati da moze ici lijevo i desno kad jede figuru
                    if(jednaFigura instanceof Pawn && (kojiJeSmjerKretanja(jednaFigura.getPosition(), position).equals("dijagonalno gore desno") || kojiJeSmjerKretanja(jednaFigura.getPosition(), position).equals("dijagonalno gore lijevo"))
                            && trebaLiPojestiFiguru(figure, position, color)) {
                        jednaFigura.setPosition(position);
                    }
                    else
                        jednaFigura.move(position);
                    //provjeriti je li pojela neku figuru
                    if(trebaLiPojestiFiguru(figure, position, color)) {
                        for(ChessPiece f : figure) {
                            if (f.getPosition().equals(position)) {
                                //provjeriti da li je na ovoj pozicijji figura iste boje
                                if(f.getColor().equals(color))
                                    throw new IllegalChessMoveException("Illegal move");
                                //ako nije iste boje treba je pojesti
                                figure.remove(f);
                                krajPetlje = true;
                                break;
                            }
                        }

                    }
                } catch (IllegalChessMoveException izuzetak) {
                    kraj++;
                    if(kraj == figure.size())
                        throw izuzetak;
                    continue;
                }
            }
            if(krajPetlje) break;
        }
    }

    public void move(String oldPosition, String newPosition) {
        if(!imaLiFiguraNaPoziciji(oldPosition))
            throw new IllegalArgumentException("Na ovoj poziciji nema figure");
        ChessPiece figuraNaStarojPoziciji = getFiguruNaPoziciji(oldPosition);
        if(!(figuraNaStarojPoziciji instanceof Knight || figuraNaStarojPoziciji instanceof King) &&
                daLiJeBlokirana(oldPosition, newPosition, kojiJeSmjerKretanja(oldPosition, newPosition)))
            throw new IllegalChessMoveException("Ova figura je blokirana drugim figurama");
        try {
            if(figuraNaStarojPoziciji instanceof Pawn && (kojiJeSmjerKretanja(figuraNaStarojPoziciji.getPosition(), newPosition).equals("dijagonalno gore desno") || kojiJeSmjerKretanja(figuraNaStarojPoziciji.getPosition(), newPosition).equals("dijagonalno gore lijevo"))
                    && trebaLiPojestiFiguru(figure, newPosition, figuraNaStarojPoziciji.getColor())) {
                figuraNaStarojPoziciji.setPosition(newPosition);
            }
            else
                figuraNaStarojPoziciji.move(newPosition);
            //provjeriti je li pojela neku figuru
            if(trebaLiPojestiFiguru(figure, newPosition, figuraNaStarojPoziciji.getColor())) {
                for(ChessPiece f : figure) {
                    if (f.getPosition().equals(newPosition)) {
                        //provjeriti da li je na ovoj pozicijji figura iste boje
                        if(f.getColor().equals(figuraNaStarojPoziciji.getColor()))
                            throw new IllegalChessMoveException("Na odredisnoj poziciji je figura iste boje");
                        //ako nije iste boje treba je pojesti
                        figure.remove(f);
                        break;
                    }
                }
            }
        } catch (IllegalChessMoveException izuzetak) {
            System.out.println(izuzetak.getMessage());
            throw izuzetak;
        }

    }

    public boolean isCheck(ChessPiece.Color color) {
        boolean povratni = false;
        String pozicijaKralja = new String();
        for(ChessPiece figura : figure) {
            if(figura instanceof King && figura.getColor().equals(color)) {
                pozicijaKralja = figura.getPosition();
                break;
            }
        }
        for(ChessPiece figura : figure) {
            try {
                if(!figura.getColor().equals(color) && !daLiJeBlokirana(figura.getPosition(), pozicijaKralja, kojiJeSmjerKretanja(figura.getPosition(), pozicijaKralja))) {
                    figura.move(pozicijaKralja);
                    povratni = true;
                    break;
                }
            }
            catch(IllegalChessMoveException izuzetak) {
                //continue;
            }
        }
        return povratni;
    }
}
