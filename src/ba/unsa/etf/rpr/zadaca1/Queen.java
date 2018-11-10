package ba.unsa.etf.rpr.zadaca1;

public class Queen extends ChessPiece {
    public Queen(String pozicija, Color boja) {
        super(pozicija, boja);
    }


    @Override
    public void move(String position) {
        if(!provjeraIspravnostiPozicije(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        //ako nije zadovoljen if iznad onda nema neodgovarajuce pozicije za kraljicu, jer se ona krece u svim smjerovima i koliko god polja zeli
        //kraljica moze gore, dole, lijevo, desno i po dijagonalama
        if(this.kojiJeSmjerKretanja(position).length() == 0)
            throw new IllegalChessMoveException("Kraljica se ne može kretati na zadani nacin");
        this.setPosition(position);
    }
}
