package U4_MetodosDeOrdenamiento.ejercicios;

import java.util.Arrays;


import U0_Diagnostico.utilerias.Rutinas;

public class AplOrdenamiento {
	static class MyInteger {
		private int numero;
		public MyInteger(int numero) {
			this.numero=numero;
		}
		public String toString() {
			return Rutinas.PonCeros(numero, 10);
		}
	}
	public static void main(String[] args) {
		Ordenamiento<Integer> ordena=new Ordenamiento();
		MyInteger [] arreglo= new MyInteger[2000000];
		for(int i=0 ; i<arreglo.length;i++) {
			arreglo[i]=new MyInteger(Rutinas.nextInt(200, 300));
			//arreglo[i]=new MyInteger(10-i);
		}
		Integer [] arreglo_1 = new Integer[200];
		for(int i=0 ; i<arreglo_1.length;i++)
			arreglo_1[i]=new Integer(Rutinas.nextInt(1000, 2000));
//		System.out.println("ordenado");
//		ordena.QuickSort(arreglo_1);
//		for(int i=0 ; i<10 ; i++)
//			System.out.println(arreglo_1[i]);
		int [] contenedor=new int[300000];
		for(int i=0 ; i<contenedor.length;i++)
			contenedor[i]=Rutinas.nextInt(100, 1000);
		System.out.println("ORDENANDO CON MERGE SORT");
		ordena.Mergesort(contenedor);
		//Arrays.sort(contenedor);
		for(int i=0 ; i<20 ; i++)
			System.out.print(contenedor[i]+"    ");
		
		
	}

}
