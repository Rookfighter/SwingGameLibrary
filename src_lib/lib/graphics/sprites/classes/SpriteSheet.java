package lib.graphics.sprites.classes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lib.graphics.sprites.ISpriteSheet;
import lib.utils.integer.Dimension2DI;
import lib.utils.integer.Position2DI;


public class SpriteSheet implements ISpriteSheet {

	private Dimension2DI spriteSheetDimension;
	private File sheetFile;
	private BufferedImage spriteSheetImg;
	
	private Dimension2DI spriteDimension;
	private int maxSpriteCount;
	private int spritesPerLine;
	private int spritesPerColumn;
	
	public SpriteSheet(final Dimension2DI p_spriteDimension, final String p_path)
	{
		spriteDimension = p_spriteDimension;
		setFilePath(p_path);
	}
	
	private void setFilePath(final String p_filePath)
	{
		setFile(new File(p_filePath));
	}
	
	private void setFile(final File p_file)
	{
		if(!p_file.isFile())
			throw new IllegalArgumentException(String.format("The SpriteSheet file does not exist: %s.",p_file.getAbsolutePath()));
		sheetFile = p_file;
	}
	
	@Override
	public void loadImage() throws IOException
	{
		spriteSheetImg = ImageIO.read(sheetFile);
		spriteSheetDimension = new Dimension2DI();
		spriteSheetDimension.setHeight(spriteSheetImg.getHeight());
		spriteSheetDimension.setWidth(spriteSheetImg.getWidth());
		spritesPerLine = spriteSheetDimension.Width() / spriteDimension.Width();
		spritesPerColumn = (int) spriteSheetDimension.Height() / (int) spriteDimension.Height(); 
		maxSpriteCount = spritesPerLine * spritesPerColumn;
	}
	
	@Override
	public void drawSprite(int p_index,
						   Position2DI p_position,
						   Dimension2DI p_dimension,
						   double p_radian,
						   Graphics p_graphic)
	{
		BufferedImage drawImage = new BufferedImage(p_dimension.Width(), p_dimension.Height(), spriteSheetImg.getType());
		Graphics2D drawGraphics = drawImage.createGraphics();
		drawGraphics.rotate(p_radian, p_dimension.Width() / 2, p_dimension.Height() / 2);
		drawSprite(p_index,
				   new Position2DI(0,0),
				   p_dimension,
				   drawGraphics);
		drawGraphics.dispose();
		
		p_graphic.drawImage(drawImage,
							p_position.X(),
							p_position.Y(),
							null);
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
		int destx1, destx2, desty1, desty2;
		
		Position2DI topLeft = getTopLeftOf(p_index);
		Position2DI botRight = getBotRightOf(p_index);
		
		destx1 = (int) p_position.X();
		destx2 = destx1 + (int) p_dimension.Width();
		desty1 = (int) p_position.Y();
		desty2 = desty1 + (int) p_dimension.Height();
		
		
		
		p_graphic.drawImage(spriteSheetImg,
							destx1,desty1,
							destx2, desty2,
							topLeft.X(), topLeft.Y(),
							botRight.X(), botRight.Y(),
							null);
	}
	
	private Position2DI getBotRightOf(final int p_idx)
	{
		Position2DI result = getTopLeftOf(p_idx);
		result.set(result.X() + spriteDimension.Width(), result.Y() + spriteDimension.Height());
		return result;
	}
	
	private Position2DI getTopLeftOf(final int p_idx)
	{
		int x = (p_idx % spritesPerLine) * spriteDimension.Width() ;
		int y = (p_idx / spritesPerLine) * spriteDimension.Height();
		return new Position2DI(x,y);
	}

	@Override
	public int getMaxSpriteCount()
	{
		return maxSpriteCount;
	}
}
