package utils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class CajaTexto extends JTextField {
	
	private static final long serialVersionUID = 1L;

	public CajaTexto(int x, int y,int l, int a) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setCaretColor(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Sitka Small", Font.PLAIN, 14));
		setBackground(new Color(19, 30, 49));
		setBounds(x, y, l, a);
		setColumns(10);
	}
	
}
