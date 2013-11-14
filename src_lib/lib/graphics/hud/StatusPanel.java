package lib.graphics.hud;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lib.utils.DeltaTime;

public class StatusPanel extends JPanel {

	private static final long serialVersionUID = 5098685921479038877L;
	private JLabel fps;
	private DeltaTime deltaTime;
	
	public StatusPanel()
	{
		super();
		addComponents();
	}
	
	private void addComponents()
	{
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		addFPSDisplay();
		
	}
	
	private void addFPSDisplay()
	{
		fps = new JLabel();
		this.add(fps);
	}
	
	public void updateDisplay()
	{
		fps.setText(String.format("FPS: %.2f", deltaTime.getFPS()));
		
		repaint();
	}
	
	public void setDeltaTime(final DeltaTime p_deltaTime)
	{
		deltaTime = p_deltaTime;
	}

	

}
