import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for dealing from a deck of cards.
 * @author Emily Hageboeck
 * @author Kelly Amar
 * @author Mitch Hornsby
 * @author Collin Sherman
 */

public class MainView extends JFrame{

    //private Deck deck;
    private WarGame warGame;

    //public MainView(Deck deck)
    public MainView(WarGame warGame)
    {
        //this.deck = deck;
        this.warGame = warGame;
        
        //Creates card panels, buttons, and labels
        CardPanel playerOnePanel = new CardPanel();
        CardPanel playerTwoPanel = new CardPanel();
        JTextArea gameStatsArea = new JTextArea(); 
        	gameStatsArea.setEditable(false);
        	gameStatsArea.setForeground(Color.white);
        	gameStatsArea.setBackground(Color.gray);
        JLabel playerOneLabel = new JLabel("Player 1", SwingConstants.CENTER);
        	playerOneLabel.setForeground(Color.white);
        JLabel playerTwoLabel = new JLabel("Player 2", SwingConstants.CENTER);
        	playerTwoLabel.setForeground(Color.white);
        JLabel gameLabel = new JLabel("Game Status", SwingConstants.CENTER);
        	gameLabel.setForeground(Color.white);
        JButton dealButton = new JButton("Move");
        JButton newButton = new JButton("New Game");
        
        //Creates nested panel for CENTER
        JPanel playerPanel = new JPanel(new GridLayout(1, 3));
        playerPanel.setBackground(Color.black);
        playerPanel.add(playerOnePanel);
        playerPanel.add(gameStatsArea);
        playerPanel.add(playerTwoPanel);
        
        //Creates nested panel for NORTH
        JPanel labelPanel = new JPanel(new GridLayout(1, 3));
        labelPanel.setBackground(Color.blue);
        labelPanel.add(playerOneLabel);
        labelPanel.add(gameLabel);
        labelPanel.add(playerTwoLabel);
        
        //Creates nested panel for SOUTH
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.blue);
        buttonPanel.add(dealButton);
        buttonPanel.add(newButton);
        
        /* Waits for user to click on deal button, then
         * calls WarGame's move method and changes the GUI.
         */
        dealButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(warGame.getMoveCount() == 26) {
            		String winMessage = warGame.winner();
            		JOptionPane.showMessageDialog(MainView.this, winMessage, "Game Over", JOptionPane.PLAIN_MESSAGE);
            	}
            	warGame.move();
            	gameStatsArea.setText(warGame.toString());
                playerOnePanel.setCard(warGame.player1Card);
                playerTwoPanel.setCard(warGame.player2Card); 
            }});
        
        /*Waits of the user to click on new game button, then 
         * calls WarGame's newGame method and changes the GUI.
         */
        newButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
        		warGame.newGame();
        		playerOnePanel.setCard(null);
        		playerTwoPanel.setCard(null);
        		gameStatsArea.setText("");
                }
            });
        
        Container c = getContentPane();
        c.add(playerPanel, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);
        c.add(labelPanel, BorderLayout.NORTH);
    }
}

