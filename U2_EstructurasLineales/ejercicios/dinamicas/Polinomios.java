package U2_EstructurasLineales.ejercicios.dinamicas;

import U0_Diagnostico.utilerias.Rutinas;
import java.util.*;
class Termino {
	private int base, exponente;
	
	public Termino(int base, int exponente) {
		this.base=base;
		this.exponente=exponente;
	}
	public String toString() {
		return Rutinas.PonCeros(exponente, 3);
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getExponente() {
		return exponente;
	}
	public void setExponente(int exponente) {
		this.exponente = exponente;
	}
	
}
public class Polinomios {
	private Lista<Termino> pol1,pol2,polSuma;
	
	public Polinomios() {
		pol1=new Lista();
		pol2=new Lista();
		
	}
	public void Capturar(int cualPolinomio) {
		
		Lista <Termino> pol= cualPolinomio==1?pol1:pol2;
		
		Scanner in = new Scanner(System.in);
		int base,exponente;
		while(true) {
			System.out.print("Base (0 fin polinomio :");
			base=in.nextInt();
			if(base ==0 ) {
				break;
			}
			System.out.print("Exponente ");
			exponente=in.nextInt();
			pol.InsertarFinal(new Termino(base,exponente));
			
		}
		
	}
	public void Sumar( ) {
		polSuma=new Lista();
		SumaParcial(pol1); // SumaParcial(pol1.getFrente());
		SumaParcial(pol2);
	}
	private void SumaParcial(Lista<Termino> lista) {
		Nodo<Termino> aux= lista.getFrente();
		while ( aux !=null ) {
			if ( polSuma.Buscar( new Termino(0,aux.getInfo().getExponente())   )) {
				int baseExiste = polSuma.getDr().getBase();
				int baseIncrementar=aux.getInfo().getBase();
				polSuma.getDr().setBase(baseExiste+baseIncrementar);
			} else {
				Termino nuevo=new Termino( aux.getInfo().getBase(),aux.getInfo().getExponente());
				polSuma.InsertarOrdenado(nuevo);
			}
				
			
			
			aux=aux.getSig();
		}
	}
	private void SumaParcial(Nodo<Termino> aux) {
		if(aux==null)
			return;

			if ( polSuma.Buscar( new Termino(0,aux.getInfo().getExponente())   )) {
				int baseExiste = polSuma.getDr().getBase();
				int baseIncrementar=aux.getInfo().getBase();
				polSuma.getDr().setBase(baseExiste+baseIncrementar);
			} else {
				Termino nuevo=new Termino( aux.getInfo().getBase(),aux.getInfo().getExponente());
				polSuma.InsertarOrdenado(nuevo);
			}
			SumaParcial(aux.getSig());

	}

	
	public void Imprimir(int cual) {
		Lista<Termino> pol=null;
		switch (cual) {
		case 1: pol=pol1;break;
		case 2: pol=pol2;break;
		case 3: pol=polSuma;break;
		}
		
		Nodo<Termino> aux=pol.getFrente();
		while (aux != null) {
			System.out.print(aux.getInfo().getBase()+" X "+aux.getInfo().getExponente()+"  ");
			aux=aux.getSig();
		}
		System.out.println();
	}
	
}
