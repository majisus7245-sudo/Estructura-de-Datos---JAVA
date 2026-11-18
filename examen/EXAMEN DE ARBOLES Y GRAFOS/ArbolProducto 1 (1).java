/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto: Examen unidad 4
 * Fecha: 03 de diciembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/

package ExamenUN4;

import Arbol.ArbolBB;
import Arbol.NodoABB;

public class ArbolProducto {
	
	public static void main(String [] args) {
		ArbolBB<Producto> arbol = new ArbolBB();
		arbol.Insertar(new Producto(797,1));
		arbol.Insertar(new Producto(814,2));
		arbol.Insertar(new Producto(265,2));
		arbol.Insertar(new Producto(149,3));
		arbol.Insertar(new Producto(613,3));
		arbol.Insertar(new Producto(874,3));
		arbol.Insertar(new Producto(810,3));
		arbol.Insertar(new Producto(805,4));
		arbol.Insertar(new Producto(123,4));
		arbol.Insertar(new Producto(174,4));
		arbol.Insertar(new Producto(172,5));
		arbol.Insertar(new Producto(122,4));
		
		Imprimir(arbol);
		
		Eliminar(new Producto(123), arbol);
		
		Imprimir(arbol);
		
	}
	
	public static void Eliminar(Producto producto, ArbolBB<Producto> arbol) {
		Producto raiz;
		if(!arbol.Buscar(producto)) {
			System.out.println("Este producto no existe");
			return;
		}
// AQUI YA SABES QUE EL EXISTE EL NODO QUE CONTIENE EL PRODUCTO
		NodoABB<Producto> nodo = Buscar(arbol.getDr(), arbol.getRaiz());
		if(nodo.getSubDer() == null && nodo.getSubIzq() == null) {
			arbol.Borrar(producto);// NOHAY NIVELES QUE ACTUALIZAR
			return;
		}
// ESTO ES SI TIENE DOS HIJO
		NodoABB<Producto> sustituto = nodo.getSubDer();
		if(sustituto == null) {
			sustituto = nodo.getSubIzq();// TE TIENES QUE IR HASTA EL FINAL DE SUBIZQ
			sustituto.getInfo().setNivel(nodo.getInfo().getNivel());
			Modificar(sustituto.getSubDer());
			Modificar(sustituto.getSubIzq());
			arbol.Borrar(producto);
			return;
		}
		while(sustituto.getSubIzq() != null) {
			sustituto = sustituto.getSubIzq();
		}
		sustituto.getInfo().setNivel(nodo.getInfo().getNivel());
		Modificar(sustituto.getSubDer());
		return;
	}
	public static NodoABB<Producto> Buscar(Producto producto, NodoABB<Producto> raiz){
// NO VALIDA SI NO ESTA POR TENER LA CERTEZA QUE ESTA EN EL ARBOL
		int res = producto.toString().compareTo(raiz.getInfo().toString());
		if(res == 0)
			return raiz;
		if(res < 0)
			return Buscar(producto, raiz.getSubIzq());
		return Buscar(producto, raiz.getSubDer());
	}
	public static void Modificar(NodoABB<Producto> nodo) {
		if(nodo == null)
			return;
		nodo.getInfo().setNivel(nodo.getInfo().getNivel()-1);
		Modificar(nodo.getSubDer());
		Modificar(nodo.getSubIzq());
	}
	
	public static void Imprimir(ArbolBB<Producto> arbol) {
		Imprimir(arbol.getRaiz());
		System.out.println("__________________");
	}
	private static void Imprimir(NodoABB<Producto> raiz) {
		if(raiz==null)
			return;
	
		System.out.println(raiz.getInfo().toString() + " - " + raiz.getInfo().getNivel());
		Imprimir(raiz.getSubIzq());
		Imprimir(raiz.getSubDer());
		
	}
	
}
