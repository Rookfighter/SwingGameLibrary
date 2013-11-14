package game.entities.classes;

import game.entities.IGameObject;
import game.entities.IGameWorld;

import java.util.LinkedList;
import java.util.List;

import lib.utils.doubl.Dimension2DF;
import lib.utils.doubl.Rectangle2DF;

public class SimpleWorld implements IGameWorld {

	private Rectangle2DF worldRect;
	private List<IGameObject> objectList;
	
	public SimpleWorld() 
	{
		this(new Dimension2DF(1000,1000));
	}
	
	public SimpleWorld(final Dimension2DF p_dimension)
	{
		worldRect = new Rectangle2DF();
		setDimension(p_dimension);
		objectList = new LinkedList<IGameObject>();
	}
	
	@Override
	public Dimension2DF getDimension()
	{
		return worldRect.getDimension();
	}

	@Override
	public void setDimension(Dimension2DF p_dimension)
	{
		worldRect.setDimension(p_dimension); 
		worldRect.getPosition().set(p_dimension.Width() / 2, p_dimension.Height() / 2);
	}

	@Override
	public List<IGameObject> getObjectList()
	{
		return objectList;
	}

	@Override
	public void setObjectList(List<IGameObject> p_objectList)
	{
		objectList.clear();
		objectList.addAll(p_objectList);
	}

	@Override
	public void addObject(IGameObject p_gameObject)
	{
		objectList.add(p_gameObject);
	}

	@Override
	public void removeObject(IGameObject p_gameObject)
	{
		objectList.remove(p_gameObject);
	}

	@Override
	public void ClearObjectList()
	{
		objectList.clear();
	}

	@Override
	public Rectangle2DF getRect()
	{
		return worldRect;
	}

}
