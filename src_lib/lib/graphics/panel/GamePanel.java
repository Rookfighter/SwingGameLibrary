package lib.graphics.panel;

import java.awt.Graphics;
import java.util.List;
import java.util.LinkedList;

import javax.swing.JPanel;

import lib.graphics.IDrawable;
import lib.utils.DeltaTime;
import lib.utils.doubl.Dimension2DF;
import lib.utils.integer.Dimension2DI;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 5656487653867749985L;
	
	private List<IDrawable> drawList;
	private IDrawListGenerator drawListGenerator;
	private DeltaTime deltaTime;
	
	public GamePanel()
	{
		super();
		drawList = new LinkedList<IDrawable>();
		setIgnoreRepaint(true);
	}
	
	public void setDrawList(final List<IDrawable> p_drawList)
	{
		drawList.clear();
		drawList.addAll(p_drawList);
	}
	
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
	
	public void render()
	{
		getParent()
	}
	
	private GameFrame getGameFrameParent()
	{
		return null;
	}
	
	public void renderGame(final Graphics p_graphic)
	{
		synchronized(deltaTime)
		{
			synchronized(drawList)
			{
				paintDrawableObjects(p_graphic);
			}
		}
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
