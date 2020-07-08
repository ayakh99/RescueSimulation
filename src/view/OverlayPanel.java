package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import model.units.UnitState;
import simulation.Simulatable;

public class OverlayPanel extends JPanel {

	private JPanel buttonsPanel;
	private JScrollPane scroll;
	
	public OverlayPanel() {
		this.setSize(new Dimension(300,130));
		//this.setPreferredSize(new Dimension(200,200));
		//Border outsideBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY);
		//Border insideBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		//this.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		this.setVisible(false);
		
		//this.setOpaque(false);
		constructButtonsPanel();
		//this.add(scroll);
		//this.add(buttonsPanel);
		this.validate();
		this.repaint();
	}
	
	private void constructButtonsPanel() {
		
		this.buttonsPanel = new JPanel();
		this.buttonsPanel.setLayout(new FlowLayout());
		scroll = new JScrollPane(buttonsPanel);
		scroll.setSize(new Dimension(300,130));
		//Border outsideBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
		//Border insideBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		//scroll.setBorder(insideBorder);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scroll);
	}
	
	public void addSubButtons(ArrayList<MapButton> arrayList) {
		for(MapButton b: arrayList) {
			buttonsPanel.add(b);
		}
	}
	
	/*public void addSubUnitButtons(ArrayList<UnitButton> arrayList, MapGridButton gridButton) {
		for(UnitButton b: arrayList) {
			if(b.getUnit().getState().equals(UnitState.IDLE) && b.getUnit().getLocation() == gridButton.getAddress())
				buttonsPanel.add(b);
		}
	}*/

	public boolean isOptimizedDrawingEnabled() {
		return false;
	}
	
	public JPanel getButtonsPanel() {
		return this.buttonsPanel;
	}
}