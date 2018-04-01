import javax.swing.*; 
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.font.*;



/**
 * The main window for dealing FreeCell.
 * @authors Emily Hageboeck Kelly Amar, Mitch Hornsby, Collin Sherman
 */

public class AppView extends JFrame{
    private FreeCellModel freeCell;
    private AbstractPanel fromPanel, selectedPanel;
    ViewInformer view;
	
	public AppView(FreeCellModel freeCell) {
		this.freeCell = freeCell;
        fromPanel = null;
        selectedPanel = null;
        view = new AppView.AppViewInformer();
        Color colorBlue = new Color(106, 184, 229);
        Color cream = new Color(255,248,220);
		
			GridBagLayout gridbag = new GridBagLayout();
			JPanel gamePanel = new JPanel(gridbag);
			GridBagConstraints c = new GridBagConstraints();
			
			ArrayList<String> letters = new ArrayList<String>();
			letters.addAll(Arrays.asList("F", "R", "E", "E", "C", "E", "L", "L"));
			Font cellFont = new Font("Times New Roman", Font.PLAIN, 42);
			Font labelFont = new Font("Times New Roman", Font.ITALIC, 24);
			Font buttonFont = new Font("Times New Roman", Font.PLAIN, 14);
			
			ArrayList<TableauPanel> tableaux = new ArrayList<TableauPanel>();

			for(int i = 0; i < 4; i++) {
				CellPanel fCell = new CellPanel(freeCell.getFreeCell(i), view);
				JLabel letterLabel = new JLabel(letters.get(i));
				letterLabel.setBackground(colorBlue);
				letterLabel.setForeground(Color.black);
				letterLabel.setFont(cellFont);
				c.gridx = i;
				c.gridy = 0;
				c.weighty = 1;
				c.weightx = 1;
				c.fill = GridBagConstraints.BOTH;
				gridbag.setConstraints(fCell, c);
				gamePanel.add(letterLabel);
				gamePanel.add(fCell);
				}
			for(int i = 0; i < 4; i++) {
				CellPanel hCell = new CellPanel(freeCell.getHomeCell(i), view);
				JLabel letterLabel = new JLabel(letters.get(i + 4));
				letterLabel.setBackground(colorBlue);
				letterLabel.setForeground(Color.black);
				letterLabel.setFont(cellFont);
				hCell.setOpaque(true);
				c.gridx = 4 + i;
				c.gridy = 0;
				c.weighty = 1;
				c.weightx = 1;
				c.fill = GridBagConstraints.BOTH;
				gridbag.setConstraints(hCell, c);
				gamePanel.add(letterLabel);
				gamePanel.add(hCell);}
			for(int i = 0; i < 8; i++) {
				TableauPanel tableauPanel = new TableauPanel(freeCell.getTableau(i), view);
				tableaux.add(tableauPanel);
				c.gridx = i;
				c.gridy = 1;
				c.weighty = 3;
				c.weightx = 1;
				c.fill = GridBagConstraints.BOTH;
				tableauPanel.setBackground(Color.black);
				gridbag.setConstraints(tableauPanel, c);
        		gamePanel.add(tableauPanel);}
			
			JPanel titlePanel = new JPanel(new GridLayout(1, 2));
			
			JLabel freeCellLabel = new JLabel("Freecells");
			freeCellLabel.setOpaque(true);
			freeCellLabel.setBackground(Color.black);
			freeCellLabel.setForeground(Color.white);
			freeCellLabel.setHorizontalAlignment(0);
			freeCellLabel.setFont(labelFont);
			titlePanel.add(freeCellLabel);
			
			JLabel homeCellLabel = new JLabel("Homecells");
			homeCellLabel.setOpaque(true);
			homeCellLabel.setBackground(Color.black);
			homeCellLabel.setForeground(Color.white);
			homeCellLabel.setHorizontalAlignment(0);
			homeCellLabel.setFont(labelFont);
			titlePanel.add(homeCellLabel);
			
	        JButton newDealButton = new JButton("New Game");
		        JPanel buttonPanel = new JPanel(new FlowLayout());
		        newDealButton.setBackground(cream);
		        newDealButton.setForeground(Color.black);
		        newDealButton.setFont(buttonFont);
		        newDealButton.setFocusPainted(false);
		        buttonPanel.add(newDealButton);
		        buttonPanel.setBackground(Color.black);
				
				Container pane = getContentPane();
				pane.add(titlePanel, BorderLayout.NORTH);
				pane.add(gamePanel, BorderLayout.CENTER);
				pane.add(buttonPanel, BorderLayout.SOUTH);
				gamePanel.setBackground(cream);
				
		      newDealButton.addActionListener(new ActionListener(){
		          public void actionPerformed(ActionEvent e){
		            		freeCell.newDeal();
		            		repaint();
		            		for(TableauPanel t: tableaux) {
		            			t.setBackground(Color.black);
		            		}
		            }
		        });
		        

			}
	
	public Color randomColor()
	{
		Random rand = new Random();
		int r = rand.nextInt(255) + 1;
		int g = rand.nextInt(255) + 1;
		int b = rand.nextInt(255) + 1;
		Color randomColor = new Color(r, g, b);
		return randomColor;
	}

    private class AppViewInformer implements ViewInformer
    {
    		private AppViewInformer() {}
    		
		public void panelPressed(AbstractPanel panel) {
			if (freeCell.getHomeCell(1).size() == 13 && freeCell.getHomeCell(2).size() == 13 && freeCell.getHomeCell(3).size() == 13 && freeCell.getHomeCell(4).size() == 13)			
			{
				javax.swing.JOptionPane.showMessageDialog(AppView.this, "You Won, You're not Dumb.", "YOU WON!", JOptionPane.PLAIN_MESSAGE);
			}
			
			else if (selectedPanel == null)
			{
				selectedPanel = panel;
			}
			
			else if(panel == selectedPanel)
			{
				selectedPanel = null;
			}
			
			else
			{
				if(panel.getCell().move(selectedPanel.getCell()))
					
				{
					selectedPanel.setBackground(randomColor());
					panel.setBackground(new Color(255,248,220));
					selectedPanel.repaint();
					panel.repaint();
					selectedPanel = null;
				}
				else
				{
					javax.swing.JOptionPane.showMessageDialog(AppView.this, "Illegal Move.", "Error", JOptionPane.PLAIN_MESSAGE);
					selectedPanel = null;
				}
					

			}
		}
		private Color randomColor()
		{
			Random rand = new Random();
			int r = rand.nextInt(255) + 1;
			int g = rand.nextInt(255) + 1;
			int b = rand.nextInt(255) + 1;
			Color randomColor = new Color(r, g, b);
			return randomColor;
			
		}
    		
    }
}