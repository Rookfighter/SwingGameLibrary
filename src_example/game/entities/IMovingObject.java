package game.entities;

import lib.utils.doubl.Vector2D;

public interface IMovingObject extends IGameObject{

	Vector2D getVector();
	void setVector(final Vector2D p_vector);
}
