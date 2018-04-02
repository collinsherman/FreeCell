/**
 * Abstract class for panels in AppView. 
 * @authors Emily Hageboeck Colin Sherman Mitchell Hornsby and Kelly Amar
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AbstractPanel extends JPanel{
 
    protected Cell cell;
    protected ViewInformer view;

    public AbstractPanel(Cell c, ViewInformer vi){
    		cell = c;
    		view = vi;
    		addMouseListener(new AbstractPanel.PanelListener(this));
    		
    }
    
    public Cell getCell()
    {
    		return cell;
    }
    
    public void paintComponent(Graphics g){
		super.paintComponent(g);
    }

    public void panelPressed(AbstractPanel panel){
    		view.panelPressed(panel);
    }
    
    private class PanelListener extends MouseAdapter
    {
    		private AbstractPanel absPanel;
    		public PanelListener(AbstractPanel ap)
    		{
    			absPanel = ap;
    		}
    		public void mousePressed(MouseEvent e) {
    			view.panelPressed(absPanel);
    		}
    }
		
}


