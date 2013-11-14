package game.controller.classes;

import java.util.LinkedList;
import java.util.List;

import lib.utils.doubl.Circle2DF;
import lib.utils.doubl.Position2DF;
import lib.utils.doubl.Rectangle2DF;
import game.controller.IObjectSearcher;
import game.entities.IGameObject;
import game.entities.IGameWorld;

public class SimpleObjectSearcher implements IObjectSearcher {

	private IGameWorld world;
	private List<IGameObject> objectList;
	private Circle2DF searchCircle;
	private Rectangle2DF searchRect;
	
	public SimpleObjectSearcher()
	{
		this(null);
	}
	
	public SimpleObjectSearcher(final IGameWorld p_world)
	{
		world = p_world;
	}

	@Override
	public void setWorld(IGameWorld p_world)
	{
		world = p_world;
	}

	@Override
	public List<IGameObject> getObjectsInRange(Circle2DF p_circle)
	{
		objectList = new LinkedList<IGameObject>();
		searchCircle = p_circle;
		searchInCircle();
		return objectList;
	}
	
	private void searchInCircle()
	{
		for(IGameObject gameObject : world.getObjectList())
			addIfInCircle(gameObject);
	}
	
	private void addIfInCircle(final IGameObject p_gameObject)
	{
		if( isInCircle(p_gameObject))
			objectList.add(p_gameObject);
	}
	
	private boolean isInCircle(final IGameObject p_gameObject)
	{
		Position2DF objPos = p_gameObject.getPosition();
		Position2DF circlePos = searchCircle.Mid();
		
		double distx = circlePos.X() - objPos.X();
		double disty = circlePos.Y() - objPos.Y();
		double distsq = distx * distx + disty * disty;
		
		return distsq <= (searchCircle.Radius() * searchCircle.Radius());
	}

	@Override
	public List<IGameObject> getObjectsInRect(Rectangle2DF p_rect)
	{
		objectList = new LinkedList<IGameObject>();
		searchRect = p_rect;
		searchInRect();
		return objectList;
	}
	
	private void searchInRect()
	{
		for(IGameObject gameObject : world.getObjectList())
			addIfInRect(gameObject);
	}
	
	private void addIfInRect(final IGameObject p_gameObject)
	{
		if(isInRect(p_gameObject))
			objectList.add(p_gameObject);
	}
	
	private boolean isInRect(final IGameObject p_gameObject)
	{
		Position2DF objPos = p_gameObject.getPosition();
		Position2DF rectPos = searchRect.getPosition();
		
		double diffx = Math.abs(rectPos.X() - objPos.X());
		double diffy = Math.abs(rectPos.Y() - objPos.Y());
		
		return ((diffx * 2) <= searchRect.getDimension().Width()) &&
			   ((diffy * 2) <= searchRect.getDimension().Height());
	}
}
