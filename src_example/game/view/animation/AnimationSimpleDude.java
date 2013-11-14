package game.view.animation;

import game.view.sprites.SpriteSimpleDudeDown;
import game.view.sprites.SpriteSimpleDudeLeft;
import game.view.sprites.SpriteSimpleDudeRight;
import game.view.sprites.SpriteSimpleDudeUp;
import lib.graphics.animation.classes.Animation;
import lib.utils.DeltaTime;

public class AnimationSimpleDude extends Animation {

	public AnimationSimpleDude(final DeltaTime p_delta)
	{
		super();
		setDeltaTime(p_delta);
		getAnimationContainer().setSize(4);
		getAnimationContainer().get(0).set(new SpriteSimpleDudeUp(), 41);
		getAnimationContainer().get(1).set(new SpriteSimpleDudeRight(), 41);
		getAnimationContainer().get(2).set(new SpriteSimpleDudeDown(), 41);
		getAnimationContainer().get(3).set(new SpriteSimpleDudeLeft(), 41);
		getDimension().set(32, 32);
		applyChanges();
	}
	
}
