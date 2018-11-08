package ba.unsa.etf.rpr;

public class King extends ChessPiece {

    public King(String pozicija, Color boja) {
        /*if(pozicija.charAt(0) < 'A' || pozicija.charAt(0) > 'H' || Character.getNumericValue(pozicija.charAt(1)) < 1 || Character.getNumericValue(pozicija.charAt(1)) > 8)
            throw new IllegalArgumentException("Neispravni parametri");
        this.pozicija = pozicija;
        this.boja = boja;*/
        super(pozicija, boja);
    }

    private boolean pomjeraLiLijevoDesno(String poz1, String poz2) {
        String poz11 = new String();
        poz11 = poz1.toUpperCase();
        String poz22 = new String();
        poz22 = poz2.toUpperCase();
        if(poz11.charAt(1) == poz22.charAt(1))
            return true;
        return false;
    }

    private boolean pomjeraLiGoreDole(String poz1, String poz2) {
        String poz11 = new String();
        poz11 = poz1.toUpperCase();
        String poz22 = new String();
        poz22 = poz2.toUpperCase();
        if(poz11.charAt(0) == poz22.charAt(0))
            return true;
        return false;
    }

    @Override
    public void move(String position) {
        if(!provjeraIspravnostiPozicije(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        String pomocni = new String(position);
        pomocni.toUpperCase();
        String pomocniThis = new String(this.getPosition());
        pomocniThis.toUpperCase();
        //ako je pozicija neodgovarajuca za kralja
        //1. ako pomjera lijevo-desno
        if(pomjeraLiLijevoDesno(pomocniThis, pomocni)) {
            if(pomocni.charAt(0) < pomocniThis.charAt(0) - 1 || pomocni.charAt(0) > pomocniThis.charAt(0) + 1)
                throw new IllegalChessMoveException("Kralj se moze kretati samo za jedno mjesto");
        }
        if(pomjeraLiGoreDole(pomocniThis, pomocni)) {
            if(pomocni.charAt(1) < pomocniThis.charAt(0) - 1 || pomocni.charAt(0) > pomocniThis.charAt(0) + 1)
                throw new IllegalChessMoveException("Kralj se moze kretati samo za jedno mjesto");
        }
        if(!pomjeraLiGoreDole(pomocniThis, pomocni) && !pomjeraLiLijevoDesno(this.getPosition(), position)) {
            //znaci dijagonalno
            //ako je dalje od jedne pozicije lijevo ili jedne pozicije desno
            if(pomocni.charAt(0) != (pomocniThis.charAt(0) - 1) || pomocni.charAt(0) != (pomocniThis.charAt(0) + 1))
                throw new IllegalChessMoveException("Kralj se mora kretati samo za jedno mjesto");
            else if(pomocni.charAt(0) == (pomocniThis.charAt(0) - 1) || pomocni.charAt(0) == (pomocniThis.charAt(0) + 1)) {
            //slovo je ok, provjerava da li je broj ok
                if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 1 || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocni.charAt(1)) - 1)
                    throw new IllegalChessMoveException("Kralj se mora kretati samo za jedno mjesto");
            }
        }
        this.pozicija = position;

    }

}
