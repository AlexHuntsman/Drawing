package ctec.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import ctec.controller.Controller;

public class ShapePanel extends JPanel
{
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Polygon> polygonList;
	private ArrayList<Polygon> triangleList;
	
	
	
	public ShapePanel()
	{
		
		rectangleList = new ArrayList<Rectangle>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
		squareList = new ArrayList<Rectangle>();
		polygonList = new ArrayList<Polygon>();
		triangleList = new ArrayList<Polygon>();
		
	}
	
	public void addEllipse()
	{
		int xPoint = (int)(Math.random() * 1000);
		int yPoint = (int)(Math.random() * 1000);
		int height = (int)(Math.random() * 100);
		int width = (int)(Math.random() * 100);
		
		Ellipse2D ellipse = new Ellipse2D.Double(xPoint, yPoint, height, width);
		ellipseList.add(ellipse);
		
	}
	
	public void addCircle()
	{
		int xPoint = (int)(Math.random() * 1000);
		int yPoint = (int)(Math.random() * 1000);
		int diameter = (int)(Math.random() * 100);
		
		Ellipse2D circle = new Ellipse2D.Double(xPoint, yPoint, diameter, diameter);
		circleList.add(circle);
		
	}
	
	public void addPolygon()
	{
		int numberOfSides =(int)(Math.random() * 10) + 3;
		int [] xPoints = new int [numberOfSides];
		int [] yPoints = new int [numberOfSides];
		
		for (int sides = 0; sides < numberOfSides; sides++)
		{
			xPoints[sides] = (int)(Math.random() * 1000);
			yPoints[sides] = (int)(Math.random() * 1000);
		}
		
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
		repaint();
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int [3];
		int [] yPoints = new int [3];
		xPoints[0] = (int)(Math.random() * 1000);
		
		xPoints = new int []{(int)(Math.random() * 800), (int)(Math.random() * 800), (int)(Math.random() * 800)};
		yPoints = new int []{(int)(Math.random() * 800), (int)(Math.random() * 800), (int)(Math.random() * 800)};
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		
		triangleList.add(triangle);
		repaint();
	}
	
	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * 800);
		int yPosition = (int)(Math.random() * 800);
		int width = (int)(Math.random() * 100);
		int height = (int)(Math.random() * 150);
		
		rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
		repaint();
	}
	
	public void addSquare()
	{
		int xPosition = (int)(Math.random() * 800);
		int yPosition = (int)(Math.random() * 800);
		int sideLength = (int)(Math.random() * 100);
		
		
		rectangleList.add(new Rectangle(xPosition, yPosition, sideLength, sideLength));
		repaint();
	}
	
	public void clear()
	{
		triangleList.clear();
		squareList.clear();
		rectangleList.clear();
		polygonList.clear();
		circleList.clear();
		ellipseList.clear();
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		
		for(Polygon triangle : triangleList)
		{
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			
			int pencilSize = (int)(Math.random() * 15);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(triangle);
		}
		
		for(Ellipse2D ellipse : ellipseList)
		{
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			
			int pencilSize = (int)(Math.random() * 15);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(ellipse);
		}
		
		for(Ellipse2D ellipse : circleList)
		{
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			
			int pencilSize = (int)(Math.random() * 15);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(ellipse);
		}
		
		for(Polygon polygon : polygonList)
		{
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			
			int pencilSize = (int)(Math.random() * 15);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			mainGraphics.draw(polygon);
		}
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 15);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.draw(current);
		}
		
		for(Rectangle current : squareList)
		{
			int randomStroke = (int)(Math.random() * 15);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.draw(current);
		}
		
	}
}
