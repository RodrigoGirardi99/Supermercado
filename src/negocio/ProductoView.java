package negocio;

public class ProductoView {
	private String codigo;
	private String descripcion;
	private String marca;
	private float precio;
	private Proveedor proveedor;
	private int stock;
	private int stockMinimo;
	private int pedidoReposicion;
	private String estado;

	public ProductoView(String codigo, String descripcion, String marca, float precio, Proveedor proveedor, int stock,
			int stockMinimo, int pedidoReposicion, String estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.marca = marca;
		this.precio = precio;
		this.proveedor = proveedor;
		this.stock = stock;
		this.stockMinimo = stockMinimo;
		this.pedidoReposicion = pedidoReposicion;
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public float getPrecio() {
		return precio;
	}

	public int getPedidoReposicion() {
		return pedidoReposicion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public int getStock() {
		return stock;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public String getEstado() {
		return estado;
	}

}
