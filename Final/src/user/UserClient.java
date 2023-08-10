package user;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserClient extends JFrame {
    private static int WIDTH = 300;
    private static int HEIGHT = 200;

    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    JTextField usernameField = null;
    JTextField passwordField = null;
    JLabel notice = null;
    Socket socket = null;
    JButton loginButton;
    JButton registerButton;
    Thread msgGetter;

    public UserClient() {
        super("Login Client");
        this.setLayout(new BorderLayout());
        this.setSize(WIDTH, HEIGHT);

        notice = new JLabel("Welcome to chatroom");
        this.add(notice, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(4, 1));
        usernameField = new JTextField(5);
        passwordField = new JTextField(5);
        inputPanel.add(new JLabel("username"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("password"));
        inputPanel.add(passwordField);
        this.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener((e) -> {
            try {
                socket = new Socket("localhost", 9898);

                // Create an input stream to receive data from the server
                fromServer = new DataInputStream(socket.getInputStream());
                // Create an output stream to send data to the server
                toServer = new DataOutputStream(socket.getOutputStream());

                String type = "login";
                toServer.writeInt(type.length());
                toServer.writeBytes(type);

                String username = usernameField.getText().trim();
                toServer.writeInt(username.length());
                toServer.writeBytes(username);

                String password = passwordField.getText().trim();
                toServer.writeInt(password.length());
                toServer.writeBytes(password);

                int respCode = fromServer.readInt();
                switch (respCode) {
                    case 0: { // success

                    }
                    default: { // failed
                    }
                }
            } catch (Exception e1) {
                System.err.println("error");
            }
        });

        loginButton.addActionListener((e) -> {
            try {
                socket = new Socket("localhost", 9898);

                // Create an input stream to receive data from the server
                fromServer = new DataInputStream(socket.getInputStream());
                // Create an output stream to send data to the server
                toServer = new DataOutputStream(socket.getOutputStream());

                int reqCode = 1; // login req
                toServer.writeInt(reqCode);

                String username = usernameField.getText().trim();
                toServer.writeInt(username.length());
                toServer.writeBytes(username);

                String password = passwordField.getText().trim();
                toServer.writeInt(password.length());
                toServer.writeBytes(password);
            } catch (Exception e1) {
                System.err.println("error");
            }
        });
        // openButton.addActionListener(new OpenConnectionListener());
        // msgGetter = new Thread(this);
    }

    // class OpenConnectionListener implements ActionListener {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // try {
    // socket = new Socket("localhost", 9898);
    // textArea.append("connected\n");
    // msgGetter.start();
    // } catch (IOException e1) {
    // e1.printStackTrace();
    // textArea.append("connection Failure\n");
    // }
    // }

    // }

    // class TextFieldListener implements ActionListener {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // // get io stream
    // try {
    // // Create an output stream to send data to the server
    // toServer = new DataOutputStream(socket.getOutputStream());
    // } catch (IOException ex) {
    // textArea.append(ex.toString() + '\n');
    // }

    // try {
    // String msg = usernameField.getText().trim();

    // toServer.writeInt(msg.length());
    // toServer.writeBytes(msg);
    // toServer.flush();
    // } catch (IOException ex) {
    // System.err.println(ex);
    // }
    // }
    // }

    // public void run() {
    // // get msg from server
    // try {
    // // Create an input stream to receive data from the server
    // fromServer = new DataInputStream(socket.getInputStream());
    // // Create an output stream to send data to the server
    // toServer = new DataOutputStream(socket.getOutputStream());
    // while (true) {
    // int msgLen = fromServer.readInt();
    // byte[] msg = fromServer.readNBytes(msgLen);
    // textArea.append(new String(msg));
    // }

    // } catch (IOException ex) {
    // ex.printStackTrace();
    // }
    // }

    public static void main(String[] args) {
        UserClient loginClient = new UserClient();
        loginClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginClient.setVisible(true);
    }

}