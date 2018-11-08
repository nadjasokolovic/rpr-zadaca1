package ba.unsa.etf.rpr;

public abstract class ChessPiece {

    public static enum Color{
        BLACK, WHITE
    }
    protected  String pozicija;
    protected Color boja;
    public ChessPiece(String pozicija, Color boja) {
        if(pozicija.charAt(0) < 'A' || pozicija.charAt(0) > 'H' || Character.getNumericValue(pozicija.charAt(1)) < 1 || Character.getNumericValue(pozicija.charAt(1)) > 8)
            throw new IllegalArgumentException("Neispravni parametri");
        this.pozicija = pozicija;
        this.boja = boja;
    }

    public boolean provjeraIspravnostiPozicije(String position) {
        //pozicija van table
        String pomocni = new String(position);
        pomocni.toUpperCase();
        String pomocniThis = new String(this.getPosition());
        pomocniThis.toUpperCase();
        if(pomocni.charAt(0) < 'A' || pomocni.charAt(0) > 'H' || Character.getNumericValue(pomocni.charAt(1)) < 1 || Character.getNumericValue(pomocni.charAt(1)) > 8)
            return false;
        //ako je neispravan format, tj ide nesto sto nije slovo, pa onda nesto sto nije broj, ili samo jedno od ovoga
        if(!(pomocni.charAt(0) >= 'A' && pomocni.charAt(0) <= 'Z') || !(Character.getNumericValue(pomocni.charAt(1)) >= 1 || Character.getNumericValue(pomocni.charAt(1)) <= 9))
            return false;

        return true;
    }

    public String getPosition() { return this.pozicija; }
    public Color getColor() { return boja; }
    public abstract void move(String position);
}
