package U2_EstructurasLineales.ejercicios.dinamicas;

public class ListaCircular<T> {
	
	private Nodo<T> frente;
	private Nodo<T> fin, nuevo;
	private T       dr;
	private int     largo;
	
	public ListaCircular() {
		frente=fin=null;
		largo=0;
	}
	
	public boolean InsertarFrente(T dato) {
		if(!CrearNodo(dato))
			return false;
		largo++;
		// primer nodo de la lista
		if(frente==null) {
			frente=fin=nuevo;
			fin.setSig(frente);
			return true;
		}
		// insertalo al inicio
		nuevo.setSig(frente);
		frente=nuevo;
		fin.setSig(nuevo);
		
		return true;
	}
	
	private boolean CrearNodo(T dato) {
		try {
			nuevo=new Nodo(dato);
		} catch (OutOfMemoryError e) {
			return false;
		}
		return true;
	}

	public Nodo<T> getFrente() {
		return frente;
	}

	public void setFrente(Nodo<T> frente) {
		this.frente = frente;
	}

	public Nodo<T> getFin() {
		return fin;
	}

	public void setFin(Nodo<T> fin) {
		this.fin = fin;
	}

	public T getDr() {
		return dr;
	}

	public void setDr(T dr) {
		this.dr = dr;
	}

	public int getLength() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}
	
}
