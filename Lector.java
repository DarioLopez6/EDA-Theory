/*********************************************************************
*
* Interface Name: Lector
* Author/s name: AJE, JAEL, JFBR
* Release/Creation date: [24/09/2024]
* Interface version: 1.0
* Interface description: La interfaz `Lector` define un método para leer 
* y asignar datos de un vector de Strings a los atributos de una clase.
*
**********************************************************************/
public interface Lector {
    
    /*********************************************************************
    *
    * Method name: leerDatos
    *
    * Description of the Method: Define un método que acepta un arreglo de cadenas
    * para procesar y asignar sus valores a los atributos de una clase que implemente 
    * esta interfaz.
    *
    * Calling arguments:
    *   - String[] palabras : Un vector de cadenas de caracteres que contiene los datos que se van 
    *     a leer y asignar en la clase implementadora.
    *
    * Return value: void. No devuelve ningún valor.
    *
    * Required Files: N/A
    *
    * List of Checked Exceptions: N/A
    *
    **********************************************************************/
    public void leerDatos(String[] palabras);
}
