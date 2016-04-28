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
	private JButton drawCircleButton;
	private JButton drawTriangleButton;
	private JButton drawEllipseButton;
	private JButton drawSquareButton;
	private JButton drawPolygonButton;
	private JButton clearButton;
	
	
	
	public DrawingPanel(Controller baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		drawRectangleButton = new JButton("Rectangle");
		drawCircleButton = new JButton("Circle");
		drawSquareButton = new JButton("Square");
		drawPolygonButton = new JButton("Polygon");
		drawTriangleButton = new JButton("Triangle");
		shapePanel = new ShapePanel();
		drawEllipseButton = new JButton("Ellipse");
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 0, SpringLayout.NORTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawEllipseButton, 6, SpringLayout.EAST, drawPolygonButton);
		clearButton = new JButton("Clear");

		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(drawRectangleButton);
		this.add(drawCircleButton);
		this.add(drawSquareButton);
		this.add(drawPolygonButton);
		this.add(drawTriangleButton);
		this.add(drawEllipseButton);
		this.add(clearButton);
		this.add(shapePanel);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, drawTriangleButton, 0, SpringLayout.NORTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawPolygonButton, 85, SpringLayout.WEST, drawTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 70, SpringLayout.WEST, drawCircleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawCircleButton, 0, SpringLayout.NORTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawCircleButton, 175, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 0, SpringLayout.NORTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 81, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawSquareButton, 6, SpringLayout.SOUTH, shapePanel);
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 6, SpringLayout.SOUTH, shapePanel);
	}
	
	private void setupListeners()
	{
		clearButton.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
				repaint();
			}
		});
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			
				shapePanel.addRectangle();
				repaint();
			}
		});
		drawCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			
				shapePanel.addCircle();
				repaint();
			}
		});
		drawTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			
				shapePanel.addTriangle();
				repaint();
			}
		});
		drawSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			
				shapePanel.addSquare();
				repaint();
			}
		});
		drawEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			
				shapePanel.addEllipse();
				repaint();
			}
		});
		drawPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			
				shapePanel.addPolygon();
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


