/* Nombre: Manuel de Jesus Inzunza Lara
 * No. Control: 23170195
 * Materia: Estructura de datos
 * Unidad: 4
 * Proyecto:Apl Arbol Cuentas
 * Fecha: 01 de diciembre del 2024
 * Maestro: Dr. Clemente Garcia Gerardo*/
package U3_EstructurasNoLineales.tareas.proyectoabb;

import java.util.Scanner;

public class AplArbolCuenta {

	public static void main(String[] args) {

		ArbolCuentas arbol = new ArbolCuentas();
		
		Scanner sc = new Scanner(System.in);
		int num;
		do{
			System.out.println("1 - Registrar Cuenta");
			System.out.println("2 - Eliminar Cuenta");
			System.out.println("3 - Registrar Cargo o Abono");
			System.out.println("4 - Eliminar cuentas de mayor sin movimientos");
			System.out.println("5 - Consultar Cuenta");
			System.out.println("6 - Consultar Cuentas");
			System.out.println("7 - Salir");
			num = sc.nextInt();
			sc.nextLine();
			String opc, cuenta;
			int cant;
			switch(num) {
			case 1:
				do {
					System.out.print("Registrar cuenta(6 digitos): ");
					cuenta = sc.nextLine();
				}while(cuenta.length()>6);
				arbol.Registrar(new Cuenta(cuenta));
				System.out.println(arbol.getMsg());
				break;
			case 2:
				do {
					System.out.print("Eliminar cuenta(6 digitos): ");
					cuenta =sc.nextLine();
				}while(cuenta.length()>6);
				arbol.Eliminar(new Cuenta(cuenta));
				System.out.println(arbol.getMsg());
				break;
			case 3:
				do {
					System.out.print("Elegir Cuenta(6 digitos): ");
					cuenta = sc.nextLine();
				}while(cuenta.length()>6);
				System.out.print("Registrar Cargo(C) o Abono(A): ");
				opc = sc.nextLine();
				System.out.print("Cantidad: ");
				cant = sc.nextInt();
				if(opc.equals("C") || opc.equals("c"))
					arbol.RegistrarAC(new Cuenta(cuenta), cant, true);
				if(opc.equals("A") || opc.equals("a"))
					arbol.RegistrarAC(new Cuenta(cuenta), cant, false);
				System.out.println(arbol.getMsg());
				break;
			case 4:
				arbol.EliminarCuentas();
				System.out.println(arbol.getMsg());
				break;
			case 5:
				do {
					System.out.print("Consultar Cuenta(6 digitos):");
					cuenta = sc.nextLine();
				}while(cuenta.length()>6);
				arbol.Consultar(new Cuenta(cuenta));
				System.out.println(arbol.getMsg());
				break;
			case 6:
				arbol.Consultar();
				System.out.println(arbol.getMsg());
				break;
			}	
		}while(num != 7);
		System.out.println("FIN DE LA OPERACION");

	}

}
