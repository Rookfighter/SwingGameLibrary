package lib.graphics.panel;

import java.util.List;

import lib.graphics.IDrawable;
import lib.utils.DeltaTime;

public interface IDrawListGenerator {

	List<IDrawable> generateDrawList();
	void setDeltaTime(final DeltaTime p_delta);
}
