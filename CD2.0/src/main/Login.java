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
import java.awt.event.MouseMotionAdapter;

import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				setLocation(x-xx, y-xy);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				xx = e.getX();
				xy = e.getY();
			}
		});
		setUndecorated(true);
		initComponents();
		setLocationRelativeTo(null);
		
	}
	
	protected void ingresar() {
		String usuario = txtUsuario.getText();
		String clave = String.copyValueOf(txtContraseña.getPassword());
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setUsuario(usuario);
		usuario2.setClave(clave);
		
		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
		System.out.println("usuario: "+usu);
		if(usu!=null) {
			this.dispose();
			FrmPaciente FrmSecretaria = new FrmPaciente();
			FrmSecretaria.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(contentPane, "Datos invalidos","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected void salir() {
		System.exit(0);
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
				lblCerrar.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_close_window_32px_1.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrar.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_close_window_32px.png")));
			}
		});
		lblCerrar.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_close_window_32px.png")));
		lblCerrar.setBounds(768, 0, 32, 32);
		barra.add(lblCerrar);
		
		JLabel lblMinimizar = new JLabel("");
		lblMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_minimize_window_32px_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_minimize_window_32px_2.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setState(JFrame.ICONIFIED);
			}
		});
		lblMinimizar.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_minimize_window_32px_2.png")));
		lblMinimizar.setBounds(739, 0, 32, 32);
		barra.add(lblMinimizar);
		
		JPanel panel_der = new JPanel();
		panel_der.setBounds(450, 0, 350, 448);
		panel_der.setBackground(new java.awt.Color(33, 44, 61));
		contentPane.add(panel_der);
		panel_der.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_login_40px.png")));
		label.setBounds(274, 72, 40, 40);
		panel_der.add(label);
		
		JLabel lblCorreoElectr = new JLabel("USUARIO");
		lblCorreoElectr.setForeground(new Color(255, 255, 255));
		lblCorreoElectr.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblCorreoElectr.setBounds(44, 123, 221, 24);
		panel_der.add(lblCorreoElectr);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUsuario.setCaretColor(new Color(255, 255, 255));
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtUsuario.setBackground(new Color(19, 30, 49));
		txtUsuario.setBounds(101, 158, 213, 38);
		panel_der.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtContraseña.setCaretColor(new Color(255, 255, 255));
		txtContraseña.setForeground(Color.WHITE);
		txtContraseña.setFont(new Font("Sitka Small", Font.PLAIN, 29));
		txtContraseña.setBackground(new Color(19, 30, 49));
		txtContraseña.setBounds(101, 272, 213, 38);
		panel_der.add(txtContraseña);
			
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setBackground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblContrasea.setBounds(44, 237, 221, 24);
		panel_der.add(lblContrasea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 200, 270, 11);
		panel_der.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(44, 314, 270, 11);
		panel_der.add(separator_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_lock_40px_1.png")));
		label_1.setBounds(44, 273, 46, 37);
		panel_der.add(label_1);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnIngresar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new  Color(19, 30, 49));
		btnIngresar.setBounds(201, 368, 113, 38);
		panel_der.add(btnIngresar);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_user_50px_1.png")));
		label_2.setBounds(41, 146, 50, 50);
		panel_der.add(label_2);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		btnSalir.setBackground(new Color(19, 30, 49));
		btnSalir.setBounds(44, 368, 113, 38);
		panel_der.add(btnSalir);
		
		JLabel lblLogin = new JLabel("Iniciar Sesi\u00F3n");
		lblLogin.setBounds(44, 72, 220, 46);
		panel_der.add(lblLogin);
		lblLogin.setForeground(new Color(66, 169, 174));
		lblLogin.setFont(new Font("Sitka Small", Font.PLAIN, 31));
		
		JLabel lblregistrar = new JLabel("Registrarse ahora...");
		lblregistrar.setForeground(Color.CYAN);
		lblregistrar.setBounds(131, 336, 113, 14);
		panel_der.add(lblregistrar);
		lblregistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblregistrar.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblregistrar.setForeground(Color.CYAN);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Registrarse nuevoRegistro = new Registrarse();
				nuevoRegistro.setVisible(true);
			}
		});
		
		
		
		
		
		RSPanelGradiente panel_izq = new RSPanelGradiente();
		panel_izq.setBounds(0, 0, 450, 448);
		panel_izq.setColorSecundario(new Color(33, 44, 61));
		panel_izq.setColorPrimario(new Color(66, 169, 174));
		contentPane.add(panel_izq);
		panel_izq.setLayout(null);
		
		JLabel lblCentro = new JLabel("CENTRO DENTAL");
		lblCentro.setBounds(28, 72, 372, 46);
		panel_izq.add(lblCentro);
		lblCentro.setForeground(new Color(255, 255, 255));
		lblCentro.setBackground(new Color(255, 255, 255));
		lblCentro.setFont(new Font("Sitka Small", Font.PLAIN, 42));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(166, 195, 120, 120);
		panel_izq.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Image/icons8_tooth_120px.png")));
	}
}	