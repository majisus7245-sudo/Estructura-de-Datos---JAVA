package U2_EstructurasLineales.ejercicios.estaticas;

import U0_Diagnostico.utilerias.Rutinas;
class Reporte {
	private int comp,hojas,prioridad;
	private String usuario;
	public Reporte(int comp, int hojas, int prioridad,String usuario) {
		this.comp=comp;
		this.hojas=hojas;
		this.prioridad=prioridad;
		this.usuario=usuario;
	}
	public String toString() {
		return Rutinas.PonCeros(comp,3)+Rutinas.PonBlancos(usuario,20)+prioridad;
	}
	public String getUsuario() {
		return usuario;
	}
	public int getComp() {
		return comp;
	}

	public int getHojas() {
		return hojas;
	}

	public int getPrioridad() {
		return prioridad;
	}


	
}
class MyInteger {
	private int dato;
	public MyInteger(int dato) {
		this.dato=dato;
	}
	public int getDato() {
		return dato;
	}
	public String toString() {
		return Rutinas.PonCeros(dato, 5);
	}
}
public class AplColaOrdenada {

	public static void main(String[] args) {
		ColaOrdenada<Reporte> colaOrdenada=new ColaOrdenada(10);
		
		System.out.println(colaOrdenada.Enviar(new Reporte(5,50,3,"juan")));
		System.out.println(colaOrdenada.Enviar(new Reporte(5,50,1,"juan")));
		System.out.println(colaOrdenada.Enviar(new Reporte(5,50,2,"juan")));
		System.out.println(colaOrdenada.Enviar(new Reporte(2,50,3,"juan")));
		System.out.println(colaOrdenada.Enviar(new Reporte(100,50,2,"Alicia")));
		System.out.println(colaOrdenada.Enviar(new Reporte(99,50,1,"Alicia")));
		System.out.println(colaOrdenada.EstadoActual(1));
		boolean ban=colaOrdenada.Imprimir();
		System.out.println("Imprimitr "+ban);
		if(ban) {
			System.out.println("se imprimió un reporte con los sig datos");
			System.out.println(colaOrdenada.getDr().getUsuario());
		}
		
		ColaOrdenada<Integer> colaOrdenada1=new ColaOrdenada(10);
		
		System.out.println(colaOrdenada1.Enviar(new Integer(20)));
		System.out.println(colaOrdenada1.Enviar(new Integer(100)));
		System.out.println(colaOrdenada1.Enviar(new Integer(30)));
		System.out.println("--------------------");
		colaOrdenada1.EstadoActual();

ColaOrdenada<MyInteger> colaOrdenada2=new ColaOrdenada(10);
		
		System.out.println(colaOrdenada2.Enviar(new MyInteger(200)));
		System.out.println(colaOrdenada2.Enviar(new MyInteger(1000)));
		System.out.println(colaOrdenada2.Enviar(new MyInteger(50)));
		System.out.println(colaOrdenada2.Enviar(new MyInteger(300)));
		System.out.println("--------------------");
		colaOrdenada2.EstadoActual();
	}

}
