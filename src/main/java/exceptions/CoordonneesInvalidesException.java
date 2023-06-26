package exceptions;

public class CoordonneesInvalidesException extends Exception {
    public CoordonneesInvalidesException(){
        super("Les coordonnées ne sont pas dans la grille");
    }
}
