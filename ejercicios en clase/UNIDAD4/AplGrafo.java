package UNIDAD4;

import UNIDAD3DINAMICA.Nodo;
public class AplGrafo {
	public static void main(String[] args) {
		
		Grafo grafo=new Grafo();
		// agregar los nodos vertice
		for(int i=0 ; i<6 ; i++) {
			grafo.Vertice(i+1);
		}
		grafo.VerticeAdyacente(1, 2, 7);
		grafo.VerticeAdyacente(1, 4, 2);

		grafo.VerticeAdyacente(5, 6, 1);
		grafo.VerticeAdyacente(3, 6, 5);
		
		grafo.VerticeAdyacente(2, 3, 1);
		grafo.VerticeAdyacente(2, 4, 2);

		grafo.VerticeAdyacente(3, 5, 5);

		grafo.VerticeAdyacente(4, 2, 3);
		grafo.VerticeAdyacente(4, 3, 8);
		grafo.VerticeAdyacente(4, 5, 5);

		grafo.VerticeAdyacente(5, 3, 4);
		
		grafo.Dijkstra(1);// el 1 idica el nodo origen hacia el resto de los vertices
		
		// Imprimir la tabla de resultado
		
		Nodo<Vertice > aux=grafo.getGrafo().getFrente();
		while(aux != null) {
			System.out.println(aux.getInfo().toString(1));
			// imprimir el toString(1) de cada nodo adyacente
			Nodo<Vertice> auxAdy = aux.getInfo().getListaAdyacente().getFrente();
			while (auxAdy != null ) {
				System.out.println("\t"+auxAdy.getInfo().toString(1));
				auxAdy=auxAdy.getSig();
			}
			
			aux=aux.getSig();
		}
		System.out.println("_________________");
		

		
}
