package mantenimientos;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classDAO.HorariosDAO;
import utils.MySQLConexion;



public class HorarioRandom {
	private int id_medico;
	public HorarioRandom(int id_medico) {
		this.id_medico=id_medico;
	}
	public void generarHorario(){
		int horariosCadaDia=0;
		int i=1;
		int k=0;
		int[] bloques= new int[8];// se guardan los bloques para cada dia para compararlos y que no se repitan
		int bloqueRand=0;
		String[] horas= new String [8];
		while(i<7) {//para cada dia de trabajo se generan x bloques de trabajo
			
			horariosCadaDia=(int) Math.floor(Math.random()*8);
			k=1;
			
			Arrays.rellenarConUnos(bloques);
			while(k<=horariosCadaDia) {
				bloqueRand=(int) Math.floor(Math.random()*8);
				Arrays fArreglo = new Arrays(bloqueRand);
				if(fArreglo.seRepite(bloques)==0) {
					bloques[k]=bloqueRand;
					k++;
				}
			}
			
			Arrays.numerosAHoras(bloques, horas, horariosCadaDia);
			
			HorariosDAO.insertarHorasRandom(horas,id_medico,i,horariosCadaDia);
			
			i++;
		}
		
		
	}
	
}
