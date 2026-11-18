package U2_EstructurasLineales.ejercicios.dinamicas;

public class AplPolinomio {

	public static void main(String[] args) {
		Polinomios poli=new Polinomios();
		
		System.out.println("captura del primer polinomio");
		poli.Capturar(1);
		
		System.out.println("captura del segundo polinomio");
		poli.Capturar(2);
		
		
		
		
		poli.Sumar();
		poli.Imprimir(1);
		poli.Imprimir(2);
		poli.Imprimir(3);
		
	}

}
