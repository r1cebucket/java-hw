package client;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatClient extends JFrame implements Runnable {

	private static int WIDTH = 800;
	private static int HEIGHT = 600;

	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	JTextField inputField = null;
	JTextArea textArea = null;
	Socket socket = null;
	JButton sendButton;
	Thread msgGetter;

	public ChatClient(Socket socket) {
		super("Chat Client");
		this.socket = socket;
		this.setLayout(new BorderLayout());
		this.setSize(WIDTH, HEIGHT);

		inputField = new JTextField(5);
		inputField.addActionListener(new TextFieldListener());

		textArea = new JTextArea(30, 30);
		this.add(textArea, BorderLayout.NORTH);

		JPanel controlPanel = new JPanel();
		sendButton = new JButton("Send");
		controlPanel.add(sendButton);

		JPanel operationPanel = new JPanel(new GridLayout(2, 1));
		operationPanel.add(inputField);
		operationPanel.add(controlPanel);
		this.add(operationPanel, BorderLayout.SOUTH);

		sendButton.addActionListener(new TextFieldListener());
		msgGetter = new Thread(this);
		msgGetter.start();
	}

	class TextFieldListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// get io stream
			try {
				// Create an output stream to send data to the server
				toServer = new DataOutputStream(socket.getOutputStream());
			} catch (IOException ex) {
				textArea.append(ex.toString() + '\n');
			}

			try {
				String msg = inputField.getText().trim();
				inputField.setText("");

				toServer.writeInt(msg.length());
				toServer.writeBytes(msg);
				toServer.flush();
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}

	public void run() {
		// get msg from server
		try {
			// Create an input stream to receive data from the server
			fromServer = new DataInputStream(socket.getInputStream());
			// Create an output stream to send data to the server
			toServer = new DataOutputStream(socket.getOutputStream());
			while (true) {
				int msgLen = fromServer.readInt();
				byte[] msg = fromServer.readNBytes(msgLen);
				// System.out.println("broadcast msg : " + msg + "\n");
				textArea.append(new String(msg));
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
