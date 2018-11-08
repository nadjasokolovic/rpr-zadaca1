package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {
    public Rook(String pozicija, Color boja) {
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
        //neispravno kretanje je dijagonalno
        if(!pomjeraLiLijevoDesno(pomocniThis, pomocni) && !pomjeraLiGoreDole(pomocniThis, pomocni))
            throw new IllegalChessMoveException("Top se ne moze kretati dijagonalno");

        this.pozicija = position;
    }

}
