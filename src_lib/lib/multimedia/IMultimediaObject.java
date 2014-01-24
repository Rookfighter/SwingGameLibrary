package lib.multimedia;

import java.util.List;

import lib.audio.IMultiSound;
import lib.graphics.animation.IAnimation;
import lib.graphics.sprites.ISprite;
import lib.utils.DeltaTime;

public interface IMultimediaObject extends ISprite{

	ISprite getSprite(final int p_idx);
	IAnimation getAnimation(final int p_idx);
	IMultiSound getSound(final int p_idx);
	
	ISprite getToDraw();
	
	List<ISprite> getSprites();
	List<IAnimation> getAnimations();
	List<IMultiSound> getSounds();
	
	void addSprite(final ISprite p_sprite);
	void addAnimation(final IAnimation p_animation);
	void addSound(final IMultiSound p_sound);
	
	void setAnimationToDraw(final int p_idx);
	void setSpriteToDraw(final int p_idx);
	
	void setDeltaTime(final DeltaTime p_delta);
	DeltaTime getDeltaDeltaTime();
	
}
