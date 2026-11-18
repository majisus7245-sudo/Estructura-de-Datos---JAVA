/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto: Examen unidad 4
 * Fecha: 03 de diciembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/
package U3_EstructurasNoLineales.examen;

import U3_EstructurasNoLineales.ejercicios.Grafo;
import U3_EstructurasNoLineales.ejercicios.Vertice;
import U2_EstructurasLineales.ejercicios.dinamicas.Nodo;

public class CaminoCorto {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        for (int i = 1; i <= 8; i++) {
            grafo.Vertice(i);
        }

        grafo.VerticeAdyacente(1, 2, 1);
        grafo.VerticeAdyacente(1, 3, 2);
        grafo.VerticeAdyacente(1, 4, 1);
        grafo.VerticeAdyacente(2, 3, 1);
        grafo.VerticeAdyacente(3, 4, 3);
        grafo.VerticeAdyacente(3, 5, 2);
        grafo.VerticeAdyacente(4, 6, 1);
        grafo.VerticeAdyacente(5, 7, 1);
        grafo.VerticeAdyacente(6, 5, 1);
        grafo.VerticeAdyacente(6, 8, 4);
        grafo.VerticeAdyacente(7, 6, 2);
        grafo.VerticeAdyacente(7, 8, 1);
// BIEN CREADO EL GRAFO Y APLICADO EL ALGORITMO DE DIJSTRA
        grafo.Dijkstra(1);

        Nodo<Vertice> aux = grafo.getGrafo().getFrente().getSig();// TE PONE EN EL SEGUNDO VERTICE

        while (aux != null) {
            Vertice destino = aux.getInfo();
            System.out.println("Nodo origen 1, destino " + destino.getVertice() + ": ");
            
            Ruta(grafo, destino.getVertice());// ES LA RUTA DEL 1 AL DESTINO (DEL VERTICE 2 AL 8)

            aux = aux.getSig();
        }
    }

    public static void Ruta(Grafo grafo, int destino) {
        Nodo<Vertice> nodo = grafo.getGrafo().getFrente();
        Vertice actual = null;
        while (nodo != null) {
            if (nodo.getInfo().getVertice() == destino) {// EL BUSCAR TE AYUDARIA
                actual = nodo.getInfo();
                break;
            }
            nodo = nodo.getSig();
        }
        if (actual.getPrevio() != -1) {
            Ruta(grafo, actual.getPrevio());
        }
// LA RECURSIVIDAD RESUELVE QUE EL REPORTE SALGA COMO SE PIDIO
        if(actual.getVertice() != 1) {
        	System.out.print(actual.getVertice() + "(peso =  " + actual.getDistancia() + ") ");
            System.out.println();
        }
        
    }
}
