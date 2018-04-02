import java.util.ArrayList;
import javax.swing.*;

/**
 * The model of the War Game.
 * @author Emily Hageboeck
 * @author Kelly Amar
 * @author Mitch Hornsby
 * @author Collin Sherman
 */

public class WarGame extends Player{
	
	private Deck deck = new Deck();
	private Player player1 = new Player();
	private Player player2 = new Player();
	public Card player1Card;
	public Card player2Card;
	private ArrayList<Card> warPile = new ArrayList<Card>();
	public int moveCount;
	private Card deltCard1, deltCard2;
	
    /**
     * Constructor of WarGame.
     * Deals cards to each of the two players.
     */
	public WarGame(){
		newGame();
		
	}
	
	public void newGame()
	{
		deck = new Deck();
		deck.shuffle();
		player1 = new Player();
		player2 = new Player();
		while(!deck.isEmpty()){
			deltCard1 = deck.deal();
			deltCard1.turn();
			deltCard2 = deck.deal();
			deltCard2.turn();
			player1.addToUnplayedPile(deltCard1);
			player2.addToUnplayedPile(deltCard2);
		}

		moveCount = 0;
		
	}
	
    /**
     * Gets a card from each player and compares them.
     * If player 1 card is greater than player 2 card, add both cards to player 1's winnings pile.
     * If player 2 card is greater than player 1 card, add both cards to player 2's winnings pile.
     * If player 1 card is equal to player 2 card, add both cards to war pile.
     */
	public void move()
	{
		moveCount += 1;
		if(player1.cardsInUnplayedPile()){
			player1Card = player1.getCard();
			player2Card = player2.getCard();
			if (player1Card.compareTo(player2Card) <= -1){
				player2.addToWinningsPile(player1Card);
				player2.addToWinningsPile(player2Card);
				if(!warPile.isEmpty()){
					while(!warPile.isEmpty()){
						player2.addToWinningsPile(warPile.remove(0));
					}
				}
			}
			
			else if (player1Card.compareTo(player2Card) >= 1){
				player1.addToWinningsPile(player1Card);
				player1.addToWinningsPile(player2Card);
				if(!warPile.isEmpty()){
					while(!warPile.isEmpty()){
						player2.addToWinningsPile(warPile.remove(0));
					}
				}
			}
			
			else{
				warPile.add(player1Card);
				warPile.add(player2Card);
			}
		}
				
		
	}
	
	/**
	 * Returns a string of the player who won after comparing both player's length of winnings pile.
	 * @return String of the player who won.
	 */
	public String winner(){
		if(player1.lengthOfWinningsPile() > player2.lengthOfWinningsPile()) {
			return "Player 1 has won the Game";
		}
		
		else if(player1.lengthOfWinningsPile() < player2.lengthOfWinningsPile()) {
			return "Player 2 has won the Game";
		}
		
		else {
			return "Player 1 and Player 2 have tied.";
		}
	}
	
	public int getMoveCount()
	{
		return moveCount;
	}
	
    /**
     * Returns the string representation of the WarGame's current move.
     * @return the string representations of the WarGame's current move.
     */
	public String toString() {
		String player1Name = "Player 1";
		String player2Name = "Player 2";
		return player1Name + "\nCurrent Card: " + player1Card.toString() + "\nUnplayed Pile: " + player1.lengthOfUnplayedPile() + "\nWar Pile: " + warPile.size() + "\nWinnings Pile: " + player1.lengthOfWinningsPile() + "\n\n"+
				player2Name + "\nCurrent Card: " + player2Card.toString() + "\nUnplayed Pile: " + player2.lengthOfUnplayedPile() + "\nWar Pile: " + warPile.size() + "\nWinnigns Pile: " + player2.lengthOfWinningsPile() +
				"\n\nMove Count: " + moveCount + "\n";
	}
	
}
