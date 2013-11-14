package game.entities;

import lib.utils.doubl.Circle2DF;
import lib.utils.doubl.Position2DF;

public interface IGameObject {

	Position2DF getPosition();
	void setPosition(final Position2DF p_position);
	
	Circle2DF getArea();
	void setArea(final Circle2DF p_area);
}
