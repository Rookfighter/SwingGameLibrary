package lib.graphics.sprites;

import java.awt.Graphics;
import java.io.IOException;

import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;


public class SpriteSheet extends ASpriteSheet {

	protected Dimension2DI spriteDimension;
	protected int maxSpriteCount;
	protected int spritesPerLine;
	protected int spritesPerColumn;
	
	public SpriteSheet(final Dimension2DI p_spriteDimension, final String p_path)
	{
		spriteDimension = p_spriteDimension;
		setFilePath(p_path);
	}
	
	@Override
	public void loadImage() throws IOException
	{
		super.loadImage();
		spritesPerLine = spriteSheetDimension.Width() / spriteDimension.Width();
		spritesPerColumn = (int) spriteSheetDimension.Height() / (int) spriteDimension.Height(); 
		maxSpriteCount = spritesPerLine * spritesPerColumn;
	}
	
	@Override
	public void drawSprite(final int p_index,
						   final Position2DI p_position,
						   final Graphics p_graphic)
	{
		drawSprite(p_index, p_position, spriteDimension, p_graphic);
	}

	@Override
	public void drawSprite(final int p_index,
						   final Position2DI p_position,
						   final Dimension2DI p_dimension,
						   final Graphics p_graphic)
	{
		int srcx1,srcx2, srcy1, srcy2;
		int destx1, destx2, desty1, desty2;
		
		srcx1 = getTopLeftXOf(p_index);
		srcx2 = srcx1 + (int) spriteDimension.Width();
		srcy1 = getTopLeftYOf(p_index);
		srcy2 = srcy1 + (int) spriteDimension.Height();
		
		destx1 = (int) p_position.X();
		destx2 = destx1 + (int) p_dimension.Width();
		desty1 = (int) p_position.Y();
		desty2 = desty1 + (int) p_dimension.Height();
		
		p_graphic.drawImage(spriteSheetImg,
							destx1,desty1,
							destx2, desty2,
							srcx1, srcy1,
							srcx2, srcy2,
							null);
	}

	private int getTopLeftXOf(final int p_index)
	{
		int lineIndex = p_index % spritesPerLine;
		return lineIndex * (int) spriteDimension.Width();
	}
	
	private int getTopLeftYOf(final int p_index)
	{
		int columnIndex = p_index / spritesPerLine;
		return columnIndex * (int) spriteDimension.Height();
	}

	@Override
	public int getMaxSpriteCount()
	{
		return maxSpriteCount;
	}

}
