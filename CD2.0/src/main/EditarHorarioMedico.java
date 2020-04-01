package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import classDAO.HorariosDAO;
import utils.Boton;
import utils.MySQLConexion;

public class EditarHorarioMedico extends JFrame{

	private JPanel contentPane;
	private JTable tablaHorario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HorarioMedico frame = new HorarioMedico(17);
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
	public EditarHorarioMedico(int id_medico) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 209);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 44, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columnNames = {"Hora","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
		
		
		Object[][] data = new Object[8][7];
		data[0][0]="Hora";
		data[0][1]="Lunes";
		data[0][2]="Martes";
		data[0][3]="Miercoles";
		data[0][4]="Jueves";
		data[0][5]="Viernes";
		data[0][6]="Sabado";
		data[1][0]="8:00-9:30";
		data[2][0]="9:45-11:15";
		data[3][0]="11:30-13:00";
		data[4][0]="14:30-16:00";
		data[5][0]="16:15-17:45";
		data[6][0]="18:00-19:30";
		data[7][0]="19:45-21:15";
		
		int[][] ocupadosXY = new int[2][100];
		int[] max = new int[1];
		HorariosDAO.buscarCitaDisponible(ocupadosXY,id_medico,max);
		int i=0;
		while(i<max[0]) {
			data[ocupadosXY[0][i]][ocupadosXY[1][i]]="Disponible";
			i++;
		}
				
		tablaHorario = new JTable(data,columnNames);
		tablaHorario.setGridColor(new Color(128, 128, 128));
		tablaHorario.setForeground(new Color(255, 255, 255));
		tablaHorario.setBackground(new Color(33, 44, 61));
		tablaHorario.setBounds(0, 11, 679, 128);
		contentPane.add(tablaHorario);
		
		JButton btnNewButton = new Boton(244, 153, 148, 50,"Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);
	}
	
}
