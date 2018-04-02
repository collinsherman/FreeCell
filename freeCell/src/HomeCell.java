/**
* @authors Emily Hageboek Colin Sherman Mitchel Hornsby and Kelly Amar
* @adds card to foundation pile
*/ 

public class HomeCell extends AbstractCell{
	
	public HomeCell()
	{
		super(13);
	}
	
	public void add(Card card){
		
		if(pile.isEmpty()) {
			if(card.getRank() == 1) {
				pile.add(card);
			}
			else {
				System.out.print("Illegal Move");
			}
		}
		else {
			if((card.getSuit() != this.topCard().getSuit()) || (this.topCard().getRank() + 1 != card.getRank())) {
				System.out.printf("Illegal Move.");
			}
			else 
				pile.add(card);
		}
	}
	
	public Card remove() {
		throw new IllegalStateException("Cannot remove card from Home Cell.");
	}
	
	public boolean canMove(Cell fromCell)
	{
		if(isEmpty()){
			if(fromCell.topCard().getRank() == 1) {
				return true;
			}
		}
		else if(this.topCard().getSuit() == fromCell.topCard().getSuit()){
			if((this.topCard().getRank() - fromCell.topCard().getRank()) == -1){
				return true;
			}
		}
		else if(fromCell instanceof HomeCell){
			return false;
		}
		return false;
	}
}