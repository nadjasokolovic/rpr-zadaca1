package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {
    public Rook(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    private boolean lijevoDesno(String poz1, String poz2) {
        String poz11 = new String();
        poz11 = poz1.toUpperCase();
        String poz22 = new String();
        poz22 = poz2.toUpperCase();
        if(poz11.charAt(1) == poz22.charAt(1))
            return true;
        return false;
    }

    private boolean goreDole(String poz1, String poz2) {
        String poz11 = new String();
        poz11 = poz1.toUpperCase();
        String poz22 = new String();
        poz22 = poz2.toUpperCase();
        if(poz11.charAt(0) == poz22.charAt(0))
            return true;
        return false;
    }

    private boolean dijagonalno(String poz1, String poz2) {
        if(!goreDole(poz1, poz2) && !lijevoDesno(poz1, poz2))
            return true;
        return false;
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
        if(dijagonalno(pomocniThis, pomocni))
            throw new IllegalChessMoveException("Top se ne moze kretati dijagonalno");

        this.pozicija = position;
    }

}
