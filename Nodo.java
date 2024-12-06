
public class Nodo {

	private Nodo padre;
	private Nodo hijoIzquierdo;
	private Nodo hijoCentral;
	private Nodo hijoDerecho;
	private Integer claveIzquierda;
	private Integer claveDerecha;

	public boolean esRaiz() {
		return this.padre == null;
	}
	
	public boolean esHoja() {
		return this.hijoIzquierdo == null && this.hijoCentral == null && this.hijoDerecho == null;
	}
	
	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public Nodo getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(Nodo hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	public Nodo getHijoCentral() {
		return hijoCentral;
	}

	public void setHijoCentral(Nodo hijoCentral) {
		this.hijoCentral = hijoCentral;
	}

	public Nodo getHijoDerecho() {
		return hijoDerecho;
	}

	public void setHijoDerecho(Nodo hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}

	public Integer getClaveIzquierda() {
		return claveIzquierda;
	}

	public void setClaveIzquierda(Integer claveIzquierda) {
		this.claveIzquierda = claveIzquierda;
	}

	public Integer getClaveDerecha() {
		return claveDerecha;
	}

	public void setClaveDerecha(Integer claveDerecha) {
		this.claveDerecha = claveDerecha;
	}

	public Integer[] obtenerValoresOrdenados(Integer nuevoValor) {
		Integer[] nodosOrdenados = new Integer[3];

		Integer valorMenor = nuevoValor < this.claveIzquierda ? nuevoValor : this.claveIzquierda;
		Integer valorMayor = nuevoValor > this.claveDerecha ? nuevoValor : this.claveDerecha;
		Integer valorMediana;

		if(nuevoValor > this.getClaveIzquierda() && nuevoValor < this.getClaveDerecha()) {
			valorMediana = nuevoValor;
		}else if(nuevoValor < this.getClaveIzquierda()) {
			valorMediana = this.getClaveIzquierda();
		}else {
			valorMediana = this.getClaveDerecha();
		}

		nodosOrdenados[0] = valorMenor;
		nodosOrdenados[1] = valorMediana;
		nodosOrdenados[2] = valorMayor;
		
		return nodosOrdenados;
	}

	public boolean equals(Nodo otroNodo) {
		return this.claveIzquierda == otroNodo.claveIzquierda && this.claveDerecha == otroNodo.claveDerecha;
	}
}
