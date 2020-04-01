package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Boton;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AcercaDe dialog = new AcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(33, 44, 61));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		JButton btnNewButton = new Boton(201, 368, 113, 38,"Salir");
		btnNewButton.setText("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(351, 266, 89, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Centro Dental");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel.setBounds(77, 47, 171, 29);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Universidad de La Serena");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(258, 53, 180, 20);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SISTEMA PARA LA ADMINISTRACI\u00D3N DE CENTRO DENTAL ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(34, 75, 396, 19);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Autores:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(68, 132, 60, 20);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Diego Herrera y Ricardo Neyra");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(161, 132, 217, 20);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nivel:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(68, 157, 42, 20);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cuarto Ingenier\u00EDa en Computaci\u00F3n");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(161, 156, 242, 20);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Asignatura:");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(68, 182, 82, 20);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Programaci\u00F3n Orientada a Objetos");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(161, 181, 242, 20);
		contentPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Profesor:");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(68, 207, 65, 20);
		contentPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Eric Jeltsch");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(161, 207, 80, 20);
		contentPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(AcercaDe.class.getResource("/Image/icons8_clinic_64px.png")));
		lblNewLabel_11.setBounds(10, 11, 64, 64);
		contentPanel.add(lblNewLabel_11);
	}
}
