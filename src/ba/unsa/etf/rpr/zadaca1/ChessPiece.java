package ba.unsa.etf.rpr.zadaca1;

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
        String pomocni = pozicija.toUpperCase();
        if(!(pomocni.charAt(0) >= 'A' && pomocni.charAt(0) <= 'H') || !(Character.getNumericValue(pomocni.charAt(1)) >= 1 && Character.getNumericValue(pomocni.charAt(1)) <= 8))
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

    public String kojiJeSmjerKretanja(String odredisnaPozicija) {
        String s = "";
        int trenutnaBroj = Character.getNumericValue(this.getPosition().charAt(1));
        int odredisnaBroj = Character.getNumericValue(odredisnaPozicija.charAt(1));
        char trenutnaSlovo = this.getPosition().charAt(0);
        char odredisnaSlovo = odredisnaPozicija.charAt(0);
        if(trenutnaSlovo == odredisnaSlovo && trenutnaBroj < odredisnaBroj)
            s += "gore";
        else if(trenutnaSlovo == odredisnaSlovo && trenutnaBroj > odredisnaBroj)
            s += "dole";
        else if(trenutnaSlovo < odredisnaSlovo && trenutnaBroj < odredisnaBroj && (odredisnaSlovo - trenutnaSlovo) == (odredisnaBroj - trenutnaBroj))
            s += "dijagonalno gore desno";
        else if(trenutnaSlovo > odredisnaSlovo && trenutnaBroj < odredisnaBroj && (trenutnaSlovo - odredisnaSlovo) == (odredisnaBroj - trenutnaBroj))
            s += "dijagonalno gore lijevo";
        else if(trenutnaSlovo < odredisnaSlovo && trenutnaBroj > odredisnaBroj && (odredisnaSlovo - trenutnaSlovo) == (trenutnaBroj - odredisnaBroj))
            s += "dijagonalno dole desno";
        else if(trenutnaSlovo > odredisnaSlovo && trenutnaBroj > odredisnaBroj && (trenutnaSlovo - odredisnaSlovo) == (trenutnaBroj - odredisnaBroj))
            s += "dijagonalno dole lijevo";
        else if(trenutnaSlovo < odredisnaSlovo && trenutnaBroj == odredisnaBroj)
            s += "desno";
        else if(trenutnaSlovo > odredisnaSlovo && trenutnaBroj == odredisnaBroj)
            s += "lijevo";

        return s;
    }


    public String getPosition() { return this.pozicija; }

    public void setPosition(String position) {
        if(!provjeraIspravnostiPozicije(position))
            throw new IllegalArgumentException("Neispravna pozicija");
        this.pozicija = position;
    }

    public Color getColor() { return boja; }
    public abstract void move(String position);
}
