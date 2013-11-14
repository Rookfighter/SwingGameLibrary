package game.controller.classes;

import java.util.Random;

import lib.utils.SimpleCollisionDetector;
import lib.utils.doubl.Vector2D;
import game.controller.IObjectController;
import game.entities.IGameObject;
import game.entities.IGameWorld;
import game.entities.classes.SimpleDude;

public class SimpleDudeController implements IObjectController {

	private final int maxCount = 20;
	private int count;
	private SimpleDude dude;
	private IGameWorld world;
	private Random random;
	
	public SimpleDudeController()
	{
		this(null, null);
	}
	
	public SimpleDudeController(SimpleDude p_dude, IGameWorld p_gameWorld)
	{		
		setControlledObject(p_dude);
		setWorld(p_gameWorld);
		count = 0;
		random = new Random();
	}

	@Override
	public void doLogics()
	{
		moveDude();
		increaseCount();
	}
	
	private void moveDude()
	{
		dude.getPosition().add(dude.getVector());
		SimpleCollisionDetector.keepCircleInRect(dude.getArea(), world.getRect());
	}
	
	private void increaseCount()
	{
		count++;
		if(count > maxCount)
		{
			count = 0;
			setDudeVector();
		}
	}
	
	private void setDudeVector()
	{
		 Vector2D vector = dude.getVector();
		 vector.DX = dude.getMaxSpeed() * random.nextDouble();
		 vector.DY = dude.getMaxSpeed() * random.nextDouble();
		 
		 if(random.nextBoolean())
			 vector.DX = -vector.DX;
		 if(random.nextBoolean())
			 vector.DY = -vector.DY;
	}

	@Override
	public IGameWorld getWorld()
	{
		return world;
	}

	@Override
	public void setWorld(IGameWorld p_gameWorld)
	{
		world = p_gameWorld;
	}

	@Override
	public IGameObject getControlledObject()
	{
		return dude;
	}

	@Override
	public void setControlledObject(IGameObject p_gameObject)
	{
		if(p_gameObject != null && !(p_gameObject instanceof SimpleDude))
			throw new IllegalArgumentException("Non SimpleDude object to SimpleDudeController given.");
		
		dude = (SimpleDude) p_gameObject;
	}

}