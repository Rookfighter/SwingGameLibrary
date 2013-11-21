package lib.net;

public interface IGameServer {

	void setPort(final int p_port);
	int getPort();
	
	void start();
	void shutdown();
	
	boolean running();
}
