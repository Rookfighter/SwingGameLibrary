package lib.control.classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import lib.control.IKeyAction;
import lib.control.IKeyControl;

public class KeyControl implements IKeyControl {

	private IKeyAction onKeyDown;
	private IKeyAction onKeyUp;
	private IKeyAction onKeyTyped;
	
	private KeyListener keyListener;
	
	public KeyControl()
	{
		keyListener = new KeyControlListener();
	}

	public void onKeyDown(final IKeyAction p_onKeyDown)
	{
		onKeyDown = p_onKeyDown;
	}

	public void onKeyUp(final IKeyAction p_onKeyUp)
	{
		onKeyUp = p_onKeyUp;
	}

	public void onKeyTyped(final IKeyAction p_onKeyTyped)
	{
		onKeyTyped = p_onKeyTyped;
	}

	public IKeyAction getOnDownAction()
	{
		return onKeyDown;
	}

	public IKeyAction getOnUpAction()
	{
		return onKeyUp;
	}

	public IKeyAction getOnTypedAction()
	{
		return onKeyTyped;
	}

	@Override
	public KeyListener getKeyListener()
	{
		return keyListener;
	}

	private class KeyControlListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent p_event)
		{
			if (onKeyDown != null)
				onKeyDown.process(p_event);
		}

		@Override
		public void keyReleased(KeyEvent p_event)
		{
			if (onKeyUp != null)
				onKeyUp.process(p_event);
		}

		@Override
		public void keyTyped(KeyEvent p_event)
		{
			if (onKeyTyped != null)
				onKeyTyped.process(p_event);
		}

	}

}
