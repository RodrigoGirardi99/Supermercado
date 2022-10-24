package negocio;

import java.util.Vector;

public class Producto {
	private String codigo;
	private String descripcion;
	private String marca;
	private float precio;
	private Proveedor proveedor;
	private int stock;
	private int stockMinimo;
	private int pedidoReposicion;
	private String estado;

	public Producto(String codigo, String descripcion, String marca, Proveedor proveedor, float precio, int stock,
			int stockMinimo, int pedidoReposicion, String estado) {

		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
		this.proveedor = proveedor;
		this.stockMinimo = stockMinimo;
		this.pedidoReposicion = pedidoReposicion;
		this.estado = estado;

	}

// Setters

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public int getPedidoReposicion() {
		return pedidoReposicion;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void setPedidoReposicion(int pedidoReposicion) {
		this.pedidoReposicion = pedidoReposicion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Metodos de negocio

	public boolean sosElProducto(String productoBuscado) {
		if (codigo.equalsIgnoreCase(productoBuscado)) {
			return true;
		} else {
			return false;
		}
	}

	public Vector<String> getVectorStock() {

		Vector<String> datos = new Vector<String>();
		if (stock <= stockMinimo) {
			datos.add(codigo.toString());
			datos.add(descripcion);
			datos.add(stock + "");
			datos.add(stockMinimo + "");
			datos.add(pedidoReposicion + "");
			datos.add(precio + "");
		}

		return datos;
	}

	public ProductoView getView() {
		return (new ProductoView(codigo, descripcion, marca, precio, proveedor, stock, stockMinimo, pedidoReposicion,
				estado));
	}
}
