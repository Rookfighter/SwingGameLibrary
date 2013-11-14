package game.entities;

import java.util.List;

import lib.utils.doubl.Dimension2DF;
import lib.utils.doubl.Rectangle2DF;

public interface IGameWorld {

	Dimension2DF getDimension();
	void setDimension(final Dimension2DF p_dimension);
	
	Rectangle2DF getRect();
	
	List<IGameObject> getObjectList();
	void setObjectList(final List<IGameObject> p_objectList);
	
	void addObject(final IGameObject p_gameObject);
	void removeObject(final IGameObject p_gameObject);
	void ClearObjectList();
}
