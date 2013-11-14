package game.entities;

public interface IDude extends IMovingObject {

	int getLifePoints();
	void setLifePoints(final int p_lifePoints);
	void addToLifePoints(final int p_lifePointsToAdd);
	void subFromLifePoints(final int p_lifePointsToSub);
	double getMaxSpeed();
}
