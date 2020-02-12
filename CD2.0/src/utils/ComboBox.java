package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class ComboBox extends JComboBox{
	public ComboBox(int x, int y, int l, int a) {
		setBorder(null);
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Sitka Small", Font.BOLD, 11));
		setBackground(new Color(19, 30, 49));
		setBounds(x,y,l,a);
		
	}
}
