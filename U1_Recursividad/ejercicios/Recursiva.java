package U1_Recursividad.ejercicios;

public class Recursiva {
	public static int Sumar(int [] a) {
		return Sumar(a,0);
	}
	private static int Sumar(int [] a,int sub) {
		if(sub == a.length-1)
			return a[sub];
		return a[sub]+Sumar(a,sub+1);
	}
//En el peor de los casos, el número total de llamadas 
//	recursivas es aproximadamente doble para cada nivel de
//recursión. Es decir, para calcular Fib(n), el número de 
//	llamadas recursivas será del orden de 2 elevado a la n 
//la complejidad es  O(2 ELEVADO A LA N)
	public static int Fib(int posicion) {
		if(posicion < 3)
			return 1;
		return Fib(posicion-1)+Fib(posicion-2);
	}
/*
 * 0!=1 CASO BASE O CASO TRIVIAL
 * 1!=1 CASO BASE O CASO TRIVIAL
 * 2!=2 * 1! CASO RECURSIVO.
 * 3!=3 *2!
 * 4!=4 * 3!	
 */
	public static long Fact(int numero) {
		if(numero == 0 || numero == 1)
			return 1;
		return numero * Fact(numero-1);
	}
/*	
	public void ImpresionLogica(Cliente [] arreglo,int inicio) {
		if(inicio==-1)
			return;
		ImpresionLogica(arreglo[inicio].getSiguinte());
		System.out.printf("%-30s %-40s",arreglo[inicio].getEstado(),arreglo[inicio].getNombre());
	}
*/
	static public long Eleva(int x, int y) {
//		if(y==0)
//			return 1;
//		if(y==1)
//			return x;
//		return Eleva(x,y-1) * x;
		if( y==0)
			return 1;
		if(y==1)
			return x;
		if( y % 2 ==0)
			return Eleva(x*x, y/2) ;
		return Eleva(x*x,y/2)*x;
		
	}
	/*
	 * Se desea que desarrolle un método recursivo que regrese el valor
	 * mayor contenido en el arreglo
	 */
	static public int Mayor(int [] arreglo) {
		return Mayor(arreglo,0);
//		int mayorp1=Mayor(arreglo,0,arreglo.length/2);
//		int mayorp2=Mayor(arreglo,arreglo.length/2+1,arreglo.length);
//		if( mayorp1>mayorp2)
//			return mayop1;
//		return mayorp2;
	}
	static private int Mayor(int [] arreglo,int sub) {
		if(sub == arreglo.length-1)
			return arreglo[sub];
		int tra=Mayor(arreglo,sub+1);
		if( tra > arreglo[sub])
			return tra;
		return arreglo[sub];
	}
/*
	 * Desarrollen un método recursivo que permita imprimir el contenido de 
	 * matriz en formato de matriz
	 */
	
	static public <T> void  ImprimirMatriz( T [][] matriz){
		Renglones(matriz,0);
	}
	static private<T> void Renglones(T [][] matriz, int ren){
		if(ren==matriz.length)
			return;
		Columnas(matriz,ren,0);
		System.out.println();
		Renglones(matriz,ren+1);
	}
	static private<T> void Columnas(T[][] matriz,int ren,int col) {
		if(col==matriz[ren].length)
			return;
		if( matriz[ren][col] instanceof Persona) {
			Persona objeto = (Persona) matriz[ren][col];
			System.out.printf("%-15s",objeto.toStrig());
		} else
			System.out.printf("%-15s",matriz[ren][col]);
		Columnas(matriz,ren,col+1);
	}

	// LAS PALABRAS O FRASES PALINDOMOS O PALINDROMES
	// ANA OSO 
	
	public static boolean Palindrome(String texto) {
		if(texto.length()<2)
			return true;
		char carIni=texto.charAt(0);
		if(carIni==' ')
			return Palindrome(texto.substring(1));
		char carFin=texto.charAt(texto.length()-1);
		if(carFin==' ')
			return Palindrome(texto.substring(0,texto.length()-1));
		if( carIni>='a' && carIni<='z')
			//carIni=(char)(carIni-32); 
			carIni=(char)(carIni-'a'+'A');
		if( carFin>='a' && carFin<='z')
			//carFin=(char)(carFin-32);
			carFin=(char)(carFin-'a'+'A');
		if( carIni != carFin)
			return false;
		return Palindrome(texto.substring(1,texto.length()-1));
	}
	// algoritmo EUCLIDES
/*	static public int MCD(int x, int y) {
		if(x==y)
			return x;
		if( y>x ) 
			return MCD(y,x);
		return MCD(x-y,y);
	}
*/	
	static public int MCD(int x, int y) {
		if(y==0)
			return x;
		return MCD(y,x%y);
	}	
	static String digitos="0123456789ABCDEF";
	static public String Convierte(int numero, int base) {
		if(numero < base )
			return digitos.charAt(numero)+"";
		return Convierte(numero/base,base) + digitos.charAt(numero%base)+"";
		
	}
	static public void Hanoi(char Inicial,char Central,char Final,int N) {
		if(N==1) {
			System.out.println(" Move disco "+N+" de la torre "+Inicial+" a la torre "+Final);
			return;	
		}
		Hanoi(Inicial,Final,Central,N-1);
		System.out.println(   " Move disco "+N+" de la torre "+Inicial+" a la torre "+Final);
		Hanoi(Central,Inicial,Final,N-1);
	 }

	static public int ackerman(int M, int N){ 
		if(M == 0) 
			return N + 1; 
		if (N == 0) 
			return ackerman(M-1,1); 
		return ackerman(M-1,ackerman(M,N-1)); 
	} 
	
}
