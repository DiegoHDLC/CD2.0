package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class CTextoSecretaria extends CajaTexto {
	public CTextoSecretaria(int x,int y,int l, int a) {
		super(x,y,l,a);
		setBorder(null);
		setName("");
		setEditable(true);
		setBounds(x, y, l, a);
	}
}
