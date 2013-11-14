package lib.graphics.animation;

import lib.graphics.animation.classes.AnimationContainer;
import lib.graphics.sprites.ISprite;
import lib.utils.DeltaTime;

public interface IAnimation extends ISprite {
	
	void setDeltaTime(final DeltaTime p_delta);
	
	void setAnimationContainer(final AnimationContainer p_container);
	AnimationContainer getAnimationContainer();
	
	void reset();
	void invert();
	boolean running();
	void setRepeat(final boolean p_repeat);
	void applyChanges();
}
