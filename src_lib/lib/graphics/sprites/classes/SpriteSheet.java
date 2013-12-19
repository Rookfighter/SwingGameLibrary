package lib.graphics.sprites.classes;

import java.awt.Color;
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
	
	private int currentIndex;
	private Position2DI topLeft;
	private Position2DI botRight;
	
	public SpriteSheet(final Dimension2DI p_spriteDimension, final String p_path)
	{
		spriteDimension = p_spriteDimension;
		topLeft = new Position2DI();
		botRight = new Position2DI();
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
		
		getCornersOf(p_index);
		
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
	
	private void getCornersOf(final int p_idx)
	{
		currentIndex = p_idx;
		getTopLeft();
		getBotRight();
	}
	
	private void getTopLeft()
	{
		int x = (currentIndex % spritesPerLine) * spriteDimension.Width() ;
		int y = (currentIndex / spritesPerLine) * spriteDimension.Height();
		topLeft.set(x, y);
	}
	
	private void getBotRight()
	{
		int x = topLeft.X() + spriteDimension.Width();
		int y = topLeft.Y() + spriteDimension.Height();
		botRight.set(x,y);
	}

	@Override
	public int getMaxSpriteCount()
	{
		return maxSpriteCount;
	}
	
	@Override
	public void setInvisibleColor(final Color p_color)
	{
		
	}

}
