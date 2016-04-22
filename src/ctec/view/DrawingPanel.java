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
	private ArrayList<Rectangle> rectangleList;
	
	
	public DrawingPanel(Controller baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		drawRectangleButton = new JButton("Rectangle");
		baseLayout.putConstraint(SpringLayout.SOUTH, drawRectangleButton, -26, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, drawRectangleButton, -169, SpringLayout.EAST, this);
		rectangleList = new ArrayList<Rectangle>();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(drawRectangleButton);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * 800);
				int yPosition = (int)(Math.random() * 800);
				int width = (int)(Math.random() * 100);
				int height = (int)(Math.random() * 150);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				repaint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent moved)
	          { 
	        	  int xPosition = (int)(Math.random() * 800);
					int yPosition = (int)(Math.random() * 800);
					int width = (int)(Math.random() * 100);
					int height = (int)(Math.random() * 150);
					
					rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
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
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
	}
	
}


