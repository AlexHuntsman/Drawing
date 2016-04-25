package ctec.view;

import javax.swing.JFrame;
import ctec.controller.Controller;

public class Frame extends JFrame
{	
	private Controller baseController;
	private DrawingPanel drawPanel;
	
	public Frame(Controller baseController)
	{
		this.baseController = baseController;
		drawPanel = new DrawingPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(drawPanel);
		this.setSize(800,800);
		this.setTitle("Drawing in Java");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public Controller getBaseController()
	{
		return baseController;
	}
}
