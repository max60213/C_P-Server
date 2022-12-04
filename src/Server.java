import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

// declaring required variables
private static ServerSocket serverSocket;
private static Socket clientSocket;
private static InputStreamReader inputStreamReader;
private static BufferedReader bufferedReader;
private static String message="";

	public void startServer() {
	System.out.println("Server start");
		try {
			// creating a new ServerSocket at port 4444
			serverSocket = new ServerSocket(8964);
			System.out.println("Server started. Listening to the port 8964");
	
		} catch (IOException e) {
			System.out.println("Could not listen on port: 8964");
		}
	
		// we keep listening to the socket's
		// input stream until the message
		// "over" is encountered
		while (!message.equalsIgnoreCase("over")) {
			try {
	
				// the accept method waits for a new client connection
				// and and returns a individual socket for that connection
				clientSocket = serverSocket.accept();
				
				// get the inputstream from socket, which will have
				// the message from the clients
				inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
				bufferedReader = new BufferedReader(inputStreamReader);					
				
				// reading the message
				message = bufferedReader.readLine();
	
				// printing the message
				System.out.println(message);
				
				// add the message into system clipboard
				StringSelection stringSelection = new StringSelection(message);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				
				// finally it is very important
				// that you close the sockets
				inputStreamReader.close();
				clientSocket.close();
	
			} catch (IOException ex) {
				System.out.println("Problem in message reading");
			}
		}
	}
}
