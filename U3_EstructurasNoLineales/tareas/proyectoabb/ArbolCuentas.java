/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto:Arbol Cuentas
 * Fecha: 01 de diciembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/
package U3_EstructurasNoLineales.tareas.proyectoabb;

import U3_EstructurasNoLineales.ejercicios.*;

public class ArbolCuentas {

	private ArbolBB <Cuenta> arbol;
	private String msg;
	private int noCuentas;
	
	public ArbolCuentas() {
		arbol = new ArbolBB();
	}
	
	public boolean Registrar(Cuenta cuenta) {
		if(arbol.Buscar(cuenta)) {
			msg = "Esta cuenta ya existe";
			return false;
		}
		if(cuenta.getNivel() == 1) {
			arbol.Insertar(cuenta);
			msg = "Cuenta insertada correctamente";
			return true;
		}
		if(cuenta.getNivel() == 2 && !arbol.Buscar(new Cuenta(cuenta.toString().substring(0, 2)))) {
			msg = "No es posible registrar esta cuenta";
			return false;
		}
		if(cuenta.getNivel() == 3 && !arbol.Buscar(new Cuenta(cuenta.toString().substring(0,4)))) {
			msg = "No es posible registrar esta cuenta";
			return false;
		}
		arbol.Insertar(cuenta);
		msg = "Cuenta insertada correctamente";
		return true;
	}
	public boolean Eliminar(Cuenta cuenta) {
		if(!arbol.Buscar(cuenta)) {
			msg = "Esta cuenta no existe";
			return false;
		}
		Cuenta aux = arbol.getDr();
		if(arbol.getDr().getNivel() == 3) {
			if(arbol.getDr().getAbono() != arbol.getDr().getCargo()) {
				msg = "Esta cuenta no se puede eliminar por que sus saldos son diferentes";
				return false;
			}
			arbol.Buscar(new Cuenta(aux.toString().substring(0,4)));
			arbol.getDr().setAbono(arbol.getDr().getAbono()-aux.getAbono());
			arbol.getDr().setCargo(arbol.getDr().getCargo()-aux.getCargo());
			arbol.Buscar(new Cuenta(aux.toString().substring(0,2)));
			arbol.getDr().setAbono(arbol.getDr().getAbono()-aux.getAbono());
			arbol.getDr().setCargo(arbol.getDr().getCargo()-aux.getCargo());
		}
		NodoABB<Cuenta> nodo = BuscarNodo(aux.toString(), arbol.getRaiz());
		if(cuenta.getNivel() == 2 && Verificar(nodo.getInfo().toString().substring(0,4), nodo.getSubDer(), false)) {
			msg = "Esta cuenta tiene al menos una subsubcuenta";
			return false;
		}
		if(cuenta.getNivel() == 1 && Verificar(nodo.getInfo().toString().substring(0,2), nodo.getSubDer(), false)) {
			msg = "Esta cuenta tiene al menos una subcuenta";
			return false;
		}
		arbol.Borrar(aux);
		msg = "Cuenta eliminada exitosamente";
		return true;
	}
	public boolean RegistrarAC(Cuenta cuenta, int cantidad, boolean isCargo) {
		if(!arbol.Buscar(cuenta)) {
			msg = "Esta cuenta no existe";
			return false;
		}
		if(cuenta.getNivel() != 3) {
			msg = "Esta cuenta no se puede modificar directamente";
			return false;
		}
		if(isCargo) {
			arbol.getDr().setCargo(arbol.getDr().getCargo() + cantidad);
			String noCuenta = arbol.getDr().toString();
			arbol.Buscar(new Cuenta(noCuenta.substring(0,4)+"00", "", 2));
			arbol.getDr().setCargo(arbol.getDr().getCargo() + cantidad);
			arbol.Buscar(new Cuenta(noCuenta.substring(0,2)+"0000","",1));
			arbol.getDr().setCargo(arbol.getDr().getCargo() + cantidad);
			msg = "Se ha añadido correctamente el cargo a la cuenta " + noCuenta;
		} else {
			arbol.getDr().setAbono(arbol.getDr().getAbono() + cantidad);
			String noCuenta = arbol.getDr().toString();
			arbol.Buscar(new Cuenta(noCuenta.substring(0,4)+"00", "", 2));
			arbol.getDr().setAbono(arbol.getDr().getAbono() + cantidad);
			arbol.Buscar(new Cuenta(noCuenta.substring(0,2)+"0000","",1));
			arbol.getDr().setAbono(arbol.getDr().getAbono() + cantidad);
			msg = "Se ha añadido correctamente el abono a la cuenta " + noCuenta;
		}
		return true;
	}
	
	public boolean EliminarCuentas() {
		noCuentas = 0;
		Borrar(arbol.getRaiz(),null,0);
		msg = "Se han eliminado " + noCuentas + " cuentas";
		return true;
	}
	
	private void Borrar(NodoABB<Cuenta> aux, String raiz, int nivel) {
		if(aux==null)
			return;
		if(nivel == 0 && aux.getInfo().getNivel() == 1 && aux.getInfo().getCargo() == 0 && aux.getInfo().getAbono() == 0) {
			Borrar(aux.getSubDer(), aux.getInfo().toString().substring(0, 2), 1);
			arbol.Borrar(aux.getInfo());
			noCuentas ++;
		}
		if(nivel == 1 && aux.getInfo().toString().substring(0,2).equals(raiz)) {
			arbol.Borrar(aux.getInfo());
			noCuentas++;
		}
		Borrar(aux.getSubIzq(), raiz, nivel);
		Borrar(aux.getSubDer(), raiz, nivel);
	}

	public boolean Consultar(Cuenta cuenta) {
		if(!arbol.Buscar(cuenta)) {
			msg = "Esta cuenta no existe";
			return false;
		}
		if(cuenta.getNivel() == 3) {
			msg = arbol.getDr().toString(0);
			return true;
		}
		NodoABB<Cuenta> raiz = BuscarNodo(arbol.getDr().toString(), arbol.getRaiz());
		if(cuenta.getNivel() == 2) {
			msg = arbol.getDr().toString(0);
			Buscar(raiz.getSubDer(), raiz.getInfo().toString().substring(0, 4), 1);
			return true;
		}
		msg = cuenta.toString(0) + "\n";
		Buscar(raiz.getSubDer(), raiz.getInfo().toString().substring(0,2), 0);
		return true;
	}
		
	public boolean Consultar() {
		msg = "";
		Buscar(arbol.getRaiz());
		return true;
	}
	
	private NodoABB<Cuenta> BuscarNodo(String cuenta, NodoABB<Cuenta> nodo){
		int res = cuenta.compareTo(nodo.getInfo().toString());
		if(res == 0)
			return nodo;
		if(res < 0)
			return BuscarNodo(cuenta, nodo.getSubIzq());
		return BuscarNodo(cuenta, nodo.getSubDer());
	}
	
	private boolean Verificar(String noCuenta, NodoABB<Cuenta> nodo, boolean estado) {
		if(nodo == null)
			return false;
		if(noCuenta.length()==2 && noCuenta.equals(nodo.getInfo().toString().substring(0, 2))) {
			return true;
		}
		if(noCuenta.length()==4 && noCuenta.equals(nodo.getInfo().toString().substring(0, 4))) {
			return true;
		}
		boolean ladoIzquierdo = Verificar(noCuenta,nodo.getSubIzq(), estado);
		boolean ladoDerecho = Verificar(noCuenta, nodo.getSubDer(), ladoIzquierdo);
		return ladoIzquierdo || ladoDerecho;
	}
	
	private void Buscar(NodoABB<Cuenta> aux) {
		if(aux == null)
			return;
		Buscar(aux.getSubDer());
		if(aux.getInfo().getNivel() == 1) {
			msg += aux.getInfo().toString(0) + "\n";
			Buscar(aux.getSubDer(),aux.getInfo().toString().substring(0,2), 0);
		}
		Buscar(aux.getSubIzq());
	}
	private void Buscar(NodoABB<Cuenta> aux, String raiz, int nivel) {
		if(aux == null)
			return;
		Buscar(aux.getSubIzq(), raiz, nivel);
		if(nivel == 0 && aux.getInfo().getNivel() == 2 && aux.getInfo().toString().substring(0,2).equals(raiz)) {
			msg += "\t" + aux.getInfo().toString(0) + "\n";
			Buscar(aux.getSubDer(), aux.getInfo().toString().substring(0,4), 1);
		}
		if(nivel == 1 && aux.getInfo().getNivel() == 3 && aux.getInfo().toString().substring(0,4).equals(raiz)) {
			msg += "\t\t" + aux.getInfo().toString(0) + "\n"; 
		}
		Buscar(aux.getSubDer(), raiz, nivel);
	}
	
	public String getMsg() {
		return msg;
	}
	
}
