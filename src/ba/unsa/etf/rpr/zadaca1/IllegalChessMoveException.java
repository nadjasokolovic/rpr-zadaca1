package ba.unsa.etf.rpr.zadaca1;

public class IllegalChessMoveException extends IllegalArgumentException {
    private String porukaIzuzetka;
    public IllegalChessMoveException(String s) {
        porukaIzuzetka = s;
    }
}
