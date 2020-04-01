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

import classDAO.PacientesDAO;
import classDAO.EspecialidadesDAO;
import main.Login;
import classVO.Usuario;
import mantenimientos.Arrays;
import mantenimientos.WolframExecute;
import mantenimientos.WolframInput;
import rspanelgradiente.RSPanelGradiente;
import utils.Boton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.concurrent.TimeUnit;

import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class Administrador extends JFrame {

	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
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
	public Administrador() {
		
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
	
	protected void salir() {
		dispose();
		Login nuevo= new Login();
		nuevo.setVisible(true);
	}
		
	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		RSPanelGradiente panel_izq = new RSPanelGradiente();
		panel_izq.setBounds(0, 0, 800, 448);
		panel_izq.setColorSecundario(new Color(33, 44, 61));
		panel_izq.setColorPrimario(new Color(66, 169, 174));
		contentPane.add(panel_izq);
		panel_izq.setLayout(null);
		
		JButton btnSALIR = new Boton(44,368, 113, 38,"Regresar");
		btnSALIR.setText("Regresar");
		btnSALIR.setBounds(32, 40, 113, 38);
		panel_izq.add(btnSALIR);
		btnSALIR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salir();
				
			}
			
		});
		/*btnGrafo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] parametro1Aux=new int[Especialidades_database.obtenerEspecialidades()+Pacientes_database.obtenerPacientes()];
				
				String elmaineador=wolframInput.parametro2(parametro1Aux);
				int max= elmaineador.length();
				String elmaineador2=Arrays.replace(elmaineador,max-1,' ');
				String parametro1=Arrays.intToStringWM(parametro1Aux);
				System.out.println("string: "+elmaineador2+"su tamaño:"+max+ "parametro1: "+parametro1);
				
			}
			
		});*/
		
		JLabel datos = new JLabel("");
		datos.setBounds(197, 11, 603, 395);
		panel_izq.add(datos);
		
		Boton btnBarras = new Boton(44, 368, 113, 38, "SALIR");
		btnBarras.setText("Grafico");
		btnBarras.setBounds(32, 110, 113, 38);
		panel_izq.add(btnBarras);
		btnBarras.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String input=WolframInput.parametro1Barchart();
				
				
				String input2 = WolframInput.parametro2Barchart();
				
				ImageIcon imagen = WolframExecute.barchar(input,input2);
				System.out.println("paso");
				datos.setIcon(imagen);
			}
			
		});
		
		
		
		Boton btnGrafo = new Boton(44, 368, 113, 38, "Grafo");
		btnGrafo.setBounds(32, 290, 113, 38);
		panel_izq.add(btnGrafo);
		
		Boton btngrafocom = new Boton(44, 368, 113, 38, "Comunnity");
		btngrafocom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] parametro1Aux=new int[EspecialidadesDAO.obtenerEspecialidades()+PacientesDAO.obtenerPacientes()];
				int x=EspecialidadesDAO.obtenerEspecialidades();
				int transformar[][]= new int[x][2];
				String parametro=WolframInput.parametro2(parametro1Aux,transformar);
				int max= parametro.length();
				String parametro2=Arrays.replace(parametro,max-1,' ');
				
				
				String parametro1=Arrays.intToStringWM(parametro1Aux);
				ImageIcon imagen= new ImageIcon();
				imagen=WolframExecute.grafocom(parametro1,parametro2,transformar,x);
				datos.setIcon(imagen);
			}
		});
		btngrafocom.setText("Comunnity");
		btngrafocom.setBounds(32, 197, 113, 38);
		panel_izq.add(btngrafocom);
		btnGrafo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int[] parametro1Aux=new int[EspecialidadesDAO.obtenerEspecialidades()+PacientesDAO.obtenerPacientes()];
				int x=EspecialidadesDAO.obtenerEspecialidades();
				int transformar[][]= new int[x][2];
				String parametro=WolframInput.parametro2(parametro1Aux,transformar);
				int max= parametro.length();
				String parametro2=Arrays.replace(parametro,max-1,' ');
				
				
				String parametro1=Arrays.intToStringWM(parametro1Aux);
				ImageIcon imagen= new ImageIcon();
				imagen=WolframExecute.grafo(parametro1,parametro2,transformar,x);
				datos.setIcon(imagen);
				
			}
			
		});
		
		
		
	}
}	