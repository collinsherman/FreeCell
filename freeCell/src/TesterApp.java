/**
 * Terminal test for WarGame 
 * @author Emily Hageboeck
 * @author Kelly Amar
 * @author Mitch Hornsby
 * @author Collin Sherman
 */
import java.util.*;
public class TesterApp{

	public static void main(String[] args){
	//test move
		WarGame warGame = new WarGame();
		int moveCount = 0;
		while (!(moveCount == 26)) {
			warGame.move();
			moveCount += 1;
			System.out.println(warGame);
		}
		System.out.println("The winner is: " + warGame.winner());
	
	}
}
