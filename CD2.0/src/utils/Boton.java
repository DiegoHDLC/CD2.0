package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Boton extends JButton{
	public Boton(int x,int y,int l, int a, String texto) {
		setText(texto);
		setForeground(Color.WHITE);
		setFont(new Font("Sitka Small", Font.PLAIN, 11));
		setBackground(new Color(19, 30, 49));
		setBounds(x, y, l, a);
	}
}
