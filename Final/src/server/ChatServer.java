package server;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class ChatServer extends JFrame implements Runnable {
	private static int WIDTH = 400;
	private static int HEIGHT = 300;

	// Text area for displaying contents
	JTextArea ta;

	HashMap<String, Socket> connMap = new HashMap<>();
	UserManager dao = new UserManager();

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
			ta.append("Chatroom Server started at "
					+ new Date() + '\n');

			while (true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();
				// Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(
						socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(
						socket.getOutputStream());
				int reqCode = inputFromClient.readInt();
				switch (reqCode) {
					case 0: { // send msg

					}
					case 1: { // login
						int usernameLen = inputFromClient.readInt();
						String username = new String(inputFromClient.readNBytes(usernameLen));
						int passwordLen = inputFromClient.readInt();
						String password = new String(inputFromClient.readNBytes(passwordLen));

						if (!dao.login(username, password)) {
							outputToClient.writeInt(-1);
							ta.append(username + " login failed\n");
						} else {
							outputToClient.writeInt(0);
							ta.append(username + " login success\n");
							connMap.put(username, socket);
							// Create and start a new thread for the connection
							new Thread(new HandleAClient(socket, username)).start();
						}
						break;
					}
					case 2: { // register
						int usernameLen = inputFromClient.readInt();
						String username = new String(inputFromClient.readNBytes(usernameLen));
						int passwordLen = inputFromClient.readInt();
						String password = new String(inputFromClient.readNBytes(passwordLen));

						if (!dao.register(username, password)) {
							outputToClient.writeInt(-1);
							ta.append(username + " register failed\n");
						} else {
							outputToClient.writeInt(0);
							ta.append(username + " register success\n");
						}

						break;
					}
					default: {
						ta.append("invalid code\n");
					}
				}

			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Define the thread class for handling new connection
	class HandleAClient implements Runnable {
		private Socket socket; // A connected socket
		private String username;

		/** Construct a thread */
		public HandleAClient(Socket socket, String username) {
			this.socket = socket;
			this.username = username;
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
					for (Map.Entry<String, Socket> entry : connMap.entrySet()) {
						DataOutputStream outputToClient = new DataOutputStream(
								entry.getValue().getOutputStream());
						String broadcastMsg = "(" + new Date() + ")" + username + ": " + new String(msg) + "\n";
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
