package game.entities;

import lib.utils.doubl.Circle2DF;
import lib.utils.doubl.Position2DF;

public abstract class AGameObject implements IGameObject {

	private Circle2DF objectArea;
	
	public AGameObject()
	{
		objectArea = new Circle2DF();
	}
	
	@Override
	public Position2DF getPosition()
	{
		return objectArea.Mid();
	}

	@Override
	public void setPosition(Position2DF p_position)
	{
		objectArea.setMid(p_position);
	}

	@Override
	public Circle2DF getArea()
	{
		return objectArea;
	}

	@Override
	public void setArea(Circle2DF p_area) {
		objectArea = p_area;
	}

}
