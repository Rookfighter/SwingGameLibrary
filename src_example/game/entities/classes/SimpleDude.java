package game.entities.classes;

import lib.utils.doubl.Position2DF;
import game.entities.AMovingObject;
import game.entities.IDude;

public class SimpleDude extends AMovingObject implements IDude {

	private int lifePoints;
	private static final double maxSpeed = 5.0;
	
	public SimpleDude()
	{
		this(new Position2DF());
	}
	
	public SimpleDude(final Position2DF p_position)
	{
		super();
		lifePoints = 100;
		setPosition(p_position);
		getArea().setRadius(16.0);
	}
	
	@Override
	public int getLifePoints()
	{
		return lifePoints;
	}

	@Override
	public void setLifePoints(int p_lifePoints)
	{
		lifePoints = p_lifePoints;
	}

	@Override
	public void addToLifePoints(int p_lifePointsToAdd)
	{
		lifePoints += p_lifePointsToAdd;
	}

	@Override
	public void subFromLifePoints(int p_lifePointsToSub)
	{
		lifePoints -= p_lifePointsToSub;
	}

	@Override
	public double getMaxSpeed()
	{
		return maxSpeed;
	}
}
