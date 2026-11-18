package UNIDAD3DINAMICA;

public class ListaDbl <T>{
	
	private NodoDbl<T> frente;
	private NodoDbl<T> fin;
	private T          dr;
	private int        largo;
	private NodoDbl<T> nuevo;
	
	public ListaDbl() {
		frente=fin=null;
		largo=0;
	}
	public boolean InsertarFrente(T dato) {
		if( !CrearNodo(dato))
			return false;
		largo++;
		// PRIMER NODOS
		if(frente==null) {
			frente=fin=nuevo;
		} else {
			frente.setAnt(nuevo);
			nuevo.setSig(frente);
			frente=nuevo;
		}
		return true;
	}
	public boolean InsertarFin(T dato) {
		if( !CrearNodo(dato))
			return false;
		// PRIMER NODOS
		largo++;
		if(frente==null) {
			frente=fin=nuevo;
		} else {
			fin.setSig(nuevo);
			nuevo.setAnt(fin);
			fin=nuevo;
		}		
		return true;
	}
	public boolean InsertarOrdenado(T dato) {
		// primer nodo de la lista
		if(frente==null) {
			return InsertarFrente(dato);
		}
		String texto = dato.toString();
		// si el dato va al inicio de la lisa
		if( texto.compareTo(frente.getInfo().toString())<=0) {
			return InsertarFrente(dato);
		}
		// si el dato va el final de la lista
		if( texto.compareTo(fin.getInfo().toString())>=0) {
			return InsertarFin(dato);
		}
		
		// entre dos nodos
		if( !CrearNodo(dato))
			return false;
		NodoDbl<T> aux=frente;
		largo++;
		while ( texto.compareTo(aux.getInfo().toString())>0)
			aux=aux.getSig();
		NodoDbl<T> ant=aux.getAnt();
		
		nuevo.setSig(aux);
		nuevo.setAnt(ant);
		ant.setSig(nuevo);
		aux.setAnt(nuevo);
		
		
		return true;
	}
	private boolean CrearNodo(T dato) {
		try {
			nuevo=new NodoDbl(dato);
		} catch (OutOfMemoryError e) {
			return false;
		}
		return true;
	}
	public boolean Borrar(int posicion) {
		if(posicion<1 || posicion>largo)
		return false;
		largo--;
		// unico de la lista
		if(frente==fin) {
			dr=frente.getInfo();
			frente=fin=null;
			return true;
		}
		// frente
		if(posicion==1) {
			dr=frente.getInfo();
			frente=frente.getSig();
			frente.setAnt(null);
			return true;
		}
		if(posicion==largo+1) {
			dr=fin.getInfo();
			fin=fin.getAnt();
			fin.setSig(null);
			return true;
		}
		// entre dos nodos
		NodoDbl<T> aux = frente;
		for(int i=1 ; i<posicion ; i++)
			aux=aux.getSig();
		dr=aux.getInfo();
		aux.getSig().setAnt(aux.getAnt());
		aux.getAnt().setSig(aux.getSig());
		return true;
		
		
	}
	public boolean Borrar(T dato) {
		int pos=0;
		for(NodoDbl<T> aux = frente ; aux !=null ; aux=aux.getSig()) {
			pos++;
			if(aux.getInfo().toString().equalsIgnoreCase(dato.toString())) {
				return Borrar(pos);
			}
			
		}
		return false;
	}
	public boolean Buscar(T dato) {
		for(NodoDbl<T> aux = frente ; aux !=null ; aux=aux.getSig()) {

			if(aux.getInfo().toString().equalsIgnoreCase(dato.toString())) {
				dr=aux.getInfo();
				return true;
			}
			
		}
		return false;
		
	}
	public int length() {
		return largo;
	}
	public NodoDbl<T> getFrente() {
		return frente;
	}
	public void setFrente(NodoDbl<T> frente) {
		this.frente = frente;
	}
	public NodoDbl<T> getFin() {
		return fin;
	}
	public void setFin(NodoDbl<T> fin) {
		this.fin = fin;
	}
	public T getDr() {
		return dr;
	}
	public void setDr(T dr) {
		this.dr = dr;
	}

}
