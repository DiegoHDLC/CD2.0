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

public class CalendarioVentana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public RSCalendar calendar;

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

	/**
	 * Create the frame.
	 */
	public CalendarioVentana() {
		initComponents();
		
	}
	
	protected void initComponents() {
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
				PacientesVO pac = new PacientesVO();
				FrmPaciente frm = new FrmPaciente();
				//JTextField txtFecha = new JTextField();
				
				//PacientesVO pac = new PacientesVO();
				if(calendar.getDatoFecha() == null) {
					JOptionPane.showMessageDialog(contentPane, "Seleccione una fecha", "Error", JOptionPane.ERROR_MESSAGE);
				}
				String formatoFecha = "dd/MM/yyyy";
				SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);	
				
				pac.setFecha_nacimiento(formateador.format(calendar.getDatoFecha()));
				frm.txtFecha.setText(pac.getFecha_nacimiento());
				JOptionPane.showMessageDialog(null, "fecha: "+frm.txtFecha.getText());
				//FrmPaciente frmPac = new FrmPaciente();
				frm.txtFecha.setText(pac.getFecha_nacimiento());
				frm.update(getGraphics());
				dispose();
			
					
					
			//pac.setFecha_nacimiento(frm.txtFecha.getText());
			}
		});
		lblAplicarFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicarFecha.setFont(new Font("Sitka Small", Font.BOLD, 16));
		lblAplicarFecha.setBackground(new Color(63, 179, 145));
		calendar.setVisible(true);
	}
	
	
}
