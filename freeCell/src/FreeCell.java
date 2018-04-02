/**
 * Adds a card to one of the Free Cells.
 * Removes card from Free Cell after moving.
 * @authors Emily Hageboeck Colin Sherman Mitchell Hornsby and Kelly Amar
 */ 

public class FreeCell extends AbstractCell{
	
	public FreeCell()
	{
		super(1);
	}
	public boolean canMove(Cell fromCell)
	{
		if(this.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}
}