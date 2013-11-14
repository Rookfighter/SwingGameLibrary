package game.controller.classes;

import java.util.List;

import lib.utils.doubl.Dimension2DF;
import lib.utils.doubl.Position2DF;
import lib.utils.doubl.Rectangle2DF;
import game.controller.IFieldOfVisionController;
import game.controller.IObjectSearcher;
import game.entities.IFieldOfVision;
import game.entities.IGameObject;
import game.entities.IGameWorld;

public class FieldOfVisionController implements IFieldOfVisionController {

	private IGameWorld world;
	private IFieldOfVision fieldOfVision;
	private final double scrollSpeed = 5.0;
	private IObjectSearcher objSearcher;
	private Dimension2DF inFoVBuffer;
	
	public FieldOfVisionController()
	{
		this(null);
	}
	
	public FieldOfVisionController(final IFieldOfVision p_fov)
	{
		world = null;
		fieldOfVision = p_fov;
		objSearcher = new SimpleObjectSearcher();
		inFoVBuffer = new Dimension2DF();
	}
	
	@Override
	public void doLogics()
	{
		moveFieldOfVision();
	}
	
	private void moveFieldOfVision()
	{
		Position2DF destPos = fieldOfVision.getPosition();
		destPos.add(fieldOfVision.getVector());
		correctXMovement(destPos);
		correctYMovement(destPos);
	}
	
	private void correctXMovement(Position2DF p_destPos)
	{
		if(fovXIsHigherWorldMaxWidth(p_destPos))
			p_destPos.setX(world.getDimension().Width());
		else if (fovXIsLowerWorldMinWidth(p_destPos))
			p_destPos.setX(0);	
	}
	
	private boolean fovXIsHigherWorldMaxWidth(Position2DF p_destPos)
	{
		return p_destPos.X() > world.getDimension().Width();
	}
	
	private boolean fovXIsLowerWorldMinWidth(Position2DF p_destPos)
	{
		return p_destPos.X() < 0;
	}
	
	private void correctYMovement(Position2DF p_destPos)
	{
		if(fovYIsHigherWorldMaxHeight(p_destPos))
			p_destPos.setY(world.getDimension().Height());
		else if (fovYIsLowerWorldMinHeight(p_destPos))
			p_destPos.setY(0);
	}
	
	private boolean fovYIsHigherWorldMaxHeight(Position2DF p_destPos)
	{
		return p_destPos.Y() > world.getDimension().Height();
	}
	
	private boolean fovYIsLowerWorldMinHeight(Position2DF p_destPos)
	{
		return p_destPos.Y() < 0;
	}

	@Override
	public IFieldOfVision getFieldOfVision()
	{
		return fieldOfVision;
	}

	@Override
	public void setFieldOfVision(IFieldOfVision p_fov)
	{
		fieldOfVision = p_fov;
	}

	@Override
	public IGameWorld getWorld()
	{
		return world;
	}

	@Override
	public void setGameWorld(IGameWorld p_world)
	{
		world = p_world;
		objSearcher.setWorld(world);
	}
	
	@Override
	public void setInFovBuffer(final Dimension2DF p_buffer)
	{
		inFoVBuffer = p_buffer;
	}
	
	@Override
	public Dimension2DF getInFovBuffer()
	{
		return inFoVBuffer;
	}
	
	@Override
	public List<IGameObject> getObjectsInFoV()
	{
		return objSearcher.getObjectsInRect(new Rectangle2DF(fieldOfVision.getPosition(),
															fieldOfVision.getDimension()));
	}
	
	@Override
	public List<IGameObject> getObjectsInFoVBuffer()
	{
		return objSearcher.getObjectsInRect(new Rectangle2DF(fieldOfVision.getPosition(),
															inFoVBuffer));
	}

	//ÜBERDENKEN TODO
	public void moveRight()
	{
		fieldOfVision.getVector().DX += scrollSpeed;
	}
	
	public void moveLeft()
	{
		fieldOfVision.getVector().DX -= scrollSpeed;
	}
	
	public void moveUp()
	{
		fieldOfVision.getVector().DY -= scrollSpeed;
	}
	
	public void moveDown()
	{
		fieldOfVision.getVector().DY += scrollSpeed;
	}
	
}
