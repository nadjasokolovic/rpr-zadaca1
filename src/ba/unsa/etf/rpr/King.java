package ba.unsa.etf.rpr;

public class King extends ChessPiece {

    public King(String pozicija, Color boja) {
        super(pozicija, boja);
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
            if(Character.getNumericValue(pomocni.charAt(1)) < (Character.getNumericValue(pomocniThis.charAt(1)) - 1) || Character.getNumericValue(pomocni.charAt(1)) > (Character.getNumericValue(pomocniThis.charAt(1)) + 1))
            if(pomocni.charAt(1) < pomocniThis.charAt(0) - 1 || pomocni.charAt(0) > pomocniThis.charAt(0) + 1)
                throw new IllegalChessMoveException("Kralj se moze kretati samo za jedno mjesto");
        }
        if(!pomjeraLiGoreDole(pomocniThis, pomocni) && !pomjeraLiLijevoDesno(this.getPosition(), position)) {
            //znaci dijagonalno
            //ako je dalje od jedne pozicije lijevo ili jedne pozicije desno
            if(pomocni.charAt(0) < (pomocniThis.charAt(0) - 1) || pomocni.charAt(0) > (pomocniThis.charAt(0) + 1))
                throw new IllegalChessMoveException("Kralj se mora kretati samo za jedno mjesto");
            else if(pomocni.charAt(0) == (pomocniThis.charAt(0) - 1) || pomocni.charAt(0) == (pomocniThis.charAt(0) + 1)) {
            //slovo je ok, provjerava da li je broj ok
                if(Character.getNumericValue(pomocni.charAt(1)) > Character.getNumericValue(pomocniThis.charAt(1)) + 1 || Character.getNumericValue(pomocni.charAt(1)) < Character.getNumericValue(pomocni.charAt(1)) - 1)
                    throw new IllegalChessMoveException("Kralj se mora kretati samo za jedno mjesto");
            }
        }
        this.setPosition(position);

    }

}
