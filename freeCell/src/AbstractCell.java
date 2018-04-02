import java.util.*;

/**
* @authors Emily Hageboeck Colin Sherman Mitchell Hornsby and Kelly Amar
*/

public abstract class AbstractCell implements Cell{

	//Lists - freecell, homecell, tableau - want as much overlap as possible
	protected List<Card> pile;
	protected int maxSize;
	
	protected AbstractCell(int size) {
		maxSize = size;
		pile = new ArrayList<Card>();
	}
	
	public void add(Cell cell) {
		this.add(cell);
	}
	
	public void addCard(Card card)
	{
		pile.add(card);
	}
	
	public Card getCard(int i)
	{
		if(pile.size() != 0) {
			return pile.get(i);
		}
		else {
			throw new IllegalStateException("Cell is empty");
		}
	}
	
	public Card remove() {
		if(pile.isEmpty())
		{
			throw new IllegalStateException("Cell is empty");
		}
		return pile.remove(pile.size()-1);
	}
	
	public boolean isEmpty(){
		if (pile.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean canMove(Cell fromCell)
	{
		if(this.size() != maxSize){
			if(!fromCell.isEmpty() && !(this instanceof HomeCell)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean move(Cell fromCell)
	{
		if(canMove(fromCell))
		{
			addCard(fromCell.remove());
			return true;
		}
		return false;
	}
	
	public Card topCard()
	{
		if(this.isEmpty()){
			throw new IllegalStateException("Cell is Empty.");
		}
			return this.getCard(pile.size()-1);
	}
	
	public Iterator<Card> iterator() {
		return pile.iterator();
	}
	
	public int size() {
		return pile.size();
	}
	
	public String toString() {
		String result = "";
		for(Card c: pile) {
			result += c.toString() + " , ";
		}
		return result;
	}
	
	public void clear()
	{
		pile.clear();
	}
	
}