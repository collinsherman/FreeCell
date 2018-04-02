import java.util.ArrayList;
import javax.swing.*;

/**
 * Represents a player of a game.
 * @author Emily Hageboeck
 * @author Kelly Amar
 * @author Mitch Hornsby
 * @author Collin Sherman
 */

public class Player
{
	private ArrayList<Card> unplayedPile;
	private ArrayList<Card> playedPile;
	
	public Player()
	{
		unplayedPile = new ArrayList<Card>(0);
		playedPile = new ArrayList<Card>(0);
		
	}
	
    /**
     * Returns whether or not the pile is empty or not.
     * @return boolean if pile is or is not empty.
     */
	public boolean cardsInUnplayedPile(){
		if(!unplayedPile.isEmpty())
			return true;
		return false;
	}
	
    /**
     * Returns the last card in the unplayed pile.
     * @return card in unplayed pile.
     */
	public Card getCard(){
		return unplayedPile.remove(unplayedPile.size() - 1);
	}

    /**
     * Adds card to player's winnings pile.
     */
	public void addToWinningsPile(Card card) {
		playedPile.add(card);
	}
	
    /**
     * Returns the length of the winnings pile.
     * @return int of winnings pile size.
     */
	public int lengthOfWinningsPile(){
		return playedPile.size();
	}
	
    /**
     * Returns the length of the unplayed pile.
     * @return int of unplayed pile size.
     */
	public int lengthOfUnplayedPile(){
		return unplayedPile.size();
	}
	
    /**
     * Adds card to player's unplayed pile.
     */
	public void addToUnplayedPile(Card card) {
		unplayedPile.add(card);
		
	}
}
