/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto: Serpientes y Escaleras
 * Fecha: 15 de noviembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/
package U2_EstructurasLineales.tareas.serpientesyescaleras;

import U2_EstructurasLineales.ejercicios.dinamicas.*;

import U0_Diagnostico.utilerias.Rutinas;

class Casilla{
	
	private int numero;
	private int posiciones;
	private String tipo;
	
	public Casilla(int numero) {
		this.numero = numero;
		posiciones = 0;
		tipo = "N";
	}
	public String toString() {
		return Rutinas.PonCeros(numero, 3) + (!tipo.equals("N")?"-"+tipo:"");
	}
	
	public int getPosiciones() {
		return posiciones;
	}
	public void setPosiciones(int posiciones) {
		this.posiciones = posiciones;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumero() {
		return numero;
	}
	
}
class Jugador{
	
	private int id;
	private NodoDbl<Casilla> casilla;
	
	public Jugador(int id) {
		this.id = id;
		casilla = new NodoDbl(new Casilla(0));
	}
	public String toString() {
		return "Jugador " + id + " Casilla: " + casilla.getInfo().getNumero() + "\t";
	}

 	public NodoDbl<Casilla> getCasilla() {
		return casilla;
	}
	public void setCasilla(NodoDbl<Casilla> casilla) {
		this.casilla = casilla;
	}
	public int getId() {
		return id;
	}
	
}

public class SerpientesYEscaleras {

	private ListaDbl<Casilla> tablero;
	private Jugador [] jugadores;
	private int noCasillas, noJ;
	private boolean estado;
	private String msg, contenido;
	
	public SerpientesYEscaleras() {
		this(Rutinas.nextInt(1, 2));
	}
	public SerpientesYEscaleras(int nivel) {
		if(nivel == 1)
			noCasillas = Rutinas.nextInt(90, 110);
		else 
			noCasillas = Rutinas.nextInt(100, 120);
		tablero = new ListaDbl();
		for(int i = 0; i < noCasillas; i++)
			tablero.InsertarFin(new Casilla(i+1));
		jugadores = new Jugador[Rutinas.nextInt(2, 5)];
		for(int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador(i + 1);
			jugadores[i].getCasilla().setSig(tablero.getFrente());
		}
		estado = false;
		noJ = 0;
		GenerarEscaleras();
		GenerarSerpientes();
		Tablero();
	}
	private void GenerarEscaleras() {
		NodoDbl<Casilla> nodo, aux;
		int pos;
		for(int i = 0; i < 5; i++) {
			//Generar principio de la escalera
			while(true) {
				pos = Rutinas.nextInt(5, noCasillas-20);
				nodo = Buscar(pos);
				if(nodo.getInfo().getTipo().equals("N"))
					break;
			}
			nodo.getInfo().setTipo("E");
			//Generar termino de la escalera
			while(true) {
				pos = Rutinas.nextInt(10, 20);
				aux = Buscar(nodo.getInfo().getNumero()+pos);
				if(aux.getInfo().getTipo().equals("N"))
					break;
			}
			nodo.getInfo().setPosiciones(pos);
			aux.getInfo().setTipo("T");
		}
	}
	private void GenerarSerpientes() {
		NodoDbl<Casilla> nodo, aux;
		int pos;
		for(int i = 0; i < 5; i++) {
			//Generar principio de la serpiente
			while(true) {
				pos = Rutinas.nextInt(20, 90);
				nodo = Buscar(pos);
				if(nodo.getInfo().getTipo().equals("N"))
					break;
			}
			nodo.getInfo().setTipo("S");
			//Generar termino de la serpiente
			while(true) {
				pos = Rutinas.nextInt(5, 10);
				aux = Buscar(nodo.getInfo().getNumero()-pos);
				if(aux.getInfo().getTipo().equals("N"))
					break;
			}
			nodo.getInfo().setPosiciones(pos);
			aux.getInfo().setTipo("T");
		}
	}
	public boolean Jugar() {
		if(estado) {
			msg = "Un jugador ya es ganador";
			return false;
		}
		Jugador jugador = jugadores[noJ];
		int dado = Rutinas.nextInt(2, 12);
		msg = jugador.toString() + " Dado: " + dado;
		NodoDbl<Casilla> nodo = Buscar(jugador.getCasilla().getInfo().getNumero() + dado);
		if(nodo.getInfo().getTipo().equals("E"))
			nodo = Buscar(nodo.getInfo().getNumero()+nodo.getInfo().getPosiciones());
		if(nodo.getInfo().getTipo().equals("S"))
			nodo = Buscar(nodo.getInfo().getNumero() - nodo.getInfo().getPosiciones());
		jugador.setCasilla(nodo);
		msg += " Nueva Casilla: " + jugador.getCasilla().getInfo().getNumero() + "\n";
		if(jugador.getCasilla() == tablero.getFin()) {
			msg += "El jugador " + jugador.getId() + " ha ganado\n"; 
			estado = true;
		}
		noJ++;
		if(noJ == jugadores.length)
			noJ = 0;
		return true;
	}
	public void JugarA() {
		contenido = "";
		while(Jugar()) {
			contenido+=msg;
		}
		msg = contenido;
	}
	private NodoDbl<Casilla> Buscar(int pos){
		NodoDbl<Casilla> nodo;
		if(pos > noCasillas/2) {
			if(pos>noCasillas)
				pos = pos - noCasillas;
			else
				pos = noCasillas - pos;
			nodo = tablero.getFin();
			for(int i = 0; i < pos; i++)
				nodo = nodo.getAnt();
		}else {
			nodo = tablero.getFrente();
			for(int i = 0; i < pos-1; i++)
				nodo = nodo.getSig();
		}
		return nodo;
	}
	public void Tablero() {
		NodoDbl<Casilla> nodo = tablero.getFrente();
		msg = "";
		while(nodo!=null) {
			for(int i = 0; i < 10 && nodo!=null; i++) {
				msg += nodo.getInfo().toString() + "\t";
				nodo = nodo.getSig();
			}
			msg+="\n";
		}
	}
	public String getMsg() {
		return msg;
	}	
	
}
