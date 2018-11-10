package ba.unsa.etf.rpr.zadaca1;

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
        char thisPozSlovo = pomocniThis.charAt(0);
        int thisPozBroj = Character.getNumericValue(this.getPosition().charAt(1));
        char pozSlovo = pomocni.charAt(0);
        int pozBroj = Character.getNumericValue(position.charAt(1));
        if((pozSlovo != thisPozSlovo - 1 || pozBroj != thisPozBroj + 2) && (pozSlovo != thisPozSlovo - 2 || pozBroj != thisPozBroj + 1)
           && (pozSlovo != thisPozSlovo - 2 || pozBroj != thisPozBroj - 1) && (pozSlovo != thisPozSlovo - 1 || pozBroj != thisPozBroj - 2)
           && (pozSlovo != thisPozSlovo + 1 || pozBroj != thisPozBroj - 2) && (pozSlovo != thisPozSlovo + 2 || pozBroj != thisPozBroj - 1)
           && (pozSlovo != thisPozSlovo + 2 || pozBroj != thisPozBroj + 1) && (pozSlovo != thisPozSlovo + 1 || pozBroj != thisPozBroj + 2))
            throw new IllegalChessMoveException("Neispravna pozicija");

        this.setPosition(position);
    }

}
