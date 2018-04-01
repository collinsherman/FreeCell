/**
* @authors Emily Hageboeck Colin Sherman Mitchell Hornsby and Kelly Amar
* moves the last card of a tableau pile to another tableau pile 
*/ 

import java.awt.List;
import java.util.ArrayList;

public class Tableau extends AbstractCell{
	private ArrayList<Card> movePile;
	
	public Tableau() {
		super(52);
	}


	public Card getCard(int i)
	{
		if(pile.size() != 0)
		{
			return pile.get(i);
		}
		else {
			throw new IllegalStateException("Cell is empty");
		}
	}
	
	//CanMove Method that works to move 1 card at a time
/*	public boolean canMove(Cell fromCell)
	{
		Card cardToMove = fromCell.topCard();
		if(this.isEmpty())
		{
			if(cardToMove.getRank() == 13)
			{
				return true;
			}
		}
		Card cardToMoveTo = this.topCard();
		if(oppositeSuit(cardToMoveTo, cardToMove) && rankOrder(cardToMoveTo, cardToMove))
		{
			return true;
		}
		return false;
	}*/
	
	public boolean canMove(Cell fromCell)
	{	
		movePile = new ArrayList<Card>();
		Card beforeCard = null;
		Card nextCard = null;
		if(fromCell.isEmpty() || fromCell instanceof HomeCell) {
			return false; 
		}
		Card moveTo = this.topCard();
		System.out.println(moveTo);
		for(int i = fromCell.size()-1; i > 0; i--)
		{
			beforeCard = fromCell.getCard(i);
			System.out.println(beforeCard);
			nextCard = fromCell.getCard(i-1);
			if(oppositeSuit(moveTo, beforeCard) && rankOrder(moveTo, beforeCard))
			{
				movePile.add(beforeCard);
				System.out.println(movePile);
				moveTo = beforeCard;//movePile.get(movePile.size()-1);
				System.out.println(moveTo);
				beforeCard = nextCard;
			}
			//break;
		}
		return true;
	}
	
	public boolean move(Cell fromCell)
	{
		int count = 0;
		if(canMove(fromCell))
		{
			//while (!movePile.isEmpty()) {
			for (int i = movePile.size()-1; i >= 0; i--) {
				addCard(movePile.remove(count));
				count++;
			}
			for(int i = 0; i < count; i++)
			{
				fromCell.remove();
			}
			movePile.clear();
			count = 0;
		
			return true;
		}
		return false;
}	
	private boolean oppositeSuit(Card topCard, Card moveCard)
	{
		ArrayList<Suit> red = new ArrayList();
		red.add(Suit.diamond);
		red.add(Suit.heart);
		ArrayList<Suit> black = new ArrayList();
		black.add(Suit.spade);
		black.add(Suit.club);
		if(red.contains(topCard.getSuit()) && black.contains(moveCard.getSuit()) || black.contains(topCard.getSuit()) && red.contains(moveCard.getSuit()))
		{
			return true;
		}
		return false;
	}

	private boolean rankOrder(Card topCard, Card moveCard)
	{
		int destinationRank = topCard.getRank();
		int moveCardRank = moveCard.getRank();
		if(destinationRank - moveCardRank == 1)
		{
			return true;
		}
		return false;
	}
	
	private boolean backwardsRank(Card topCard, Card moveCard)
	{
		int destinationRank = topCard.getRank();
		int moveCardRank = moveCard.getRank();
		if(destinationRank - moveCardRank == -1)
		{
			return true;
		}
		return false;
	}
	
	
	public boolean inSequence(Cell fromCell)
	{
		if (size() == 1 || isEmpty()) 
		{
			return true;
		}
			Card topCard = this.topCard();
			for (int i = size()-2; i > 0; i--) {
				Card nextCard = this.getCard(i);
				if (!(oppositeSuit(topCard, nextCard)) || !(rankOrder(topCard, nextCard))) 
				{
					return false;
				}
				topCard = nextCard;
			}
		return true;
	}
}