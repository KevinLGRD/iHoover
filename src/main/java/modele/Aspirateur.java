package modele;

import exceptions.DeplacementInvalideException;

public interface Aspirateur {
    /**
     * @param instructions : Instructions transmises à l'aspirateur sous forme de chaine de caractères
     * @return : La position de l'aspirateur après avoir appliqué les instructions
     * @throws DeplacementInvalideException : Exception levée lorsque l'aspirateur sort de la grille
     */
    Position lireInstructions(String instructions) throws DeplacementInvalideException;

    /**
     * @throws DeplacementInvalideException : Exception levée si l'instruction avancer fait sortir l'aspirateur
     */
    void avancer() throws DeplacementInvalideException;

    void rotationGauche();

    void rotationDroite();
}
