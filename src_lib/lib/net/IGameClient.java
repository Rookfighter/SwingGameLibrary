package lib.net;

public interface IGameClient {

	void setIP(final String p_ip);
	String getIP();
	
	void setPort(final int p_port);
	int getPort();
	
	void send(final Object p_message);
	
	void connect();
	
	
}
