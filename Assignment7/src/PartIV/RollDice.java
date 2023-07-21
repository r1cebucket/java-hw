package PartIV;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.util.concurrent.TimeUnit;

public class RollDice extends JFrame {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;

	ImagePanel diceLeft, diceRight;
	JLabel result;

	public RollDice() {
		JPanel dicePanel = new JPanel(new GridLayout(1, 2));
		diceLeft = new ImagePanel(1);
		diceRight = new ImagePanel(1);
		diceLeft.setAlignmentX(SwingConstants.CENTER);
		diceRight.setAlignmentX(SwingConstants.CENTER);
		dicePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));
		MouseListener imgListener = new ImgListener();
		diceLeft.addMouseListener(imgListener);
		diceRight.addMouseListener(imgListener);

		dicePanel.add(diceLeft);
		dicePanel.add(diceRight);

		JPanel rollPanel = new JPanel(new GridLayout(2, 1));
		result = new JLabel("result: 2");
		JButton rollButton = new JButton("roll");

		result.setHorizontalAlignment(SwingConstants.CENTER);
		rollButton.setSize(100, 50);
		rollButton.setHorizontalAlignment(SwingConstants.CENTER);
		rollPanel.setBorder(BorderFactory.createEmptyBorder(0, 150, 20, 150));
		rollPanel.add(result);
		rollPanel.add(rollButton);
		rollButton.addActionListener(buttonListener);

		add(dicePanel, BorderLayout.CENTER);
		add(rollPanel, BorderLayout.SOUTH);

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	ActionListener buttonListener = (e) -> {
		Random rand = new Random();
		for (int i = 0; i < rand.nextInt(5) + 5; i++) {
			diceLeft.setVal(rand.nextInt(5) + 1);
			diceRight.setVal(rand.nextInt(5) + 1);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
		diceLeft.setVal(rand.nextInt(5) + 1);
		diceRight.setVal(rand.nextInt(5) + 1);
		result.setText(String.valueOf(diceLeft.getVal() + diceRight.getVal()));
	};

	public class ImgListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			ImagePanel dice = (ImagePanel) e.getSource();
			Random rand = new Random();
			for (int i = 0; i < rand.nextInt(5) + 5; i++) {
				dice.setVal(rand.nextInt(5) + 1);
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException exc) {
					exc.printStackTrace();
				}
			}
			dice.setVal(rand.nextInt(5) + 1);
			result.setText(String.valueOf(diceLeft.getVal() + diceRight.getVal()));
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
		rollDice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rollDice.setVisible(true);
	}
}
