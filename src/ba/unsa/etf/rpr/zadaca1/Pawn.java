package ba.unsa.etf.rpr.zadaca1;

public class Pawn extends ChessPiece {
    public Pawn(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) {
        if(!provjeraIspravnostiPozicije(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        String pomocni = position.toUpperCase();
        String pomocniThis = this.getPosition().toUpperCase();
        //neispravna pozicija za pijuna
        if(Character.getNumericValue(this.getPosition().charAt(1)) == 2 || Character.getNumericValue(this.getPosition().charAt(1)) == 7) {
            if (pomocni.charAt(0) != pomocniThis.charAt(0) || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 2)
                throw new IllegalChessMoveException("Neispravna pozicija za pijuna");
        }
        else if(Character.getNumericValue(this.getPosition().charAt(1)) != 2 || Character.getNumericValue(this.getPosition().charAt(1)) != 7) {
            if (pomocni.charAt(0) != pomocniThis.charAt(0) || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 1)
                throw new IllegalChessMoveException("Neispravna pozicija za pijuna");
        }
        //provjeriti sta za prvi potez i kad jede
        this.pozicija = position;
    }


}
