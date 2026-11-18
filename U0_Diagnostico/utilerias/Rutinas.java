package U0_Diagnostico.utilerias;
import java.util.*;
public class Rutinas {
	static Random r=new Random();
	static String []VN ={"Diego","Daniel","Yessenia","Luis","Anastacia","Plutarco","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
			"Rebeca","Javier","Luis"};
	static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
	static boolean [] Sexo={true,true,false,true,false,true,false,false,false,true,false,false,
			false,true,true};	

	public static String nextNombre(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;;

		for(int i=0;i<Numero;i++){
			Pos=r.nextInt(VN.length);

			NomTra=VN[Pos]+" ";

			if (i==0){
				Genero=Sexo[Pos];
			}

			if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
				i--;
				continue;
			}	

			Nom+=NomTra;

		}
		NomTra="";
		for(byte i=0;i<2;i++){
			NomTra+=VA[r.nextInt(VA.length)]+" ";
		}
		Nom=Nom+NomTra;
		return Nom.trim();
	} 	
	public static int nextInt(int li, int ls) {
		return r.nextInt(ls-li+1)+li;
	}
	public static String PonCeros(long numero, int tamaño) {
		String texto=numero+"";
		while (texto.length()<tamaño)
			texto="0"+texto;
		return texto;
	}
	public static String PonBlancos(String texto, int tamaño) {
		if(texto.length()>tamaño) {
			return texto.substring(0,tamaño);
		}
		while (texto.length()<tamaño)
			texto=texto+" ";
		return texto;
	}

	public static String nextColor() {
		String [] colores= {"rojo","rosa","violeta","negro","amarillo","blanco","gris","azul","verde","cafe","naranja","lila"};
		return colores[ Rutinas.nextInt(0,colores.length-1)   ];
	}

	// Lee desde teclado un entero dentro del rango [li, ls]; repite hasta que sea valido.
	public static int LeerEntero(String mensaje, int li, int ls) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print(mensaje);
			try {
				int valor = Integer.parseInt(sc.nextLine().trim());
				if (valor >= li && valor <= ls)
					return valor;
				System.out.println("El valor debe estar entre " + li + " y " + ls);
			} catch (NumberFormatException e) {
				System.out.println("Debe capturar un numero entero");
			}
		}
	}

	// Renombra el archivo origen como destino (si destino existe, se reemplaza).
	public static boolean Renombrar(String origen, String destino) {
		java.io.File archDestino = new java.io.File(destino);
		if (archDestino.exists())
			archDestino.delete();
		return new java.io.File(origen).renameTo(archDestino);
	}

}
