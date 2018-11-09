package ba.unsa.etf.rpr;

public class Queen extends ChessPiece {
    public Queen(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) {
        if(!provjeraIspravnostiPozicije(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        //ako nije zadovoljen niti jedan od if-ova iznad onda nema neodgovarajuce pozicije za kraljicu, jer se ona krece u svim smjerovima i koliko god polja zeli

        this.setPosition(position);
    }
}
