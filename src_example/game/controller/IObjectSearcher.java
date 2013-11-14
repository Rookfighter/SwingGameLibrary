package game.controller;

import java.util.List;

import lib.utils.doubl.Circle2DF;
import lib.utils.doubl.Rectangle2DF;
import game.entities.IGameObject;
import game.entities.IGameWorld;

public interface IObjectSearcher {

	void setWorld(final IGameWorld p_world);
	List<IGameObject> getObjectsInRange(final Circle2DF p_circle);
	List<IGameObject> getObjectsInRect(final Rectangle2DF p_rect);
}
