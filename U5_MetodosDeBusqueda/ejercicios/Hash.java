package U5_MetodosDeBusqueda.ejercicios;

import java.io.Serializable;
import java.util.*;

class Auto implements Serializable{   
    private String Marca;
    private String Color;
    private int Ato, frecuencia;
    public Auto(String M,String C,int A)  {
        Marca=M;Color=C;Ato=A;
        frecuencia=1;
    }
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getAto() {
		return Ato;
	}
	public void setAto(int ato) {
		Ato = ato;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
    
}

class Hash {
    public static void main(String [] arg)    {  
        String Placa, Marca,Color;
        int Ato;
        Scanner in = new Scanner(System.in);
        
        Hashtable <String,Auto> h = new Hashtable();
        
         while (true) {
             System.out.print("Placa");
             Placa=in.nextLine();
              if(Placa.compareTo("*")==0)
                 break;
               System.out.print("Marca");
               Marca=in.nextLine();
               System.out.print("Color");
               Color=in.nextLine();
               System.out.print("Año");
               Ato=in.nextInt();
               in.nextLine();
               if( h.containsKey(Placa)) {
            	   Auto auto = (Auto) h.get(Placa);
            	   auto.setFrecuencia(auto.getFrecuencia()+1);
            	   continue;
            	   
               }
               Auto Nuevo=new Auto(Marca,Color,Ato);
               h.put(Placa,Nuevo); 
              
         }
         Hashtable <String,Auto> hClonada = (Hashtable <String,Auto>) h.clone();
         
         System.out.println("Total de autos capturados "+h.size()+" clonada"+hClonada.size());
         Enumeration e =h.keys();
         while (e.hasMoreElements())    {
            String clave = (String) e.nextElement();
            Auto valor = (Auto) h.get(clave);
            System.out.println(valor.getFrecuencia()+" Placa : " + clave + " Marca = " + valor.getMarca()+" color "+
          		  valor.getColor()); 
        }
         System.out.println("_______________________");
         
        Placa="TRES";
       hClonada.remove(Placa);
       e =hClonada.keys();
       Auto coche;
       h.clear();
       System.out.println("Total de autos capturados "+h.size()+" clonada"+hClonada.size());
       while (e.hasMoreElements())    {
          String clave = (String) e.nextElement();
          coche = (Auto) hClonada.get(clave);
          System.out.println(" Placa : " + clave + " Marca = " + coche.getMarca()+" color "+
        		  coche.getColor()); 
      }
    }
}

