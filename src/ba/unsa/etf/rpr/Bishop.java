package ba.unsa.etf.rpr;

public class Bishop extends ChessPiece {
    public Bishop(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) {
        if(!provjeraIspravnostiPozicije(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        String pomocni = position.toUpperCase();
        String pomocniThis = this.getPosition().toUpperCase();
        if(pomjeraLiGoreDole(pomocniThis, pomocni) || pomjeraLiLijevoDesno(pomocniThis, pomocni))
            throw new IllegalChessMoveException("Lovac ne ne moze kretati u ovom smjeru");

        this.pozicija = position;
    }
}
