package ba.unsa.etf.rpr.zadaca1;

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
        String smjer = this.kojiJeSmjerKretanja(position);
        if(!smjer.contains("dijagonalno"))
            throw new IllegalChessMoveException("Lovac se ne može kretiati u zadanom smjeru");

        this.pozicija = position;
    }
}
