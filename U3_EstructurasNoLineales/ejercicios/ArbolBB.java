package U3_EstructurasNoLineales.ejercicios;

public class ArbolBB <T>{

	private NodoABB<T> raiz,nuevo;
	private T          dr;
	
	public ArbolBB() {
		raiz=null;
	}
	public boolean Insertar(T dato) {
		if(raiz==null) {
			if(!CrearNodo(dato))
				return false;
			raiz=nuevo;
			return true;
		}
		return Insertar(raiz,dato);
	}
	private boolean Insertar(NodoABB<T> root, T dato) {
		int res=root.getInfo().toString().compareTo(dato.toString());
		if( res==0)
			return false;
		if(res>0) {
			if( root.getSubIzq()!=null)
				return Insertar(root.getSubIzq(),dato);
			if(!CrearNodo(dato))
				return false;
			root.setSubIzq(nuevo);
			
		} else {
			if( root.getSubDer()!=null)
				return Insertar(root.getSubDer(),dato);
			if(!CrearNodo(dato))
				return false;
			root.setSubDer(nuevo);
		}
		
		
		return true;
	}
	public boolean Borrar(T dato) {
		dr=null;
		return Retirar(raiz,null,false,dato);
	}
	private boolean Retirar(NodoABB<T> root,NodoABB<T> anterior,boolean sentido, T dato) {
		if( root==null)
			return false;
		
//		Comparable datoNuevo = (Comparable) dato;
//		Comparable datoRoot= (Comparable) root.getInfo();
		String datoNuevo=dato.toString();
		String datoRoot=root.getInfo().toString();
		int res = datoNuevo.compareTo(datoRoot);
		if(res>0)
			return Retirar(root.getSubDer(),root,true,dato);
		if(res<0)
			return Retirar(root.getSubIzq(),root,false,dato);
		// Encontró al nodo, señaloadp por root
			dr=root.getInfo();

		
		if( root.getSubDer()!=null && root.getSubIzq()!= null) {
			
			NodoABB<T> aux = root.getSubDer();
					
			while ( aux.getSubIzq() != null) {
				aux=aux.getSubIzq();
			}

			root.setInfo(aux.getInfo());
			dato=aux.getInfo();
			
			return Retirar( root.getSubDer(),root,true,dato);
		}
		else { 
			if( root == raiz) {
				if( root.getSubIzq()==null && root.getSubDer()==null) {
					raiz=null;
				}else {
					raiz=root.getSubDer()==null?root.getSubIzq():root.getSubDer();
				}
				return true;
			}
			
			
			// 1 o 0 hijos.
			// llegue por el subIzq
			if(sentido) {
				anterior.setSubDer(root.getSubIzq()==null?root.getSubDer():root.getSubIzq());

			} else {
				
				anterior.setSubIzq(root.getSubIzq()==null?root.getSubDer():root.getSubIzq());
			}
		}
		return true;
	}

	public boolean Buscar(T dato) {
		return Buscar(dato,raiz);
	}
	private boolean Buscar(T dato, NodoABB<T> root) {
		if(root==null)
			return false;
		int res=dato.toString().compareTo(root.getInfo().toString());
		if(res==0) {
			dr=root.getInfo();
			return true;
		}
		if(res<0)
			return Buscar(dato,root.getSubIzq());
		return Buscar(dato,root.getSubDer());
	}
	public int Altura() {
		return Altura(raiz);
	}
	private int Altura(NodoABB<T> root) {
		if(root==null)
			return 0;
		int as1=Altura(root.getSubIzq())+1;
		int as2=Altura(root.getSubDer())+1;
		if(as1>as2)
			return as1;
		return as2;
		
	}
	private boolean CrearNodo(T dato) {
		try {
			nuevo=new NodoABB(dato);
		} catch (Error e)
		{
		   return false;	
		}
		return true;
	}
	public NodoABB<T> getRaiz() {
		return raiz;
	}
	public void setRaiz(NodoABB<T> raiz) {
		this.raiz = raiz;
	}
	public T getDr() {
		return dr;
	}
	public void setDr(T dr) {
		this.dr = dr;
	}
	
}
