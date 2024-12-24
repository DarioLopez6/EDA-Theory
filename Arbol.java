/*********************************************************************
*
* Class Name: Arbol
* Author/s name: JFBR
* Release/Creation date: 08/12/2024
* Class version: 1.0
* Class description: Esta clase implementa el TAD arbol B3R cuyos nodos 
* almacenan objetos de la clase Integer. Cuenta con los métodos
* necesarios para crear un árbol vacío, insertar un valor entero en
* el árbol donde corresponda, buscar si existe un valor en alguno de
* los nodos del árbol, encontrar y devolver los valores mínimo y máximo
* del árbol, devolver el número de nodos, devolver el número de claves
* almacenadas en los nodos del  árboly devolver una cadena con todos los
* valores almacenados en todos los nodos ordenados por orden ascendente.
*
**********************************************************************/

import java.util.ArrayList;
import java.util.List;
public class Arbol {

	private Nodo raiz;
	
	/*********************************************************************
	 * Method name: Arbol
	 * 
	 * Description of the Method: Constructor de un árbol vacío, cuyo nodo
	 * raíz sera null.
	 * 
	 * Calling arguments:- None.
	 * 
	 * Return value: Una instancia de la clase Arbol cuya raíz es null
	 * 
	 *********************************************************************/
	
	public Arbol() {
		this.raiz = null;
	}
	
	/*********************************************************************
	 * Method name: insertarValor
	 * 
	 * Description of the Method: Método para insertar un valor entero en el
	 * árbol, de tal forma que, para todo nodo, el valor de su clave izquierda
	 * será mayor que cualquier valor el el subárbol izquierdo de dicho nodo, 
	 * su clave derecha (si existe) será mayor o igual que la clave derecha y
	 * mayor que los valores almacenados en los nodos del subárbol enraizado
	 * en el hijo central, pero menor que los valores del subárbol derecho.
	 * 
	 * Calling arguments:- valor(int): El valor entero que se quiere insertar
	 * en algún nodo del árbol, donde proceda según su valor.
	 * 
	 * Return value: void
	 * 
	 *********************************************************************/
	public void insertarValor(int valor) {
		if(this.raiz==null) {
			this.raiz = new Nodo();
			this.raiz.setClaveIzquierda(valor);
		}else
			insertarValorEnNodo(this.raiz,valor);
	}
	
	/*********************************************************************
	 * Method name: insertarValorEnNodo
	 * 
	 * Description of the Method: Método recursivo para insertar un valor entero
	 * en el árbol, de tal forma que, para todo nodo, el valor de su clave
	 * izquierda será mayor que cualquier valor el el subárbol izquierdo de 
	 * dicho nodo, su clave derecha (si existe) será mayor o igual que la 
	 * clave izquierda ymayor que los valores almacenados en los nodos del
	 * subárbol enraizado en el hijo central, pero menor que los valores del 
	 * subárbol derecho.
	 * 
	 * Calling arguments:- nodo(Nodo): Un objeto de la clase Nodo cuyas claves 
	 * serán evaluadas en esta llamada para la inserción del valor. -valor(int):
	 * El valor entero que se quiere insertar en algún nodo del árbol, donde 
	 * proceda según su valor.
	 * 
	 * Return value: Un objeto de la clase Nodo cuya clave izquierda es valor
	 * y que se corresponde con el nuevo nodo a insertar (si el primer argumento
	 * es null),o bien el nodo hijo correspondiente del primer argumento (bien
	 * tal cual estaba antes de la llamada recursiva o bien con valor insertado en su
	 * clave derecha si esta era null y el valor a insertar era mayor que la 
	 * clave izquierda).		
	 * 
	 *********************************************************************/
	public Nodo insertarValorEnNodo(Nodo nodo, int valor) {
		if(nodo == null) {
			nodo = new Nodo();
			nodo.setClaveIzquierda(valor);
		}
		else {
			if(valor < nodo.getClaveIzquierda()) {
				nodo.setHijoIzquierdo(insertarValorEnNodo(nodo.getHijoIzquierdo(),valor));
			}else if (nodo.getClaveDerecha()==null) {
				nodo.setClaveDerecha(valor);
			}else if (valor < nodo.getClaveDerecha()) {
				nodo.setHijoCentral(insertarValorEnNodo(nodo.getHijoCentral(),valor));
			}else {
				nodo.setHijoDerecho(insertarValorEnNodo(nodo.getHijoDerecho(),valor));
			}
		}
		return nodo;
	}
	
	/*********************************************************************
	 * Method name: buscar
	 * 
	 * Description of the Method: Método que permite comprobar si un determinado
	 * valor entero se encuentra almacenado como clave izquierda o derecha de
	 * alguno de los nodos del árbol.
	 * 
	 * Calling arguments:-valor(int): El valor entero que se quiere buscar en 
	 * las claves de los nodos del árbol
	 * 
	 * Return value: Un boolean que será true si se encontró en algún nodo del
	 * árbol el valor buscado y false en caso contrario		
	 * 
	 *********************************************************************/
	public boolean buscar(int valor) {
		boolean resultado = valorEnNodo(this.raiz,valor);
		return resultado;
	}
	
	/*********************************************************************
	 * Method name: valorEnNodo
	 * 
	 * Description of the Method: Método que permite comprobar si un determinado
	 * valor entero se encuentra almacenado como clave izquierda o derecha del
	 * nodo pasado como argumento o de cualquiera de sus descendientes.
	 * 
	 * Calling arguments:-nodo(Nodo): Nodo cuyas claves (y claves de sus descendientes)
	 * se exploran en la llamada. -valor(int): El valor entero que se quiere buscar.
	 * 
	 * Return value: Un boolean que será true si se encontró en algún descendiente
	 * (o en el propio nodo) del nodo pasado como argumento el valor buscado
	 * y false en caso contrario		
	 * 
	 *********************************************************************/
	private boolean valorEnNodo(Nodo nodo, int valor) {
		boolean resultado = nodo!=null;
		if(resultado) {
			if(valor < nodo.getClaveIzquierda()) {
				resultado = valorEnNodo(nodo.getHijoIzquierdo(),valor);
			}else if(valor == nodo.getClaveIzquierda()) {
				resultado = true;
			}else if (nodo.getClaveDerecha() != null && valor == nodo.getClaveDerecha()) {
				resultado = true;
			}else if(nodo.getClaveDerecha() != null && valor > nodo.getClaveIzquierda() && valor < nodo.getClaveDerecha()) {
				resultado = valorEnNodo(nodo.getHijoCentral(),valor);
			}else {
				resultado = valorEnNodo(nodo.getHijoDerecho(),valor);
			}
		}
		return resultado;
	}
	
	/*********************************************************************
	 * Method name: getNumNodos
	 * 
	 * Description of the Method: Método que devuelve el número de nodos del
	 * árbol.
	 * 
	 * Calling arguments:-None.
	 * 
	 * Return value: Un entero con el número de nodos presentes en el árbol.
	 * 
	 *********************************************************************/
	public int getNumNodos() {
		return calcNumNodos(this.raiz);
	}
	/*********************************************************************
	 * Method name: calcNumNodos
	 * 
	 * Description of the Method: Método que devuelve el número de nodos del
	 * árbol enraizado en el nodo que se pasa como parámetro.
	 * 
	 * Calling arguments:-nodo(Nodo): El nodo que se contabiliza en cada llamada
	 * recursiva.
	 * 
	 * Return value: Un entero con el número de nodos del los subárboles izquierdo
	 * central y derecho del nodo pasado como argumento más 1 (se contabiliza el propio nodo).
	 * 
	 *********************************************************************/
	private int calcNumNodos(Nodo nodo) {
		int res = 0;
		if(nodo != null) {
			res++;
			res += calcNumNodos(nodo.getHijoIzquierdo());
			res += calcNumNodos(nodo.getHijoCentral());
			res += calcNumNodos(nodo.getHijoDerecho());
		}
		return res;
	}
	
	/*********************************************************************
	 * Method name: getNumClaves
	 * 
	 * Description of the Method: Método que devuelve el número de claves 
	 * almacenadas en los nodos del árbol.
	 * 
	 * Calling arguments:-None.
	 * 
	 * Return value: Un entero con el número de claves de los nodos del árbol.
	 * 
	 *********************************************************************/
	public int getNumClaves() {
		return calcNumClaves(this.raiz);
	}
	
	/*********************************************************************
	 * Method name: calcNumClaves
	 * 
	 * Description of the Method: Método que devuelve el número de claves 
	 * almacenadas en el nodo pasado como argumento más las claves almacenadas
	 * en los subárboles enraizados en el hijo izquierdo, central y derecho
	 * de ese nodo.
	 * 
	 * Calling arguments:-nodo(Nodo): El nodo cuyas claves (y las de sus subárboles)
	 * se contabilizan.
	 * 
	 * Return value: Un entero con el número de claves del los subárboles izquierdo
	 * central y derecho del nodo pasado como argumento más las claves de dicho nodo.
	 * 
	 *********************************************************************/
	private int calcNumClaves(Nodo nodo) {
		int res = 0;
		if(nodo != null) {
			if(nodo.getClaveIzquierda() != null)
				res++;
			if(nodo.getClaveDerecha() != null)
				res++;
			res += calcNumClaves(nodo.getHijoIzquierdo());
			res += calcNumClaves(nodo.getHijoCentral());
			res += calcNumClaves(nodo.getHijoDerecho());
		}
		return res;
	}
	
	/*********************************************************************
	 * Method name: getValoresOrdenados
	 * 
	 * Description of the Method: Método que devuelve una cadena de caracteres
	 * con los valores almacenados en los nodos del arbol en orden ascendente.
	 * 
	 * Calling arguments:-None
	 * 
	 * Return value: Una cadena de caracteres con los valores almacenados en
	 * los nodos del arbol en orden ascendente.
	 * 
	 *********************************************************************/
	public String getValoresOrdenados() {
		return calcCadena(this.raiz);
	}
	
	/*********************************************************************
	 * Method name: calcCadena
	 * 
	 * Description of the Method: Método que devuelve una cadena de caracteres
	 * con los valores,en orden ascendente, almacenados en el nodo que se pasa
	 * como parámetro y en sus descendientes.
	 * 
	 * Calling arguments:-nodo(Nodo): El nodo cuyas claves y las de sus descendientes
	 * se devuelven ordenadas en una cadena de caracteres
	 * 
	 * Return value:Una cadena de caracteres con los valores,en orden ascendente,
	 * almacenados en el nodo que se pasa como parámetro y en sus descendientes.
	 * 
	 *********************************************************************/
	private String calcCadena(Nodo nodo) {
		String cad = "";
		if(nodo != null) {
			cad += calcCadena(nodo.getHijoIzquierdo());
			if(nodo.getClaveIzquierda() != null)
				cad += nodo.getClaveIzquierda().toString() + " ";
			cad += calcCadena(nodo.getHijoCentral());
			if(nodo.getClaveDerecha() != null)
				cad += nodo.getClaveDerecha().toString() + " ";
			cad += calcCadena(nodo.getHijoDerecho());
		}
		return cad;
	}
	
	public int getValorMin() throws ArbolVacioException {
		if(this.raiz==null)
			throw new ArbolVacioException();
		return calcValorMin(this.raiz);
	}
	
	public int calcValorMin(Nodo nodo) {
		int valorMin;
		if(nodo.getHijoIzquierdo()==null)
			valorMin=nodo.getClaveIzquierda();
		else
			valorMin=calcValorMin(nodo.getHijoIzquierdo());
		return valorMin;
	}
	
	public int getValorMax() throws ArbolVacioException {
		if(this.raiz==null)
			throw new ArbolVacioException();
		return calcValorMax(this.raiz);
	}
	
	public int calcValorMax(Nodo nodo) {
		int valorMax;
		if(nodo.getHijoDerecho()!=null) 
				valorMax=calcValorMax(nodo.getHijoDerecho());
		else if(nodo.getClaveDerecha()!=null)
				valorMax=nodo.getClaveDerecha();
		else
			    valorMax=nodo.getClaveIzquierda();
		return valorMax;
	}
}

