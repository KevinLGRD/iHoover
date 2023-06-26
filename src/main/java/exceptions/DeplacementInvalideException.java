package exceptions;

public class DeplacementInvalideException extends Exception {
    public DeplacementInvalideException(){
        super("Le déplacement fait sortir de la grille");
    }
}
