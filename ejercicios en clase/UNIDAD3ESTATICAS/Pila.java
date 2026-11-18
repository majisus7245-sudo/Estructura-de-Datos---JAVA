package UNIDAD3ESTATICAS;
public class Pila <T> {
	private T [] pila;
	private int tope, tamañoMaximo;
	private T dr;
	private String msg;
	public Pila() {
		this(10);
	}
	public Pila(int tamañoMaximo) {
		this.tamañoMaximo=tamañoMaximo;
		
		pila=(T[]) new Object[tamañoMaximo];
		tope=-1;
	}
	public boolean Insertar(T dato) {
		if(Llena()) {
			msg="Pila llena (verflow)";
			return false;
		}
		pila[++tope]=dato;
		msg="Inserción pexitosa";
		return true;
	}
	public boolean Retirar() {
		if(Vacia()) {
			msg="Pila vacia (underflow)";
			return false;
		}
		dr=pila[tope];
		pila[tope--]=null;
		msg="Retiro exitoso";
		return true;
	}
	public boolean Llena() {
		return tope==tamañoMaximo-1;
	}
	public boolean Vacia() {
/*		version 1
		if(tope==-1)
			return true;
		return false;

		VERSION 2
		return tope==-1?true:false;
*/
		return tope==-1;
	}
	public T getDr() {
		return dr;
	}
	public String getMsg() {
		return msg;
	}
	public int getTamañoMaximo() {
		return tamañoMaximo;
	}


}
