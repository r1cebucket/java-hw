package chat;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class ChatServer extends JFrame implements Runnable {
	private static int cliID = 0;

	private static int WIDTH = 400;
	private static int HEIGHT = 300;

	// Text area for displaying contents
	JTextArea ta;

	HashMap<Integer, Socket> connMap = new HashMap<>();

	public ChatServer() {
		super("Chat Server");
		this.setSize(ChatServer.WIDTH, ChatServer.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		this.setVisible(true);

		ta = new JTextArea();
		this.add(ta);

		setSize(600, 800);
		Thread t = new Thread(this);
		t.start();
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener((e) -> System.exit(0));
		menu.add(exitItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}

	@Override
	public void run() {
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(9898);
			ta.append("MultiThreadServer started at "
					+ new Date() + '\n');

			while (true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();
				connMap.put(cliID, socket);

				// Increment clientNo
				cliID++;

				ta.append("Starting thread for client " + (cliID + 1) +
						" at " + new Date() + '\n');

				// Find the client's host name, and IP address
				InetAddress inetAddress = socket.getInetAddress();
				ta.append("Client " + cliID + "'s host name is "
						+ inetAddress.getHostName() + "\n");
				ta.append("Client " + cliID + "'s IP Address is "
						+ inetAddress.getHostAddress() + "\n");

				// Create and start a new thread for the connection
				new Thread(new HandleAClient(socket, cliID)).start();
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Define the thread class for handling new connection
	class HandleAClient implements Runnable {
		private Socket socket; // A connected socket
		// private int clientNum;

		/** Construct a thread */
		public HandleAClient(Socket socket, int clientNum) {
			this.socket = socket;
			// this.clientNum = clientNum;
		}

		/** Run a thread */
		public void run() {
			try {
				// Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(
						socket.getInputStream());

				// Continuously serve the client
				while (true) {
					// Receive msg from the client
					int msgLen = inputFromClient.readInt();
					byte[] msg = inputFromClient.readNBytes(msgLen);
					System.out.println(new String(msg));

					// broadcast msg to the client
					for (Map.Entry<Integer, Socket> entry : connMap.entrySet()) {
						DataOutputStream outputToClient = new DataOutputStream(
								entry.getValue().getOutputStream());
						String broadcastMsg = "(" + new Date() + ")" + cliID + ": " + new String(msg) + "\n";
						outputToClient.writeInt(broadcastMsg.length());
						outputToClient.writeBytes(broadcastMsg);
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		chatServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatServer.setVisible(true);
	}
}
