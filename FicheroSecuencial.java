/*********************************************************************
 * 
 * Class Name: FicheroSecuencial
 * Author/s name: JAEL, JFBR, AJE
 * Release/Creation date: [24/09/2024]
 * Class version: 1.0
 * Class description: 
 * 	La clase FicheroSecuencial utiliza genéricos para permitir la
 * 	lectura secuencial de archivos de texto, donde cada línea es
 *	procesada por un objeto que extiende la interfaz o clase 'Lector'.
 * 	Permite abrir un fichero, leer líneas, saltar líneas y detectar el fin del archivo.
 * 
 ********************************************************************** */
import java.io.*;
import java.util.*;

public class FicheroSecuencial<T extends Lector> {

	private File file; // Instancia de la clase Fichero
	private Scanner sc; // Permite la lectura secuencial del archivo de texto
	private String separador; // Cadena que define el separador de campos en el archivo (por ejemplo, coma,en ficheros CSV)

	/*********************************************************************
	 * 
	 * Method name: FicheroSecuencial (Constructor)
	 * 
	 * Description of the Method: 
	 * 	Constructor que inicializa el archivo, el objeto
	 * 	Scanner y el separador para dividir las líneas leídas.
	 * 
	 * Calling arguments: 
	 * 	- String nombreFichero: nombre o ruta del archivo a leer.
	 * 	- String separador: cadena que define el delimitador para dividir cada línea.
	 * 
	 * Return value: 
	 * 	No tiene valor de retorno.
	 * 
	 * Required Files:
	 * 	El archivo indicado por `nombreFichero` debe existir.
	 * 
	 * List of Checked Exceptions: 
	 * 	- FileNotFoundException se lanza si el archivo no se encuentra.
	 * 
	 *********************************************************************/
	public FicheroSecuencial(String nombreFichero, String separador) throws FileNotFoundException {
		file = new File(nombreFichero);
		sc = new Scanner(file);
		this.separador = separador;
	}

	/*********************************************************************
	 * 
	 * Method name: cerrar
	 * 
	 * Description of the Method: 
	 * 	Este método cierra el objeto Scanner para liberar
	 * 	los recursos utilizados al leer el archivo. 
	 * 
	 * Calling arguments: 
	 * 	No recibe argumentos.
	 * 
	 * Return value: 
	 * 	No tiene valor de retorno.
	 * 
	 *********************************************************************/
	public void cerrar() {
		sc.close();
	}

	/*********************************************************************
	 *
	 * Method name: leerLinea
	 * 
	 * Description of the Method: 
	 * 	Lee una línea del archivo, la divide en campos
	 * 	utilizando el separador proporcionado, y delega el procesamiento de esos
	 * 	campos al método leerDatos del objeto genérico (debe tener el método
	 * 	leerDatos()).
	 *
	 * Calling arguments: 
	 * 	- generico (T): Un objeto genérico el cual debe tener implementado el método leerDatos(String[]).
	 *
	 * Return value: 
	 * 	No tiene valor de retorno.
	 *
	 * Required Files: 
	 * 	El archivo debe estar abierto y debe tener al menos una línea
	 * 	de contenido para leer.
	 *
	 * List of Checked Exceptions: 
	 *	- NoSuchElementException: Lanzada si no hay más líneas que leer.
	 *
	 *********************************************************************/
	public void leerLinea(T generico) {
		String[] palabras = sc.nextLine().split(separador);
		generico.leerDatos(palabras);
	}

	/*********************************************************************
	 * 
	 * Method name: saltarLinea 
	 * 
	 * Description of the Method:
	 * 	Lee la siguiente línea del archivo sin hacer nada con ella,
	 * 	esencialmente saltando dicha línea. 
	 * 
	 * Calling arguments: 
	 * 	No recibe argumentos.
	 * 
	 * Return value: 
	 * 	No tiene valor de retorno.
	 * 
	 *********************************************************************/
	public void saltarLinea() {
		sc.nextLine();
	}

	/*********************************************************************
	 * 
	 * Method name: detectaEOF 
	 * 
	 * Description of the Method:
	 * 	Detecta si se ha llegado al final del archivo. 
	 * 
	 * Calling arguments: 
	 * 	No recibe argumentos.
	 * 
	 * Return value: 
	 * 	boolean - true si no hay más líneas que leer, false en caso contrario.
	 * 
	 *********************************************************************/
	public boolean detectaEOF() {
		return !(sc.hasNext());
	}
}
