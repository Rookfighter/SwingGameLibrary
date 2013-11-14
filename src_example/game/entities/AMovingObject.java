package game.entities;

import lib.utils.doubl.Vector2D;

public abstract class AMovingObject extends AGameObject implements IMovingObject {

	private Vector2D objectVector;
	
	public AMovingObject()
	{
		super();
		objectVector = new Vector2D();
	}
	
	@Override
	public Vector2D getVector()
	{
		return objectVector;
	}

	@Override
	public void setVector(Vector2D p_vector)
	{
		objectVector = p_vector;
	}

}
