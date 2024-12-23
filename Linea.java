/*********************************************************************
*
* Interface Name: Linea
* Author/s name: JFBR
* Release/Creation date: 19/12/2024
* Interface version: 1.0
* Interface description: Esta clase es creada para que se facilite el trabajo del metodo Main.leerFichero(), implementa a lector.
*
**********************************************************************/

public class Linea implements Lector{
	private String operacion;
	private int num;

/*********************************************************************
* Method name: Linea
* 
* Description of the Method: constructor con valores para inicializarlo con esos valores.
* 
* Calling arguments:- op(String): El nombre de la operación,
* n(int): El número para la operación.
* 
* Return value: None.
* 
*********************************************************************/
	
	public Linea(String op, int n) {
		operacion=op;
		num=n;
	}

/*********************************************************************
* Method name: Linea
* 
* Description of the Method: constructor sin valores para que todo sea null.
* 
* Calling arguments:- None.
* 
* Return value: None.
* 
*********************************************************************/
	
	public Linea() {};

/*********************************************************************
* Method name: leerDatos
* 
* Description of the Method: método para leer los datos y por consiguiente usarlos en la operación.
* 
* Calling arguments:- datos(String[]): argumento para leer los datos.
* 
* Return value: None.
* 
*********************************************************************/
	public void leerDatos(String[] datos) {
		this.operacion = datos[0];
		if(datos.length==2)
			this.num = Integer.parseInt(datos[1]); 
    }

/*********************************************************************
* Method name: getOperacion
* 
* Description of the Method: método para devolver la operación.
* 
* Calling arguments:- None.
* 
* Return value: operation(String): devuelve la operación.
* 
*********************************************************************/

	public String getOperacion() {
		return operacion;
	}

/*********************************************************************
* Method name: getNum
* 
* Description of the Method: método para devolver el número.
* 
* Calling arguments:- None.
* 
* Return value: num(int): devuelve el número.
* 
*********************************************************************/

	public int getNum() {
		return num;
	}
}
