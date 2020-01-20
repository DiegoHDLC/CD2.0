package main;

import java.awt.BorderLayout;
import javafx.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classDAO.PacientesDAO;
import classVO.PacientesVO;
import rspanelgradiente.RSPanelGradiente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import rojerusan.RSMetroTextPlaceHolder;
import rojerusan.RSMaterialButtonRectangleBeanInfo;
import rojerusan.RSMaterialButtonCircle;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import rojeru_san.componentes.RSDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtFecha;
	private JTextField txtRut;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtStatus;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FrmPaciente() {
		initComponents();
		//cargarPacientes(0);
	
	}
	private void initComponents() {
		
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel barra = new JPanel();
		barra.setBackground(new Color(66, 169, 174));
		barra.setBounds(0, 0, 497, 32);
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
		lblCerrar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_close_window_32px.png")));
		lblCerrar.setBounds(465, 0, 32, 32);
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
		lblMinimizar.setBounds(436, 0, 32, 32);
		barra.add(lblMinimizar);
		
		JLabel tituloPaciente = new JLabel("PACIENTE");
		tituloPaciente.setForeground(new Color(33, 44, 61));
		tituloPaciente.setFont(new Font("Sitka Small", Font.BOLD, 15));
		tituloPaciente.setBounds(10, 0, 86, 32);
		barra.add(tituloPaciente);
		
		
		
		RSPanelGradiente panelFRM = new RSPanelGradiente();
		panelFRM.setBounds(0, 32, 497, 508);
		contentPane.add(panelFRM);
		panelFRM.setColorSecundario(new Color(33, 44, 61));
		panelFRM.setColorPrimario(new Color(66, 169, 174));
		panelFRM.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(new Color(255, 255, 255));
		lblID.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblID.setBounds(10, 17, 46, 14);
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
		lblRut.setBounds(10, 213, 46, 14);
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
		lblRegistrar.setBounds(30, 472, 65, 14);
		panelFRM.add(lblRegistrar);
		
		JLabel lblActualizar = new JLabel("ACTUALIZAR");
		lblActualizar.setForeground(new Color(255, 255, 255));
		lblActualizar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblActualizar.setBounds(206, 472, 73, 14);
		panelFRM.add(lblActualizar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblBuscar.setBounds(132, 472, 46, 14);
		panelFRM.add(lblBuscar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setForeground(new Color(255, 255, 255));
		lblEliminar.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblEliminar.setBounds(310, 472, 65, 14);
		panelFRM.add(lblEliminar);
		
		JLabel lblEliminarTodo = new JLabel("LIMPIAR TODO");
		lblEliminarTodo.setForeground(new Color(255, 255, 255));
		lblEliminarTodo.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		lblEliminarTodo.setBounds(397, 472, 83, 14);
		panelFRM.add(lblEliminarTodo);
		
		JLabel btnRegistrar = new JLabel("");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				registrarPacienteActionPerformed(evt);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnRegistrar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_add_user_male_64px_4.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_add_user_male_64px_1.png")));
			}
		});
		btnRegistrar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_add_user_male_64px_1.png")));
		btnRegistrar.setBounds(30, 397, 64, 64);
		panelFRM.add(btnRegistrar);
		
		JLabel btnActualizar = new JLabel("");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarPacienteActionPerformed(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnActualizar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_update_user_64px_2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnActualizar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_update_user_64px_1.png")));
			}
		});
		btnActualizar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_update_user_64px_1.png")));
		btnActualizar.setBounds(208, 397, 65, 64);
		panelFRM.add(btnActualizar);
		
		JLabel btnBuscar = new JLabel("");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarPacienteActionPerformed(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_search_more_64px_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_search_more_64px.png")));
			}
		});
		btnBuscar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_search_more_64px.png")));
		btnBuscar.setBounds(122, 397, 64, 64);
		panelFRM.add(btnBuscar);
		
		JLabel btnEliminar = new JLabel("");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminarPacienteActionPerformed(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_denied_64px_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_denied_64px.png")));
			}
		});
		btnEliminar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_denied_64px.png")));
		btnEliminar.setBounds(300, 397, 64, 64);
		panelFRM.add(btnEliminar);
		
		JLabel btnLimpiar = new JLabel("");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpiarPacienteActionPerformed(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLimpiar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_trash_64px_1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLimpiar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_trash_64px.png")));
			}
		});
		btnLimpiar.setIcon(new ImageIcon(FrmPaciente.class.getResource("/Image/icons8_trash_64px.png")));
		btnLimpiar.setBounds(397, 397, 64, 64);
		panelFRM.add(btnLimpiar);
		
		RSDateChooser chooser = new RSDateChooser();
		chooser.setPlaceholder("SELECCIONAR FECHA");
		chooser.setFormatoFecha("dd/MM/yyyy");
		chooser.setBounds(212, 5, 240, 40);
		panelFRM.add(chooser);
		
		JButton btnAplicarFecha = new JButton("aplicar fecha");
		btnAplicarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PacientesVO pac = new PacientesVO();
				if(chooser.getDatoFecha() == null) {
					JOptionPane.showMessageDialog(contentPane, "Seleccione una fecha", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					String formatoFecha = "dd/MM/yyyy";
					Date fecha = chooser.getDatoFecha();
					SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
					txtFecha.setText(formateador.format(fecha).toString());
					pac.setFecha_nacimiento(txtFecha.getText());
					
					//JOptionPane.showMessageDialog(contentPane, "La fecha seleccionada es:"+formateador.format(fecha), "Información", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnAplicarFecha.setBounds(372, 160, 89, 23);
		panelFRM.add(btnAplicarFecha);
		
	}
	
	private void registrarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarProveedorActionPerformed
        PacientesVO pac = new PacientesVO();
        pac.setNombre(txtNombre.getText());
        pac.setApellidos(txtApellidos.getText());
        if(chooser.getDatoFecha() == null) {
			JOptionPane.showMessageDialog(contentPane, "Seleccione una fecha", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			String formatoFecha = "dd/MM/yyyy";
			Date fecha = chooser.getDatoFecha();
			SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
			txtFecha.setText(formateador.format(fecha).toString());
			pac.setFecha_nacimiento(txtFecha.getText());
        //pac.setFecha_nacimiento(txtFecha.getText());
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
        
        //p_email.setText("");
        cargarPacientes(0);
    }//GEN-LAST:event_actualizarProveedorActionPerformed
	
	private void buscarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarProveedorActionPerformed
	
	        //PacientesVO pac = PacientesDAO.buscarPacientes(txtID.getText());
			PacientesVO pac = PacientesDAO.buscarPacientes(txtRut.getText());
	        txtID.setText(pac.getIdPaciente()+"");
	        txtNombre.setText(pac.getNombre());
	        txtApellidos.setText(pac.getApellidos());
	        txtFecha.setText(pac.getFecha_nacimiento());
	        txtRut.setText(pac.getRut());
	        txtDireccion.setText(pac.getDireccion());
	        txtTelefono.setText(pac.getTelefono());
	        txtStatus.setText(pac.getResultado());
	    }//GEN-LAST:event_buscarProveedorActionPerformed
	
	private void eliminarPacienteActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarProveedorActionPerformed
        String resp = PacientesDAO.eliminarPacientes(txtID.getText());
        txtStatus.setText(resp);
        txtNombre.setText("");
        txtApellidos.setText("");
        txtFecha.setText("");
        txtRut.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        cargarPacientes(0);
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
        //list_pacientes.addItem("Selecciona un paciente");
        for(PacientesVO pac: PacientesDAO.getListPacientes()){
            //list_pacientes.addItem(pac);
            if(pac.getIdPaciente() == busca){
                list_pacientes.setSelectedIndex(index);
            }
            index++;
        }
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPaciente frame = new FrmPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox list_pacientes;
}
