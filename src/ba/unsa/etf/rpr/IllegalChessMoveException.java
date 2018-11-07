package ba.unsa.etf.rpr;

public class IllegalChessMoveException extends IllegalArgumentException {
    private String porukaIzuzetka;
    public IllegalChessMoveException(String s) {
        porukaIzuzetka = s;
    }
}
