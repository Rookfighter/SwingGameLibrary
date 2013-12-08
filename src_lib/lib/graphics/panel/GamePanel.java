package lib.graphics.panel;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.List;
import java.util.LinkedList;

import lib.graphics.IDrawable;
import lib.graphics.IRedrawable;
import lib.graphics.IUseDelta;
import lib.graphics.frame.DrawThread;
import lib.utils.DeltaTime;
import lib.utils.doubl.Dimension2DF;
import lib.utils.integer.Dimension2DI;

public class GamePanel extends Canvas implements IRedrawable, IUseDelta {

	private static final long serialVersionUID = 5656487653867749985L;
	private static final int BUFFER_COUNT = 3;
	
	private List<IDrawable> drawList;
	private IDrawListGenerator drawListGenerator;
	private DeltaTime deltaTime;
	
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
	
	public DeltaTime getDeltaTime()
	{
		return deltaTime;
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
	}
	
	public IDrawListGenerator getDrawListGenerator()
	{
		return drawListGenerator;
	}
	
	@Override
	public void redraw()
	{
		generatePaintlist();
		draw();
	}
	
	private void draw()
	{
		if(!isDisplayable())
			throw new IllegalStateException("GamePanel cannot be rendered. GamePanel is not displayable.");
			
		setBufferStrategy();
		startDrawThread();
	}
	
	private void setBufferStrategy()
	{
		if(getBufferStrategy() == null)
			createBufferStrategy(BUFFER_COUNT);
	}
	
	private void startDrawThread()
	{
		DrawThread thread = new DrawThread();
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.setGamePanel(this);
		thread.start();
	}
	
	public void renderGame(final Graphics p_graphic)
	{
		clearCanvasGraphics(p_graphic);
		synchronized(deltaTime)
		{
			synchronized(drawList)
			{
				paintDrawableObjects(p_graphic);
			}
		}
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
		synchronized(drawList)
		{
			setDrawList(drawListGenerator.generateDrawList()); 
		}
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
