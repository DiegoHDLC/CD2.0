package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classDAO.PacientesDAO;
import classVO.PacientesVO;
import rspanelgradiente.RSPanelGradiente;
import utils.CTextoSecretaria;
import utils.Label;
import utils.MySQLConexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import utils.*;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
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
import javax.swing.Icon;

import rojerusan.RSComboMetro;
import mantenimientos.Dias;
import mantenimientos.FechasOcupadas_database;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JList;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.TextArea;


public class Secre extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	public Secre(){
		initComponents();
		setLocationRelativeTo(null);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		MouseActionBarra(lblCerrar, CerrEntered, CerrExited, null, 2);
		lblCerrar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px.png")));
		barra.setLayout(null);
		barra.add(lblCerrar);

		
		JLabel lblMinimizar = new JLabel("");
		MouseActionBarra(lblMinimizar, MinEntered,MinExited ,null, 1);
		lblMinimizar.setIcon(new ImageIcon(Registrarse.class.getResource("/Image/minimizar_azul_oscuro_32px.png")));
		lblMinimizar.setBounds(436, 0, 32, 32);
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
		
			
			
//////////////////////////////////////////////////////////////////////////////////		
////////////////////////////HORARIOS/////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////			
			panelHorarios.setVisible(false);
			
			panelHorarios.setBounds(0, 32, 497, 508);
			contentPane.add(panelHorarios);
			panelHorarios.setColorSecundario(new Color(33, 44, 61));
			panelHorarios.setColorPrimario(new Color(66, 169, 174));
			comboMedico.setBounds(10, 234, 303, 32);
			
			comboMedico.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {	
					}
				}
			});
			panelHorarios.setLayout(null);
			
			JLabel lblNewLabel = new Label(10,67,14,"Ingrese el dia");
			lblNewLabel.setBounds(10, 67, 300, 22);
			panelHorarios.add(lblNewLabel);
			
			JLabel lblRegistrarUnaHora = new Label(10,11,14,"Registrar una Hora para un Paciente");
			lblRegistrarUnaHora.setBounds(10, 11, 300, 22);
			panelHorarios.add(lblRegistrarUnaHora);
			
			JLabel lblIngreseElMes = new Label(10,100,14,"Ingrese el mes");
			lblIngreseElMes.setBounds(10, 100, 300, 22);
			panelHorarios.add(lblIngreseElMes);
			
			JLabel lblSeleccioneUnaHora = new Label(10,177,14,"Seleccione una hora");
			lblSeleccioneUnaHora.setBounds(10, 177, 300, 22);
			panelHorarios.add(lblSeleccioneUnaHora);
			
			JLabel lblIngreseElRut = new Label(10,136,14,"Ingrese el rut de paciente");
			lblIngreseElRut.setBounds(10, 136, 300, 22);
			panelHorarios.add(lblIngreseElRut);
			
			txtDia = new CTextoSecretaria(297, 61, 105, 20);
			txtDia.setBounds(297, 61, 105, 20);
			txtDia.setText("13");
			panelHorarios.add(txtDia);
			
			txtMes = new CTextoSecretaria(198, 94, 204, 20);
			txtMes.setBounds(198, 94, 204, 20);
			txtMes.setText("12");
			panelHorarios.add(txtMes);
			
			textRut = new CTextoSecretaria(198, 130, 204, 20);
			textRut.setBounds(198, 130, 204, 20);
			textRut.setText("00.000.000-0");
			panelHorarios.add(textRut);
			comboHora.setBounds(198, 171, 204, 20);
			
			comboHora.addItem("8:00-9:30");
			comboHora.addItem("9:45-11:15");
			comboHora.addItem("11:30-13:00");
			comboHora.addItem("14:30-16:00");
			comboHora.addItem("16:15-17:45");
			comboHora.addItem("18:00-19:30");
			comboHora.addItem("19:45-21:15");
			panelHorarios.add(comboHora);
			
			JButton btnRegistrarPaciente = new Boton(10, 465, 473, 32,"Registrar Cita");
			btnRegistrarPaciente.setBounds(10, 465, 228, 32);
			btnRegistrarPaciente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboEsp.getSelectedIndex()!=0) {
						if(txtDia.getText().isEmpty()==false || txtMes.getText().isEmpty()==false || textRut.getText().isEmpty()==false ) {
							FechasOcupadas_database fecha = 
									new FechasOcupadas_database(comboHora.getSelectedIndex()+1,
											Integer.parseInt(txtDia.getText().trim()),
											Integer.parseInt(txtMes.getText().trim()));
									if(fecha.buscarFecha()==false) {
										FechasOcupadas_database nuevo = new FechasOcupadas_database(comboHora.getSelectedIndex()+1,
												Integer.parseInt(txtDia.getText().trim()),
												Integer.parseInt(txtMes.getText().trim()),
												textRut.getText(),comboDia.getSelectedIndex()+1,idMedicos[comboMedico.getSelectedIndex()],txtDiagnostico.getText());
										nuevo.insertarDatos();
										JOptionPane.showMessageDialog(contentPane, "Cita registrada","OK",JOptionPane.INFORMATION_MESSAGE);
									}else {JOptionPane.showMessageDialog(contentPane, "Ese dia, mes y hora no esta disponible para una cita","error",JOptionPane.ERROR_MESSAGE);}
						}else {JOptionPane.showMessageDialog(contentPane, "rellene los campos","Error",JOptionPane.ERROR_MESSAGE);}
						
					}else {JOptionPane.showMessageDialog(contentPane, "seleccione una especialidad, y luego un doctor","Error",JOptionPane.ERROR_MESSAGE);}
				}
			});
			panelHorarios.add(btnRegistrarPaciente);
			comboDia.setBounds(198, 61, 97, 20);
			
			comboDia.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"}));
			panelHorarios.add(comboDia);
			txtDiagnostico.setBounds(189, 326, 84, 55);
			txtDiagnostico.setVisible(false);
			panelHorarios.add(txtDiagnostico);
			panelHorarios.add(comboMedico);
			comboEsp.setBounds(10, 202, 303, 32);
			
			comboEsp.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					comboMedico.removeAllItems();
					if(!comboEsp.getItemAt(0).toString().equals(comboEsp.getSelectedItem())){
						// vamos a guardar los id de los medicos para poder tener 
						// acceso a ellos, ya que en el combo box se mostrara el nombre y apellido juntos
						idMedicos = new int[100];
						filtrarMedico(idMedicos);
					}	
				}	
			});
			panelHorarios.add(comboEsp);
			
			JButton btnMostrarHorarioDel = new Boton(323, 266, 161, 61,"Horario de Medico");
			btnMostrarHorarioDel.setBounds(323, 266, 161, 61);
			btnMostrarHorarioDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(idMedicos!=null) {
						
						HorarioMedico horario = new HorarioMedico(idMedicos[comboMedico.getSelectedIndex()]);
						horario.setVisible(true);
					}
				}
			});
			panelHorarios.add(btnMostrarHorarioDel);
			
			JList listFechas = new JList();
			listFechas.setBounds(1, 1, 298, 98);
			listFechas.setForeground(new Color(255, 255, 255));
			listFechas.setBorder(null);
			listFechas.setBackground(new Color(19, 30, 49));
			panelHorarios.add(listFechas);
			
			listFechas.setLayoutOrientation(JList.VERTICAL);
			JScrollPane scrollbar = new JScrollPane(listFechas);
			scrollbar.setBounds(10, 300, 300, 100);
			scrollbar.setBackground(new Color(0, 255, 255));
			panelHorarios.add(scrollbar);
			
			JButton btnMostrarFechas = new Boton(10, 266, 303, 32,"Mostrar Fechas Ocupadas");
			btnMostrarFechas.setBounds(10, 266, 303, 32);
			btnMostrarFechas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(idMedicos!=null) {
						Object[] fechas = new Object[500];
						guardarFechasOcupadas(fechas);
						listFechas.setListData(fechas);
						
					}else {JOptionPane.showMessageDialog(contentPane, "Seleccione una especialidad","Error",JOptionPane.ERROR_MESSAGE);}
				}
			});
			btnMostrarFechas.setFont(new Font("Sitka Small", Font.ITALIC, 14));
			panelHorarios.add(btnMostrarFechas);
			
			JButton btnBuscarFechasOcupadas = new Boton(323, 202, 160, 61,"Verificar Fecha");
			btnBuscarFechasOcupadas.setBounds(323, 202, 160, 61);
			btnBuscarFechasOcupadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboEsp.getSelectedIndex()!=0) {
						if(txtDia.getText().isEmpty()==false || txtMes.getText().isEmpty()==false || textRut.getText().isEmpty()==false ) {
							FechasOcupadas_database fecha = 
									new FechasOcupadas_database(comboHora.getSelectedIndex()+1,
											Integer.parseInt(txtDia.getText().trim()),
											Integer.parseInt(txtMes.getText().trim()));
									if(fecha.buscarFecha()==false) {
										JOptionPane.showMessageDialog(contentPane, "Ese dia, mes y hora esta disponible para una cita","OK",JOptionPane.INFORMATION_MESSAGE);
									}else {JOptionPane.showMessageDialog(contentPane, "Ese dia, mes y hora no esta disponible para una cita","error",JOptionPane.ERROR_MESSAGE);}
							
						}else {JOptionPane.showMessageDialog(contentPane, "Rellene todos los campos","Error",JOptionPane.ERROR_MESSAGE);}
					}else {JOptionPane.showMessageDialog(contentPane, "Seleccione una especialidad para poder verificar su fecha","Error",JOptionPane.ERROR_MESSAGE);}
				}
			});
			panelHorarios.add(btnBuscarFechasOcupadas);
			
			Boton btnEliminarCita = new Boton(10, 465, 473, 32, "Eliminar Cita");
			btnEliminarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(comboEsp.getSelectedIndex()!=0) {
						if(txtDia.getText().isEmpty()==false || txtMes.getText().isEmpty()==false  ) {
							
							FechasOcupadas_database.eliminarCita(idMedicos[comboMedico.getSelectedIndex()], txtDia.getText(), txtMes.getText(), comboHora.getSelectedIndex()+1);
								
							
						}else {JOptionPane.showMessageDialog(contentPane, "Rellene los campos del dia y mes, no se olvide de seleccionar una hora","Error",JOptionPane.ERROR_MESSAGE);}
					}else {JOptionPane.showMessageDialog(contentPane, "Seleccione una especialidad y posteriormente un medico para eliminar una cita","Error",JOptionPane.ERROR_MESSAGE);}
					
		
				}
			});
			btnEliminarCita.setBounds(248, 465, 228, 32);
			panelHorarios.add(btnEliminarCita);
		
		panelFRM.setBounds(0, 32, 497, 508);
		contentPane.add(panelFRM);
		panelFRM.setColorSecundario(new Color(33, 44, 61));
		panelFRM.setColorPrimario(new Color(66, 169, 174));
		panelFRM.setLayout(null);
		
		txtNombre = new CTextoSecretaria(122,11,128,38);
		panelFRM.add(txtNombre);
		
		txtApellidos = new CTextoSecretaria(122,60,128,38);
		panelFRM.add(txtApellidos);
		
		txtFecha = new CTextoSecretaria(122,109,128,38);
		txtFecha.setEditable(false);
		panelFRM.add(txtFecha);
		
		txtRut = new CTextoSecretaria(122,158,128,38);
		panelFRM.add(txtRut);
		
		txtDireccion = new CTextoSecretaria(122,256,365,38);
		panelFRM.add(txtDireccion);
		
		txtTelefono = new CTextoSecretaria(122,207,128,38);
		panelFRM.add(txtTelefono);
		
		txtStatus = new CTextoSecretaria(10, 348, 477,38);
		txtStatus.setEditable(false);
		panelFRM.add(txtStatus);
		
		JLabel lblNombre = new Label(10, 23, 15,"NOMBRE:");
		panelFRM.add(lblNombre);
		
		JLabel lblApellidos = new Label(10, 72, 15,"APELLIDOS:");
		panelFRM.add(lblApellidos);
		
		JLabel lblFecha = new Label(10, 121, 15,"FECHA:");
		panelFRM.add(lblFecha);
		
		JLabel lblRut = new Label(10, 164,15,"RUT:");
		panelFRM.add(lblRut);
		
		JLabel lblDireccion = new Label(10, 265,15,"DIRECCION:");
		panelFRM.add(lblDireccion);
		
		JLabel lblTelefono = new Label(10,216,15,"TELEFONO:");
		panelFRM.add(lblTelefono);
		
		JLabel lblRegistrar = new Label(18, 472,11,"REGISTRAR");
		panelFRM.add(lblRegistrar);
		
		JLabel lblActualizar = new Label(218, 472,11,"ACTUALIZAR");
		panelFRM.add(lblActualizar);
		
		JLabel lblBuscar = new Label(101, 472,11,"BUSCAR POR RUT");
		panelFRM.add(lblBuscar);
		
		JLabel lblEliminar = new Label(309, 472,11,"ELIMINAR");
		panelFRM.add(lblEliminar);
		
		JLabel lblEliminarTodo = new Label(392, 472,11,"LIMPIAR TODO");
		panelFRM.add(lblEliminarTodo);
		
		JLabel btnRegistrar = new JLabel("");
		
			botonesSecretaria( 1, btnRegistrar, registrarBlanco, registrarCeleste, registrarGris,null);
			btnRegistrar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px_1.png")));
			btnRegistrar.setBounds(29, 397, 64, 64);
			panelFRM.add(btnRegistrar);
			
			JLabel btnActualizar = new JLabel("");
			botonesSecretaria( 2, btnActualizar, actualizarBlanco, actualizarCeleste, actualizarGris,null);
			btnActualizar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px_1.png")));
			btnActualizar.setBounds(215, 397, 65, 64);
			panelFRM.add(btnActualizar);
			
			JLabel btnBuscar = new JLabel("");
			botonesSecretaria( 3, btnBuscar, buscarBlanco, buscarCeleste, buscarGris,null);
			btnBuscar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_4.png")));
			btnBuscar.setBounds(122, 397, 64, 64);
			panelFRM.add(btnBuscar);
			
			JLabel btnEliminar = new JLabel("");
			botonesSecretaria( 4, btnEliminar, eliminarBlanco, eliminarCeleste, eliminarGris,null);
			btnEliminar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px.png")));
			btnEliminar.setBounds(309, 397, 64, 64);
			panelFRM.add(btnEliminar);
			
			JLabel btnLimpiar = new JLabel("");
			botonesSecretaria( 5, btnLimpiar, limpiarBlanco, limpiarCeleste, limpiarGris,null);
			btnLimpiar.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px.png")));
			btnLimpiar.setBounds(402, 397, 64, 64);
			panelFRM.add(btnLimpiar);
				
				RSDateChooser calendarioRS = new RSDateChooser();
				calendarioRS.addPropertyChangeListener("DatoFecha",new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent arg0) {
						if(arg0.getNewValue() !=null) {
						JOptionPane.showMessageDialog(contentPane, "Seleccione una fecha"+arg0.getPropertyName()+":"+arg0.getNewValue(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				calendarioRS.setColorBackground(new Color(19, 30, 49));
				calendarioRS.setBounds(new Rectangle(0, 0, 0, 40));
				calendarioRS.setRequestFocusEnabled(false);
				calendarioRS.setBorder(null);
				calendarioRS.setBounds(236, 109, 38, 38);
				calendarioRS.setOpaque(false);
				
				
				panelFRM.add(calendarioRS);
				
				JLabel lvlAdd = new JLabel("");
				botonesSecretaria( 6, lvlAdd, addBlanco, addCeleste , addGris, calendarioRS);
				lvlAdd.setIcon(new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px.png")));
				lvlAdd.setBounds(271, 109, 32, 38);
				panelFRM.add(lvlAdd);
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
		
		comboEspecialidades();
				
	}
	
//////////////////////////////////////////////////////////////////////////////////
////////////////////////////MODULOS/////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	
	private void botonesSecretaria(int tarea, JLabel label, Icon blanco, Icon celeste, Icon gris, RSDateChooser calendarioRS) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				switch(tarea) {
				case 1: registrarPacienteActionPerformed(evt);break;
				case 2: actualizarPacienteActionPerformed(evt);break;
				case 3: buscarPacienteActionPerformed(evt);break;
				case 4: eliminarPacienteActionPerformed(evt);break;
				case 5: limpiarPacienteActionPerformed(evt);break;
				case 6: String formatoFecha = "dd/MM/yyyy";
				SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
				txtFecha.setText(formateador.format(calendarioRS.getDatoFecha()));break;
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				label.setIcon(blanco);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(celeste);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				label.setIcon(gris);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label.setIcon(blanco);
			}
		});
	}
	
	private void guardarFechasOcupadas(Object fechas[]) {
		int i=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		String hora;
		
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			String sql = "SELECT * FROM fechas_ocupadas WHERE id_medico="+idMedicos[comboMedico.getSelectedIndex()];
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				hora=Dias.numeroAFecha(rs.getInt(5));
				
				fechas[i]="Fecha: "+rs.getInt(6)+"/"+rs.getInt(4)+"    Rut: "+rs.getString(7)  +"      Hora: "+hora;
				i++;
			}
			ps.close();
			rs.close();
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	private void filtrarMedico(int idMedicos[]) {
		PreparedStatement ps = null;
		ResultSet rs = null;
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
	@SuppressWarnings("unchecked")
	private void comboEspecialidades() {
		PreparedStatement ps = null;
		ResultSet rs = null;
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
	
	private void registrarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarProveedorActionPerformed
        PacientesVO pac = new PacientesVO();
        
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
        	     DejarBlanco();
        	     cargarPacientes(0);
        	
        }
    }//GEN-LAST:event_registrarProveedorActionPerformed

	private void actualizarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarProveedorActionPerformed
        PacientesVO pac = new PacientesVO();
        pac.setIdPaciente(PacientesDAO.getId(txtRut.getText()));
        pac.setNombre(txtNombre.getText());
        pac.setApellidos(txtApellidos.getText());
        pac.setFecha_nacimiento(txtFecha.getText());
        pac.setRut(txtRut.getText());
        pac.setDireccion(txtDireccion.getText());
        pac.setTelefono(txtTelefono.getText());
        String resp = PacientesDAO.ActualizarPacientes(pac);
        txtStatus.setText(resp);
        DejarBlanco();
        cargarPacientes(0);
    }//GEN-LAST:event_actualizarProveedorActionPerformed
	
	private void buscarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarProveedorActionPerformed
			
			if(txtRut.getText().isEmpty()) {
				txtStatus.setText("Porfavor, digite el RUT del paciente");
			}else {
			
			PacientesVO pac = PacientesDAO.buscarPacientes(txtRut.getText());
	    
	        txtNombre.setText(pac.getNombre());
	        txtApellidos.setText(pac.getApellidos());
	        txtFecha.setText(pac.getFecha_nacimiento());
	        txtRut.setText(pac.getRut());
	        txtDireccion.setText(pac.getDireccion());
	        txtTelefono.setText(pac.getTelefono());
	        txtStatus.setText(pac.getResultado());
			}
	    }
	
	private void eliminarPacienteActionPerformed(java.awt.event.MouseEvent evt) {
		if(txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtFecha.getText().isEmpty()
        		|| txtRut.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty()) 
        {
        txtStatus.setText("Complete todos los datos para eliminar al paciente");
        }
        else {
        String resp = PacientesDAO.eliminarPacientes(txtRut.getText());
        DejarBlanco();
        txtStatus.setText(resp);
        cargarPacientes(0);
        }
    }

	private void limpiarPacienteActionPerformed(java.awt.event.MouseEvent evt) {
    	DejarBlanco();
        txtStatus.setText("");
    }
	
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
	
	public class eventoCerrar implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent arg0) {dispose();}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
    }
	
	public void DejarBlanco() {
		txtNombre.setText("");
        txtApellidos.setText("");
        txtFecha.setText("");
        txtRut.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
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
	
	TextArea txtDiagnostico = new TextArea();
	@SuppressWarnings("rawtypes")
	JComboBox comboDia = new ComboBox(198, 61, 97, 20);
	@SuppressWarnings("rawtypes")
	private JComboBox comboHora = new ComboBox(198, 171, 204, 20);
	@SuppressWarnings("unused")
	private int i=0;
	private int idMedicos[]=null;
	@SuppressWarnings("rawtypes")
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
	ImageIcon MinEntered = new ImageIcon(Registrarse.class.getResource("/Image/minimizar_blanco_32px.png"));
	ImageIcon MinExited = new ImageIcon(Registrarse.class.getResource("/Image/minimizar_azul_oscuro_32px.png"));
	ImageIcon CerrEntered = new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px_1.png"));
	ImageIcon CerrExited = new ImageIcon(Registrarse.class.getResource("/Image/icons8_close_window_32px.png"));
	ImageIcon registrarBlanco = new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px_4.png"));
	ImageIcon registrarCeleste = new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px_1.png"));
	ImageIcon registrarGris = new ImageIcon(Secre.class.getResource("/Image/icons8_add_user_male_64px.png"));
	ImageIcon actualizarBlanco = new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px_2.png"));
	ImageIcon actualizarCeleste = new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px_1.png"));
	ImageIcon actualizarGris = new ImageIcon(Secre.class.getResource("/Image/icons8_update_user_64px.png"));
	ImageIcon buscarBlanco = new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_3.png"));
	ImageIcon buscarCeleste = new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_4.png"));
	ImageIcon buscarGris = new ImageIcon(Secre.class.getResource("/Image/icons8_search_more_64px_1.png"));
	ImageIcon eliminarBlanco = new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px_1.png"));
	ImageIcon eliminarCeleste = new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px.png"));
	ImageIcon eliminarGris = new ImageIcon(Secre.class.getResource("/Image/icons8_denied_64px_3.png"));
	ImageIcon limpiarBlanco = new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px_1.png"));
	ImageIcon limpiarCeleste = new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px.png"));
	ImageIcon limpiarGris = new ImageIcon(Secre.class.getResource("/Image/icons8_trash_64px_2.png"));
	ImageIcon addGris = new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px_1.png"));
	ImageIcon addBlanco = new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px_2.png"));
	ImageIcon addCeleste = new ImageIcon(Secre.class.getResource("/Image/icons8_add_32px.png"));
	int xx,xy;
	@SuppressWarnings("rawtypes")
	JComboBox comboEsp = new ComboBox(10, 202, 303, 32);
	@SuppressWarnings("rawtypes")
	JComboBox comboMedico = new ComboBox(10, 234, 303, 32);
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField textRut;
}
