import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {
	public static void main(String[] args) {
		Scanner lectura = new Scanner(System.in);
		String fichero;
		System.out.println("Bienvenido");
		do {
			System.out.println("Introduzca el nombre del fichero");
			fichero = lectura.nextLine();
			if (!fichero.equals("")) {
				try {
					leerFichero(fichero);
				} catch (FileNotFoundException e) {
					System.out.println("Fichero no encontrado");
				} catch (ArbolVacioException e) {
					System.out.println("Error, el arbol esta vacio");
				}
			}
		} while (!fichero.equals(""));
		System.out.println("Programa terminado");
	}

	public static void leerFichero(String fichero) throws FileNotFoundException, ArbolVacioException {

		FicheroSecuencial<Linea> f = new FicheroSecuencial<Linea>(fichero, " ");
		Linea line = new Linea();
		f.leerLinea(line);
		if (!line.getOperacion().equals("c"))
			System.out.println("Error, la primera linea tiene que ser de creacion");
		else {
			Arbol arbol = new Arbol();
			System.out.println("Arbol creado");
			while (!f.detectaEOF()) {
				f.leerLinea(line);
				switch (line.getOperacion()) {
				case "c":
					arbol = new Arbol();
					System.out.println("Arbol creado");
					break;
				case "i":
					arbol.insertarValor(line.getNum());
					System.out.println("Valor " + line.getNum() + " insertado");
					break;
				case "mx":
					System.out.println("Valor maximo del arbol:" + arbol.getValorMax());
					break;
				case "mn":
					System.out.println("Valor minimo del arbol:" + arbol.getValorMin());
					break;
				case "s":
					System.out.println("Cadena de caracteres del arbol:" + arbol.getValoresOrdenados());
					break;
				case "nn":
					System.out.println("Numero de nodos del arbol:" + arbol.getNumNodos());
					break;
				case "nk":
					System.out.println("Numero de claves del arbol:" + arbol.getNumClaves());
					break;
				case "b":
					String resultado = "El valor " + line.getNum() + " no esta en el arbol";
					if (arbol.buscar(line.getNum()))
						resultado = "El valor " + line.getNum() + " si esta en el arbol";
					System.out.println(resultado);
					break;
				default:
					System.out.println("Opcion incorrecta leida");
					break;
				}
			}
		}
	}
}
