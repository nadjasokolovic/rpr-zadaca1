package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public Pawn(String pozicija, Color boja) {
        super(pozicija, boja);
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
        //neispravna pozicija za pijuna
        //zanemaruju se ostale figure, znaci on ne moze ici ni dijagonalno?
        if(pomocni.charAt(0) != pomocniThis.charAt(0) || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 1)
            throw new IllegalChessMoveException("Neispravna pozicija za pijuna");
        //provjeriti sta za prvi potez
        this.pozicija = position;
    }
}
