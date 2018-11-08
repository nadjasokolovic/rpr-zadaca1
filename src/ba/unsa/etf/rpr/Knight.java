package ba.unsa.etf.rpr;

public class Knight extends ChessPiece {
    public Knight(String pozicija, Color boja) {
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
        //neispravna pozicija za konja
        //1. kada skace gore
        if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) - 2)
            throw new IllegalChessMoveException("Neispravna pozicija");
        else {
            if(pomocni.charAt(0) != pomocniThis.charAt(0) - 1 || pomocni.charAt(0) != pomocniThis.charAt(0) + 1)
                throw new IllegalChessMoveException("Neispravna pozicija");
        }
        //2. kada skace dole
        if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 2)
            throw new IllegalChessMoveException("Neispravna pozicija");
        else {
            if(pomocni.charAt(0) != pomocniThis.charAt(0) - 1 || pomocni.charAt(0) != pomocniThis.charAt(0) + 1)
                throw new IllegalChessMoveException("Neispravna pozicija");
        }
        //3. kada skace lijevo
        if(pomocni.charAt(0) != pomocniThis.charAt(0) - 2)
            throw new IllegalChessMoveException("Neispravna pozicija");
        else {
            if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 1 || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) - 1)
                throw new IllegalChessMoveException("Neispravna pozicija");
        }
        //4. kada skace desno
        if(pomocni.charAt(0) != pomocniThis.charAt(0) + 2)
            throw new IllegalChessMoveException("Neispravna pozicija");
        else {
            if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 1 || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) - 1)
                throw new IllegalChessMoveException("Neispravna pozicija");
        }

        this.pozicija = position;
    }

}
