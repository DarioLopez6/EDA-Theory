
public class Linea implements Lector{
	private String operacion;
	private int num;
	public Linea(String op, int n) {
		operacion=op;
		num=n;
	}
	public Linea() {};
	public void leerDatos(String[] datos) {
		this.operacion = datos[0];
		if(datos.length==2)
			this.num = Integer.parseInt(datos[1]); 
    }
	public String getOperacion() {
		return operacion;
	}
	public int getNum() {
		return num;
	}
}
