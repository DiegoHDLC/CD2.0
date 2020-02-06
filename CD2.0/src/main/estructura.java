package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classVO.Usuario;
import mantenimientos.GestionUsuario;
import rspanelgradiente.RSPanelGradiente;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class estructura extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					estructura frame = new estructura();
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
	public estructura() {
		setUndecorated(true);
		initComponents();
		
	}
		
	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel barra = new JPanel();
		barra.setBounds(0, 0, 800, 32);
		barra.setBackground(new java.awt.Color(66, 169, 174));
		contentPane.add(barra);
		barra.setLayout(null);
		
		JLabel lblCerrar = new JLabel("");
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar.setIcon(new ImageIcon(estructura.class.getResource("/Image/icons8_close_window_32px_1.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrar.setIcon(new ImageIcon(estructura.class.getResource("/Image/icons8_close_window_32px.png")));
			}
		});
		lblCerrar.setIcon(new ImageIcon(estructura.class.getResource("/Image/icons8_close_window_32px.png")));
		lblCerrar.setBounds(768, 0, 32, 32);
		barra.add(lblCerrar);
		
		JLabel lblMinimizar = new JLabel("");
		lblMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(estructura.class.getResource("/Image/icons8_minimize_window_32px_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(estructura.class.getResource("/Image/icons8_minimize_window_32px_2.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setState(JFrame.ICONIFIED);
			}
		});
		lblMinimizar.setIcon(new ImageIcon(estructura.class.getResource("/Image/icons8_minimize_window_32px_2.png")));
		lblMinimizar.setBounds(739, 0, 32, 32);
		barra.add(lblMinimizar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 448);
		panel.setBackground(new java.awt.Color(33, 44, 61));
		contentPane.add(panel);
		panel.setLayout(null);
	}
}	
