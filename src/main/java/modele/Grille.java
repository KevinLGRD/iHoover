package modele;

import exceptions.DimensionInvalideException;

public class Grille {
    private final int x;
    private final int y;

    private Grille(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param x
     * @param y
     * @return : Une instance de la classe Grille
     * @throws DimensionInvalideException : Exception levée si les dimensions saisies ne sont pas strictement positives
     */
    public static Grille creer(int x, int y) throws DimensionInvalideException {
        if (x <= 0 || y <= 0) {
            throw new DimensionInvalideException();
        }
        return new Grille(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
