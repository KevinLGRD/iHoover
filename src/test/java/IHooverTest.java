import enums.Orientation;
import exceptions.CoordonneesInvalidesException;
import exceptions.DeplacementInvalideException;
import exceptions.DimensionInvalideException;
import modele.Aspirateur;
import modele.AspirateurImpl;
import modele.Grille;
import modele.Position;
import org.junit.Assert;
import org.junit.Test;

public class IHooverTest {

    @Test
    public void test_creer_grille_OK() throws DimensionInvalideException {
        Grille.creer(1,1);
    }
    @Test(expected = DimensionInvalideException.class)
    public void test_creer_grille_dim_nulle_KO() throws DimensionInvalideException {
        Grille.creer(0,0);
    }

    @Test
    public void test_creer_aspirateur_OK() throws DimensionInvalideException, CoordonneesInvalidesException {
        final Position startPosition = new Position(5,5, Orientation.N);
        final Grille grille = Grille.creer(10,10);
        AspirateurImpl.creer(grille, startPosition);
    }

    @Test(expected = CoordonneesInvalidesException.class)
    public void test_creer_aspirateur_position_inf_x_grille() throws DimensionInvalideException, CoordonneesInvalidesException {
        final Position startPosition = new Position(-5,5, Orientation.N);
        final Grille grille = Grille.creer(10,10);
        AspirateurImpl.creer(grille, startPosition);
    }

    @Test(expected = CoordonneesInvalidesException.class)
    public void test_creer_aspirateur_position_sup_x_grille() throws DimensionInvalideException, CoordonneesInvalidesException {
        final Position startPosition = new Position(15,5, Orientation.N);
        final Grille grille = Grille.creer(10,10);
        AspirateurImpl.creer(grille, startPosition);
    }

    @Test(expected = CoordonneesInvalidesException.class)
    public void test_creer_aspirateur_position_inf_y_grille() throws DimensionInvalideException, CoordonneesInvalidesException {
        final Position startPosition = new Position(5,-5, Orientation.N);
        final Grille grille = Grille.creer(10,10);
        AspirateurImpl.creer(grille, startPosition);
    }

    @Test(expected = CoordonneesInvalidesException.class)
    public void test_creer_aspirateur_position_sup_y_grille() throws DimensionInvalideException, CoordonneesInvalidesException {
        final Position startPosition = new Position(5,15, Orientation.N);
        final Grille grille = Grille.creer(10,10);
        AspirateurImpl.creer(grille, startPosition);
    }

    @Test
    public void test_lire_instructions_OK() throws DeplacementInvalideException, CoordonneesInvalidesException, DimensionInvalideException {

        final Position positionDepart = new Position(5,5, Orientation.N);
        final Position positionAttendue = new Position(5,6, Orientation.N);
        final Grille grille = Grille.creer(10,10);

        Aspirateur aspirateur = AspirateurImpl.creer(grille, positionDepart);
        String instructions = "DADADADAA";
        Position positionFinale = aspirateur.lireInstructions(instructions);

        Assert.assertEquals(positionFinale.getOrientation(), positionAttendue.getOrientation());
        Assert.assertEquals(positionFinale.getX(), positionAttendue.getX());
        Assert.assertEquals(positionFinale.getY(), positionAttendue.getY());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_lire_instructions_invalides_KO() throws DeplacementInvalideException, DimensionInvalideException, CoordonneesInvalidesException {
        final Position startPosition = new Position(5,5, Orientation.N);
        final Grille grille = Grille.creer(10,10);
        Aspirateur aspirateur = AspirateurImpl.creer(grille, startPosition);
        String instructions = "S";
        aspirateur.lireInstructions(instructions);
    }

    @Test(expected = DeplacementInvalideException.class)
    public void test_lire_instructions_deplacement_vers_x_inf_x_grille() throws DeplacementInvalideException, CoordonneesInvalidesException, DimensionInvalideException {
        final Position startPosition = new Position(0,0, Orientation.W);
        final Grille grille = Grille.creer(10,10);
        Aspirateur aspirateur = AspirateurImpl.creer(grille, startPosition);
        String instructions = "A";
        aspirateur.lireInstructions(instructions);
    }

    @Test(expected = DeplacementInvalideException.class)
    public void test_lire_instructions_deplacement_vers_x_sup_x_grille() throws DeplacementInvalideException, CoordonneesInvalidesException, DimensionInvalideException {
        final Position startPosition = new Position(10,0, Orientation.E);
        final Grille grille = Grille.creer(10,10);
        Aspirateur aspirateur = AspirateurImpl.creer(grille, startPosition);
        String instructions = "A";
        aspirateur.lireInstructions(instructions);
    }

    @Test(expected = DeplacementInvalideException.class)
    public void test_lire_instructions_deplacement_vers_y_inf_y_grille() throws DeplacementInvalideException, CoordonneesInvalidesException, DimensionInvalideException {
        final Position startPosition = new Position(0,0, Orientation.S);
        final Grille grille = Grille.creer(10,10);
        Aspirateur aspirateur = AspirateurImpl.creer(grille, startPosition);
        String instructions = "A";
        aspirateur.lireInstructions(instructions);
    }

    @Test(expected = DeplacementInvalideException.class)
    public void test_lire_instructions_deplacement_vers_y_sup_y_grille() throws DimensionInvalideException, CoordonneesInvalidesException, DeplacementInvalideException {
        final Position startPosition = new Position(0,10, Orientation.N);
        final Grille grille = Grille.creer(10,10);
        Aspirateur aspirateur = AspirateurImpl.creer(grille, startPosition);
        String instructions = "A";
        aspirateur.lireInstructions(instructions);
    }

}
