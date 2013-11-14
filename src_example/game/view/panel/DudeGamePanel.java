package game.view.panel;

import game.controller.IFieldOfVisionController;
import lib.graphics.panel.GamePanel;

public class DudeGamePanel extends GamePanel {

	private static final long serialVersionUID = -9214779472957323616L;

	public DudeGamePanel(final IFieldOfVisionController p_fov)
	{
		super();
		setDrawListGenerator(new GameDrawListGenerator(p_fov));
	}

}
