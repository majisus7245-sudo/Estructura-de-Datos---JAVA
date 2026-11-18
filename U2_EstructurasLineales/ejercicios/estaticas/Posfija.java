package U2_EstructurasLineales.ejercicios.estaticas;

public class Posfija {
	private Pila<Float> pila;
	private String expresion;
	private String msg;
	private float resultado;
	public Posfija() {
		this("");
	}
	public Posfija(String expresion) {
		this(expresion,10);
	}
	public Posfija(String expresion,int tamaño) {
		this.expresion=expresion;
		pila=new Pila(tamaño);
	}
	public boolean Evaluar(String expresion) {
		this.expresion=expresion;
		return Evaluar();
	}

	public boolean Evaluar() {
		if(expresion.isEmpty()) {
			msg="No proporcionó expresión en notación posfija a evaluar";
			return false;
		}
		// recorres los caracteres de la expresión
		char car;
		for(int i=0 ; i<expresion.length();i++) {
			car=expresion.charAt(i);
			if(car==' ')
				continue;
			// es uno de los siguientes carateres 0-9, +, -, *. /
			if( Character.isDigit(car)) {
				float numero=(float) (car-48);
				if(!(pila.Insertar(numero))) {
					msg="La expresión no puede avaluarse, capacidad pila insifiiente";
					return false;
				}
			}
			if("+-*/".indexOf(car+"")>=0) {
				if(!pila.Retirar() ) {
					msg="la expresión no está bien formada";
					return false;
				}
				float num1=pila.getDr();
				if( !pila.Retirar()) {
					msg="la expresión no est+a bien formada";
					return false;
				}
				float num2=pila.getDr();
				float resParcial=0;
				switch (car) {
				case '+': resParcial=num1+num2;break;
				case '-': resParcial=num2-num1;break;
				case '*': resParcial=num2*num1;break;
				case '/': resParcial=num2/num1;break;
				}
				pila.Insertar(resParcial);
			}
			
		}
		if( !pila.Retirar()) {
			msg="La expresión no es correcta";
			return false;
		}
		if( !pila.Vacia()) {
			msg="La expresión no es correcta";
			return false;
		}
		resultado=pila.getDr();
		return true;
	}
	
	public float getResultado() {
		return resultado;
	}
	public void setResultado(float resultado) {
		this.resultado = resultado;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
