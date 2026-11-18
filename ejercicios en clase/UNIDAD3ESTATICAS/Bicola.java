package UNIDAD3ESTATICAS;

public class Bicola <T>{
	
	private int tamaño,frente,fin;
	private T [] bicola;
	private T dr;
	
	public Bicola() {
		this(10);
	}
	public Bicola(int tamaño) {
		this.tamaño=tamaño;
		bicola=(T[]) new Object[tamaño];
		frente=fin=-1;
	}
	public boolean Insertar(T dato) {
		if(Llena())
			return false;
		if(frente==-1)
			frente=fin=0;
		else 
			fin++;
		bicola[fin]=dato;
		return true;
	}
	public boolean RetirarFrente() {
		if(Vacia())
			return false;
		dr=bicola[frente];
		bicola[frente]=null;
		if(frente==fin)
			frente=fin=-1;
		else
			frente++;
		return true;
	}
	public boolean RetirarFin() {
		if(Vacia())
			return false;
		dr=bicola[fin];
		bicola[fin]=null;
		if(frente==fin)
			frente=fin=-1;
		else
			fin--;
		return true;
		
	}
	public boolean Llena() {
		return fin==tamaño-1;
	}
	public boolean Vacia() {
		return fin==-1;
	}
	public int getMaximo() {
		return tamaño;
	}
	public T getDr() {
		return dr;
	}
}
