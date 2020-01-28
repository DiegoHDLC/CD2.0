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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import classVO.Usuario;
import mantenimientos.GestionUsuario;
import mantenimientos.connect_codigoMaestro;
import mantenimientos.connect_tbUsuarios;
import rspanelgradiente.RSPanelGradiente;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import rojerusan.RSPasswordTextPlaceHolder;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Registrarse extends JFrame {

	private JPanel contentPane;

	
	public Registrarse() {
		setUndecorated(true);
		initComponents();
		this.setLocationRelativeTo(null);
		
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
				lblCerrar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px_1.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px.png")));
			}
		});
		lblCerrar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px.png")));
		lblCerrar.setBounds(768, 0, 32, 32);
		barra.add(lblCerrar);
		
		JLabel lblMinimizar = new JLabel("");
		lblMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_minimize_window_32px_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimizar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_minimize_window_32px_2.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setState(JFrame.ICONIFIED);
			}
		});
		lblMinimizar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_minimize_window_32px_2.png")));
		lblMinimizar.setBounds(739, 0, 32, 32);
		barra.add(lblMinimizar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 448);
		panel.setBackground(new java.awt.Color(33, 44, 61));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese su usuario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblNewLabel.setBounds(143, 59, 139, 25);
		panel.add(lblNewLabel);
		
		JLabel lblIngreseSuContrasea = new JLabel("Ingrese su contrase\u00F1a");
		lblIngreseSuContrasea.setForeground(Color.WHITE);
		lblIngreseSuContrasea.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblIngreseSuContrasea.setBounds(131, 131, 162, 25);
		panel.add(lblIngreseSuContrasea);
		
		JLabel lblIngreseElCodigo = new JLabel("Ingrese el c\u00F3digo maestro");
		lblIngreseElCodigo.setForeground(Color.WHITE);
		lblIngreseElCodigo.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblIngreseElCodigo.setBounds(120, 203, 185, 25);
		panel.add(lblIngreseElCodigo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(132, 78, 150, 11);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(132, 150, 150, 11);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(120, 222, 185, 11);
		panel.add(separator_2);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		btnRegresar.setBackground(new Color(19, 30, 49));
		btnRegresar.setBounds(192, 352, 113, 38);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login nuevaVentana2 = new Login();
				nuevaVentana2.setVisible(true);
			}
		});
		panel.add(btnRegresar);
		
		JRadioButton rdSecretaria = new JRadioButton("Secretari@");
		rdSecretaria.setBounds(435, 311, 89, 23);
		panel.add(rdSecretaria);
		
		JRadioButton rdMedico = new JRadioButton("M\u00E9dico");
		rdMedico.setBounds(243, 311, 90, 23);
		panel.add(rdMedico);
		
		JLabel lblElijaSuProfesin = new JLabel("Elija su profesi\u00F3n");
		lblElijaSuProfesin.setBounds(321, 277, 150, 38);
		panel.add(lblElijaSuProfesin);
		lblElijaSuProfesin.setForeground(Color.WHITE);
		lblElijaSuProfesin.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		JLabel lblIngreseSuNombre = new JLabel("Ingrese su nombre");
		lblIngreseSuNombre.setForeground(Color.WHITE);
		lblIngreseSuNombre.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblIngreseSuNombre.setBounds(505, 59, 139, 25);
		panel.add(lblIngreseSuNombre);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(485, 78, 168, 11);
		panel.add(separator_3);
		
		JLabel lblIngreseSuCiudad = new JLabel("Ingrese su apellido");
		lblIngreseSuCiudad.setForeground(Color.WHITE);
		lblIngreseSuCiudad.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblIngreseSuCiudad.setBounds(505, 131, 139, 25);
		panel.add(lblIngreseSuCiudad);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(485, 150, 168, 11);
		panel.add(separator_4);
		
		JLabel lblIngreseSuCiudad_1 = new JLabel("Ingrese su ciudad");
		lblIngreseSuCiudad_1.setForeground(Color.WHITE);
		lblIngreseSuCiudad_1.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblIngreseSuCiudad_1.setBounds(505, 203, 139, 25);
		panel.add(lblIngreseSuCiudad_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(473, 222, 185, 11);
		panel.add(separator_5);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		btnRegistrarse.setBackground(new Color(19, 30, 49));
		btnRegistrarse.setBounds(473, 352, 113, 38);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//usuario.contentEquals(null) || clave.contentEquals(null) || codigo.contentEquals(null)
				String usuario = txtUsuario.getText();
				String clave = String.copyValueOf(txtPassNoVisible.getPassword());
				String codigo = txtCodigoMaestro.getText();
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String ciudad = txtCiudad.getText();
				System.out.println("\n"+usuario+clave+codigo);
				if( !usuario.isEmpty() || !clave.isEmpty() || !codigo.isEmpty() || !nombre.isEmpty() || !apellido.isEmpty() || !ciudad.isEmpty()) {
					
					if( codigo.equals(connect_codigoMaestro.getCodigoMaestro())) {
						
						if(rdMedico.isSelected() == true && rdSecretaria.isSelected() == true) {JOptionPane.showMessageDialog(contentPane, "Escoja solo 1 profesion","Error",JOptionPane.ERROR_MESSAGE);}
						else if(rdMedico.isSelected() == false && rdSecretaria.isSelected() == false) {JOptionPane.showMessageDialog(contentPane, "Escoja una profesion","Error",JOptionPane.ERROR_MESSAGE);}
						else if(rdMedico.isSelected() == true) {
							System.out.println("medico");
							Usuario usu = new Usuario(usuario,clave,nombre,apellido,ciudad,"1");
							connect_tbUsuarios.insertUsuario(usu);
							JOptionPane.showMessageDialog(contentPane, "Registrado exitosamente","OK",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(rdSecretaria.isSelected() == true) {
							System.out.println("secre");
							Usuario usu1 = new Usuario(usuario,clave,nombre,apellido,ciudad,"0");
							connect_tbUsuarios.insertUsuario(usu1);
							JOptionPane.showMessageDialog(contentPane, "Registrado exitosamente","OK",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else{JOptionPane.showMessageDialog(contentPane, "Codigo maestro erroneo","Error",JOptionPane.ERROR_MESSAGE);}
				}else {JOptionPane.showMessageDialog(contentPane, "Datos invalidos","Error",JOptionPane.ERROR_MESSAGE);}
				/*
				GestionUsuario gestionUsuario = new GestionUsuario();
				
				Usuario usuario2 = new Usuario();
				
				usuario2.setUsuario(usuario);
				usuario2.setClave(clave);
				
				Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
				System.out.println("usuario: "+usu);
				if(usu!=null) {
					JOptionPane.showMessageDialog(contentPane, "Bienvenido");
					
					this.dispose();
					
					ProgramaFRM2 bienvenida = new ProgramaFRM2();
					bienvenida.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Datos invalidos","Error",JOptionPane.ERROR_MESSAGE);
				}*/
			}
		});
		panel.add(btnRegistrarse);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUsuario.setCaretColor(new Color(255, 255, 255));
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtUsuario.setBackground(new Color(19, 30, 49));
		txtUsuario.setBounds(105, 86, 216, 34);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtCodigoMaestro = new JTextField();
		txtCodigoMaestro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCodigoMaestro.setCaretColor(new Color(255, 255, 255));
		txtCodigoMaestro.setForeground(Color.WHITE);
		txtCodigoMaestro.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtCodigoMaestro.setBackground(new Color(19, 30, 49));
		txtCodigoMaestro.setColumns(10);
		txtCodigoMaestro.setBounds(105, 232, 216, 34);
		panel.add(txtCodigoMaestro);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombre.setCaretColor(new Color(255, 255, 255));
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtNombre.setBackground(new Color(19, 30, 49));
		txtNombre.setColumns(10);
		txtNombre.setBounds(458, 86, 216, 34);
		panel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtApellido.setCaretColor(new Color(255, 255, 255));
		txtApellido.setForeground(Color.WHITE);
		txtApellido.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtApellido.setBackground(new Color(19, 30, 49));
		txtApellido.setColumns(10);
		txtApellido.setBounds(458, 158, 216, 34);
		panel.add(txtApellido);
		
		txtCiudad = new JTextField();
		txtCiudad.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCiudad.setCaretColor(new Color(255, 255, 255));
		txtCiudad.setForeground(Color.WHITE);
		txtCiudad.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtCiudad.setBackground(new Color(19, 30, 49));
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(458, 239, 216, 34);
		panel.add(txtCiudad);
		
		txtPassVisible = new JTextField();
		txtPassVisible.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassVisible.setCaretColor(new Color(255, 255, 255));
		txtPassVisible.setForeground(Color.WHITE);
		txtPassVisible.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtPassVisible.setBackground(new Color(19, 30, 49));
		txtPassVisible.setColumns(10);
		txtPassVisible.setBounds(105, 158, 216, 34);
		txtPassVisible.setVisible(false);
		panel.add(txtPassVisible);
		
		txtPassNoVisible = new JPasswordField();
		txtPassNoVisible.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassNoVisible.setCaretColor(new Color(255, 255, 255));
		txtPassNoVisible.setForeground(Color.WHITE);
		txtPassNoVisible.setFont(new Font("Sitka Small", Font.PLAIN, 25));
		txtPassNoVisible.setBackground(new Color(19, 30, 49));
		txtPassNoVisible.setBounds(105, 158, 216, 34);
		panel.add(txtPassNoVisible);
		
		JLabel Visibilidad = new JLabel("");
		Visibilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				Visibilidad.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_eye_40px_1.png")));
				txtPassVisible.setText(String.copyValueOf(txtPassNoVisible.getPassword()));
				txtPassVisible.setVisible(true);
				txtPassNoVisible.setVisible(false);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Visibilidad.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_closed_eye_40px_2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Visibilidad.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_closed_eye_40px.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Visibilidad.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_closed_eye_40px_2.png")));
				txtPassVisible.setVisible(false);
				txtPassNoVisible.setVisible(true);
				
			}
		});
		Visibilidad.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_closed_eye_40px.png")));
		Visibilidad.setBounds(331, 150, 40, 40);
		panel.add(Visibilidad);
		
		
	}
	
	private int x;
    private int y;
    private JTextField txtUsuario;
    private JTextField txtCodigoMaestro;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCiudad;
    private JTextField txtPassVisible;
    private JPasswordField txtPassNoVisible;
    
    protected void this_mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
}

    protected void this_mouseDragged(MouseEvent e) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
}
}	
