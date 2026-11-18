package U2_EstructurasLineales.ejercicios.estaticas;

import U0_Diagnostico.utilerias.Rutinas;

public class AplPila {

	public static void main(String[] args) {

		Pila<Integer> miPila=new Pila();
		Pila<Persona> personaPila = new Pila();

		for(int i=0; i<15 ; i++)
			if(miPila.Insertar(i))
				System.out.println("inserción éxitosa "+i);
			else
				System.out.println("PILA LLENA (OVERFLOW)");

		// mostrar el contenido original de la pila
		Mostrar(miPila);
		System.out.println("miPila está vacía ?"+miPila.Vacia());

		// elimminar de la pila todos los numeros impares
		Pila<Integer> auxPila=new Pila();
		while(miPila.Retirar()) {
			if(miPila.getDr() % 2 !=0 )
				continue;
			auxPila.Insertar(miPila.getDr());
		}
		// paso de la pila auxiliar a la pila original
		while(auxPila.Retirar() && miPila.Insertar(auxPila.getDr()));

		while(miPila.Retirar())		
			System.out.println(miPila.getMsg()+", el dato es:"+miPila.getDr()    );
		System.out.println(miPila.getMsg());

		// quisiera retirar un dato especifico que se encuentra en la pila
		while(personaPila.Insertar(new Persona(Rutinas.nextNombre(1),
				"SINALOA",
				Rutinas.nextInt(18,65))
		));
		personaPila.Retirar();
		personaPila.Retirar();
		personaPila.Insertar(new Persona("JUAN ESCUTIA","SINALOA",10));
		personaPila.Insertar(new Persona("JUAN ESCUTIA","SINALOA",10));
		Eliminar(personaPila, new Persona("JUAN ESCUTIA","",0));

		while(personaPila.Retirar())
			System.out.println(personaPila.getDr().toString());
	}
	public static void  Eliminar(Pila<Persona> pila, Persona dato){
		Pila<Persona> aux=new Pila();
		while(pila.Retirar()) {
			if(pila.getDr().toString().compareTo(dato.toString())==0)
				break;
//			aux.Insertar(new Persona( pila.getDr().getNombre(),pila.getDr().getEstado(),pila.getDr().getEdad()));
			aux.Insertar(pila.getDr());
		}
		while(aux.Retirar() && pila.Insertar(aux.getDr()));
		
		
	}
	public static void Mostrar(Pila<Integer> laPila) {
		Pila<Integer> auxPila=new Pila();
		System.out.println("----------------");
		while(laPila.Retirar() && auxPila.Insertar(laPila.getDr())) {
			System.out.println(laPila.getDr()+"--------");

		}
		while(auxPila.Retirar() && laPila.Insertar(auxPila.getDr()));
		System.out.println("___________________");
	}

	

}
