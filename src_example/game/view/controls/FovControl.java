package game.view.controls;

import game.controller.IFieldOfVisionController;
import lib.control.classes.KeyControl;

public class FovControl extends KeyControl {

	public FovControl()
	{
		onKeyDown(new FovKeyDown());
		onKeyUp(new FovKeyUp());
	}
	
	public void setFovController(final IFieldOfVisionController p_fovController)
	{
		((AFovKeyAction)getOnDownAction()).setFoVController(p_fovController);
		((AFovKeyAction)getOnUpAction()).setFoVController(p_fovController);
	}

}
