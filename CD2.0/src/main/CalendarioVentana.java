package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classVO.PacientesVO;
import rojeru_san.componentes.RSCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import main.FrmPaciente;
import main.FrmPaciente.eventoCerrar;

public class CalendarioVentana extends javax.swing.JFrame {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	public String txtID;
	public String txtNombre;
	public String txtApellidos;
	public String txtRut;
	public String txtDireccion;
	public String txtTelefono;
	public String txtStatus;
	private JPanel contentPane;
	public static RSCalendar calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarioVentana frame = new CalendarioVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void settxtNombre(String txtNombre) {
		this.txtNombre=txtNombre;
	}
	public void settxtID(String txtID) {
		this.txtID=txtID;
	}
	public void settxtApellidos(String txtApellidos) {
		this.txtApellidos=txtApellidos;
	}
	public void settxtRut(String txtRut) {
		this.txtRut=txtRut;
	}
	public void settxtDireccion(String txtDireccion) {
		this.txtDireccion=txtDireccion;
	}
	public void settxtTelefono(String txtTelefono) {
		this.txtTelefono=txtTelefono;
	}
	public void settxtStatus(String txtStatus) {
		this.txtStatus=txtStatus;
	}
	/**
	 * Create the frame.
	 * @param eventoCerrar 
	 */
	public CalendarioVentana(eventoCerrar eventoCerrar) {
		initComponents(eventoCerrar);
		
	}
	public CalendarioVentana() {
		initComponents();
		
	}
	public static String fechaTexto = "";
	
	private void initComponents(eventoCerrar eventoCerrar) {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 309, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RSCalendar calendar = new RSCalendar();
		calendar.setBorder(null);
		calendar.setBounds(0, 0, 309, 295);
		contentPane.add(calendar);
		calendar.getDatoFecha();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(63, 179, 145));
		panel.setBounds(0, 295, 309, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAplicarFecha = new JLabel("APLICAR FECHA");
		lblAplicarFecha.setBounds(0, 0, 309, 40);
		panel.add(lblAplicarFecha);
		lblAplicarFecha.setForeground(new Color(255, 255, 224));
		lblAplicarFecha.addMouseListener(eventoCerrar);
		lblAplicarFecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(135, 207, 186));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel.setBackground(new Color(63, 179, 145));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(calendar.getDatoFecha() == null) {
					JOptionPane.showMessageDialog(contentPane, "Seleccione una fecha", "Error", JOptionPane.ERROR_MESSAGE);
				}	
				String formatoFecha = "dd/MM/yyyy";
				SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
				fechaTexto = formateador.format(calendar.getDatoFecha());
				FrmPaciente frm = new FrmPaciente();
				frm.settxtNombre(txtNombre);
				frm.settxtApellidos(txtApellidos);
				frm.settxtDireccion(txtDireccion);
				frm.settxtID(txtID);
				frm.settxtNombre(txtNombre);
				frm.settxtRut(txtRut);
				frm.settxtStatus(txtStatus);
				frm.settxtTelefono(txtTelefono);
				frm.setVisible(true);
				setVisible(false);
			}
		});
		
		lblAplicarFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicarFecha.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblAplicarFecha.setBackground(new Color(63, 179, 145));
		calendar.setVisible(true);
	}
	
private void initComponents() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 309, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RSCalendar calendar = new RSCalendar();
		calendar.setBorder(null);
		calendar.setBounds(0, 0, 309, 295);
		contentPane.add(calendar);
		calendar.getDatoFecha();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(63, 179, 145));
		panel.setBounds(0, 295, 309, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAplicarFecha = new JLabel("APLICAR FECHA");
		lblAplicarFecha.setBounds(0, 0, 309, 40);
		panel.add(lblAplicarFecha);
		lblAplicarFecha.setForeground(new Color(255, 255, 224));
		lblAplicarFecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(135, 207, 186));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel.setBackground(new Color(63, 179, 145));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(calendar.getDatoFecha() == null) {
					JOptionPane.showMessageDialog(contentPane, "Seleccione una fecha", "Error", JOptionPane.ERROR_MESSAGE);
				}	
				
				
				
				String formatoFecha = "dd/MM/yyyy";
				SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
				fechaTexto = formateador.format(calendar.getDatoFecha());
				
				setVisible(false);
			}
		});
		lblAplicarFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicarFecha.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblAplicarFecha.setBackground(new Color(63, 179, 145));
		calendar.setVisible(true);
	}
	
}
