package lib.graphics.sprites;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lib.utils.integer.Dimension2DI;

public abstract class ASpriteSheet implements ISpriteSheet {
	
	protected Dimension2DI spriteSheetDimension;
	private File sheetFile;
	protected BufferedImage spriteSheetImg;
	
	@Override
	public void loadImage() throws IOException
	{
		spriteSheetImg = ImageIO.read(sheetFile);
		spriteSheetDimension = new Dimension2DI();
		spriteSheetDimension.setHeight(spriteSheetImg.getHeight());
		spriteSheetDimension.setWidth(spriteSheetImg.getWidth());
	}
	
	protected void setFile(final File p_file)
	{
		if(!p_file.isFile())
			throw new IllegalArgumentException(String.format("The SpriteSheet file does not exist: %s.",p_file.getAbsolutePath()));
		sheetFile = p_file;
	}
	
	protected File getFile()
	{
		return sheetFile;
	}
	
	protected String getFilePath()
	{
		return sheetFile.getAbsolutePath();
	}
	
	protected void setFilePath(final String p_filePath)
	{
		setFile(new File(p_filePath));
	}
	
	@Override
	public void setInvisibleColor(final Color p_color)
	{
		
	}
	
}
