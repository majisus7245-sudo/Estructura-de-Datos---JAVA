package UNIDAD3ESTATICAS;

public class VeridicarParentesis {
	private String expresion, msg;
	private Pila<Character> pila;
	public VeridicarParentesis() {
		this("");
	}
	public VeridicarParentesis(String expresion) {
		this.expresion=expresion;
		pila=new Pila(10);
	}
	public boolean Verificar(String expresion) {
		this.expresion=expresion;
		return Verificar();
	}
	public boolean Verificar() {
		if(expresion.isEmpty()) {
			msg="no hay expresión para evaluar";
			return false;
		}
		char car, car_abre;
		for(int i=0 ; i<expresion.length() ; i++) {
			car=expresion.charAt(i);
			if("([{<>}])".indexOf(car+"")==-1)
				continue;
			if("([{<".indexOf(car+"")>=0) { // parentesis que abre
				if(!pila.Insertar(car)) {
					msg="La capicidad de la PILA, no es suficiente para resolver la expresion";
					return false;
				}
				continue;
			}
			// Llegó un parentesis que cierra
			
			if(!pila.Retirar()) {
				msg="Hay un parentesis cerrando sin que se haya un parentesis abierto";
				return false;
			}
			
			car_abre=(char) pila.getDr();
			
			if(car_abre=='(' && car != ')' ||
			   car_abre=='[' && car != ']' ||
			   car_abre=='{' && car != '}' ||
			   car_abre=='<' && car != '>'
					) {
				msg="un parentesis "+car_abre+", se intenta cerrar con "+car;
				return false;
			}
		}
		if(!pila.Vacia()) {
			int cont=0; 
			while(pila.Retirar())
				cont++;
			msg="Exitenten " + cont+  " parentesis abiertos sin cerrar";
			return false;
		}
		msg="Expresión correctamente parentisada";
		return true;
	}
	public String getExpresion() {
		return expresion;
	}
	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
