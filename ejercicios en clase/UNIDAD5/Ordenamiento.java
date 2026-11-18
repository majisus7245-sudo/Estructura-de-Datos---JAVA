package UNIDAD5;

public class Ordenamiento<T> {
	
	public void Burbuja(T [] arreglo) {

		int superior,  i;
		T temp;
		boolean bandera=true;
		superior=arreglo.length;
		while (bandera) {
			bandera=false;
			superior--;
			for(i=0 ; i < superior ; i ++) {
				
				if (arreglo[i].toString().compareTo( arreglo[i+1].toString())>0){
					temp=arreglo[i];
					arreglo[i]=arreglo[i+1];
					arreglo[i+1]=temp;
					bandera=true;
				}
			} 
		}
	}
	public void Intercambio(T [] arreglo) {
		for(int i=0 ; i<arreglo.length-1; i++) {
			for(int j=i+1 ; j<arreglo.length ; j++) {
				
				if( arreglo[i].toString().compareTo(arreglo[j].toString())>0) {
					T aux=arreglo[i];
					arreglo[i]=arreglo[j];
					arreglo[j]=aux;
				}
			}
		}
	}
	public void Insercion(T [] arreglo) {
		int j,n=arreglo.length;
		T aux;
		for(int i=1 ; i<n ; i++) {
			j=i;
			aux=arreglo[i];
			while( j>0 && aux.toString().compareTo(arreglo[j-1].toString())<0) {
				arreglo[j]=arreglo[j-1];
				j--;
			}
			arreglo[j]=aux;
		}
	}
	public void QuickSort(T [] arreglo) {
		QuickSort(arreglo,0,arreglo.length-1);
	}
	private void QuickSort(T [] arreglo,int izq, int der) {
		int i,j;
		i=izq;
		j=der;
		T pivote=arreglo[(izq+der)/2];
		do {
			while ( i<der && arreglo[i].toString().compareTo(pivote.toString())<0)
				i++;
			/*
			 * while ( i<der){
			 *   arch.seek(i*longReg);
			 *   Persona dato=new Persona(arch.readUTF()+arch.readUTF());
			 *  IF( dato.toString().compareTo(pivote.toString())<0))
				   i++;
			 * 
			 * 
			 */
			while ( j>izq && pivote.toString().compareTo(arreglo[j].toString())<0)
				j--;
			if( i<=j) {
				T y = arreglo[i];
				arreglo[i]=arreglo[j];
				arreglo[j]= y;
				i++;
				j--;
			}
		} while ( i<=j );
		if (izq < j)
			QuickSort(arreglo,izq,j);
		if ( i<der)
			QuickSort(arreglo,i,der);
	}
	public static void Mergesort(int [] a) {
		 Mergesort(a,0,a.length-1);
		}
		public static void Mergesort(int A[],int izq, int der){
		    if (izq < der){
		            int m=(izq+der)/2;
		            Mergesort(A,izq, m);
		            Mergesort(A,m+1, der);                                                                                
		            Merge(A,izq, m, der);                                                                                 
		    }
		}
		public static void Merge(int A[],int izq, int m, int der){
			   int i, j, k;
			   int [] B = new int[A.length]; //array auxiliar
			   for (i=izq; i<=der; i++) //copia ambas mitades en el array auxiliar                                       
			        B[i]=A[i];

			   i=izq; j=m+1; k=izq;
			     
			   while (i<=m && j<=der) //copia el siguiente elemento más grande                                      
			          if (B[i]<=B[j])
			              A[k++]=B[i++];
			          else
			              A[k++]=B[j++];
			        
			   while (i<=m)         //copia los elementos que quedan de la
			         A[k++]=B[i++]; //primera mitad (si los hay)
			}

}
