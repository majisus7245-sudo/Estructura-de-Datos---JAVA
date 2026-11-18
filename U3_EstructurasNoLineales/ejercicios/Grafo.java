package U3_EstructurasNoLineales.ejercicios;
import U2_EstructurasLineales.ejercicios.dinamicas.*;
import U2_EstructurasLineales.ejercicios.estaticas.*;
public class Grafo {
	private Lista<Vertice> grafo;
	Cola<Distancia> Q;
	private String msg;
	public Grafo() {
		grafo=new Lista();
		
	}
	
	public boolean Vertice(int noVertice) {
		if(grafo.Buscar(new Vertice(noVertice))) {
			msg="El vertice ya se encuentra en el grafo";
			return false;
		}
		return grafo.InsertarFinal(new Vertice(noVertice));
	}
	public boolean VerticeAdyacente(int noVertice, int verticeAdyacente,int peso ) {
		if( !grafo.Buscar(new Vertice(noVertice))) {
			msg="El vertice no se encuentra en el grafo, no se puede agregar adyacentes";
			return false;
		}
		
		if( grafo.getDr().getListaAdyacente().Buscar(new Vertice(verticeAdyacente))) {
			msg="el nodo adyacente ya se encuentra en el nodo especificadp";
			return false;
		}
		return grafo.getDr().getListaAdyacente().InsertarFinal(new Vertice(verticeAdyacente,peso));
	}
	public void Dijkstra(int nodoOrigen) {
		if(!grafo.Buscar(new Vertice(nodoOrigen))){
			msg="El nodo origen proporcionado no existe ";
			return;
		}
		Q=new Cola<Distancia>(200);
		grafo.getDr().setDistancia(0);
		PonEnColaOrdenada(Q,new Distancia(nodoOrigen,0));
		while (Q.Retirar()){
			int U=Q.getDr().getVertice();
			if(!grafo.Buscar(new Vertice(U))){
				msg="ERROR EN LA ESTRUTUTA DEL GRAFO "+U;
				return;
			}		
			if(grafo.getDr().isVisitado())
				continue;
			grafo.getDr().setVisitado(true);
			Vertice ApU=grafo.getDr();
			Nodo<Vertice> Frente=grafo.getDr().getListaAdyacente().getFrente();
			while(Frente != null){
				int W=Frente.getInfo().getPeso();
				int VAdyacente=Frente.getInfo().getVertice();
				if(!grafo.Buscar(new Vertice(VAdyacente))){
					msg="error en la estrutura del grafo";
					return;
				}	
				Vertice ApAd=grafo.getDr();
				if(! grafo.getDr().isVisitado()){
					Relajacion(ApU,ApAd,W);
				}	
				Frente=Frente.getSig();
			}
		}
	}
	private void Relajacion(Vertice Actual,Vertice Adyacente,int Peso){
		if(Actual.getDistancia()+Peso < Adyacente.getDistancia()){
			Adyacente.setDistancia(Actual.getDistancia()+Peso);
			Adyacente.setPrevio(Actual.getVertice());
			PonEnColaOrdenada(Q,new Distancia(Adyacente.getVertice(),Adyacente.getDistancia()));
		}
	}
	private void PonEnColaOrdenada(Cola<Distancia> Q,Distancia  Origen){
		boolean Band=false;
		Cola<Distancia> QAux=new Cola<Distancia>(200);
		while(Q.Retirar()){
			if(Origen.toString().compareTo(Q.getDr().toString())<0 && !Band){
				Band=true;
				QAux.Insertar(Origen);
			}
			QAux.Insertar(Q.getDr());
		}
		if(!Band)
			QAux.Insertar(Origen);
		
		while(QAux.Retirar() && Q.Insertar(QAux.getDr()));
	}

	public Lista<Vertice> getGrafo() {
		return grafo;
	}

	public void setGrafo(Lista<Vertice> grafo) {
		this.grafo = grafo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
