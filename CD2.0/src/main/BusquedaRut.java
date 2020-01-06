package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import rojerusan.RSButtonMetro;
import rojerusan.RSButtonPane;
import app.bolivia.swing.JCTextField;
import javax.swing.JButton;

public class BusquedaRut extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaRut frame = new BusquedaRut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BusquedaRut() {
		initComponents();
		
	}
	
	public void initComponents() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(33, 44, 61));
		panel.setBounds(0, 0, 450, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCTextField txtRut = new JCTextField();
		txtRut.setBounds(80, 96, 270, 48);
		panel.add(txtRut);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(261, 177, 89, 23);
		panel.add(btnBuscar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(81, 177, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblIngreseRut = new JLabel("INGRESE RUT");
		lblIngreseRut.setForeground(new Color(255, 255, 255));
		lblIngreseRut.setBounds(80, 52, 66, 14);
		panel.add(lblIngreseRut);
	}
}
