package lib.graphics.panel;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.List;
import java.util.LinkedList;

import lib.graphics.IDrawable;
import lib.graphics.IRedrawable;
import lib.graphics.IUseDelta;
import lib.graphics.IUseTimeAccount;
import lib.utils.DeltaTime;
import lib.utils.TimeAccount;
import lib.utils.doubl.Dimension2DF;
import lib.utils.integer.Dimension2DI;

public class GamePanel extends Canvas implements IRedrawable, IUseDelta, IUseTimeAccount {

	private static final long serialVersionUID = 5656487653867749985L;
	private static final int BUFFER_COUNT = 3;
	
	private List<IDrawable> drawList;
	private IDrawListGenerator drawListGenerator;
	private DeltaTime deltaTime;
	private TimeAccount timeAccount;
	
	public GamePanel()
	{
		super();
		drawList = new LinkedList<IDrawable>();
	}
	
	public void setDrawList(final List<IDrawable> p_drawList)
	{
		drawList.clear();
		drawList.addAll(p_drawList);
	}
	
	@Override
	public void setDeltaTime(final DeltaTime p_deltaTime)
	{
		deltaTime = p_deltaTime;
		drawListGenerator.setDeltaTime(deltaTime);
	}
	
	@Override
	public void setTimeAccount(final TimeAccount p_account)
	{
		timeAccount = p_account;
		drawListGenerator.setTimeAccount(timeAccount);
	}
	
	public DeltaTime getDeltaTime()
	{
		return deltaTime;
	}
	
	public TimeAccount getTimeAccount()
	{
		return timeAccount;
	}
	
	public void clearDrawList()
	{
		drawList.clear();
	}
	
	public void addObjectToDraw(final IDrawable p_objToDraw)
	{
		drawList.add(p_objToDraw);
	}
	
	public void setDrawListGenerator(final IDrawListGenerator p_drawListGenerator)
	{
		drawListGenerator = p_drawListGenerator;
		drawListGenerator.setDeltaTime(deltaTime);
	}
	
	public IDrawListGenerator getDrawListGenerator()
	{
		return drawListGenerator;
	}
	
	@Override
	public void redraw()
	{
		setBufferStrategy();
		BufferStrategy buffStartegy = getBufferStrategy();
		Graphics g = getBufferStrategy().getDrawGraphics();
		
		try
		{
			drawGame(g);
		}
		finally
		{
			g.dispose();
		}
		
		buffStartegy.show();
		
	}
	
	public void setBufferStrategy()
	{
		if(getBufferStrategy() == null)
			createBufferStrategy(BUFFER_COUNT);
	}
	
	public void drawGame(final Graphics p_graphic)
	{
		clearCanvasGraphics(p_graphic);
		paintDrawableObjects(p_graphic);
	}
	
	private void clearCanvasGraphics(final Graphics p_graphic)
	{
		p_graphic.clearRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	private void paintDrawableObjects(final Graphics p_graphic)
	{
		for(IDrawable objToDraw : drawList)
			objToDraw.draw(p_graphic);
	}
	
	public void generatePaintlist()
	{
		setDrawList(drawListGenerator.generateDrawList()); 
	}
	
	public void setPreferredSize(final Dimension2DI p_dimension)
	{
		setPreferredSize(p_dimension.toAWTDimension());
	}
	
	public void setPreferredSize(final Dimension2DF p_dimension)
	{
		setPreferredSize(p_dimension.toAWTDimension());
	}
	
}
