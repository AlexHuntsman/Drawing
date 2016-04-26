package ctec.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import ctec.controller.Controller;


public class DrawingPanel extends JPanel
{
	private Controller baseController;
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	private JButton drawRectangleButton;
	
	
	
	public DrawingPanel(Controller baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		drawRectangleButton = new JButton("Rectangle");
		shapePanel = new ShapePanel();

		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(drawRectangleButton);
		this.add(shapePanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawRectangleButton, -26, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawRectangleButton, -169, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

				
				shapePanel.addTriangle();
				shapePanel.addSquare();	
				shapePanel.addCircle();		
				shapePanel.addEllipse();				
				shapePanel.addPolygon();			
				shapePanel.addRectangle();
				repaint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent moved)
	          { 
				shapePanel.addTriangle();
				shapePanel.addSquare();	
				shapePanel.addCircle();		
				shapePanel.addEllipse();				
				shapePanel.addPolygon();			
				shapePanel.addRectangle();
				repaint();
			
	          }

			public void mouseMoved(MouseEvent e) 
			{
				
				
			}
	        }); 

	  }
	
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.GREEN);
		mainGraphics.setStroke(new BasicStroke(10));
		mainGraphics.draw(new Rectangle(10,10,20,40));
		
		
	}
	
}


