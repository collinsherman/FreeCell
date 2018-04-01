import javax.swing.JFrame;

/**
 * Generic main method template for any GUI-based application.
 * Instantiates a model and passes it to a new view.
 * @authors Emily Hageboeck, Kelly Amar, Collin Sherman, Mitch Hornsby
 *
 */
public class FreeCellApp{

    public static void main(String[] args){ 
        final FreeCellModel freeCellGame = new FreeCellModel();
        final JFrame view = new AppView(freeCellGame);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(800, 800);
        view.setVisible(true);
        
    }
}