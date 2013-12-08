package game.controller;

import java.util.List;

import lib.utils.doubl.Dimension2DF;
import lib.utils.doubl.Vector2D;
import game.entities.IFieldOfVision;
import game.entities.IGameObject;
import game.entities.IGameWorld;

public interface IFieldOfVisionController extends IController{

	IFieldOfVision getFieldOfVision();
	void setFieldOfVision(final IFieldOfVision p_fov);
	
	IGameWorld getWorld();
	void setGameWorld(final IGameWorld p_world);
	
	void setInFovBuffer(final Dimension2DF p_buffer);
	Dimension2DF getInFovBuffer();
	
	List<IGameObject> getObjectsInFoV();
	List<IGameObject> getObjectsInFoVBuffer();
	
	void addVector(final Vector2D p_vector);
}
