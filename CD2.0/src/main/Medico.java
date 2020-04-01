package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classDAO.CitasDAO;
import rspanelgradiente.RSPanelGradiente;
import utils.Boton;
import utils.CajaTexto;
import utils.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rojeru_san.componentes.RSDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.beans.PropertyChangeEvent;
import java.awt.Rectangle;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.DefaultComboBoxModel;
import rojerusan.RSComboMetro;
import mantenimientos.Dias;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.TextArea;
import java.awt.event.KeyAdapter;
import com.jgoodies.forms.factories.DefaultComponentFactory;


public class Medico extends javax.swing.JFrame {
	public JFrame FrameMedico = (JFrame) SwingUtilities.getWindowAncestor(this);
	private static final long serialVersionUID = 1L;
	public Medico(int idMedico){
		this.idMedicos=idMedico;
		
		initComponents();
		setLocationRelativeTo(null);
		txtNombre.grabFocus();
	}
	
	public class eventoCerrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}

        
    }
	
	
	@SuppressWarnings("unchecked")
	private void initComponents() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 540);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(1,1));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel barra = new JPanel();
		barra.setBackground(new Color(46, 118, 121));
		barra.setBounds(0, 0, 497, 32);
		contentPane.add(barra);
		
		
		JLabel lblCerrar = new JLabel("");
		lblCerrar.setBounds(465, 0, 32, 32);
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_close_window_32px_1.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrar.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_close_window_32px.png")));
			}
		});
		barra.setLayout(null);
		lblCerrar.setIcon(new ImageIcon(Medico.class.getResource("/Image/icons8_close_window_32px.png")));
		barra.add(lblCerrar);

		
		JLabel lblMinimizar = new JLabel("");
		lblMinimizar.setBounds(436, 0, 32, 32);
		lblMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Image/minimizar_blanco_32px.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Image/minimizar_azul_oscuro_32px.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setState(JFrame.ICONIFIED);
			}
		});
		lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Image/minimizar_azul_oscuro_32px.png")));
		barra.add(lblMinimizar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(46, 118, 121));
		menuBar.setBounds(400, 0, 41, 34);
		barra.add(menuBar);
		
		JMenu menu = new JMenu("");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				menu.setIcon(new ImageIcon(Medico.class.getResource("/Image/icons8_menu_32px_2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu.setIcon(new ImageIcon(Medico.class.getResource("/Image/icons8_menu_32px_1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				menu.setIcon(new ImageIcon(Medico.class.getResource("/Image/icons8_menu_32px_3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				menu.setIcon(new ImageIcon(Medico.class.getResource("/Image/icons8_menu_32px_2.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		menu.setContentAreaFilled(false);
		menu.setBorder(null);
		menu.setBackground(new Color(33, 44, 61));
		menu.setIcon(new ImageIcon(Medico.class.getResource("/Image/icons8_menu_32px_1.png")));
		menuBar.add(menu);
		
		JMenuItem btnCerrarSesion = new JMenuItem("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		menu.add(btnCerrarSesion);
		
		btnCerrarSesion.setOpaque(true);
		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setIcon(new ImageIcon(Medico.class.getResource("/Image/icons8_logout_rounded_left_20px.png")));
		btnCerrarSesion.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBackground(new Color(33, 44, 61));

		panelFRM.setVisible(true);
		panelFRM.setBounds(0, 31, 497, 509);
		contentPane.add(panelFRM);
		panelFRM.setColorSecundario(new Color(33, 44, 61));
		panelFRM.setColorPrimario(new Color(66, 169, 174));
		panelFRM.setLayout(null);
		
		JButton btnEditarHorario = new Boton(23,0,145,25,"Editar Horario");
		btnEditarHorario.setSize(119, 25);
		btnEditarHorario.setLocation(0, 0);
		
		btnEditarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(idMedicos);
				EditarHorarioMedico horario = new EditarHorarioMedico(idMedicos);
				horario.setVisible(true);
			}
		});
		panelFRM.add(btnEditarHorario);
		
		
		JButton btnBuscarPaciente = new Boton(162, 0, 145, 25,"Buscar Paciente");
		btnBuscarPaciente.setSize(126, 25);
		btnBuscarPaciente.setLocation(117, 0);
		btnBuscarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscaRutMedico buscar = new BuscaRutMedico(new eventoCerrar(),idMedicos);
				buscar.setVisible(true);
			}
		});
		
		panelFRM.add(btnBuscarPaciente);
		
		JButton btnMostrarHorario = new Boton(334,0,145,25,"Mostrar Horario");
		btnMostrarHorario.setSize(137, 25);
		btnMostrarHorario.setLocation(242, 0);
		btnMostrarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(idMedicos);
				HorarioMedico horario = new HorarioMedico(idMedicos);
				horario.setVisible(true);
			}
		});
		panelFRM.add(btnMostrarHorario);
		
		txtNombre = new CajaTexto(23,58,216, 28);
		txtNombre.requestFocus();
		panelFRM.add(txtNombre);
		
		txtApellido = new CajaTexto(24,125,216, 28);
		panelFRM.add(txtApellido);
		
		txtNacimiento = new CajaTexto(24, 193,216, 28);
		panelFRM.add(txtNacimiento);
		
		txtRut = new CajaTexto(260,57,216, 28);
		panelFRM.add(txtRut);
		
		txtDireccion = new CajaTexto(260,125,216, 28);
		panelFRM.add(txtDireccion);
		
		txtTelefono = new CajaTexto(261, 193,216, 28);
		panelFRM.add(txtTelefono);
		txtDiagnostico.setForeground(new Color(255, 255, 255));
		txtDiagnostico.setBackground(new Color(19, 30, 49));
		
		txtDiagnostico.setText("Presione buscar Paciente...");
		txtDiagnostico.setBounds(23, 284, 233, 149);
		panelFRM.add(txtDiagnostico);
		
		Label lblApellido = new Label(23,96,14,"Apellido");
		panelFRM.add(lblApellido);
		
		JLabel lblNacimiento = new Label(23,164,14,"Nacimiento");
		panelFRM.add(lblNacimiento);
		
		JLabel lblNombre = new Label(23,28,14,"Nombre");
		panelFRM.add(lblNombre);
		
		JLabel lblRut = new Label(259,28,14,"Rut");
		panelFRM.add(lblRut);
		
		JLabel lblDireccion = new Label(259,96,14,"Direccion");
		panelFRM.add(lblDireccion);
		
		JLabel lblTelefono = new Label(260,164,14,"Telefono");
		panelFRM.add(lblTelefono);
		
		JLabel lblDiagnosticoDelPaciente = new Label(20,262,14,"Diagnostico del Paciente");
		panelFRM.add(lblDiagnosticoDelPaciente);
		
		txtDia = new CajaTexto(260,284,216, 28);
		panelFRM.add(txtDia);
		
		JLabel lblDiaDeLa = new Label(260,262,14,"Dia de la Cita");
		panelFRM.add(lblDiaDeLa);
		
		txtMes = new CajaTexto(261,344,216, 28);
		panelFRM.add(txtMes);
		
		JLabel lblMesDeLa = new Label(260,323,14,"Mes de la Cita");
		panelFRM.add(lblMesDeLa);
		
		txtHora = new CajaTexto(260,405,216, 28);
		panelFRM.add(txtHora);
		
		JLabel lblHoraDeLa = new Label(260,383,14,"Hora de la cita");
		panelFRM.add(lblHoraDeLa);
		
		JButton btnActualizarD = new Boton(23, 458, 216, 41,"Actualizar Diagnostico");
		btnActualizarD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarDatos(txtNombre.getText(),
						txtApellido.getText(),
						txtNacimiento.getText(),
						txtRut.getText(),
						txtDireccion.getText(),
						txtTelefono.getText(),
						txtDiagnostico.getText(),
						txtDia.getText(),
						txtMes.getText(),
						txtHora.getText())==true) {
					int bloque=Dias.fechaANumero(txtHora.getText());
					CitasDAO.setDiagnostico(idMedicos, txtDia.getText(), txtMes.getText(), bloque, txtDiagnostico.getText());
					JOptionPane.showMessageDialog(getContentPane(), "Diagnostico actualizado","OK",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "Primero busque un paciente","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelFRM.add(btnActualizarD);
		
		
		
		
		JButton btnSolicitud = new Boton(242, 458, 233, 41,"Eliminar Cita");
		btnSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificarDatos(txtNombre.getText(),
						txtApellido.getText(),
						txtNacimiento.getText(),
						txtRut.getText(),
						txtDireccion.getText(),
						txtTelefono.getText(),
						txtDiagnostico.getText(),
						txtDia.getText(),
						txtMes.getText(),
						txtHora.getText())==true) {
					int bloque=Dias.fechaANumero(txtHora.getText());
					CitasDAO.eliminarCita(idMedicos, txtDia.getText(), txtMes.getText(), bloque);
					JOptionPane.showMessageDialog(getContentPane(), "Cita eliminada","OK",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "Primero busque un paciente","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelFRM.add(btnSolicitud);		
		
		Boton btnCitas = new Boton(162, 0, 145, 25, "Mostrar Citas");
		btnCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarCitas citas= new MostrarCitas(idMedicos);
				citas.setVisible(true);
			}
		});
		btnCitas.setBounds(378, 0, 119, 25);
		panelFRM.add(btnCitas);
	}
	
	public boolean verificarDatos(String nombre,String apellido,String nacimiento,String rut,String direccion,String telefono,String diagnostico,String dia,String mes,String hora) {
		if(nombre.equals("Presione buscar Paciente...") ||
				apellido.equals("Presione buscar Paciente...")||
				nacimiento.equals("Presione buscar Paciente...")||
				rut.equals("Presione buscar Paciente...")||
				direccion.equals("Presione buscar Paciente...")||
				telefono.equals("Presione buscar Paciente...")||
				diagnostico.equals("Presione buscar Paciente...")||
				dia.equals("Presione buscar Paciente...")||
				mes.equals("Presione buscar Paciente...")||
				hora.equals("Presione buscar Paciente...")) {
			return false;
		}
		return true;
	}
	public void rellenarPaciente(String datos[],String diagnostico,String dia,String mes,String hora) {
		
		
		txtNombre.setText(datos[0]);
		txtApellido.setText(datos[1]);
		txtNacimiento.setText(datos[2]);
		txtRut.setText(datos[3]);
		txtDireccion.setText(datos[4]);
		txtTelefono.setText(datos[5]);
		txtDiagnostico.setText(diagnostico);
		txtDia.setText(dia);
		txtMes.setText(mes);
		txtHora.setText(hora);
		
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medico frame = new Medico(1);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	TextArea txtDiagnostico = new TextArea();
	private JLabel lblDiagnosticoDelPaciente = new JLabel("Diagnostico del Paciente");
	private JTextField txtTelefono = new JTextField();
	private int idMedicos;
	private javax.swing.JComboBox list_pacientes;
	private JPanel contentPane;
	RSPanelGradiente panelFRM = new RSPanelGradiente();
	JPanel pestañaHorarios = new JPanel();
	RSComboMetro comboEspecial = new RSComboMetro();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNacimiento;
	private JTextField txtRut;
	private JTextField txtDireccion;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtHora;
}
