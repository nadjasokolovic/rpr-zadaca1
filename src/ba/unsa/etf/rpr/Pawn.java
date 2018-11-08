package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public Pawn(String pozicija, Color boja) {
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
        //neispravna pozicija za pijuna
        //zanemaruju se ostale figure, znaci on ne moze ici ni dijagonalno?
        if(pomocni.charAt(0) != pomocniThis.charAt(0) || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 1)
            throw new IllegalChessMoveException("Neispravna pozicija za pijuna");
        //provjeriti sta za prvi potez i kad jede
        this.pozicija = position;
    }
}
