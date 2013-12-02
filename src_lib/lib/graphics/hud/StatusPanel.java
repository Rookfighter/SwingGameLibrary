package lib.graphics.hud;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import lib.graphics.IRedrawable;
import lib.graphics.IUseDelta;
import lib.utils.DeltaTime;

public class StatusPanel extends JPanel implements IRedrawable, IUseDelta {

	private static final int KILO = 1024;
	
	private static final long serialVersionUID = 5098685921479038877L;
	private JLabel fps;
	private JLabel memoryUsage;
	private DeltaTime deltaTime;
	
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
	}
	
	private void createComponents()
	{
		fps = new JLabel();
		memoryUsage = new JLabel();
	}
	
	private void addComponents()
	{
		add(fps);
		add(memoryUsage);
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
		fps.setText(String.format("FPS: %.2f", deltaTime.getFPS()));
		
		double mb = Runtime.getRuntime().totalMemory() / KILO;
		mb = mb / (double) KILO;
		memoryUsage.setText(String.format("Memory Usage: %.2f Mb", mb));
	}
	
	private void increaseCount()
	{
		++count;
		if(count > maxCount)
			count = 0;
	}

	

}
