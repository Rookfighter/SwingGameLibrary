package lib.audio.classes;

import java.util.ArrayList;
import java.util.List;

import lib.audio.ISound;

public class Playlist {
	
	private List<ISound> playList;
	private int currentIndex;

	public Playlist()
	{
		playList = new ArrayList<ISound>();
		currentIndex = 0;;
	}
	
	public void addSound(final ISound p_sound)
	{
		playList.add(p_sound);
	}
	
	public void addSounds(final List<ISound> p_list)
	{
		playList.addAll(p_list);
	}
	
	public void set(final List<ISound> p_list)
	{
		playList = new ArrayList<ISound>(p_list.size());
		playList.addAll(p_list);
	}
	
	public void append(final Playlist p_playList)
	{
		playList.addAll(p_playList.playList);
	}
	
	public ISound next()
	{
		increaseIndex();
		return playList.get(currentIndex);
	}
	
	private void increaseIndex()
	{
		++currentIndex;
		if(currentIndex >= playList.size())
			currentIndex = 0;
	}
	
	public void shuffle()
	{
		//TODO
	}
}
