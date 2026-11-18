package U2_EstructurasLineales.ejercicios.estaticas;

public class ColaOrdenada <T> {
	private Cola<T> cola;
	public ColaOrdenada() {
		this(10);
	}
	public ColaOrdenada(int tamaño) {
		cola=new Cola(tamaño);
	}
	public boolean Enviar(T dato) {
		if(cola.Llena())
			return false;
		Cola<T> aux = new Cola(cola.getMaximo());
		boolean ban=false; // indica que dato no se ha insertado en la ed cola
		while ( cola.Retirar()) {
			if(cola.getDr().toString().compareTo(dato.toString()) >0 ) {
				aux.Insertar(dato);
				aux.Insertar(cola.getDr());
				ban=true;
				break;
			}
			aux.Insertar(cola.getDr());
		}
		while(cola.Retirar() && aux.Insertar(cola.getDr()));
		if( !ban )
			aux.Insertar(dato);
		while ( aux.Retirar() && cola.Insertar(aux.getDr()));
		return true;
	}
	public boolean Imprimir() {
		// consumir un reporte de la cola, lo que indica que se imprimió
		return cola.Retirar();
	}
	public void EstadoActual() {
		Cola<T> aux=new Cola(cola.getMaximo());
		while ( cola.Retirar()) {
			System.out.println(cola.getDr().toString());
			aux.Insertar(cola.getDr());
		}
		cola=aux;
	}
	public String EstadoActual(int a) {
		Cola<T> aux=new Cola(cola.getMaximo());
		String contenido="";
		while ( cola.Retirar()) {
			contenido+=cola.getDr().toString()+"***\n";
			aux.Insertar(cola.getDr());
		}
		cola=aux;
		return contenido;
	}
	public T getDr(){
		return cola.getDr();
	}
}
