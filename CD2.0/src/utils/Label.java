package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
	public Label(int x, int y, int tamaño ,String texto) {
		setText(texto);
		setForeground(Color.WHITE);
		setFont(new Font("Sitka Small", Font.PLAIN, tamaño));
		setBounds(x, y, 300, 22);
	}
}
