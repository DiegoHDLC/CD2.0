package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import classDAO.PacientesDAO;
import classDAO.CitasDAO;
import main.Medico.eventoCerrar;
import utils.Boton;
import utils.CTextoMedico;
import utils.CajaTexto;
import utils.ComboBox;
import utils.Label;

public class BuscaRutMedico extends JDialog {
	static int id_medico;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRut;
	private JComboBox comboHora = new ComboBox(203, 153, 221, 20);
	private JComboBox comboDiaFecha = new ComboBox(328, 125, 40, 23);
	private JComboBox comboMesFecha = new ComboBox(390, 125, 34, 23);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BuscaRutMedico(eventoCerrar eventoCerrar,int id_medico) {
		setUndecorated(true);
		getContentPane().setBackground(new Color(33, 44, 61));
		setBounds(100, 100, 450, 300);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnBuscarPaciente = new Boton(234, 235, 196, 36,"Buscar Paciente");
		btnBuscarPaciente.addActionListener(eventoCerrar);
		btnBuscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] Datos= new String[6];
				String diagnostico=null;
				Datos[3]=txtRut.getText();
				if(PacientesDAO.obtenerDatosConRut(Datos)==true) {
					int diaFecha=Integer.parseInt(((String) comboDiaFecha.getSelectedItem()).trim());
					int mesFecha=Integer.parseInt(((String) comboMesFecha.getSelectedItem()).trim());
					int bloque=comboHora.getSelectedIndex()+1;
					
					diagnostico=CitasDAO.getDiagnostico(id_medico,diaFecha,mesFecha,bloque);
					
					if(diagnostico!=null) {
						Medico med = new Medico(id_medico);
						
						med.rellenarPaciente(Datos,diagnostico,comboDiaFecha.getSelectedItem().toString(),comboMesFecha.getSelectedItem().toString(),comboHora.getSelectedItem().toString());
						med.setVisible(true);
						dispose();
						
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "Este paciente no tiene una cita","Error",JOptionPane.ERROR_MESSAGE);
					}
			
				}
				else {JOptionPane.showMessageDialog(getContentPane(), "Paciente no registrado","Error",JOptionPane.ERROR_MESSAGE);}
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnBuscarPaciente);
		
		JLabel lblIngreseElRut = new JLabel("Ingrese el Rut del paciente");
		lblIngreseElRut.setForeground(new Color(255, 255, 255));
		lblIngreseElRut.setFont(new Font("Sitka Small", Font.ITALIC, 14));
		lblIngreseElRut.setBounds(10, 91, 189, 14);
		getContentPane().add(lblIngreseElRut);
		
		txtRut = new CTextoMedico(203, 83, 221, 31,"00.000.000-0");
		getContentPane().add(txtRut);
		
		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha");
		lblIngreseLaFecha.setForeground(new Color(255, 255, 255));
		lblIngreseLaFecha.setFont(new Font("Sitka Small", Font.ITALIC, 14));
		lblIngreseLaFecha.setBounds(10, 116, 189, 31);
		getContentPane().add(lblIngreseLaFecha);
		
		JLabel label_1 = new JLabel("   /");
		label_1.setFont(new Font("Sitka Small", Font.ITALIC, 26));
		label_1.setBounds(349, 125, 51, 22);
		getContentPane().add(label_1);
		
		JLabel lblEscojaLaHora = new Label(10, 158,14,"Escoja la hora de la cita");
		getContentPane().add(lblEscojaLaHora);
		
		comboHora.setModel(new DefaultComboBoxModel(new String[] {"8:00-9:30", "9:45-11:15", "11:30-13:00", "14:30-16:00", "16:15-17:45", "18:00-19:30", "19:45-21:15"}));
		getContentPane().add(comboHora);
		
		
		comboDiaFecha.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		getContentPane().add(comboDiaFecha);
		
		
		comboMesFecha.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		getContentPane().add(comboMesFecha);
		
		JComboBox comboDia = new ComboBox(203, 124, 115, 23);
		comboDia.setModel(new DefaultComboBoxModel(new String[] {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado"}));
		getContentPane().add(comboDia);
		
		JLabel lblBuscarDatosY = new JLabel("Buscar datos y diagnosticos del paciente");
		lblBuscarDatosY.setForeground(new Color(255, 255, 255));
		lblBuscarDatosY.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblBuscarDatosY.setBounds(8, 31, 354, 23);
		getContentPane().add(lblBuscarDatosY);
		
		
		JButton button = new Boton(19,235,196,36,"Regresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico med = new Medico(id_medico);
				med.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(button);
		
	}
}
