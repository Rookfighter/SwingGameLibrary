package lib.graphics.sprites.classes;

import java.awt.Graphics;

import lib.graphics.sprites.ISprite;
import lib.graphics.sprites.ISpriteSheet;
import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;


public class Sprite implements ISprite {
	
	private Position2DI SpritePos;
	private Dimension2DI SpriteDimension;
	private ISpriteSheet spriteSheet;
	private int spriteIndex;
	
	private int drawOrder; 
	
	private double radianRotation;

	public Sprite(final ISpriteSheet p_spriteSheet, final int p_spriteIndex)
	{
		spriteSheet = p_spriteSheet;
		spriteIndex = p_spriteIndex;
		SpritePos = new Position2DI();
		SpriteDimension = new Dimension2DI();
	}
	
	@Override
	public void draw(Graphics p_graphic)
	{
		spriteSheet.drawSprite(spriteIndex,
								SpritePos,
								SpriteDimension,
								radianRotation,
								p_graphic);
	}

	@Override
	public Position2DI getPosition() {
		return SpritePos;
	}

	@Override
	public void setPosition(Position2DI p_position) {
		SpritePos = p_position;
	}

	@Override
	public Dimension2DI getDimension() {
		return SpriteDimension;
	}

	@Override
	public void setDimension(final Dimension2DI p_dimension) {
		SpriteDimension = p_dimension;
	}
	
	@Override
	public int getDrawOrder()
	{
		return drawOrder;
	}
	
	@Override
	public void setDrawOrder(final int p_drawOrder)
	{
		drawOrder = p_drawOrder;
	}
	
	@Override
	public void setDefaultDrawOrder()
	{
		drawOrder = (int) SpritePos.Y();
	}

	@Override
	public void setRotation(double p_radian)
	{
		radianRotation = p_radian;
	}

	@Override
	public double getRotation()
	{
		return radianRotation;
	}
}
