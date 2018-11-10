package ba.unsa.etf.rpr;

public abstract class ChessPiece {

    public static enum Color{
        BLACK, WHITE
    }
    protected  String pozicija;
    protected Color boja;
    public ChessPiece(String pozicija, Color boja) {
        boolean prazanString = pozicija.isEmpty();
        if(prazanString)
            throw new IllegalArgumentException("Izuzetak");
        if(!(pozicija.charAt(0) >= 'A' && pozicija.charAt(0) <= 'H') || !(Character.getNumericValue(pozicija.charAt(1)) >= 1 && Character.getNumericValue(pozicija.charAt(1)) <= 8))
            throw new IllegalArgumentException("Neispravni parametri");

        this.pozicija = pozicija;
        this.boja = boja;
    }

    public boolean pomjeraLiLijevoDesno(String poz1, String poz2) {
        if(Character.getNumericValue(poz1.charAt(1)) == Character.getNumericValue(poz2.charAt(1)) && (poz1.charAt(0) < poz2.charAt(0) ||poz1.charAt(0) > poz2.charAt(0)))
            return true;

        return false;
    }

    public boolean pomjeraLiGoreDole(String poz1, String poz2) {
        if(poz1.charAt(0) == poz2.charAt(0) && (Character.getNumericValue(poz1.charAt(1)) < Character.getNumericValue(poz2.charAt(1)) || Character.getNumericValue(poz1.charAt(1)) > Character.getNumericValue(poz2.charAt(1))))
            return true;

        return false;
    }

    public boolean provjeraIspravnostiPozicije(String position) {
        //ako je prazan string
        boolean prazanString = position.isEmpty();
        if(prazanString)
            return false;
        //pozicija van table
        String pomocni = position.toUpperCase();
        if((pomocni.charAt(0) < 'A' || pomocni.charAt(0) > 'H') || (Character.getNumericValue(pomocni.charAt(1)) < 1 || Character.getNumericValue(pomocni.charAt(1)) > 8))
            return false;
        //ako je neispravan format, tj ide nesto sto nije slovo, pa onda nesto sto nije broj, ili samo jedno od ovoga
        if(!(pomocni.charAt(0) >= 'A' && pomocni.charAt(0) <= 'Z') || !(Character.getNumericValue(pomocni.charAt(1)) >= 1 && Character.getNumericValue(pomocni.charAt(1)) <= 9))
            return false;

        return true;
    }

    public String getPosition() { return this.pozicija; }
    public void setPosition(String position) { this.pozicija = position; }
    public Color getColor() { return boja; }
    public abstract void move(String position);
}
