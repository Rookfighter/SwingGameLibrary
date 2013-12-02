package game.view.controls;

import lib.control.IKeyAction;
import game.controller.IFieldOfVisionController;

public abstract class AFovKeyAction implements IKeyAction {
	
	private IFieldOfVisionController fovController;
	
	public void setFoVController(final IFieldOfVisionController p_fov)
	{
		fovController = p_fov;
	}
	
	protected IFieldOfVisionController getFoVController()
	{
		return fovController;
	}

}
