package U1_Recursividad.ejercicios;

public class RecursividadMal {

	public static void main(String[] args) {
		
		System.out.println("EJECUTO EL MAIN");
		MetA(10);
		System.out.println("TERMINO EL METODO");
		

	}
	public static void Met1(int aRR) {
		// caso base o caso trivial
		if( aRR ==0)
			return;
		System.out.println(aRR);
		Met1(aRR-1); // CASO RECURSIVO, RECURSIVIDAD DIRECTA
		System.out.println("*** "+aRR);
	}
	
	public static void MetA(int a) {
		if(a==0)
			return;
		System.out.println("MetA "+a);
		MetB(a-1); // CASO RECURSIVO, RECIRSIVIDAD INDIRECTA
		System.out.println("META recursividad de SALIDA "+a);
	}
	public static void MetB(int a) {
		if(a==0)
			return;
		System.out.println("MetB "+a);
		MetA(a-1);//CASO RECURSIVO, RECIRSIVIDAD INDIRECTA
		System.out.println("METB recursividad de SALIDA "+a);
	}
	
	public static int SumaArreglo(int [] a , int pos) {
		if(pos==1)
			return a[0];
		return SumaArreglo(a,pos-1)+a[pos-1];
		
	}
}
