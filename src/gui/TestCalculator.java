package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestCalculator {
	public static void main(String[] args) {
		JFrame f = new JFrame("¼ÆËãÆ÷");
		int gap = 8;
		f.setSize(342, 272);
		f.setLocation(200, 200);

		f.setLayout(null);

		JPanel p = new JPanel();
		p.setBounds(gap, gap, 310, 215);
		f.add(p);
		p.setLayout(new GridLayout(4,5,gap,gap));

		p.add(new JButton("7"));
		p.add(new JButton("8"));
		p.add(new JButton("9"));
		p.add(new JButton("/"));
		p.add(new JButton("sq"));
		p.add(new JButton("4"));
		p.add(new JButton("5"));
		p.add(new JButton("6"));
		p.add(new JButton("*"));
		p.add(new JButton("%"));
		p.add(new JButton("1"));
		p.add(new JButton("2"));
		p.add(new JButton("3"));
		p.add(new JButton("-"));
		p.add(new JButton("1/x"));
		p.add(new JButton("0"));
		p.add(new JButton("+/-"));
		p.add(new JButton("."));
		p.add(new JButton("+"));
		p.add(new JButton("="));

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
	}
}
