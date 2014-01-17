package game.view.panel;

import game.controller.IFieldOfVisionController;
import game.entities.IGameObject;
import game.entities.classes.SimpleDude;
import game.view.animation.AnimationSimpleDude;
import game.view.sprites.SpriteUnknown;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lib.graphics.IDrawable;
import lib.graphics.panel.DrawOrderComparator;
import lib.graphics.panel.IDrawListGenerator;
import lib.graphics.sprites.ISprite;
import lib.utils.DeltaTime;
import lib.utils.TimeAccount;
import lib.utils.doubl.Vector2D;
import lib.utils.integer.Position2DI;

public class GameDrawListGenerator implements IDrawListGenerator {

	private DrawOrderComparator comparator;
	private IFieldOfVisionController fovController;
	private List<IDrawable> drawList;
	private Vector2D translation;
	private Vector2D fovRelativeTranslation;
	
	private IGameObject currentGameObject;
	private IDrawable currentDrawable;
	private ISprite currentSprite;
	
	private DeltaTime delta;
	
	private Map<IGameObject,ISprite> objects;
	
	//TODO
	private ISprite test;
	private int round;
	
	public GameDrawListGenerator(final IFieldOfVisionController p_fov)
	{
		fovController = p_fov;
		comparator = new DrawOrderComparator();
		translation = new Vector2D();
		fovRelativeTranslation = new Vector2D();
		objects = new HashMap<IGameObject,ISprite>();
		
		round = 0;
	}
	
	public void setFieldOfVision(final IFieldOfVisionController p_fieldOfVision)
	{
		fovController = p_fieldOfVision;
	}
	
	public IFieldOfVisionController getFieldOfVision()
	{
		return fovController;
	}
	
	@Override
	public List<IDrawable> generateDrawList()
	{
		drawList = new LinkedList<IDrawable>();
		generateDrawListFromFoV();
		addTest();
		Collections.sort(drawList, comparator);
		return drawList;
	}
	
	private void addTest()
	{
		if(test == null)
		{
			test = new SpriteUnknown();
			test.getPosition().set(100,100);
		}
		round++;
		if(round >= 10)
		{
			test.setRotation(test.getRotation() + Math.toRadians(21));
			round = 0;
		}
		drawList.add(test);
	}
	
	private void generateDrawListFromFoV()
	{
		List<IGameObject> objectList = fovController.getObjectsInFoVBuffer();
		calcFoVTranslation();
		for(IGameObject gameObject : objectList)
		{
			currentGameObject = gameObject;
			addDrawableOfCurrentObject();
		}
	}
	
	private void calcFoVTranslation()
	{
		fovRelativeTranslation.DX = - (fovController.getFieldOfVision().getPosition().X() - 
									   fovController.getFieldOfVision().getDimension().Width() / 2);
		fovRelativeTranslation.DY = - (fovController.getFieldOfVision().getPosition().Y() -
									   fovController.getFieldOfVision().getDimension().Height() / 2);
	}
	
	private void addDrawableOfCurrentObject()
	{
		setDrawableOfCurrentObject();
		setDrawablePosition();
		drawList.add(currentDrawable);
	}
	
	private void setDrawableOfCurrentObject()
	{
		ISprite sprite = objects.get(currentGameObject);
		if(sprite == null)
			sprite = putSpriteOfCurrentObject();
		currentDrawable = sprite;
	}
	
	private ISprite putSpriteOfCurrentObject()
	{
		ISprite result;
		if(currentGameObject instanceof SimpleDude)
		{
			result = getSimpleDudeSprite();
			objects.put(currentGameObject,result);
		} 
		else
			result = getUnknownSprite();
		return result;
	}
	
	private ISprite getSimpleDudeSprite()
	{
		ISprite result = new AnimationSimpleDude(delta);
		return result;
	}
	
	private ISprite getUnknownSprite()
	{
		return new SpriteUnknown();
	}
	
	private void setDrawablePosition()
	{
		if(currentDrawable instanceof ISprite)
			setPositionOfCurrentSprite();
	}
	
	private void setPositionOfCurrentSprite()
	{
		currentSprite = (ISprite) currentDrawable;
		setRelativeFoVPosOfCurrentSprite();
		translatePosOfCurrentSprite();
	}

	private void setRelativeFoVPosOfCurrentSprite()
	{
		Position2DI spritePos = new Position2DI();
		spritePos.assign(currentGameObject.getPosition());
		spritePos.add(fovRelativeTranslation);
		currentSprite.getPosition().assign(spritePos);;
	}
	
	private void translatePosOfCurrentSprite()
	{
		translation.set(-currentSprite.getDimension().Width() / 2,
						-currentSprite.getDimension().Height() / 2);
		currentSprite.getPosition().add(translation);
	}

	@Override
	public void setDeltaTime(DeltaTime p_delta)
	{
		delta = p_delta;
		
	}

	@Override
	public void setTimeAccount(TimeAccount p_account)
	{
		// TODO Auto-generated method stub
	}
}
