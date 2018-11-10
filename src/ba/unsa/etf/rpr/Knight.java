package ba.unsa.etf.rpr;

public class Knight extends ChessPiece {
    public Knight(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public void move(String position) {
        if(!provjeraIspravnostiPozicije(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        String pomocni = position.toUpperCase();
        String pomocniThis = this.getPosition().toUpperCase();
        //neispravna pozicija za konja
        if(pomjeraLiGoreDole(this.getPosition(), position) || pomjeraLiLijevoDesno(this.getPosition(), position))
            throw new IllegalChessMoveException("Neiaspravna pozicija");
        char thisPozSlovo = this.getPosition().charAt(0);
        int thisPozBroj = Character.getNumericValue(this.getPosition().charAt(1));
        char pozSlovo = position.charAt(0);
        int pozBroj = Character.getNumericValue(position.charAt(1));
        //if()

        this.setPosition(position);
    }

}
