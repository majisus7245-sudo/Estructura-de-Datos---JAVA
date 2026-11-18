package U2_EstructurasLineales.ejercicios.estaticas;

public class AplPosfija {

	public static void main(String[] args) {
		Posfija posfija = new Posfija("9876 20000 400000 2+++");
		
		if( !posfija.Evaluar()) {
			System.out.println(posfija.getMsg());
		} else {
			System.out.println("resultado es "+posfija.getResultado());
		}
		

	}

}
