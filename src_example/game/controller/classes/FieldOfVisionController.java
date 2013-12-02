package game.controller.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lib.utils.doubl.Dimension2DF;
import lib.utils.doubl.Position2DF;
import lib.utils.doubl.Rectangle2DF;
import lib.utils.doubl.Vector2D;
import game.controller.IFieldOfVisionController;
import game.controller.IObjectSearcher;
import game.entities.IFieldOfVision;
import game.entities.IGameObject;
import game.entities.IGameWorld;

public class FieldOfVisionController implements IFieldOfVisionController {
	
	private static final double MAX_SPEED = 5.0;
	
	private IGameWorld world;
	private IFieldOfVision fieldOfVision;
	private IObjectSearcher objSearcher;
	private Dimension2DF inFoVBuffer;
	
	private Queue<Vector2D> controls;
	
	public FieldOfVisionController()
	{
		this(null);
		controls = new LinkedList<Vector2D>();
	}
	
	public FieldOfVisionController(final IFieldOfVision p_fov)
	{
		world = null;
		fieldOfVision = p_fov;
		objSearcher = new SimpleObjectSearcher();
		inFoVBuffer = new Dimension2DF();
	}
	
	public void addVector(final Vector2D p_vector)
	{
		synchronized(controls)
		{
			controls.add(p_vector);
		}
	}
	
	@Override
	public void doLogics()
	{
		useVectors();
		moveFieldOfVision();
	}
	
	private void useVectors()
	{
		synchronized(controls)
		{
			while(!controls.isEmpty())
				fieldOfVision.getVector().add(controls.poll());
		}
		
		double dxFac = Math.abs(MAX_SPEED / fieldOfVision.getVector().DX);
		double dyFac = Math.abs(MAX_SPEED / fieldOfVision.getVector().DY);
		if(dxFac < 1)
			fieldOfVision.getVector().DX *= dxFac;
		if(dyFac < 1)
			fieldOfVision.getVector().DY *= dyFac;
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
	
}
