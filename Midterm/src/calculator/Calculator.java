package calculator;

import java.util.HashMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JButton;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;

public class Calculator extends JFrame {
	private Double firstTerm;
	private Double secondTerm;
	private String operator;
	private int current = 1;

	private JTextArea textArea;
	private HashMap<String, JButton> buttons;

	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;

	public Calculator() {
		// Visualization Panel
		textArea = new JTextArea(1, 2);
		textArea.setFont(new Font("monospaced", Font.PLAIN, 32));

		JPanel visualPanel = new JPanel();
		visualPanel.setLayout(new BorderLayout());
		visualPanel.add(textArea);
		visualPanel.setPreferredSize(new Dimension(280, 50));
		visualPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		add(visualPanel, BorderLayout.NORTH);

		// Number Panel
		String[] labels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "+/-", "+" };
		buttons = new HashMap<String, JButton>();
		for (String label : labels) {
			buttons.put(label, new JButton(label));
			buttons.get(label).addActionListener(buttonListener);
		}

		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(4, 4));
		numberPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		for (String label : labels) {
			numberPanel.add(buttons.get(label));
		}
		add(numberPanel, BorderLayout.CENTER);

		// Control Panel
		JButton buttonClear = new JButton("C");
		JButton buttonEquals = new JButton("=");
		buttons.put("C", buttonClear);
		buttons.put("=", buttonEquals);
		buttonClear.addActionListener(buttonListener);
		buttonEquals.addActionListener(buttonListener);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 2));
		controlPanel.add(buttonClear);
		controlPanel.add(buttonEquals);
		controlPanel.setPreferredSize(new Dimension(280, 60));
		controlPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		add(controlPanel, BorderLayout.SOUTH);

		// Construct menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	/**
	 * Creates the File menu.
	 * 
	 * @return the menu
	 */
	public JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createFileExitItem());
		return menu;
	}

	/**
	 * Creates the File->Exit menu item and sets its action listener.
	 * 
	 * @return the menu item
	 */
	public JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		ActionListener listener = new MenuItemListener();
		item.addActionListener(listener);
		return item;
	}

	ActionListener buttonListener = (e) -> {
		String label = e.getActionCommand();
		if (label.equals("=")) {
			if (current == 1 || current == 3) {
				current = 1;
				return;
			}
			if (current == 2 && textArea.getText().equals("")) {
				textArea.setText(firstTerm + "");
				current = 1;
				return;
			}
			secondTerm = Double.parseDouble(textArea.getText());
			current = 3;
			flushResult();
		} else if (label.equals("+") || label.equals("-") || label.equals("*") || label.equals("/")) {
			if (textArea.getText().equals("")) {
				return;
			}
			if (current == 2) {
				secondTerm = Double.parseDouble(textArea.getText());
				flushResult();
				current = 3;
				firstTerm = Double.parseDouble(textArea.getText());
				operator = label;
				return;
			}
			firstTerm = Double.parseDouble(textArea.getText());
			operator = label;
			textArea.setText("");
			current = 2;
		} else if (label.equals("+/-")) {
			String numStr = textArea.getText();
			if (numStr.startsWith("-")) {
				numStr.replace("-", "");
				textArea.setText(numStr);
			} else {
				textArea.setText("-" + numStr);
			}
		} else if (label.equals("C")) {
			textArea.setText("");
			if (current == 2) {
				buttons.get("C").setText("AC");
			}
			if (current == 3) {
				current = 1;
			}
		} else if (label.equals("AC")) {
			textArea.setText("");
			current = 1;
			buttons.get("C").setText("C");
		} else {
			if (current == 3) {
				current = 2;
				textArea.setText("");
			}
			buttons.get("C").setText("C");
			textArea.setText(textArea.getText() + label);
		}
	};

	private void flushResult() {
		switch (operator) {
			case "+":
				textArea.setText(firstTerm + secondTerm + "");
				break;
			case "-":
				textArea.setText(firstTerm - secondTerm + "");
				break;
			case "*":
				textArea.setText(firstTerm * secondTerm + "");
				break;
			case "/":
				if (secondTerm != 0)
					textArea.setText(firstTerm / secondTerm + "");
				else
					textArea.setText("inf");
				break;
		}
	}

	public static void main(String[] args) {
		JFrame calculator = new Calculator();
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setVisible(true);
	}

}