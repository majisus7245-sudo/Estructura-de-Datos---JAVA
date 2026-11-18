package UNIDAD2;

class Persona{
	private String nombre,estado;
	public Persona(String nombre, String estado) {
		this.nombre=nombre;
		this.estado=estado;
	}
	public Persona(String nombre) {
		this.nombre=nombre;
		this.estado="Sinaloa";
	}
	public String toStrig() {
		return nombre+"-"+estado;
	}
}
public class AplRecursiva {

	public static void main(String[] args) {
		System.out.println(Recursiva.Convierte(17, 2));
		System.out.println(Recursiva.Convierte(17, 8));
		System.out.println(Recursiva.Convierte(178, 16));
		for(int i=20; i>=1;i--)
		System.out.println("8 y "+i+" el mcd="+Recursiva.MCD(8, i));
		
		 //yo dono rosas oro no doy
		System.out.println(Recursiva.Palindrome("yo dono rosas oro no doy")?"Es palindrome":"No es palindrome");

		Integer [][] matriz= {{10,20,30,40},{1,2,3,4,5,6},{100,200}};
		Recursiva.<Integer>ImprimirMatriz(matriz);
	System.out.println("___________________________________________");	
		Float [][] matriz1= {{10.0f,20.9f,30.0f,40.0f},{1.0f,2f,3f,4f,5f,6f},{100f,200f}};
		Recursiva.<Float>ImprimirMatriz(matriz1);
		System.out.println("___________________________________________");	
		String [][] matriz2= {{"10.0f","20.9f","30.0f","40.0f"},{"1.0f","2f","3f","4f","5f","6f"},{"100f","200f"}};
		Recursiva.<String>ImprimirMatriz(matriz2);
			
		System.out.println("___________________________________________");	
		Persona [][] matriz3= {{new Persona("Juan"),new Persona("Sofia"),new Persona("Alicia")},
								{new Persona("Javier"),new Persona("Estela"),new Persona("Daniela"),new Persona("Rebeca"),new Persona("Angela"),new Persona("Bertha")},
								{new Persona("Mario"),new Persona("Elvira")}};

//		for(int i=0 ; i<matriz3.length ; i++) {
//			for(int j=0 ; j<matriz3[i].length ; j++) {
//				System.out.printf("%-15s",matriz3[i][j].toStrig());
//			}
//			System.out.println();
//		}
		
		Recursiva.<Persona>ImprimirMatriz(matriz3);	

		int [] arreglo= {10,20,30,30,50,60};
		System.out.println("Suma= "+Recursiva.Sumar(arreglo));
	
		for(int i=0 ; i<=100 ; i+=20)
			System.out.println("EL NUMERO "+i+" fact= "+Recursiva.Fact(i));
		
		System.out.println("*** ELECAR 2 A ");
		for(int i=0 ; i<=10 ; i++)
			System.out.println("2 a la "+i+" ="+Recursiva.Eleva(2,i));
		
		System.out.println("movimiento de la torre hanoi");
		Recursiva.Hanoi('A', 'B', 'C', 3);
		System.out.println(Recursiva.ackerman(3, 5));
	}
	
/*
 	public static <T> void Imprime(T [][] m) {
		for(int i=0 ; i<m.length ; i++) {
			for(int j=0 ; j<m[i].length ; j++) {
				T objeto = (T)  m[i][j];
				if (objeto instanceof Persona) {
	                Persona persona = (Persona) objeto;
				System.out.printf("%-10s ----- ",persona.toStrig());
				} else {
					System.out.printf("%-10s ----- ",objeto);
				}
			}
			System.out.println();
		}
	}
 * 
 * 
 * APLICAICOM
 * 
 * Integer [][] a=new Integer[3][3];
		for(int i=0 ; i<a.length ;i++)
			for(int j=0 ; j<a[i].length ;j++)
				a[i][j]=i+j;
		Recursiva.<Integer> Imprime (a);
		System.out.println("___________________");
		String [][] ciudades= {{"La Paz","Los Cabos","San Ignacio"},
	              {"Tijuana","Mexicali","Tecate","Rosarito"},
	              {"Hermosillo","Guaymas","Obregon","Nogales","Navojoa"},
	              {"Culiacan","Mazatlan","Los Mochis","Guasave"}  };
		Recursiva.<String> Imprime (ciudades);
		System.out.println("___________________");
		Persona [][] matriz= {{new Persona("RAMONA"),new Persona("JUAN"),new Persona("PEDRO")},
				{new Persona("ALICIA"),new Persona("SOFIA")}  };


		for(int i=0 ; i<matriz.length;i++)
			for(int j=0 ; j<matriz[i].length;j++)
		System.out.println(matriz[i][j].toStrig());

		Recursiva.<Persona> Imprime (matriz);
		System.out.println("___________________");
 * 
 
 */

}
