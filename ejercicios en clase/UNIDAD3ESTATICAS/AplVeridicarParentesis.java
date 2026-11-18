package UNIDAD3ESTATICAS;

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
