package client;

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

public class UserClient extends JFrame {
    private static int WIDTH = 400;
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

        registerButton.addActionListener((e) -> {
            try {
                socket = new Socket("localhost", 9898);

                // Create an input stream to receive data from the server
                fromServer = new DataInputStream(socket.getInputStream());
                // Create an output stream to send data to the server
                toServer = new DataOutputStream(socket.getOutputStream());

                int reqCode = 2; // register req
                toServer.writeInt(reqCode);

                String username = usernameField.getText().trim();
                toServer.writeInt(username.length());
                toServer.writeBytes(username);

                String password = passwordField.getText().trim();
                toServer.writeInt(password.length());
                toServer.writeBytes(password);

                int respCode = fromServer.readInt();
                switch (respCode) {
                    case 0: { // success
                        notice.setText("register successfully");
                        break;
                    }
                    default: { // failed
                        notice.setText(respCode + ": register failed, please try to user another username");
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

                int respCode = fromServer.readInt();
                switch (respCode) {
                    case 0: { // success
                        notice.setText("login successfully");

                        ChatClient chatClient = new ChatClient();
                        chatClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        chatClient.setVisible(true);
                        break;
                    }
                    default: { // failed
                        notice.setText(reqCode + ": login failed, the username or password is incorrect");
                    }
                }
            } catch (Exception e1) {
                System.err.println("error");
            }
        });
    }

    public static void main(String[] args) {
        UserClient loginClient = new UserClient();
        loginClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginClient.setVisible(true);
    }

}