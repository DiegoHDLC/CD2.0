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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import mantenimientos.Horario_database;
import utils.Boton;
import utils.Label;

public class NuevoHorMedico extends JDialog {

	private final JPanel contentPane = new JPanel();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoHorMedico frame = new NuevoHorMedico(1);
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
	public NuevoHorMedico(int id_medico) {
		setUndecorated(true);
		setBounds(100, 100, 691, 223);
		getContentPane().setLayout(null);
		contentPane.setBounds(0, 0, 705, 269);
		contentPane.setBackground(new Color(33, 44, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane);
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
		
		
		table = new JTable(data,columnNames);
		table.setGridColor(new Color(128, 128, 128));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(33, 44, 61));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x=table.getSelectedRow();
				int y=table.getSelectedColumn();
				if(verificarSeleccion(x,y)==true) {
					if(table.getValueAt(x,y)==null) {
						table.setValueAt("Marcado",x,y);
					}
					else {
						table.setValueAt(null,x,y);
					}
				}
				
			}
		});
		table.setBounds(10, 39, 679, 128);
		contentPane.add(table);
		
		JButton btnNewButton = new Boton(246, 169, 148, 50,"Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ocupados[][]=new boolean[8][7];
				detectarOcupados(ocupados);
				Horario_database.borrarHorarioDeMedico(id_medico);
				Horario_database.nuevoHorario(ocupados, id_medico);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblSeleccioneLosHorarios = new Label(10, 11,14,"Seleccione los horarios que quiere ocupar con un click");
		lblSeleccioneLosHorarios.setBounds(10,11, 400, 22);
		contentPane.add(lblSeleccioneLosHorarios);
	}
	public void detectarOcupados(boolean ocupados[][]) {
		int i=1;
		int j=1;
		while(i<8) {
			j=1;
			while(j<7) {
				if(table.getValueAt(i,j)==null) {
					ocupados[i][j]=false;
				}else {
					ocupados[i][j]=true;
				}
				j++;
			}
			i++;
		}
		
	}
	public boolean verificarSeleccion(int x,int y) {
		if(x==0) {
			if(y==0 || y==1 || y==2 || y==3 || y==4 || y==5 || y==6 ) {
				return false;
			}
		}
		else if(y==0) {
			if(x==1 || x==2 || x==3 || x==4 || x==5 || x==6 || x==7) {
				return false;
			}
		}
		return true;
		
	}
	}


