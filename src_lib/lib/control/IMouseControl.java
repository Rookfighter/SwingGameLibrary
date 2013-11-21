package lib.control;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public interface IMouseControl {

	MouseListener getMouseListener();
	MouseMotionListener getMouseMotionListener();
	MouseWheelListener getMouseWheelListener();
}
