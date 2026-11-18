/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 3
 * Proyecto: EXAMEN UNIDAD 3
 * Fecha: 22 de noviembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/

package ExamenUN3;

import Colas.Cola;
import Listas.Lista;
import Listas.Nodo;
import UNIDAD_0.Rutinas;

public class EDPrestamos implements MyInterface{

	private Lista<Prestamo> prestamos;
	private Lista<Prestamo> acumulados;
	private Cola<Prestamo> mayores;
	
	public EDPrestamos() {
		prestamos = new Lista();
	}
	
	public void CrearPrestamos() {// BIEN CREADA LA LISTA
		int numPrestamos = Rutinas.nextInt(10000, 20000);
		for(int i = 0; i < numPrestamos; i++) {
			prestamos.InsertarOrdenado(new Prestamo(Rutinas.nextInt(2020, 2024), Rutinas.nextInt(1, 32), Rutinas.nextInt(1, 5)*1000));
		}
	}
	public void CrearAcumulados() { // MAL CREADA LA LISTA ACUMULADOS
	    acumulados = new Lista();// OK, ASEGURAMOS QUE CADA QUE SE MANDE ESTE MENSAJE NO HAY ACUMULADO PREVIOS
	    Nodo<Prestamo> nodo = prestamos.getFrente();
	    while (nodo != null) {
	        int importe = nodo.getInfo().getImporte();// LA PUEDE DEFINIR ANTES DEL CICLO
	        Prestamo prestamoActual = nodo.getInfo();// LA PUEDE DEFINIR ANTES DEL CICLO
	        Nodo<Prestamo> sig = nodo.getSig();
// ESTA MANERA DE ACUMUAR ES INCORRECTA, SE LE OLVIDA QUE HAY UN METODO BUSCA EN LA CLASE LISTA
	        while (sig != null && prestamoActual.toString().equals(sig.getInfo().toString())) {
	            importe += sig.getInfo().getImporte();
	            sig = sig.getSig();// AQUI SIGUIENTE LLEGARA A NULL Y SOLO HA TRATADO DE ACUMUAR AÑO Y MES QUE DICE EL PRIMER NODO
	        }

	        Prestamo acumulado = new Prestamo(prestamoActual.getAño(), prestamoActual.getEstado(), importe);
	        acumulados.InsertarFinal(acumulado);

	        nodo = sig;// COMO SIGUIENTE TOMO NULL PARA SALIR DEL CICLO ANTERIO AHORA NODO NULL Y SALE DEL CICLO
	    }
	}

	public void CrearMayor() {// MAL CALCULADO EL ACUMULADO
		mayores = new Cola(10);
		Nodo<Prestamo> nodo;
		Prestamo prestamo;
		int importe = 0;
		nodo = acumulados.getFrente();
		while(nodo!=null) {
			if(nodo.getInfo().getImporte()>importe) {
				importe = nodo.getInfo().getImporte();
				mayores = new Cola(10);// ESTA ESTRUCTURA DEBE DE CREARSE UNA VEZ 
				prestamo = new Prestamo(nodo.getInfo().getAño(), nodo.getInfo().getEstado(), nodo.getInfo().getImporte());
				mayores.Insertar(prestamo);
				nodo = nodo.getSig();
				continue; // NO REQUIERE EL ELSE DE ABAJO YA QUE EL CONTINUE REGRESA EL FLUJO AL WHILE
			}else if(nodo.getInfo().getImporte() == importe) {
				prestamo = new Prestamo(nodo.getInfo().getAño(), nodo.getInfo().getEstado(), nodo.getInfo().getImporte());// AQUI DEBE DE INCREMENTAR EL IMPORTE QUE YA ESTA EN LA LISTA ACUMULADO Y NO MANDARLO INSERAT
				if(!mayores.Insertar(prestamo)) {
					nodo = nodo.getSig();
					continue;
				}// OBSERVE EL CODIGO DE LAS DOS LINEAS DE ARRIBA Y DOS LINEAS DE ABAJO
				nodo = nodo.getSig();
				continue;
			}
			nodo = nodo.getSig();
		}
	}
	public void BorrarPrestamoMayor() {// LOGICAMNTE FUNCIONA,PERO SE PUEDE HACER MAS SENCILLO
		Nodo<Prestamo> nodo;
		Prestamo prestamo;
		Cola <Prestamo> aux = new Cola(10);
		while(mayores.Retirar()) {
			prestamo = mayores.getDr();
			nodo = prestamos.getFrente();
			Verificar(prestamo, nodo);
			aux.Insertar(prestamo);
		}
		while(aux.Retirar() && mayores.Insertar(aux.getDr()));
	}
	private void Verificar(Prestamo prestamo, Nodo<Prestamo> nodo) {
		if(nodo == null) {
			return;
		}
		if(nodo.getInfo().toString().equals(prestamo.toString())) {
			prestamos.Borrar(prestamo);
		}
		Verificar(prestamo, nodo.getSig());
	}
}