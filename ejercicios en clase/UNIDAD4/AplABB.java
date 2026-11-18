package UNIDAD4;
import UNIDAD3ESTATICAS.*;
public class AplABB {

	public static void main(String[] args) {
		ArbolBB<Persona> arbol = new ArbolBB();
		
		arbol.Insertar(new Persona("Raymundo","Campeche",20));
		arbol.Insertar(new Persona("Alicia","Campeche",20));
		arbol.Insertar(new Persona("Juana","Campeche",20));
		arbol.Insertar(new Persona("Alejandro","Campeche",20));
		arbol.Insertar(new Persona("Polo","Campeche",20));
		arbol.Insertar(new Persona("Fderico","Campeche",20));
		arbol.Insertar(new Persona("Victor","Campeche",20));
		arbol.Insertar(new Persona("Christian","Campeche",20));
		arbol.Insertar(new Persona("Tomas","Campeche",20));
		arbol.Insertar(new Persona("Jade","Oaxaca",20));
		arbol.Insertar(new Persona("Daniela","Oaxaca",20));
		
		// Impresion del arbol
		
		Imprimir(arbol);
		
		System.out.println("Altura del arbol "+arbol.Altura());
		
		System.out.println("Borrar Raymundo"+arbol.Borrar(new Persona("Raymundo","Campeche",20) ));
		System.out.println("Altura del arbol "+arbol.Altura());
		
	
		
		if(arbol.Buscar(new Persona("Raymundo","Campeche",0))) {
			System.out.println("Individuo localizadso");
			System.out.println("Nombre"+arbol.getDr().getNombre());
			System.out.println("Nombre"+arbol.getDr().getEstado());
			System.out.println("Nombre"+arbol.getDr().getEdad());
		}
		System.out.println("*****************");
		Imprimir(arbol);
	}
	public static void Imprimir(ArbolBB<Persona> arbol) {
		Imprimir(arbol.getRaiz());
		System.out.println("__________________");
		
	}
	private static void Imprimir(NodoABB<Persona> raiz) {
		if(raiz==null)
			return;
		System.out.println(raiz.getInfo().getNombre());
		Imprimir(raiz.getSubIzq());
		
		Imprimir(raiz.getSubDer());
		
		
	}
	// IMPRIMIR EL CONTENIDO DEL A¿ÁRBOL DE MANERA NO RECURSIVA
	private static void ImprimirNR(NodoABB<Persona> raiz) {
		Pila<NodoABB<Persona>> pila = new Pila(30);
		while (raiz!=null || !pila.Vacia()) {
			if(raiz==null) {
				pila.Retirar();
				raiz=pila.getDr();
			}
			System.out.println(raiz.getInfo().getNombre());
			if(raiz.getSubDer()!=null)
				pila.Insertar(raiz.getSubDer());
			raiz=raiz.getSubIzq();
		}
		
	}
	
}
