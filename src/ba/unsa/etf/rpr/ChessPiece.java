package ba.unsa.etf.rpr;

public abstract class ChessPiece {

    public static enum Color{ BLACK, WHITE }
    protected  String pozicija;
    protected Color boja;
    public ChessPiece(String pozicija, Color boja) {
        if(pozicija.charAt(0) < 'A' || pozicija.charAt(0) > 'H' || Character.getNumericValue(pozicija.charAt(1)) < 1 || Character.getNumericValue(pozicija.charAt(1)) > 8)
            throw new IllegalArgumentException("Neispravni parametri");
        this.pozicija = pozicija;
        this.boja = boja;
    }

    public String getPosition() { return this.pozicija; }
    public Color getColor() { return boja; }
    public abstract void move(String position);
}
