package lib.multimedia;

import java.util.List;

import lib.audio.IMultiSound;
import lib.graphics.animation.IAnimation;
import lib.graphics.sprites.ISprite;

public interface IMultimediaObject extends ISprite{

	ISprite getSprite(final int p_idx);
	IAnimation getAnimation(final int p_idx);
	IMultiSound getSound(final int p_idx);
	
	List<ISprite> getSprites();
	List<IAnimation> getAnimations();
	List<IMultiSound> getSounds();
	
}
