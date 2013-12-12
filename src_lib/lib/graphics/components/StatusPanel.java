package lib.graphics.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EtchedBorder;

import lib.graphics.IRedrawable;
import lib.graphics.IUseDelta;
import lib.utils.DeltaTime;

public class StatusPanel extends JPanel implements IRedrawable, IUseDelta {

	private static final int KILO = 1024;
	private static final int MAX_MEM = 2000;
	
	private static final long serialVersionUID = 5098685921479038877L;
	private JLabel fps;
	private JLabel memoryUsage;
	private JLabel threadCount;
	private JProgressBar memoryBar;
	private DeltaTime deltaTime;
	
	private double sumFPS;
	
	private int count;
	private static final int maxCount = 15;
	
	public StatusPanel()
	{
		super();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		createComponents();
		addComponents();
		count = 0;
		sumFPS = 0;
	}
	
	private void createComponents()
	{
		fps = new JLabel();
		memoryUsage = new JLabel();
		memoryUsage.setText("Memory Usage:");
		memoryBar = new JProgressBar(0,MAX_MEM);
		memoryBar.setString("0/2000");
		memoryBar.setStringPainted(true);
		
		threadCount = new JLabel();
	}
	
	private void addComponents()
	{
		add(fps);
		add(threadCount);
		add(memoryUsage);
		add(memoryBar);
		
	}
	
	@Override
	public void setDeltaTime(final DeltaTime p_deltaTime)
	{
		deltaTime = p_deltaTime;
	}

	@Override
	public void redraw()
	{
		increaseCount();
		if(count >= maxCount)
			updateDisplay();
	}
	
	private void updateDisplay()
	{
		fps.setText(String.format("FPS: %.2f", sumFPS / count));
		updateMemorybar();
		threadCount.setText(String.format("Threads: %d",Thread.activeCount()));
	}
	
	private void updateMemorybar()
	{
		double mb = Runtime.getRuntime().totalMemory() / KILO;
		mb = mb / (double) KILO;
		
		Color color = Color.GREEN;
		double part = mb / (double)MAX_MEM;
		if(part >= 0.5)
			color = Color.YELLOW;
		if(part >= 0.75)
			color = Color.RED;
		
		memoryBar.setForeground(color);
		memoryBar.setString(String.format("%.2fMb/%dMb", mb, MAX_MEM));
		memoryBar.setValue((int)mb);
	}
	
	
	
	private void increaseCount()
	{
		sumFPS += deltaTime.getFPS();
		++count;
		if(count > maxCount)
		{
			sumFPS = 0;
			count = 0;
		}
	}

	

}
