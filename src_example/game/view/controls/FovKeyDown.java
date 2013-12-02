package game.view.controls;


import java.awt.event.KeyEvent;

import lib.utils.doubl.Vector2D;

public class FovKeyDown extends AFovKeyAction {

	private Vector2D right;
	private Vector2D left;
	private Vector2D up;
	private Vector2D down;
	
	public FovKeyDown()
	{
		right = new Vector2D(0.0,5.0);
		left = new Vector2D(0.0,-5.0);
		up = new Vector2D(-5.0,0.0);
		down = new Vector2D(5.0,0.0);
	}
	
	@Override
	public void process(KeyEvent p_event)
	{
		switch(p_event.getKeyCode())
		{
			case KeyEvent.VK_RIGHT:
				keyRight();
				break;
			case KeyEvent.VK_LEFT:
				keyLeft();
				break;
			case KeyEvent.VK_UP:
				keyUp();
				break;
			case KeyEvent.VK_DOWN:
				keyDown();
				break;
		}
	}
	
	private void keyRight()
	{
		getFoVController().addVector(right);
	}
	
	private void keyLeft()
	{
		getFoVController().addVector(left);
	}
	
	private void keyUp()
	{
		getFoVController().addVector(up);
	}
	
	private void keyDown()
	{
		getFoVController().addVector(down);
	}

}
