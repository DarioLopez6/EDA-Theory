import java.util.ArrayList;
import java.util.List;

public class Arbol {

	private Nodo raiz;

	public Arbol() {
		this.raiz = null;
	}

	private Nodo obtenerHojaDeInsercion(Nodo nodoActual, Integer valor) throws ValorDuplicadoException{
		Nodo hojaDeInsercion = null;
		
		if(nodoActual != null) {
			Integer claveIzquierda = nodoActual.getClaveIzquierda();
			Integer claveDerecha = nodoActual.getClaveDerecha();

			if(!nodoActual.esHoja()) {
				if(valor < claveIzquierda) {
					hojaDeInsercion = this.obtenerHojaDeInsercion(nodoActual.getHijoIzquierdo(), valor);
				}else if(claveDerecha == null || valor > claveDerecha) {
					hojaDeInsercion = this.obtenerHojaDeInsercion(nodoActual.getHijoDerecho(), valor);
				}else {
					hojaDeInsercion = this.obtenerHojaDeInsercion(nodoActual.getHijoCentral(), valor);
				}
			}else {
				hojaDeInsercion = nodoActual;
			}
		}
		
		return hojaDeInsercion;
	}

	private List<Nodo> obtenerHermanosDeNodo(Nodo nodoObjetivo){
		List<Nodo> listaHermanos = new ArrayList<Nodo>();

		Nodo nodoPadre = nodoObjetivo.getPadre();
		
		if(nodoPadre != null) {
			Nodo padreHijoIzquierdo = nodoPadre.getHijoIzquierdo();
			Nodo padreHijoCentral = nodoPadre.getHijoCentral();
			Nodo padreHijoDerecho = nodoPadre.getHijoDerecho();

			if(padreHijoIzquierdo != null && nodoObjetivo.equals(padreHijoIzquierdo)) {
				if(padreHijoCentral != null) {
					listaHermanos.add(padreHijoCentral);
				}
				if(padreHijoDerecho != null) {
					listaHermanos.add(padreHijoDerecho);
				}
			}else if(padreHijoCentral != null && nodoObjetivo.equals(padreHijoCentral)) {
				if(padreHijoIzquierdo != null) {
					listaHermanos.add(padreHijoIzquierdo);
				}
				if(padreHijoDerecho != null) {
					listaHermanos.add(padreHijoDerecho);
				}
			}else if(padreHijoDerecho != null && nodoObjetivo.equals(padreHijoDerecho)) {
				if(padreHijoIzquierdo != null) {
					listaHermanos.add(padreHijoIzquierdo);
				}
				if(padreHijoCentral != null) {
					listaHermanos.add(padreHijoCentral);
				}
			}
		}
		
		return listaHermanos;
	}

	private void ordenarListaNodosHermano(List<Nodo> listaHermanos) {
	    Nodo nodoMinimo;
	    int indiceMinimo;

	    for (int i = 0; i < listaHermanos.size() - 1; i++) {
	        nodoMinimo = listaHermanos.get(i);
	        indiceMinimo = i;

	        // Encontrar el índice del nodo con la clave izquierda mínima
	        for (int j = i + 1; j < listaHermanos.size(); j++) {
	            Nodo nodoComparar = listaHermanos.get(j);
	            if (nodoComparar.getClaveIzquierda() < nodoMinimo.getClaveIzquierda()) {
	                nodoMinimo = nodoComparar;
	                indiceMinimo = j;
	            }
	        }

	        // Intercambiar el nodo actual con el nodo con la clave mínima
	        if (indiceMinimo != i) {
	            Nodo temp = listaHermanos.get(i);
	            listaHermanos.set(i, listaHermanos.get(indiceMinimo));
	            listaHermanos.set(indiceMinimo, temp);
	        }
	    }
	}

	
	
	public void insertarValorSobreNodo(Nodo nodoDeInsercion, Integer valor, List<Nodo> listaHijos) {
		Nodo nodoPadre;
		Nodo nodoPadreDerecho;
	
		if(nodoDeInsercion == null) {// Caso de raiz nul
			this.raiz = new Nodo();
			this.raiz.setClaveIzquierda(valor);
			
			nodoPadre = this.raiz;
			nodoPadreDerecho = null;
		}else {// Caso de árbol con raiz

			// Nodos padre (en caso de que el se divida se popula uno nuevo)
			nodoPadre = nodoDeInsercion;
			nodoPadreDerecho = null;

			Integer nodoDeInsercionClaveIzquierda = nodoDeInsercion.getClaveIzquierda();
			Integer nodoDeInsercionClaveDerecha= nodoDeInsercion.getClaveDerecha();

			// Caso 1: Nodo de insercion no tiene clave derecha
			if(nodoDeInsercionClaveDerecha == null) {
				Integer valorMenor = valor < nodoDeInsercionClaveIzquierda ? valor : nodoDeInsercionClaveIzquierda;
				Integer valorMayor = valor < nodoDeInsercionClaveIzquierda ? nodoDeInsercionClaveIzquierda : valor;
				nodoPadre.setClaveIzquierda(valorMenor);
				nodoPadre.setClaveDerecha(valorMayor);
			}else { // Caso 2: Tiene 2 claves, rompemos el nodoPadre en dos
				Integer[] clavesOrdenadas = nodoDeInsercion.obtenerValoresOrdenados(valor);

				nodoPadre = new Nodo();
				nodoPadre.setClaveIzquierda(clavesOrdenadas[0]);
				
				nodoPadreDerecho = new Nodo();
				nodoPadreDerecho.setClaveIzquierda(clavesOrdenadas[2]);

				List<Nodo> nuevaListaHijos = this.obtenerHermanosDeNodo(nodoDeInsercion);
				nuevaListaHijos.add(nodoPadre);
				nuevaListaHijos.add(nodoPadreDerecho);
				this.ordenarListaNodosHermano(nuevaListaHijos);
				this.insertarValorSobreNodo(nodoDeInsercion.getPadre(), clavesOrdenadas[1], nuevaListaHijos);
			}
		}
		
		// Agregar conexiones padre-hijo con 1 padre de 3 hijos
		if(nodoPadreDerecho == null && listaHijos.size() == 2) {
			nodoPadre.setHijoIzquierdo(listaHijos.get(0));
			nodoPadre.setHijoDerecho(listaHijos.get(1));
			
			listaHijos.get(0).setPadre(nodoPadre);
			listaHijos.get(1).setPadre(nodoPadre);
		}
		if(nodoPadreDerecho == null && listaHijos.size() == 3) {
			nodoPadre.setHijoIzquierdo(listaHijos.get(0));
			nodoPadre.setHijoCentral(listaHijos.get(1));
			nodoPadre.setHijoDerecho(listaHijos.get(2));
			
			listaHijos.get(0).setPadre(nodoPadre);
			listaHijos.get(1).setPadre(nodoPadre);
			listaHijos.get(2).setPadre(nodoPadre);
		}else if(listaHijos.size() == 4){ // Conexiones con padre dividido (4 hijos)
			nodoPadre.setHijoIzquierdo(listaHijos.get(0));
			nodoPadre.setHijoDerecho(listaHijos.get(1));
			nodoPadreDerecho.setHijoIzquierdo(listaHijos.get(2));
			nodoPadreDerecho.setHijoDerecho(listaHijos.get(3));

			listaHijos.get(0).setPadre(nodoPadre);
			listaHijos.get(1).setPadre(nodoPadre);
			listaHijos.get(2).setPadre(nodoPadreDerecho);
			listaHijos.get(3).setPadre(nodoPadreDerecho);
		}
	}
	

	public void insertarValor(int valor) throws ValorDuplicadoException {
		Nodo hojaDeInsercion = this.obtenerHojaDeInsercion(this.raiz, valor);
		List<Nodo> listaHijos = new ArrayList<Nodo>();
		insertarValorSobreNodo(hojaDeInsercion, valor, listaHijos);
	}
	
	public boolean buscar(int valor) {
		boolean resultado = valorEnNodo(this.raiz,valor);
		return resultado;
	}
	
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
	
	public int getNumNodos() {
		return calcNumNodos(this.raiz);
	}
	
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
	
	public int getNumClaves() {
		return calcNumClaves(this.raiz);
	}
	
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
	
	public String getValoresOrdenados() {
		return calcCadena(this.raiz).toString();
	}
	
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
}

