package org.cibertec.edu.pe.modelo;

public class carrito {
	//Campos o atributos
	private int IdProducto;
	private int Cantidad;
	//Metodos Constructores
	public carrito() {
	
	}

	public carrito(int idProducto, int cantidad) {
		super();
		IdProducto = idProducto;
		Cantidad = cantidad;
	}

	//Propiedades de Lectura y Escritura
	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	
	
	
	

}
