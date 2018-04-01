import java.util.ArrayList;

/**
* @authors Emily Hageboek Colin Sherman Mitchell Hornsby and Kelly Amar
* Sets up the model and returns the string
*/

public class FreeCellModel{
	
	private ArrayList<Cell> homeCells;
	private ArrayList<Cell> freeCells;
	private ArrayList<Cell> tableaux;
	
	private Deck deck;
	
	public FreeCellModel(){
		homeCells = new ArrayList<Cell>();
		freeCells = new ArrayList<Cell>();
		tableaux = new ArrayList<Cell>();
		for(int i = 0; i<4; i++)
		{
			homeCells.add(new HomeCell());
			freeCells.add(new FreeCell());
		}
		for(int i = 0; i<8; i++)
		{
			tableaux.add(new Tableau());
		}
		newDeal();
	}
	
	public void newDeal()
	{
		deck = new Deck();
		deck.shuffle();
		Cell table;
		
		for(Cell cells: freeCells) {
			cells.clear();
		}
		for(Cell cells: homeCells) {
			cells.clear();
		}
		for(Cell cells: tableaux) {
			cells.clear();
		}
		
		for(int i = 0; i < 8; i++){
			for(int k = 0; k < 6; k++){
				Card newCard = deck.deal();
				tableaux.get(i).addCard(newCard);
			}
		}
		
		for(int i = 0; i < 4; i++){
			tableaux.get(i).addCard(deck.deal());
		}
	}
	
	public String toString() //for each tableau....homecell..and...freecell
	{
		String resultTab = "";
		for (int i = 1; i <= tableaux.size(); i++){
			resultTab += "Tableau " + i  + ": " + tableaux.get(i-1).toString() + "\n";
		}
		String resultFree = "";
		for (int i = 1; i <= freeCells.size(); i++)
		{
			resultFree += "FreeCell " + i  + ": " + freeCells.get(i-1).toString() + "\n";
		}		
		String resultHome = "";
		for (int i = 1; i <= homeCells.size(); i++)
		{
			resultHome += "HomeCell " + i  + ": " + homeCells.get(i-1).toString() + "\n";
		}
		
		return "Tableaus:\n" + resultTab + "\nFreeCells:\n" + resultFree + "\nHomeCells:\n" + resultHome;
	}
	
	
	public Cell getTableau(int i)
	{
		return tableaux.get(i);
	}

	public Cell getFreeCell(int i)
	{
		return freeCells.get(i);
	}
	
	public Cell getHomeCell(int i)
	{
		return homeCells.get(i);
	}
	
	public Card getTopCard(AbstractCell cell)
	{
		return cell.getCard(cell.size()-1);
	}
	
}
