package ba.unsa.etf.rpr.zadaca1;

public class Rook extends ChessPiece {
    public Rook(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) {
        if(!provjeraIspravnostiPozicije(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        String pomocni = position.toUpperCase();
        String pomocniThis = this.getPosition().toUpperCase();
        //neispravno kretanje je dijagonalno
        if(!pomjeraLiLijevoDesno(pomocniThis, pomocni) && !pomjeraLiGoreDole(pomocniThis, pomocni))
            throw new IllegalChessMoveException("Top se ne moze kretati dijagonalno");
        //ako je vraćen prazan string onda je to ilegalno kretanje
        if (this.kojiJeSmjerKretanja(position).length() == 0) {
            throw new IllegalChessMoveException("Top se ne moze kretati u zadanom smjeru");
        }

        this.setPosition(position);
    }

}
