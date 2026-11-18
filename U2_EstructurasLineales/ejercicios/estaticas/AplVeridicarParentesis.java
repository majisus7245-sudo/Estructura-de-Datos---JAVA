package U2_EstructurasLineales.ejercicios.estaticas;

public class AplVeridicarParentesis {

	public static void main(String[] args) {
		VeridicarParentesis verificar = new VeridicarParentesis();
		System.out.println(verificar.Verificar("((")+" "+verificar.getMsg() );
		if(verificar.Verificar("(([>")) {
			System.out.println("EXPRESION OK");
		}
		else {
			System.out.println(verificar.getMsg());
		}
	}

}
