package main;

import java.awt.Color;

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

import classDAO.MedicosDAO;
import classDAO.CodigoMaestroDAO;
import classDAO.EspecialidadesDAO;
import classDAO.TbUsuariosDAO;
import classVO.Usuario;

import mantenimientos.HorarioRandom;
import utils.Boton;

import utils.CajaTexto;
import utils.Label;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import javax.swing.JRadioButton;

import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.ButtonGroup;

import javax.swing.Icon;

import javax.swing.JTextField;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Registrarse extends JFrame {
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
		
		MouseActionBarra(lblCerrar, CerrEntered, CerrExited, null, 2);
		lblCerrar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px.png")));
		lblCerrar.setBounds(768, 0, 32, 32);
		barra.add(lblCerrar);
		
		JLabel lblMinimizar = new JLabel("");
		MouseActionBarra(lblMinimizar, MinEntered,MinExited ,null, 1);
		lblMinimizar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/minimizar_azul_oscuro_32px.png")));
		lblMinimizar.setBounds(739, 0, 32, 32);
		barra.add(lblMinimizar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 448);
		panel.setBackground(new java.awt.Color(33, 44, 61));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new Label(181, 131,14,"Usuario");
		panel.add(lblNewLabel);
		
		JLabel lblIngreseSuContrasea = new Label(132, 203,14,"Ingrese su contrase\u00F1a");
		panel.add(lblIngreseSuContrasea);
		
		JLabel lblIngreseElCodigo = new Label(116, 273, 14,"Ingrese el c\u00F3digo maestro");
		panel.add(lblIngreseElCodigo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(100, 146, 216, 11);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(100, 222, 216, 11);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(100, 292, 216, 11);
		panel.add(separator_2);
		
		JButton btnRegresar = new Boton(458, 399, 113, 38,"Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login nuevaVentana2 = new Login();
				nuevaVentana2.setVisible(true);
			}
		});
		panel.add(btnRegresar);
			
		
		rdMedico.setFont(new Font("Sitka Small", Font.BOLD, 14));
		rdMedico.setForeground(new Color(255, 255, 255));
		rdMedico.setBackground(new Color(33, 44, 61));
		rdMedico.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_medical_doctor_64px_1.png")));
		rdMedico.setBounds(158, 59, 139, 73);
		panel.add(rdMedico);
		
		
		rdSecretaria.setFont(new Font("Sitka Small", Font.BOLD, 14));
		rdSecretaria.setForeground(new Color(255, 255, 255));
		rdSecretaria.setBackground(new Color(33, 44, 61));
		rdSecretaria.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/secretaria_celeste_64px.png")));
	
		MouseActionRadio(rdSecretaria, rdMedico, rdSecRoja, rdSecBlan, rdSecCeles, rdMedCeles, 1);
		MouseActionRadio(rdMedico, rdSecretaria, rdMedRojo, rdMedBlan, rdMedCeles, rdSecCeles, 2);
		
		rdSecretaria.setBounds(470, 59, 173, 73);
		panel.add(rdSecretaria);
		
		JLabel lblElijaSuProfesin = new Label(336, 41,14,"Elija su profesi\u00F3n");
		panel.add(lblElijaSuProfesin);
		
		JLabel lblIngreseSuNombre = new Label(502, 128,14,"Ingrese su nombre");
		panel.add(lblIngreseSuNombre);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(458, 146, 216, 11);
		panel.add(separator_3);
		
		JLabel lblIngreseSuCiudad = new Label(497, 203,14,"Ingrese su apellido");
		panel.add(lblIngreseSuCiudad);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(458, 222, 216, 11);
		panel.add(separator_4);
		
		JLabel lblIngreseSuCiudad_1 = new Label(504, 273,14,"Ingrese su ciudad");
		panel.add(lblIngreseSuCiudad_1);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(458, 292, 216, 11);
		panel.add(separator_5);
		
		JButton btnRegistrarse = new Boton(668, 399, 113, 38,"Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarUsuario();
			}
		});
		panel.add(btnRegistrarse);
		
		txtUsuario = new CajaTexto(100, 153, 216, 34);
		panel.add(txtUsuario);
		
		txtCodigoMaestro = new CajaTexto(100, 301, 216, 34);
		panel.add(txtCodigoMaestro);
		
		txtNombre = new CajaTexto(458, 153, 216, 34);
		panel.add(txtNombre);
		
		txtApellido = new CajaTexto(458, 228, 216, 34);
		panel.add(txtApellido);
		
		txtCiudad = new CajaTexto(458, 301, 216, 34);
		panel.add(txtCiudad);
		
		txtPassVisible = new CajaTexto(100, 231, 216, 34);
		txtPassVisible.setVisible(false);
		panel.add(txtPassVisible);
		
		txtPassNoVisible = new JPasswordField();
		txtPassNoVisible.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassNoVisible.setCaretColor(new Color(255, 255, 255));
		txtPassNoVisible.setForeground(Color.WHITE);
		txtPassNoVisible.setFont(new Font("Sitka Small", Font.PLAIN, 25));
		txtPassNoVisible.setBackground(new Color(19, 30, 49));
		txtPassNoVisible.setBounds(100, 231, 216, 34);
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
		Visibilidad.setBounds(326, 226, 40, 40);
		panel.add(Visibilidad);
		
		bg.add(rdMedico);
		bg.add(rdSecretaria);
		
	
		lblElijaSuEspecialidad.setForeground(Color.WHITE);
		lblElijaSuEspecialidad.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblElijaSuEspecialidad.setBounds(502, 339, 150, 22);
		panel.add(lblElijaSuEspecialidad);
		lblElijaSuEspecialidad.setVisible(false);
		
		comboEsp.setForeground(new Color(255, 255, 255));
		comboEsp.setBackground(new Color(19, 30, 49));
		comboEsp.setBounds(458, 363, 323, 25);
		comboEsp.setFont(new Font("Sitka Small", Font.BOLD, 12));
		comboEsp.setVisible(false);;
		String[] especialidades = EspecialidadesDAO.comboEspecialidades();
		if(especialidades!=null) {
			int i=0;
			while(i<especialidades.length) {
				comboEsp.addItem(especialidades[i]);
				i++;
			}
		}
		panel.add(comboEsp);
		
		txtRut = new CajaTexto(100, 370, 216, 34);
		panel.add(txtRut);
		
		JLabel lblIngreseSuRut = new JLabel("Ingrese su rut");
		lblIngreseSuRut.setForeground(Color.WHITE);
		lblIngreseSuRut.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		lblIngreseSuRut.setBounds(158, 341, 99, 19);
		panel.add(lblIngreseSuRut);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(100, 360, 216, 11);
		panel.add(separator_6);
	}
	
//////////////////////////////////////////////////////////////////////////////////
////////////////////////////MODULOS//////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	
	
	
	private void MouseActionRadio(JRadioButton rd1,JRadioButton rd2, Icon rdPrinRoja, Icon rdPrinBlan, Icon rdPrinCeles, Icon SecCeleste, int radio) {
		rd1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radio == 1) {
					comboEsp.setVisible(false);
					lblElijaSuEspecialidad.setVisible(false);
					rd1.setIcon(rdPrinRoja);
					if(rd1.isSelected()) { rdMedico.setIcon(SecCeleste);}
				}else {
					rd1.setIcon(rdPrinRoja);
					rd2.setIcon(SecCeleste);
					comboEsp.setVisible(true);
					lblElijaSuEspecialidad.setVisible(true);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(radio == 1) {
					if(rd1.isSelected()== false) { rd1.setIcon(rdPrinBlan);}
				}else {
					if(rd1.isSelected() == false) { rdMedico.setIcon(rdPrinBlan);}
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(radio == 1) {
					rd1.setIcon(rdPrinCeles);
					if(rd1.isSelected()) { rd1.setIcon(rdPrinRoja);}
				}else {
					rd1.setIcon(rdPrinCeles);
					if(rd1.isSelected() == true) { rd1.setIcon(rdPrinRoja);}
				}
			}});
	}
	
	public void MouseActionBarra(JLabel label,Icon Entered, Icon Exited, Icon Clicked, int boton) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setIcon(Entered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(Exited);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(boton == 1) {
					setState(JFrame.ICONIFIED);
				}else {
					System.exit(0);
				}
			}
		});
	}
	
	private void registrarUsuario() {
		String usuario = txtUsuario.getText();
		String clave = String.copyValueOf(txtPassNoVisible.getPassword());
		String codigo = txtCodigoMaestro.getText();
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String ciudad = txtCiudad.getText();
		String rut = txtRut.getText();
		
			if( !usuario.isEmpty() || !clave.isEmpty() || !codigo.isEmpty() || !nombre.isEmpty() || !apellido.isEmpty() || !ciudad.isEmpty() || !rut.isEmpty()) {
				
				if( codigo.equals(CodigoMaestroDAO.getCodigoMaestro())) {
					
					if(TbUsuariosDAO.repiteUsuario(usuario)==0) {
						if(!TbUsuariosDAO.repiteRut(rut)) {
							if(rdMedico.isSelected() == true && rdSecretaria.isSelected() == true) {JOptionPane.showMessageDialog(contentPane, "Escoja solo 1 profesion","Error",JOptionPane.ERROR_MESSAGE);}
							else if(rdMedico.isSelected() == false && rdSecretaria.isSelected() == false) {JOptionPane.showMessageDialog(contentPane, "Escoja una profesion","Error",JOptionPane.ERROR_MESSAGE);}
							else if(rdMedico.isSelected() == true) {
								if(!(comboEsp.getItemAt(0).toString()).equals(comboEsp.getSelectedItem().toString())) {
									
									Usuario usu = new Usuario(usuario,clave,nombre,apellido,ciudad,"1",comboEsp.getSelectedIndex(),rut);
									
									MedicosDAO.registrarEnTablaMedico(usu);
									System.out.println("registrado en tabla medico");
									MedicosDAO med = new MedicosDAO();
									HorarioRandom hr = new HorarioRandom(med.getUltimoId_medico());
									System.out.println("registrado en horario medico");
									hr.generarHorario();
									TbUsuariosDAO.insertUsuario(usu);
									
									JOptionPane.showMessageDialog(contentPane, "Registrado exitosamente","OK",JOptionPane.INFORMATION_MESSAGE);
								}else {JOptionPane.showMessageDialog(contentPane, "Escoja una especialidad","Error",JOptionPane.ERROR_MESSAGE);};
							}
							else if(rdSecretaria.isSelected() == true) {
								System.out.println("secre");
								Usuario usu1 = new Usuario(usuario,clave,nombre,apellido,ciudad,"0",rut);
								TbUsuariosDAO.insertUsuario(usu1);
								JOptionPane.showMessageDialog(contentPane, "Registrado exitosamente","OK",JOptionPane.INFORMATION_MESSAGE);
							}
						}else {JOptionPane.showMessageDialog(contentPane, "Ese rut ya esta registrado, ese está repetido","Error",JOptionPane.ERROR_MESSAGE);};
					}else {JOptionPane.showMessageDialog(contentPane, "Escoja otro nombre de usuario, ese está repetido","Error",JOptionPane.ERROR_MESSAGE);}
				}
				else{JOptionPane.showMessageDialog(contentPane, "Codigo maestro erroneo","Error",JOptionPane.ERROR_MESSAGE);}
			}else {JOptionPane.showMessageDialog(contentPane, "Datos invalidos","Error",JOptionPane.ERROR_MESSAGE);}
	}
	
	
	
	@SuppressWarnings("rawtypes")
	JComboBox comboEsp = new JComboBox();
	private int x;
    private int y;
    private JTextField txtUsuario;
    private JTextField txtCodigoMaestro;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCiudad;
    private JTextField txtPassVisible;
    private JPasswordField txtPassNoVisible;
    private JTextField txtRut;
    JRadioButton rdMedico = new JRadioButton("MEDICO");
    private JPanel contentPane;
	private ButtonGroup bg = new ButtonGroup();
	JRadioButton rdSecretaria = new JRadioButton("SECRETARIA");
	JLabel lblElijaSuEspecialidad = new JLabel("Elija su especialidad");
	ImageIcon MinEntered = new ImageIcon(Registrarse.class.getResource("/Image/minimizar_blanco_32px.png"));
	ImageIcon MinExited = new ImageIcon(Registrarse.class.getResource("/Image/minimizar_azul_oscuro_32px.png"));
	ImageIcon CerrEntered = new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px_1.png"));
	ImageIcon CerrExited = new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px.png"));
	ImageIcon rdSecRoja = new ImageIcon(Registrarse.class.getResource("/Image/secretaria_roja_64px.png"));
	ImageIcon rdSecBlan = new ImageIcon(Registrarse.class.getResource("/Image/secretaria_blanca_64px.png"));
	ImageIcon rdSecCeles = new ImageIcon(Registrarse.class.getResource("/Image/secretaria_celeste_64px.png"));
	ImageIcon rdMedCeles = new ImageIcon(Registrarse.class.getResource("/Image/icons8_medical_doctor_64px_1.png"));
	ImageIcon rdMedBlan = new ImageIcon(Registrarse.class.getResource("/Image/icons8_medical_doctor_64px_3.png"));
	ImageIcon rdMedRojo = new ImageIcon(Registrarse.class.getResource("/Image/icons8_medical_doctor_64px_4.png"));
    
    protected void this_mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
}

    protected void this_mouseDragged(MouseEvent e) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
}
}	