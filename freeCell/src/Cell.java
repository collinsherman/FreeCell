import java.util.*;

/**
* Set up the cell interface for the different piles
*@authors Emily Hageboeck Colin Sherman Mitchell Hornsby and Kelly Amar
*  
*/ 

public interface Cell extends Iterable<Card>{
	/**
	 * Adds a card to a pile
	 * @param cell that is added to the Free Cell, Homase Cell, or other Tableau
	 */
	public void add(Cell cell);
	
	public void addCard(Card card);
	
	/**
	 * Determines if a list has any objects in it
	 * @param list to determine its length
	 * @return true or false if the list is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Determines if you can move a Cell
	 * @param fromCell to determine if the cell can be moved to another cell
	 * @return a boolean if fromCell can move
	 */
	public boolean canMove(Cell fromCell);

	/**
	 * Removes a card from the cell.
	 * @return the card that is removed
	 */
	public Card remove();
	
	/**
	 * Returns the size of the cell
	 * @return the size of the cell
	 */
	public int size();

	/**
	 * Returns the card that is on top of the cell, to access card's attributes.
	 * @return card that is on top of the cell
	 */
	public Card getCard(int i);
	
	/**
	 * Clears the Model and resets it to its original state
	 */
	public void clear();
	
	/**
	 * Returns the card that is on top of the cell
	 * @return the card on top of the cell
	 */
	public Card topCard();
	
	/**
	 * Returns a boolean if card can be moved.
	 * @param fromCell can move the card to the cell
	 * @return a boolean if cards can move
	 */
	public boolean move(Cell fromCell);
	
}
