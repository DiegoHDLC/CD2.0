package mantenimientos;

public class Arrays {
	private int N;
	
	public Arrays(int N) {
		this.N=N;
	}
	public int seRepite(int arreglo[]) {
		int i=0;
		while(i<arreglo.length) {
			if(arreglo[i]==N) {
				return 1;
			}
			i++;
		}
		return 0;
	}
	public static void rellenarConUnos(int arreglo[]) {
		int i=0;
		while(i<arreglo.length) {
			arreglo[i]=-1;
			i++;
		}
	}
	public static void numerosAHoras(int numeros[], String horas[],int horariosCadaDia) {
		int i=1;
	
		while(i<=horariosCadaDia) {
			if(numeros[i]==0) {
				horas[i]="nada";
			}
			else if(numeros[i]==1) {
				horas[i]="8:00-9:30";
			}else if(numeros[i]==2) {
				horas[i]="9:45-11:15";
			}else if(numeros[i]==3) {
				horas[i]="11:30-13:00";
			}else if(numeros[i]==4) {
				horas[i]="14:30-16:00";
			}else if(numeros[i]==5) {
				horas[i]="16:15-17:45";
			}else if(numeros[i]==6) {
				horas[i]="18:00-19:30";
			}else if(numeros[i]==7) {
				horas[i]="19:45-21:15";
			}
			
			i++;
		}
	}
}
