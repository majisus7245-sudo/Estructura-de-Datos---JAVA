package U5_MetodosDeBusqueda.ejercicios;

public class Busquedas <T> {
	private int posicion;
	 public int Secuencial(T [] arreglo, T dato) {
		 int i,res;
		 for(i=0 ; i<arreglo.length;i++) {
			 if( arreglo[i]==null)
				 return -1;
			 res=arreglo[i].toString().compareTo(dato.toString());
			 if(res==0)
				 return i;
		 }
		return -1;
	}
	public int Binaria(T [] arreglo, T dato) {
		return -1;
	}
}
