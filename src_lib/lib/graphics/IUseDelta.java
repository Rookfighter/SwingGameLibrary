package lib.graphics;

import lib.utils.DeltaTime;

public interface IUseDelta {

	void setDeltaTime(final DeltaTime p_delta);
	DeltaTime getDeltaTime();
}
