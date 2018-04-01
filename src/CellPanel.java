/**
 * Displays a cell and its contents.
 * @authors Emily Hageboeck Collin Sherman Mitchell Hornsby and Kelly Amar
 */

import javax.swing.*;
import java.awt.*;

public class CellPanel extends AbstractPanel{

	private Card card;
	
    public CellPanel(Cell c, ViewInformer vi){
    		super(c, vi);
    }
    
    public void paintComponent(Graphics g){
		Icon image;
		if (cell == null || cell.isEmpty()){
			image = Card.getBack();
			g.setColor(Color.black);
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = (getHeight() - image.getIconHeight()) / 2;
			g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
		}
		else{
			image = cell.topCard().getImage();
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = (getHeight() - image.getIconHeight()) / 2;
			image.paintIcon(this, g, x, y); 
		}
    }
    
    public void panelPressed(AbstractPanel panel){
		view.panelPressed(panel);
}
    
}

