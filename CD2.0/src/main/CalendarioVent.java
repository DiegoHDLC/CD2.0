package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import main.FrmPaciente.eventoCerrar;
import rojeru_san.componentes.RSCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CalendarioVent extends JDialog {

	private JPanel contentPanel = new JPanel();
	public static String fechaTexto = "";
	public String txtID;
	public String txtNombre;
	public String txtApellidos;
	public String txtRut;
	public String txtDireccion;
	public String txtTelefono;
	public String txtStatus;
	public static RSCalendar calendar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CalendarioVent dialog = new CalendarioVent();
			dialog.setModal(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
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
	
	public CalendarioVent(eventoCerrar eventoCerrar) {
		initComponents(eventoCerrar);
		
	}
	public CalendarioVent() {
		
	}
	private void initComponents(eventoCerrar eventoCerrar) {
	
		setUndecorated(true);
		setBounds(400, 400, 309, 335);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
	
		
		RSCalendar calendar = new RSCalendar();
		calendar.setBorder(null);
		calendar.setBounds(0, 0, 309, 295);
		contentPanel.add(calendar);
		calendar.getDatoFecha();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(63, 179, 145));
		panel.setBounds(0, 295, 309, 40);
		contentPanel.add(panel);
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
						
						FrmPaciente frm = new FrmPaciente();
						frm.settxtNombre(txtNombre);
						frm.settxtApellidos(txtApellidos);
						frm.settxtDireccion(txtDireccion);
						frm.settxtID(txtID);
						frm.settxtNombre(txtNombre);
						frm.settxtRut(txtRut);
						frm.settxtStatus(txtStatus);
						frm.settxtTelefono(txtTelefono);
						//FrmPaciente.calendario.setVisible(false);
						frm.setVisible(true);
						JOptionPane.showMessageDialog(contentPanel, "Seleccione una fecha", "Error", JOptionPane.ERROR_MESSAGE);
						dispose();
					}else {
					
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
					//FrmPaciente.calendario.setVisible(true);
					frm.setVisible(true);
					dispose();
					
					}
				}
			
		});
		lblAplicarFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicarFecha.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblAplicarFecha.setBackground(new Color(63, 179, 145));
		calendar.setVisible(true);
	}
	
}