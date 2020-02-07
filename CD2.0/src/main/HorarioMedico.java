package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.MySQLConexion;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HorarioMedico extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
	public HorarioMedico(int id_medico) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 211);
		contentPane = new JPanel();
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
		buscarDisponible(ocupadosXY,id_medico,max);
		int i=0;
		while(i<max[0]) {
			data[ocupadosXY[0][i]][ocupadosXY[1][i]]="Disponible";
			i++;
		}
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnNewButton.setSelectedIcon(new ImageIcon(HorarioMedico.class.getResource("/Image/icons8_checkmark_yes_64px_3.png")));
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(66, 169, 174));
		btnNewButton.setIcon(new ImageIcon(HorarioMedico.class.getResource("/Image/icons8_checkmark_yes_64px_2.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(244, 153, 148, 50);
		contentPane.add(btnNewButton);
				
		table = new JTable(data,columnNames);
		table.setGridColor(new Color(255, 255, 255));
		table.setForeground(new Color(255, 255, 255));
		table.setFont(new Font("Sitka Small", Font.BOLD, 13));
		table.setBackground(new Color(66, 169, 174));
		table.setBounds(0, 0, 695, 211);
		contentPane.add(table);
	}
	public void buscarDisponible(int ocupadosXY[][],int id_medico,int max[]) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		int nEspecialidad=-1;
		
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			
			String sql = "SELECT * FROM horarios WHERE id_medico="+id_medico;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int i=0;
			int j=0;
			while(rs.next()) {// y los añado al combo box
				if(rs.getString(3).equals("8:00-9:30")) {
					j=1;
				}
				else if(rs.getString(3).equals("9:45-11:15")) {
					j=2;
				}
				else if(rs.getString(3).equals("11:30-13:00")) {
					j=3;
				}
				else if(rs.getString(3).equals("14:30-16:00")) {
					j=4;
				}
				else if(rs.getString(3).equals("16:15-17:45")) {
					j=5;
				}
				else if(rs.getString(3).equals("18:00-19:30")) {
					j=6;
				}
				else if(rs.getString(3).equals("19:45-21:15")) {
					j=7;
				}
				ocupadosXY[0][i]=j;
				ocupadosXY[1][i]=rs.getInt(2);
				i++;
			}
			max[0]=i;
			ps.close();
			rs.close();
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
	}
}
