package mantenimientos;

public class Dias {
	public Dias() {
		
	}
	public static String numeroAFecha(int numero) {
		String fecha=null;
		
		if(numero==1) {
			fecha="8:00-9:30";
		}else if(numero==2) {
			fecha="9:45-11:15";
		}else if(numero==3) {
			fecha="11:30-13:00";
		}else if(numero==4) {
			fecha="14:30-16:00";
		}else if(numero==5) {
			fecha="16:15-17:45";
		}else if(numero==6) {
			fecha="18:00-19:30";
		}else if(numero==7) {
			fecha="19:45-21:15";
		}
		
		return fecha;
	}
	public static int fechaANumero(String fecha) {
		int numero=0;
		
		if(fecha.equals("8:00-9:30")) {
			numero=1;
		}else if(fecha.equals("9:45-11:15")) {
			numero=2;
		}else if(fecha.equals("11:30-13:00")) {
			numero=3;
		}else if(fecha.equals("14:30-16:00")) {
			numero=4;
		}else if(fecha.equals("16:15-17:45")) {
			numero=5;
		}else if(fecha.equals("18:00-19:30")) {
			numero=6;
		}else if(fecha.equals("19:45-21:15")) {
			numero=7;
		}
		
		return numero;
	}
}
