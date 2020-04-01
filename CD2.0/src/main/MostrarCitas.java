package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import classDAO.CitasDAO;
import utils.Boton;
import utils.Label;
import java.awt.Panel;
import java.awt.List;
import java.awt.TextArea;
import java.awt.ScrollPane;

public class MostrarCitas extends JDialog {

	private final JPanel contentPane = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarCitas frame = new MostrarCitas(93);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public MostrarCitas(int id_medico) {
		setUndecorated(true);
		setBounds(200, 100, 629, 500);
		getContentPane().setLayout(null);
		contentPane.setBounds(0, 0, 629, 500);
		contentPane.setBackground(new Color(33, 44, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new Boton(246, 169, 148, 50,"Aceptar");
		btnNewButton.setLocation(244, 439);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblSeleccioneLosHorarios = new Label(10, 11,14,"Lista de Citas");
		lblSeleccioneLosHorarios.setBounds(10,11, 400, 22);
		contentPane.add(lblSeleccioneLosHorarios);
		
		
		JList listFechas = new JList();
		listFechas.setBounds(1, 1, 298, 98);
		listFechas.setForeground(new Color(255, 255, 255));
		listFechas.setBorder(null);
		listFechas.setBackground(new Color(19, 30, 49));
		contentPane.add(listFechas);
		
		listFechas.setLayoutOrientation(JList.VERTICAL);
		JScrollPane scrollbar = new JScrollPane(listFechas);
		scrollbar.setBounds(50, 50, 500, 350);
		scrollbar.setBackground(new Color(0, 255, 255));
		contentPane.add(scrollbar);
		
		Object[] fechas = new Object[500];
		CitasDAO.guardarCitas(fechas,id_medico);
		listFechas.setListData(fechas);
		
		
		
		
		
	}
}


