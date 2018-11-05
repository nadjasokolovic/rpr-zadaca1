package ba.unsa.etf.rpr;

public class Knight extends ChessPiece {
    public Knight(String pozicija, Color boja) {
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
        //neispravna pozicija za konja
        //1. kada skace gore
        if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) - 2)
            throw new IllegalArgumentException("Neispravna pozicija");
        else {
            if(pomocni.charAt(0) != pomocniThis.charAt(0) - 1 || pomocni.charAt(0) != pomocniThis.charAt(0) + 1)
                throw new IllegalArgumentException("Neispravna pozicija");
        }
        //2. kada skace dole
        if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 2)
            throw new IllegalArgumentException("Neispravna pozicija");
        else {
            if(pomocni.charAt(0) != pomocniThis.charAt(0) - 1 || pomocni.charAt(0) != pomocniThis.charAt(0) + 1)
                throw new IllegalArgumentException("Neispravna pozicija");
        }
        //3. kada skace lijevo
        if(pomocni.charAt(0) != pomocniThis.charAt(0) - 2)
            throw new IllegalArgumentException("Neispravna pozicija");
        else {
            if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 1 || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) - 1)
                throw new IllegalArgumentException("Neispravna pozicija");
        }
        //4. kada skace desno
        if(pomocni.charAt(0) != pomocniThis.charAt(0) + 2)
            throw new IllegalArgumentException("Neispravna pozicija");
        else {
            if(Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) + 1 || Character.getNumericValue(pomocni.charAt(1)) != Character.getNumericValue(pomocniThis.charAt(1)) - 1)
                throw new IllegalArgumentException("Neispravna pozicija");
        }

        this.pozicija = position;
    }

}
