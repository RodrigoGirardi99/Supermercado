package negocio;

public class ItemVenta {
	private Producto producto;
	private int cantidad;

	public ItemVenta(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

// Metodos de negocio

	public float calcularSubtotal() {
		float precio;
		precio = producto.getPrecio() * cantidad;
		return precio;
	}
}
