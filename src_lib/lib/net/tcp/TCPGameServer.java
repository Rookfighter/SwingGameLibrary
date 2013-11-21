package lib.net.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import lib.net.IGameServer;

public class TCPGameServer implements IGameServer{

	private int port;
	
	private List<Socket> clientList;
	
	private ServerSocket serverSocket;
	
	@Override
	public void setPort(int p_port)
	{
		port = p_port;
	}

	@Override
	public int getPort()
	{
		return port;
	}

	@Override
	public void start()
	{
		
	}
	
	private void createServerSocket() throws IOException
	{
		serverSocket = new ServerSocket(port);
	}

	@Override
	public boolean running()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shutdown()
	{
		// TODO Auto-generated method stub
		
	}

}
