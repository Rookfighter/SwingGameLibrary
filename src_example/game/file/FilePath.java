package game.file;

public class FilePath
{
	private FilePath()
	{
		
	}
	
	public static String getHomeDirectory()
	{
		return System.getProperty("user.home");
	}
	
	public static String getGameDirectory()
	{
		return getHomeDirectory() + "/Game";
	}
	
	public static String getKeyBindingsConfig()
	{
		return getGameDirectory() + "/.KeyBindings.xml";
	}
}
