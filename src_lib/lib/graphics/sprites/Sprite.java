package lib.graphics.sprites;

import java.awt.Graphics;

import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;


public class Sprite implements ISprite {
	
	protected Position2DI SpritePos;
	protected Dimension2DI SpriteDimension;
	protected ISpriteSheet spriteSheet;
	protected int spriteIndex;
	
	private int drawOrder; 

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
		spriteSheet.drawSprite(spriteIndex, SpritePos, SpriteDimension, p_graphic);
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
}
