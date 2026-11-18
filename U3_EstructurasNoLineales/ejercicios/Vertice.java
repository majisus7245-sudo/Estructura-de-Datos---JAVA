package U3_EstructurasNoLineales.ejercicios;

import U0_Diagnostico.utilerias.Rutinas;
import U2_EstructurasLineales.ejercicios.dinamicas.*;
import U2_EstructurasLineales.ejercicios.estaticas.*;
public class Vertice {
	private int vertice, distancia, previo, peso;// se usa para los nodos adyacentes
	private boolean visitado;
	private Lista<Vertice> listaAdyacente;
	
	public Vertice(int vertice){
		this.vertice=vertice;
		distancia=2147000000;
		previo=-1;
		visitado=false;
		listaAdyacente=new Lista<Vertice>();
		peso=0;
	}
	public Vertice(int vertice,int peso){
		this.vertice=vertice;
		distancia= 2147000000;
		previo=-1;
		visitado=false;
		listaAdyacente=new Lista<Vertice>();
		this.peso=peso;
	}
	public String toString(){
		return Rutinas.PonCeros(vertice, 5);
	}
	
	public String toString(int a){
		return String.format("%5d %10d  %5d %6b %5d ",vertice,distancia,previo,visitado,peso);
	}

	public int getVertice() {
		return vertice;
	}

	public void setVertice(int vertice) {
		this.vertice = vertice;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getPrevio() {
		return previo;
	}

	public void setPrevio(int previo) {
		this.previo = previo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public Lista<Vertice> getListaAdyacente() {
		return listaAdyacente;
	}

	public void setListaAdyacente(Lista<Vertice> listaAdyacente) {
		this.listaAdyacente = listaAdyacente;
	}
	
	
}
