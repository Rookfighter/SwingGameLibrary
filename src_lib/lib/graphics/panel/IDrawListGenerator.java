package lib.graphics.panel;

import java.util.List;

import lib.graphics.IDrawable;
import lib.utils.DeltaTime;
import lib.utils.TimeAccount;

public interface IDrawListGenerator {

	List<IDrawable> generateDrawList();
	void setDeltaTime(final DeltaTime p_delta);
	void setTimeAccount(final TimeAccount p_account);
}
