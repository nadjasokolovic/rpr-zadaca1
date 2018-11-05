package ba.unsa.etf.rpr;

public class Bishop extends ChessPiece {
    public Bishop(String pozicija, Color boja) {
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

    @Override
    public void move(String position) {
        //pozicija van table
        String pomocni = new String(position);
        pomocni.toUpperCase();
        String pomocniThis = new String(this.getPosition());
        pomocniThis.toUpperCase();
        if(pomocni.charAt(0) < 'A' || pomocni.charAt(0) > 'H' || Character.getNumericValue(pomocni.charAt(1)) < 1 || Character.getNumericValue(pomocni.charAt(1)) > 8)
            throw new IllegalArgumentException("Pozicija je van table");
        //ako je neispravan format, tj ide nesto sto nije slovo, pa onda nesto sto nije broj, ili samo jedno od ovoga
        if(!(pomocni.charAt(0) >= 'A' && pomocni.charAt(0) <= 'Z') || !(Character.getNumericValue(pomocni.charAt(1)) >= 1 || Character.getNumericValue(pomocni.charAt(1)) <= 9))
            throw new IllegalArgumentException("Neispravan format pozicije");
        if(goreDole(pomocniThis, pomocni) || lijevoDesno(pomocniThis, pomocni))
            throw new IllegalArgumentException("Lovac ne ne moze kretati u ovom smjeru");

        this.pozicija = position;
    }
}
