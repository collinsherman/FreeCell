import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @author lambertk (edited by Emily Hageboeck, Kelly Amar, Mitch Hornsby, and Collin Sherman)
 *
 */
public class GUIApp{

    public static void main(String[] args){
        final WarGame warGame = new WarGame();
        final JFrame view = new MainView(warGame);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(600, 300);
        view.setVisible(true);
    }
}