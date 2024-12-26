/*********************************************************************
 * Class Name: Nodo
 * Author/s name: JFBR
 * Release/Creation date: 19/12/2024
 * Class version: 1.0
 * Class description: Esta clase representa un nodo para un árbol, con referencias
 * a su padre y sus tres posibles hijos (izquierdo, central y derecho) y almacena dos valores que
 * claves(izquierda y derecha).
 *********************************************************************/
public class Nodo {

    private Nodo padre; 
    private Nodo hijoIzquierdo; 
    private Nodo hijoCentral; 
    private Nodo hijoDerecho; 
    private Integer claveIzquierda; 
    private Integer claveDerecha; 

    /*********************************************************************
     * Method name: esRaiz
     * Description: método para comprobar si el nodo actual es la raíz del árbol.
     * Calling arguments:- None.
     * Return value: Un boolean que será true si el nodo es la raíz
     * y false en caso contrario
     *********************************************************************/
    public boolean esRaiz() {
        return this.padre == null;
    }

    /*********************************************************************
     * Method name: esHoja
     * Description: método para comprobar si el nodo actual es una hoja (sin hijos).
     * Calling arguments:- None.
     * Return value: Un boolean que será true si el nodo es un nodo hoja
     * y false en caso contrario
     *********************************************************************/
    public boolean esHoja() {
        return this.hijoIzquierdo == null && this.hijoCentral == null && this.hijoDerecho == null;
    }

    /*********************************************************************
     * Method name: getPadre
     * Description: método que devuelve el nodo padre del nodo actual.
     * Calling arguments:- None.
     * Return value: Un nodo, el cual es el padre del actual.
     *********************************************************************/
    public Nodo getPadre() {
        return padre;
    }

    /*********************************************************************
     * Method name: setPadre
     * Description: método que establece el nodo padre del nodo actual.
     * Calling arguments:
     * -Nodo padre : Nodo que será el padre.
     * Return value: None.
     *********************************************************************/
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    /*********************************************************************
     * Method name: getHijoIzquierdo
     * Description: método que devuelve el hijo izquierdo del nodo actual.
     * Calling arguments:- None.
     * Return value: Un nodo, el cual es el hijo izquierdo del actual.
     *********************************************************************/
    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    /*********************************************************************
     * Method name: setHijoIzquierdo
     * Description: método que establece el hijo izquierdo del nodo actual.
     * Calling arguments:
     * - Nodo hijoIzquierdo : Nodo que será el hijo izquierdo.
     * Return value: None.
     *********************************************************************/
    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    /*********************************************************************
     * Method name: getHijoCentral
     * Description: método que devuelve el hijo central del nodo actual.
     * Calling arguments:- None.
     * Return value: Un nodo, el cual es el hijo central del actual.
     *********************************************************************/
    public Nodo getHijoCentral() {
        return hijoCentral;
    }

    /*********************************************************************
     * Method name: setHijoCentral
     * Description: método que establece el hijo central del nodo actual.
     * Calling arguments:
     * - Nodo hijoCentral : Nodo que será el hijo central.
     * Return value: None.
     *********************************************************************/
    public void setHijoCentral(Nodo hijoCentral) {
        this.hijoCentral = hijoCentral;
    }

    /*********************************************************************
     * Method name: getHijoDerecho
     * Description: método que devuelve el hijo derecho del nodo actual.
     * Calling arguments:- None.
     * Return value: Un nodo, el cual es el hijo derecho del actual.
     *********************************************************************/
    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    /*********************************************************************
     * Method name: setHijoDerecho
     * Description: método que establece el hijo derecho del nodo actual.
     * Calling arguments:
     * - Nodo hijoDerecho : Nodo que será el hijo derecho.
     * Return value: None.
     *********************************************************************/
    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    /*********************************************************************
     * Method name: getClaveIzquierda
     * Description: método que devuelve la clave izquierda del nodo actual.
     * Calling arguments:- None.
     * Return value: Un integer, el cual corresponde a la clave izquierda del nodo.
     *********************************************************************/
    public Integer getClaveIzquierda() {
        return claveIzquierda;
    }

    /*********************************************************************
     * Method name: setClaveIzquierda
     * Description: método que establece la clave izquierda del nodo actual.
     * Calling arguments:
     * - Integer claveIzquierda : Valor para la clave izquierda.
     * Return value: None.
     *********************************************************************/
    public void setClaveIzquierda(Integer claveIzquierda) {
        this.claveIzquierda = claveIzquierda;
    }

    /*********************************************************************
     * Method name: getClaveDerecha
     * Description: método que devuelve la clave derecha del nodo actual.
     * Calling arguments:- None.
     * Return value: Un integer, el cual corresponde a la clave derecha del nodo.
     *********************************************************************/
    public Integer getClaveDerecha() {
        return claveDerecha;
    }

    /*********************************************************************
     * Method name: setClaveDerecha
     * Description: método que establece la clave derecha del nodo actual.
     * Calling arguments:
     * -Integer claveDerecha : Valor para la clave derecha.
     * Return value: None.
     *********************************************************************/
    public void setClaveDerecha(Integer claveDerecha) {
        this.claveDerecha = claveDerecha;
    }

    /*********************************************************************
     * Method name: obtenerValoresOrdenados
     * Description: método que ordena las claves del nodo según un nuevo valor.
     * Calling arguments:
     * -Integer nuevoValor : Valor para comparar con las claves del nodo.
     * Return value: Integer[] nodosOrdenados : Array con las claves ordenadas.
     *********************************************************************/
    public Integer[] obtenerValoresOrdenados(Integer nuevoValor) {
        Integer[] nodosOrdenados = new Integer[3];

        Integer valorMenor = nuevoValor < this.claveIzquierda ? nuevoValor : this.claveIzquierda; 
        Integer valorMayor = nuevoValor > this.claveDerecha ? nuevoValor : this.claveDerecha; 
        Integer valorMediana;

        if (nuevoValor > this.getClaveIzquierda() && nuevoValor < this.getClaveDerecha()) {
            valorMediana = nuevoValor;
        } else if (nuevoValor < this.getClaveIzquierda()) {
            valorMediana = this.getClaveIzquierda();
        } else {
            valorMediana = this.getClaveDerecha();
        }

        nodosOrdenados[0] = valorMenor;
        nodosOrdenados[1] = valorMediana;
        nodosOrdenados[2] = valorMayor;

        return nodosOrdenados;
    }

    /*********************************************************************
     * Method name: equals
     * Description: método que compara si dos nodos son iguales en base a sus claves.
     * Calling arguments:
     * - Nodo otroNodo: Nodo a comparar.
     * Return value: Un boolean que es true si las claves izquierda y derecha son iguales y false en caso contrario.
     *********************************************************************/
    public boolean equals(Nodo otroNodo) {
        return this.claveIzquierda == otroNodo.claveIzquierda && this.claveDerecha == otroNodo.claveDerecha;
    }
}
