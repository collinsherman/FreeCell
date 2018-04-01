/**
 * Creates and displays the Tableau Panels for the AppView.
 * @authors Emily Hageboeck Colin Sherman Mitchell Hornsby and Kelly Amar
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class TableauPanel extends AbstractPanel{
	
    public TableauPanel(Cell c, ViewInformer vi){
        super(c, vi);
    }
    
    public void paintComponent(Graphics g){ 
    		super.paintComponent(g);
		Icon image;
		if (cell == null || cell.isEmpty()){
			image = Card.getBack();
			g.setColor(Color.black);
			int x = (getWidth() - image.getIconWidth()) / 2;
			int y = (getHeight() - image.getIconHeight()) / 10;
			g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
		}
		else{
			for(int i = 0; i < cell.size(); i++)
			{
				image = cell.getCard(i).getImage();
				int x = (getWidth() - image.getIconWidth()) / 2;
				int y = (getHeight() - image.getIconHeight()) / 10  + (i*20);
				image.paintIcon(this, g, x, y);
			}
		}
    }
    
    public void panelPressed(TableauPanel panel){
		view.panelPressed(panel);
    }
    
}

