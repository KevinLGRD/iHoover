package modele;

import enums.Deplacement;
import enums.Orientation;
import exceptions.CoordonneesInvalidesException;
import exceptions.DeplacementInvalideException;


public class AspirateurImpl implements Aspirateur {
    private final Position position;
    private final Grille grille;

    private AspirateurImpl(Grille grille, Position position) {
        this.grille = grille;
        this.position = position;
    }

    /**
     * @param grille : Grille sur laquelle sera positionné l'aspirateur
     * @param position : Coordonnées x et y et l'orientation de l'aspirateur
     * @return : Une instance de la classe AspirateurImpl
     * @throws CoordonneesInvalidesException : Exception levée si la position de départ n'est pas dans la grille
     */
    public static Aspirateur creer(Grille grille, Position position) throws CoordonneesInvalidesException {
        if (0 <= position.getX() && position.getX() <= grille.getX() && 0 <= position.getY() && position.getY() <= grille.getY()) {
            return new AspirateurImpl(grille, position);
        }
        throw new CoordonneesInvalidesException();
    }
    @Override
    public Position lireInstructions(String instructions) throws DeplacementInvalideException {
        for (String instruction : instructions.split("")) {
            switch (Deplacement.instructionVersDeplacement(instruction)) {
                case GAUCHE -> {
                    rotationGauche();
                }
                case DROITE -> {
                    rotationDroite();
                }
                case AVANCER -> {
                    avancer();
                }
            }
        }
        return position;
    }
    @Override
    public void avancer() throws DeplacementInvalideException {
        if (position.getOrientation() == Orientation.N && position.getY() < grille.getY()) {
            position.setY(position.getY() + 1);
        } else if (position.getOrientation() == Orientation.S && position.getY() > 0) {
            position.setY(position.getY() - 1);
        } else if (position.getOrientation() == Orientation.E && position.getX() < grille.getX()) {
            position.setX(position.getX() + 1);
        } else if (position.getOrientation() == Orientation.W && position.getX() > 0) {
            position.setX(position.getX() - 1);
        } else {
            throw new DeplacementInvalideException();
        }
    }
    @Override
    public void rotationGauche() {
        if (position.getOrientation() == Orientation.N) {
            position.setOrientation(Orientation.W);
        } else if (position.getOrientation() == Orientation.S) {
            position.setOrientation(Orientation.E);
        } else if (position.getOrientation() == Orientation.E) {
            position.setOrientation(Orientation.N);
        } else if (position.getOrientation() == Orientation.W) {
            position.setOrientation(Orientation.S);
        }
    }
    @Override
    public void rotationDroite() {
        if (position.getOrientation() == Orientation.N) {
            position.setOrientation(Orientation.E);
        } else if (position.getOrientation() == Orientation.S) {
            position.setOrientation(Orientation.W);
        } else if (position.getOrientation() == Orientation.E) {
            position.setOrientation(Orientation.S);
        } else if (position.getOrientation() == Orientation.W) {
            position.setOrientation(Orientation.N);
        }
    }

    public Position getPosition() {
        return position;
    }
}
