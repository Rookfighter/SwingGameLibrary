package lib.control.classes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import lib.control.IMouseAction;
import lib.control.IMouseControl;

public class MouseControl implements IMouseControl{

	private IMouseAction onMouseEnter;
	private IMouseAction onMouseExit;
	private IMouseAction onMouseDown;
	private IMouseAction onMouseUp;
	private IMouseAction onMouseClick;
	
	//mousemotion
	private IMouseAction onMouseDrag;
	private IMouseAction onMouseMove;
	
	//mousewheel
	private IMouseAction onMouseWheelMove;
	
	private MouseMotionListener mouseMotionListener;
	private MouseListener mouseListener;
	private MouseWheelListener mouseWheelListener;
	
	public MouseControl()
	{
		mouseMotionListener = new MouseMotionControlListener();
		mouseListener = new MouseControlListener();
		mouseWheelListener = new MouseWheelControlListener();
	}
	
	public void onMouseEnter(final IMouseAction p_action)
	{
		onMouseEnter = p_action;
	}
	
	public void onMouseExit(final IMouseAction p_action)
	{
		onMouseExit = p_action;
	}
	
	public void onMouseDown(final IMouseAction p_action)
	{
		onMouseDown = p_action;
	}
	
	public void onMouseUp(final IMouseAction p_action)
	{
		onMouseUp = p_action;
	}
	
	public void onMouseClick(final IMouseAction p_action)
	{
		onMouseClick = p_action;
	}
	
	public void onMouseDrag(final IMouseAction p_action)
	{
		onMouseDrag = p_action;
	}
	
	public void onMouseMove(final IMouseAction p_action)
	{
		onMouseMove = p_action;
	}
	
	public void inMouseWheelMove(final IMouseAction p_action)
	{
		onMouseWheelMove = p_action;
	}
	
	public IMouseAction getOnEnter()
	{
		return onMouseEnter;
	}
	
	public IMouseAction getOnExit()
	{
		return onMouseExit;
	}
	
	public IMouseAction getOnDown()
	{
		return onMouseDown;
	}
	
	public IMouseAction getOnUp()
	{
		return onMouseUp;
	}
	
	public IMouseAction getOnClick()
	{
		return onMouseClick;
	}
	
	public IMouseAction getOnDrag()
	{
		return onMouseDrag;
	}
	
	public IMouseAction getOnMove()
	{
		return onMouseMove;
	}
	
	public IMouseAction getOnWheelMove()
	{
		return onMouseWheelMove;
	}
	
	@Override
	public MouseListener getMouseListener()
	{
		return mouseListener;
	}
	
	@Override
	public MouseMotionListener getMouseMotionListener()
	{
		return mouseMotionListener;
	}
	
	@Override
	public MouseWheelListener getMouseWheelListener()
	{
		return mouseWheelListener;
	}

	private class MouseControlListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent p_event)
		{
			if(onMouseClick != null)
				onMouseClick.process(p_event);
		}

		@Override
		public void mouseEntered(MouseEvent p_event)
		{
			if(onMouseEnter != null)
				onMouseEnter.process(p_event);
		}

		@Override
		public void mouseExited(MouseEvent p_event)
		{
			if(onMouseExit != null)
				onMouseExit.process(p_event);
		}

		@Override
		public void mousePressed(MouseEvent p_event)
		{
			if(onMouseDown != null)
				onMouseDown.process(p_event);
		}

		@Override
		public void mouseReleased(MouseEvent p_event)
		{
			if(onMouseUp != null)
				onMouseUp.process(p_event);
		}
	}
	
	private class MouseMotionControlListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent p_event)
		{
			if(onMouseDrag != null)
				onMouseDrag.process(p_event);
		}

		@Override
		public void mouseMoved(MouseEvent p_event)
		{
			if(onMouseMove != null)
				onMouseMove.process(p_event);
		}
		
	}
	
	private class MouseWheelControlListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent arg0)
		{
			
		}
		
	}
	
}
