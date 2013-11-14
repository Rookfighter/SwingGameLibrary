package lib.graphics.panel;

import java.util.Comparator;

import lib.graphics.IDrawable;

public class DrawOrderComparator implements Comparator<IDrawable>{

	@Override
	public int compare(IDrawable p_drawable1, IDrawable p_drawable2) {
		if(p_drawable1.getDrawOrder() == p_drawable2.getDrawOrder())
			return 0;
		else if(p_drawable1.getDrawOrder() > p_drawable2.getDrawOrder())
			return 1;
		else
			return -1;
	}

}
