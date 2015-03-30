package volk.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connector {
	private Socket socket;
	private ObjectInputStream from;
	private ObjectOutputStream to;

	public Socket getConnect() {
		try {
			socket = new Socket("localhost", 5555);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return socket;
	}

	public Object receiveObject() {
		Object recieve = null;
		try {
			from = new ObjectInputStream(socket.getInputStream());
			recieve = from.readObject();

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return recieve;
	}

	public void sendObject(Object object) {
		try {
			to = new ObjectOutputStream(socket.getOutputStream());
			to.writeObject(object);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void closeSocket() {
		try {
			socket.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
