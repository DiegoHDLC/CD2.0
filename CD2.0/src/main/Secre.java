package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classDAO.PacientesDAO;
import classVO.EspecialidadesVO;
import classVO.MedicosVO;
import classVO.PacientesVO;
import rspanelgradiente.RSPanelGradiente;
import utils.MySQLConexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rojeru_san.componentes.RSDateChooser;
import java.beans.PropertyChangeListener;
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
import jcalendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JList;
//import com.toedter.calendar.JDateChooser;


public class Secre extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	public Secre(){
		initComponents();
		setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("unchecked")
	private void initComponents() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		lblCerrar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_close_window_32px.png")));
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
				menu.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_menu_32px_2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_menu_32px_1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				menu.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_menu_32px_3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				menu.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_menu_32px_2.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		menu.setContentAreaFilled(false);
		menu.setBorder(null);
		menu.setBackground(new Color(33, 44, 61));
		menu.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_menu_32px_1.png")));
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
		btnCerrarSesion.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_logout_rounded_left_20px.png")));
		btnCerrarSesion.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setBackground(new Color(33, 44, 61));
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////PACIENTE///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		JPanel pestañaPaciente = new JPanel();
		pestañaPaciente.setBounds(0, 0, 103, 32);
		pestañaPaciente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pestañaPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(panelHorarios.isVisible() == false) {
					pestañaPaciente.setBackground(new Color(66, 169, 174));
				}else {
					pestañaPaciente.setBackground(new Color(127, 197, 200));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(panelHorarios.isVisible() == true) {
					pestañaPaciente.setBackground(new Color(46, 118, 121));
				}else {
					pestañaPaciente.setBackground(new Color(66, 169, 174));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelHorarios.isVisible() == true) {
					pestañaHorarios.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestañaPaciente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestañaPaciente.setBackground(new Color(66, 169, 174));
					pestañaHorarios.setBackground(new Color(46, 118, 121));
					panelFRM.setVisible(true);
					panelHorarios.setVisible(false);
				}
			}
		});
		pestañaPaciente.setBackground(new Color(66, 169, 174));
		barra.add(pestañaPaciente);
		
		JLabel tituloPaciente = new JLabel("PACIENTE");
		pestañaPaciente.add(tituloPaciente);
		tituloPaciente.setForeground(new Color(33, 44, 61));
		tituloPaciente.setFont(new Font("Sitka Small", Font.BOLD, 15));
		panelFRM.setVisible(true);
		
		panelHorarios.setVisible(false);
		
		panelHorarios.setBounds(0, 32, 497, 508);
		contentPane.add(panelHorarios);
		panelHorarios.setColorSecundario(new Color(33, 44, 61));
		panelHorarios.setColorPrimario(new Color(66, 169, 174));
		panelHorarios.setLayout(null);
		
		
		
		
		


		
		
		comboMedico.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					
					/*
					EspecialidadesVO esp = (EspecialidadesVO) comboEsp.getSelectedItem();
					MedicosVO med = new MedicosVO();
					DefaultComboBoxModel modlMedico = new DefaultComboBoxModel(med.mostrarMedicos(esp.getId()));
					comboMedico.setModel(modlMedico);*/
				}
			}
		});
		comboMedico.setBounds(10, 43, 303, 32);
		panelHorarios.add(comboMedico);
		
		
		
		panelFRM.setBounds(0, 32, 497, 508);
		contentPane.add(panelFRM);
		panelFRM.setColorSecundario(new Color(33, 44, 61));
		panelFRM.setColorPrimario(new Color(66, 169, 174));
		panelFRM.setLayout(null);
		
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(new Color(255, 255, 255));
		lblID.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblID.setBounds(10, 5, 46, 26);
		panelFRM.add(lblID);
		
		txtID = new JTextField();
		txtID.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtID.setCaretColor(new Color(255, 255, 255));
		txtID.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		txtID.setForeground(new Color(255, 255, 255));
		txtID.setBounds(42, 5, 46, 38);
		txtID.setBackground(new Color(19, 30, 49));
		panelFRM.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNombre.setCaretColor(new Color(255, 255, 255));
		txtNombre.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtNombre.setForeground(new Color(255, 255, 255));
		txtNombre.setColumns(10);
		txtNombre.setBackground(new Color(19, 30, 49));
		txtNombre.setBounds(122, 54, 221, 38);
		panelFRM.add(txtNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtApellidos.setCaretColor(new Color(255, 255, 255));
		txtApellidos.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtApellidos.setForeground(new Color(255, 255, 255));
		txtApellidos.setColumns(10);
		txtApellidos.setBackground(new Color(19, 30, 49));
		txtApellidos.setBounds(122, 103, 221, 38);
		panelFRM.add(txtApellidos);
		
		txtFecha = new JTextField();
		txtFecha.setIgnoreRepaint(true);
		txtFecha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtFecha.setCaretColor(new Color(255, 255, 255));
		txtFecha.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtFecha.setForeground(new Color(255, 255, 255));
		txtFecha.setColumns(10);
		txtFecha.setBackground(new Color(19, 30, 49));
		txtFecha.setBounds(122, 152, 129, 38);
		panelFRM.add(txtFecha);
		
		txtRut = new JTextField();
		txtRut.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRut.setCaretColor(new Color(255, 255, 255));
		txtRut.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtRut.setForeground(new Color(255, 255, 255));
		txtRut.setColumns(10);
		txtRut.setBackground(new Color(19, 30, 49));
		txtRut.setBounds(122, 201, 129, 38);
		panelFRM.add(txtRut);
		
		txtDireccion = new JTextField();
		txtDireccion.setForeground(new Color(255, 255, 255));
		txtDireccion.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDireccion.setCaretColor(new Color(255, 255, 255));
		txtDireccion.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(new Color(19, 30, 49));
		txtDireccion.setBounds(122, 299, 330, 38);
		panelFRM.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTelefono.setCaretColor(new Color(255, 255, 255));
		txtTelefono.setForeground(new Color(255, 255, 255));
		txtTelefono.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(122, 250, 129, 38);
		txtTelefono.setBackground(new Color(19, 30, 49));
		panelFRM.add(txtTelefono);
		
		txtStatus = new JTextField();
		txtStatus.setBorder(null);
		txtStatus.setName("");
		txtStatus.setCaretColor(new Color(255, 255, 255));
		txtStatus.setForeground(new Color(255, 255, 255));
		txtStatus.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		txtStatus.setBounds(10, 348, 470, 38);
		txtStatus.setBackground(new Color(19, 30, 49));
		panelFRM.add(txtStatus);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNombre.setBounds(10, 66, 75, 20);
		panelFRM.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setForeground(new Color(255, 255, 255));
		lblApellidos.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblApellidos.setBounds(10, 115, 90, 20);
		panelFRM.add(lblApellidos);
		
		JLabel lblFecha = new JLabel("FECHA:");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblFecha.setBounds(10, 164, 57, 20);
		panelFRM.add(lblFecha);
		
		JLabel lblRut = new JLabel("RUT:");
		lblRut.setForeground(new Color(255, 255, 255));
		lblRut.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblRut.setBounds(10, 207, 46, 26);
		panelFRM.add(lblRut);
		
		JLabel lblDireccion = new JLabel("DIRECCION:");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblDireccion.setBounds(10, 308, 93, 20);
		panelFRM.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblTelefono.setBounds(10, 259, 93, 20);
		panelFRM.add(lblTelefono);
		
		JLabel lblRegistrar = new JLabel("REGISTRAR");
		lblRegistrar.setForeground(new Color(255, 255, 255));
		lblRegistrar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblRegistrar.setBounds(20, 472, 65, 14);
		panelFRM.add(lblRegistrar);
		
		JLabel lblActualizar = new JLabel("ACTUALIZAR");
		lblActualizar.setForeground(new Color(255, 255, 255));
		lblActualizar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblActualizar.setBounds(204, 472, 73, 14);
		panelFRM.add(lblActualizar);
		
		JLabel lblBuscar = new JLabel("BUSCAR POR RUT");
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblBuscar.setBounds(95, 472, 99, 14);
		panelFRM.add(lblBuscar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setForeground(new Color(255, 255, 255));
		lblEliminar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblEliminar.setBounds(287, 472, 65, 14);
		panelFRM.add(lblEliminar);
		
		JLabel lblEliminarTodo = new JLabel("LIMPIAR TODO");
		lblEliminarTodo.setForeground(new Color(255, 255, 255));
		lblEliminarTodo.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblEliminarTodo.setBounds(362, 472, 83, 14);
		panelFRM.add(lblEliminarTodo);
		
		JLabel btnRegistrar = new JLabel("");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				
				registrarPacienteActionPerformed(evt);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnRegistrar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px_4.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px_1.png")));
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				btnRegistrar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnRegistrar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px_4.png")));
			}
		});
		btnRegistrar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px_1.png")));
		btnRegistrar.setBounds(24, 397, 64, 64);
		panelFRM.add(btnRegistrar);
		
		JLabel btnActualizar = new JLabel("");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarPacienteActionPerformed(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnActualizar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px_2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnActualizar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px_1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnActualizar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnActualizar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px_2.png")));
				
			}
		});
		btnActualizar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px_1.png")));
		btnActualizar.setBounds(207, 397, 65, 64);
		panelFRM.add(btnActualizar);
		
		JLabel btnBuscar = new JLabel("");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					buscarPacienteActionPerformed(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_3.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_4.png")));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_3.png")));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_1.png")));
			}
		});
		btnBuscar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_4.png")));
		btnBuscar.setBounds(113, 397, 64, 64);
		panelFRM.add(btnBuscar);
		
		
		
		JLabel btnEliminar = new JLabel("");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminarPacienteActionPerformed(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnEliminar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px_3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnEliminar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px_1.png")));
			}
		});
		btnEliminar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px.png")));
		btnEliminar.setBounds(287, 397, 64, 64);
		panelFRM.add(btnEliminar);
		
		JLabel btnLimpiar = new JLabel("");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpiarPacienteActionPerformed(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLimpiar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLimpiar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnLimpiar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px_2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnLimpiar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px_1.png")));
				
			}
		});
		btnLimpiar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px.png")));
		btnLimpiar.setBounds(369, 397, 64, 64);
		panelFRM.add(btnLimpiar);
		
			
			RSDateChooser calendarioTest = new RSDateChooser();
			calendarioTest.addPropertyChangeListener("DatoFecha",new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent arg0) {
					if(arg0.getNewValue() !=null) {
					JOptionPane.showMessageDialog(contentPane, "Seleccione una fecha"+arg0.getPropertyName()+":"+arg0.getNewValue(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			calendarioTest.setColorBackground(new Color(19, 30, 49));
			calendarioTest.setBounds(new Rectangle(0, 0, 0, 40));
			calendarioTest.setRequestFocusEnabled(false);
			calendarioTest.setBorder(null);
			calendarioTest.setBounds(246, 152, 38, 32);
			calendarioTest.setOpaque(false);
			
			
			panelFRM.add(calendarioTest);
			
			JLabel lvlAdd = new JLabel("");
			lvlAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					lvlAdd.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px_1.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lvlAdd.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px_2.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lvlAdd.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px.png")));
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lvlAdd.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px_2.png")));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					String formatoFecha = "dd/MM/yyyy";
					SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
					txtFecha.setText(formateador.format(calendarioTest.getDatoFecha()));
				}
			});
			lvlAdd.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px.png")));
			lvlAdd.setBounds(287, 148, 32, 38);
			panelFRM.add(lvlAdd);
//////////////////////////////////////////////////////////////////////////////////		
////////////////////////////HORARIOS/////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////			
		pestañaHorarios.setBounds(103, 0, 103, 32);
		pestañaHorarios.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		pestañaHorarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(panelHorarios.isVisible()==false) {
					pestañaHorarios.setBackground(new Color(127, 197, 200));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(panelFRM.isVisible() == false) {
					pestañaPaciente.setBackground(new Color(46, 118, 121));
					pestañaHorarios.setBackground(new Color(66, 169, 174));
				}else {
				pestañaHorarios.setBackground(new Color(46, 118, 121));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelFRM.isVisible() == true) {
					pestañaPaciente.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					pestañaHorarios.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					pestañaHorarios.setBackground(new Color(66, 169, 174));
					pestañaPaciente.setBackground(new Color(46, 118, 121));
					panelHorarios.setVisible(true);
					panelFRM.setVisible(false);
				}
			}
		});
		pestañaHorarios.setBackground(new Color(46, 118, 121));
		barra.add(pestañaHorarios);
		
		JLabel label = new JLabel("HORARIOS");
		label.setForeground(new Color(33, 44, 61));
		label.setFont(new Font("Sitka Small", Font.BOLD, 15));
		pestañaHorarios.add(label);
		
		comboEsp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\nentrando");
				if(!comboEsp.getItemAt(0).toString().equals(comboEsp.getSelectedItem())){
					// vamos a guardar los id de los medicos para poder tener 
					// acceso a ellos, ya que en el combo box se mostrara el nombre y apellido juntos
					idMedicos = new int[100];
					filtrarMedico(idMedicos);
					filtrarHorario(idMedicos);
				}
				
			}
			
		});
		comboEsp.setFont(new Font("Sitka Small", Font.BOLD, 12));
		comboEsp.setBounds(10, 11, 303, 32);
		panelHorarios.add(comboEsp);
		
		JButton btnMostrarHorarioDel = new JButton("Horario de Medico");
		btnMostrarHorarioDel.setBackground(Color.GRAY);
		btnMostrarHorarioDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idMedicos!=null) {
					
					HorarioMedico horario = new HorarioMedico(idMedicos[comboMedico.getSelectedIndex()]);
					horario.setVisible(true);
				}
				
			}
		});
		btnMostrarHorarioDel.setFont(new Font("Sitka Small", Font.ITALIC, 14));
		btnMostrarHorarioDel.setBounds(323, 11, 160, 61);
		panelHorarios.add(btnMostrarHorarioDel);
		
		
		
		JList listFechas = new JList();
		listFechas.setBounds(10, 121, 303, 116);
		panelHorarios.add(listFechas);
		
		JButton btnMostrarFechas = new JButton("Mostrar Fechas Ocupadas");
		btnMostrarFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(idMedicos!=null) {
					Object[] fechas = new Object[500];
					guardarFechasOcupadas(fechas);
					listFechas.setListData(fechas);
					
				}else {JOptionPane.showMessageDialog(contentPane, "Seleccione una especialidad","Error",JOptionPane.ERROR_MESSAGE);}
				
				
				/*
				 if (index == listModel.getSize()) {
			            //removed item in last position
			            index--;
			     }*/
				
			}
		});
		btnMostrarFechas.setFont(new Font("Sitka Small", Font.ITALIC, 14));
		btnMostrarFechas.setBounds(10, 86, 303, 32);
		panelHorarios.add(btnMostrarFechas);
		comboEspecialidades();
				
	}
	private void guardarFechasOcupadas(Object fechas[]) {
		int i=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			String sql = "SELECT * FROM fechas_ocupadas WHERE id_medico="+idMedicos[comboMedico.getSelectedIndex()];
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				fechas[i]=rs.getInt(6)+"/"+rs.getInt(4);
				i++;
			}
			ps.close();
			rs.close();
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
	}
	private void filtrarHorario(int idMedicos[]) {
		
	}
	private void filtrarMedico(int idMedicos[]) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		int nEspecialidad=-1;
		
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			
			String sql = "SELECT * FROM especialidades_medicas WHERE especialidad="+"'"+comboEsp.getSelectedItem().toString()+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				nEspecialidad=rs.getInt(1);
				
			}
			//luego en la tabla medico busco todos los medicos que tengan el numerito de la especialidad
			sql = "SELECT * FROM medicos WHERE id_especialidad="+nEspecialidad;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int i=0;
			
			while(rs.next()) {// y los añado al combo box
				
				idMedicos[i]=rs.getInt(1);
				comboMedico.addItem(rs.getString(2)+" "+rs.getString(3));
				i++;
			}
			rs.close();
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
	}
	private void comboEspecialidades() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		try {
			
			String sql = "SELECT * FROM especialidades_medicas";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			comboEsp.addItem("Seleccione especialidad");
			
			while(rs.next()) {
				comboEsp.addItem(rs.getString("especialidad"));
			}
			
			rs.close();
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
	}
	
	private void registrarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarProveedorActionPerformed
        PacientesVO pac = new PacientesVO();
        //RSDateChooser chooser = new RSDateChooser();
        
        if(txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtFecha.getText().isEmpty()
        		|| txtRut.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty()) 
        {
        txtStatus.setText("Complete todos los datos para registrar al paciente");
        }
        else {
        pac.setNombre(txtNombre.getText());
        pac.setApellidos(txtApellidos.getText());
        pac.setFecha_nacimiento(txtFecha.getText());
        pac.setRut(txtRut.getText());
        pac.setDireccion(txtDireccion.getText());
        pac.setTelefono(txtTelefono.getText());
        String resp = PacientesDAO.registrarPacientes(pac);
        txtStatus.setText(resp);
        txtNombre.setText("");
        txtApellidos.setText("");
        txtFecha.setText("");
        txtRut.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        cargarPacientes(0);
        }
    }//GEN-LAST:event_registrarProveedorActionPerformed

	private void actualizarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarProveedorActionPerformed
        PacientesVO pac = new PacientesVO();
        pac.setIdPaciente(Integer.parseInt(txtID.getText()));
        pac.setNombre(txtNombre.getText());
        pac.setApellidos(txtApellidos.getText());
        pac.setFecha_nacimiento(txtFecha.getText());
        pac.setRut(txtRut.getText());
        pac.setDireccion(txtDireccion.getText());
        pac.setTelefono(txtTelefono.getText());
        String resp = PacientesDAO.ActualizarPacientes(pac);
        txtStatus.setText(resp);
        txtNombre.setText("");
        txtApellidos.setText("");
        txtFecha.setText("");
        txtRut.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtID.setText("");
        cargarPacientes(0);
    }//GEN-LAST:event_actualizarProveedorActionPerformed
	
	private void buscarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarProveedorActionPerformed
			
			if(txtRut.getText().isEmpty()) {
				txtStatus.setText("Porfavor, digite el RUT del paciente");
			}else {
			
			PacientesVO pac = PacientesDAO.buscarPacientes(txtRut.getText());
	        txtID.setText(pac.getIdPaciente()+"");
	        txtNombre.setText(pac.getNombre());
	        txtApellidos.setText(pac.getApellidos());
	        txtFecha.setText(pac.getFecha_nacimiento());
	        txtRut.setText(pac.getRut());
	        txtDireccion.setText(pac.getDireccion());
	        txtTelefono.setText(pac.getTelefono());
	        txtStatus.setText(pac.getResultado());
			}
	    }//GEN-LAST:event_buscarProveedorActionPerformed
	
	private void eliminarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarProveedorActionPerformed
		if(txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtFecha.getText().isEmpty()
        		|| txtRut.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty()) 
        {
        txtStatus.setText("Complete todos los datos para eliminar al paciente");
        }
        else {
        String resp = PacientesDAO.eliminarPacientes(txtRut.getText());
        txtStatus.setText(resp);
        txtNombre.setText("");
        txtApellidos.setText("");
        txtFecha.setText("");
        txtRut.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        cargarPacientes(0);
        }
    }//GEN-LAST:event_eliminarProveedorActionPerformed

	private void limpiarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarProveedorActionPerformed
    	txtNombre.setText("");
        txtApellidos.setText("");
        txtFecha.setText("");
        txtRut.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtStatus.setText("");
    }//GEN-LAST:event_limpiarProveedorActionPerformed
	
	public void cargarPacientes(int busca){
        int index = 1;
        list_pacientes.removeAllItems();   
        for(PacientesVO pac: PacientesDAO.getListPacientes()){
            if(pac.getIdPaciente() == busca){
                list_pacientes.setSelectedIndex(index);
            }
            
            index++;
        }
    }
	
	class eventoCerrar implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub
        	
            dispose();
        }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secre frame = new Secre();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@SuppressWarnings("rawtypes")
	private int i=0;
	private int idMedicos[]=null;
	private javax.swing.JComboBox list_pacientes;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	public static JTextField txtFecha;
	private JTextField txtRut;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtStatus;
	RSPanelGradiente panelFRM = new RSPanelGradiente();
	RSPanelGradiente panelHorarios = new RSPanelGradiente();
	JPanel pestañaHorarios = new JPanel();
	RSComboMetro comboEspecial = new RSComboMetro();
	int xx,xy;
	JComboBox comboEsp = new JComboBox();
	JComboBox comboMedico = new JComboBox();
}
