package U5_MetodosDeBusqueda.ejercicios;
import java.util.*;
import U2_EstructurasLineales.ejercicios.estaticas.*;
public class HashMapTree {
	 public static void main(String[] args) {
		 
	        HashMap<String, Integer> hashMap = new HashMap<>();
	        
	        hashMap.put("Manzana", 3);
	        hashMap.put("Banana", 1);
	        hashMap.put("Naranja", 2);
	        hashMap.put("Cereza", 4);
	        hashMap.put("Sandia", 4);
	        hashMap.put("enero", 30);
			hashMap.compute("enero", (key, value)-> value + 1); 
			
			
//			System.out.println("Total de elementos HASHMAP "+hashMap.size());
//			System.out.println("VALOR DEL HM "+hashMap.get("enero"));
			

	        System.out.println(hashMap); // Orden no garantizado
	        
	        TreeMap<String, Integer> treeMap = new TreeMap<>();
	        
	        treeMap.put("Manzana", 3);
	        treeMap.put("Banana", 1);
	        treeMap.put("Naranja", 2);
	        treeMap.put("Cereza", 4);
	        treeMap.put("Sandia", 4);

	        System.out.println(treeMap); // Ordenado alfabéticamente por clave
	
	        TreeMap<String,Persona> tmPersonas=new TreeMap<>();
	        tmPersonas.put("21179999",new Persona("Raymundo","Sinaloa",20));
	        tmPersonas.put("21171010",new Persona("Zoila","Sinaloa",20));
	        tmPersonas.put("21171999",new Persona("Pedro","Sinaloa",20));
//	        System.out.println(tmPersonas); // Ordenado alfabéticamente por clave
System.out.println("__________Listado de personans _____");
	        for (Persona obj : tmPersonas.values()) 
				   System.out.println(obj.getNombre()+" "+obj.getEstado()+"  "+obj.getEdad()); // 
	 }
}
