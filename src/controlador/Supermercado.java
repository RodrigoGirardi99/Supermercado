package controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import negocio.Caja;
import negocio.CajaView;
import negocio.Producto;
import negocio.ProductoView;
import negocio.Proveedor;
import negocio.ProveedorView;
import negocio.Venta;
import negocio.VentaView;

public class Supermercado {
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Producto> productos;
	private ArrayList<Venta> ventas;
	private ArrayList<Caja> cajas;
	private static Supermercado instancia;

	private Supermercado() {
		super();
		this.proveedores = new ArrayList<Proveedor>();
		this.productos = new ArrayList<Producto>();
		this.ventas = new ArrayList<Venta>();
		this.cajas = new ArrayList<Caja>();
		cargaInicial();

	}

	private void cargaInicial() {

		LocalDate fecha = LocalDate.now();
		crearNuevoProveedor("1", "Marolio", "Calle Falsa", "47989448", "mail@mail.com");
		crearNuevoProveedor("2", "Matarazzo", "Calle Falsa", "47989448", "mail@mail.com");
		crearNuevoProducto("1", "Tomate", "Marca Falsa", "1", 12.5f, 10, 20, 100);
		crearNuevoProducto("2", "Zapallo", "Marca Falsa", "2", 10f, 10, 20, 100);
		crearNuevoProducto("3", "Girasol", "Marca Falsa", "1", 5f, 10, 20, 100);
		crearNuevoProducto("4", "Berenjena", "Marca Falsa", "2", 35f, 40, 20, 100);
		abrirCaja(fecha, "1", "Rodrigo", 1000f);
		inicioVenta(fecha, "1", "Rodrigo", "1");
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Producto> getProducto() {
		return productos;
	}

	public void setProducto(ArrayList<Producto> producto) {
		this.productos = producto;
	}

	public static Supermercado getInstancia() {
		if (instancia == null)
			instancia = new Supermercado();
		return instancia;
	}

	// Metodos del negocio

	// ****************************************************** PRODUCTO
	// ******************************************************
	// Crear Producto

	public void crearNuevoProducto(String codigo, String descripcion, String marca, String cuit, float precio,
			int stock, int stockMinimo, int pedidoReposicion) {

		Producto newProducto = buscarProducto(codigo);
		Proveedor newProveedor = buscarProveedor(cuit);

		if (newProducto == null && newProveedor != null) {
			newProducto = new Producto(codigo, descripcion, marca, newProveedor, precio, stock, stockMinimo,
					pedidoReposicion, "0");
			productos.add(newProducto);
			newProveedor.setEstado("1");
		}
	}

	// Borrar Producto

	public void BorrarProducto(String codigo) {
		Producto ExisteProducto = buscarProducto(codigo);
		if (ExisteProducto != null) {
			productos.remove(ExisteProducto);

		}

	}

	public void ActualizoProductoB(String codigo, String estado) {
		Producto ExisteProducto = buscarProducto(codigo);
		if (ExisteProducto != null) {
			ExisteProducto.setEstado(estado);

		}

	}

	// Modificar Producto

	public void ModificarProducto(String codigo, String descripcion, String marca, String cuit, float precio, int stock,
			int stockMinimo, int pedidoReposicion) {

		Proveedor ExisteProveedor = buscarProveedor(cuit);
		Producto ExisteProducto = buscarProducto(codigo);
		if (ExisteProducto != null && ExisteProveedor != null) {
			ExisteProducto.setCodigo(codigo);
			ExisteProducto.setDescripcion(descripcion);
			ExisteProducto.setMarca(marca);
			ExisteProducto.setProveedor(ExisteProveedor);
			ExisteProducto.setPrecio(precio);
			ExisteProducto.setStock(stock);
			ExisteProducto.setStockMinimo(stockMinimo);
			ExisteProducto.setPedidoReposicion(pedidoReposicion);
		}

	}

	// Buscar Producto

	public Producto buscarProducto(String codigo) {
		for (int i = 0; i < productos.size(); i++) {
			Producto aux = productos.get(i);
			if (aux.sosElProducto(codigo)) {

				return aux;
			}
		}

		return null;
	}

	public ProductoView buscarProductoView(String codigo) {
		Producto producto = buscarProducto(codigo);
		if (producto != null)
			return producto.getView();
		return null;
	}

	// ****************************************************** PROVEEDOR
	// ******************************************************
	// Crear Proveedor

	public void crearNuevoProveedor(String cuit, String razonSocial, String domicilio, String telefono, String mail) {
		Proveedor newProveedor = buscarProveedor(cuit);
		if (newProveedor == null) {
			newProveedor = new Proveedor(cuit, razonSocial, domicilio, telefono, mail, "0");
			proveedores.add(newProveedor);

		}
	}

	// Borrar Proveedor Fisica

	public void BorrarProveedor(String cuit) {
		Proveedor ExisteProveedor = buscarProveedor(cuit);
		if (ExisteProveedor != null) {
			proveedores.remove(ExisteProveedor);

		}

	}

	public void ActualizoProveedorB(String cuit, String estado) {
		Proveedor ExisteProveedor = buscarProveedor(cuit);
		if (ExisteProveedor != null) {
			ExisteProveedor.setEstado(estado);

		}

	}

	// Modificar Proveedor

	public void ModificarProveedor(String cuit, String razonSocial, String domicilio, String telefono, String mail) {
		Proveedor ExisteProveedor = buscarProveedor(cuit);
		if (ExisteProveedor != null) {
			ExisteProveedor.setRazonSocial(razonSocial);
			ExisteProveedor.setDomicilio(domicilio);
			ExisteProveedor.setTelefono(telefono);
			ExisteProveedor.setMail(mail);
		}

	}

	// Buscar Proveedor

	public Proveedor buscarProveedor(String cuit) {
		for (int i = 0; i < proveedores.size(); i++) {
			Proveedor aux = proveedores.get(i);
			if (aux.sosElProveedor(cuit))
				return aux;

		}

		return null;
	}

	public ProveedorView buscarProveedorView(String cuit) {
		Proveedor proveedor = buscarProveedor(cuit);
		if (proveedor != null)
			return proveedor.getView();
		return null;
	}

	// ****************************************************** VENTA
	// ******************************************************
	// Ventas

	public void agregarItem(String codigoVenta, String codigo, int cantidad) {
		Producto pagar = this.buscarProducto(codigo);
		if (pagar != null) {
			Venta newVenta = this.buscarVenta(codigoVenta);
			if (newVenta != null) {
				newVenta.agregarItem(pagar, cantidad);
			}
		}

	}

	public void inicioVenta(LocalDate fecha, String numeroCaja, String nombreCajero, String codigoVenta) {
		Venta newVenta = buscarVenta(codigoVenta);
		if (newVenta == null) {
			newVenta = new Venta(fecha, numeroCaja, nombreCajero, codigoVenta, "1");
			ventas.add(newVenta);
		}

	}

	public void cerrarVenta(LocalDate fecha, String numeroCaja, String nombreCajero, String codigoVenta,
			float importeTotalVenta, float importeRecibido, float vuelto) {
		Venta newVenta = buscarVenta(codigoVenta);
		Caja newCaja = buscarCaja(numeroCaja);
		if (newCaja != null) {
			float saldoActual = newCaja.getSaldoFinalEfectivo() + importeTotalVenta;
			newCaja.setSaldoFinalEfectivo(saldoActual);
		}

		for (int i = 0; i < newVenta.getItems().size(); i++) {

			String codigo = newVenta.getItems().get(i).getProducto().getCodigo();
			int cantidad = newVenta.getItems().get(i).getCantidad();
			Producto newProducto = buscarProducto(codigo);
			if (newProducto != null) {
				int nuevoStock = newProducto.getStock() - cantidad;
				newProducto.setStock(nuevoStock);
				newProducto.setEstado("1");
			}
		}

		if (newVenta != null) {
			newVenta.setFecha(fecha);
			newVenta.setNumeroCaja(numeroCaja);
			newVenta.setNombreCajero(nombreCajero);
			newVenta.setCodigoVenta(codigoVenta);
			newVenta.setImporteTotalVenta(importeTotalVenta);
			newVenta.setImporteRecibido(importeRecibido);
			newVenta.setVuelto(vuelto);
			newVenta.setEstado("0");
		}

	}

	public Venta buscarVenta(String codigoVenta) {
		for (int i = 0; i < ventas.size(); i++) {
			Venta aux = ventas.get(i);
			if (aux.sosLaVenta(codigoVenta)) {
				return aux;
			}
		}
		return null;
	}

	public VentaView buscarVentaView(String codigoVenta) {
		Venta venta = buscarVenta(codigoVenta);
		if (venta != null)
			return venta.getView();
		return null;
	}

	// Reporte Ventas Filtro
	public Vector<Vector<String>> consultarVentaFiltroVenta(LocalDate fecha, String numeroCaja, String nombreCajero) {
		Vector<Vector<String>> aux = new Vector<Vector<String>>();
		for (int i = 0; i < ventas.size(); i++) {
			if (fecha == null && numeroCaja == null && nombreCajero == null) {
				System.out.println("1 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				aux.add(ventas.get(i).getVectorVenta());
			}

			if (fecha == null && numeroCaja != null && nombreCajero == null) {
				System.out.println("2 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (ventas.get(i).getNumeroCaja().equals(numeroCaja)) {
					aux.add(ventas.get(i).getVectorVenta());
				}
			}

			if (fecha == null && numeroCaja == null && nombreCajero != null) {
				System.out.println("3 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (ventas.get(i).getNombreCajero().equals(nombreCajero)) {
					aux.add(ventas.get(i).getVectorVenta());
				}
			}

			if (fecha == null && numeroCaja != null && nombreCajero != null) {
				System.out.println("4 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (ventas.get(i).getNumeroCaja().equals(numeroCaja)
						&& ventas.get(i).getNombreCajero().equals(nombreCajero)) {
					aux.add(ventas.get(i).getVectorVenta());
				}
			}

			if (fecha != null && numeroCaja == null && nombreCajero == null) {
				System.out.println("5 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (ventas.get(i).getFecha().equals(fecha)) {
					aux.add(ventas.get(i).getVectorVenta());
				}
			}

			if (fecha != null && numeroCaja == null && nombreCajero != null) {
				System.out.println("6 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (ventas.get(i).getFecha().equals(fecha) && ventas.get(i).getNombreCajero().equals(nombreCajero)) {
					aux.add(ventas.get(i).getVectorVenta());
				}
			}

			if (fecha != null && numeroCaja != null && nombreCajero == null) {
				System.out.println("7 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (ventas.get(i).getNumeroCaja().equals(numeroCaja) && ventas.get(i).getFecha().equals(fecha)) {
					aux.add(ventas.get(i).getVectorVenta());
				}
			}

			if (fecha != null && numeroCaja != null && nombreCajero != null) {
				System.out.println("8 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (ventas.get(i).getNumeroCaja().equals(numeroCaja) && ventas.get(i).getFecha().equals(fecha)
						&& ventas.get(i).getNombreCajero().equals(nombreCajero)) {
					aux.add(ventas.get(i).getVectorVenta());
				}
			}

		}

		return aux;

	}

	// ****************************************************** STOCK
	// ******************************************************
	// Reporte Stock minimo

	public Vector<Vector<String>> consultarStockMinimo() {
		Vector<Vector<String>> aux = new Vector<Vector<String>>();
		for (int i = 0; i < productos.size(); i++) {
			aux.add(productos.get(i).getVectorStock());
		}
		return aux;

	}

	// Actualizar Stock

	public void actualizarStock(String codigo, int stock) {
		Producto newStock = buscarProducto(codigo);
		if (newStock != null) {
			newStock.setStock(stock);
		}

	}

	// ****************************************************** CAJA
	// ******************************************************
	// Abro Caja
	public void abrirCaja(LocalDate fecha, String numeroCaja, String nombreCajero, float saldoInicialEfectivo) {
		Caja newCaja = buscarCaja(numeroCaja);
		if (newCaja == null) {
			float saldoFinalEfectivo = saldoInicialEfectivo;
			newCaja = new Caja(fecha, numeroCaja, nombreCajero, saldoInicialEfectivo, saldoFinalEfectivo, "1");

			cajas.add(newCaja);

		}
	}

	// Cierro Caja

	public void cerrarCaja(LocalDate fecha, String numeroCaja, String codigoVenta) {
		Caja ExisteCaja = buscarCaja(numeroCaja);
		if (ExisteCaja != null) {
			ExisteCaja.setFecha(fecha);
			ExisteCaja.setNumeroCaja(numeroCaja);
			ExisteCaja.setEstado("0");
		}
	}

	public void actualizoCaja(LocalDate fecha, String numeroCaja, String codigoVenta, float saldoFinalEfectivo) {
		Venta ExisteVenta = buscarVenta(codigoVenta);
		if (ExisteVenta != null) {
			Caja ExisteCaja = buscarCaja(numeroCaja);
			if (ExisteCaja != null) {
				ExisteCaja.setSaldoFinalEfectivo(saldoFinalEfectivo);
			}
		}
	}

	public Vector<Vector<String>> consultarVentaCaja(LocalDate fecha, String numeroCaja) {
		Vector<Vector<String>> aux = new Vector<Vector<String>>();
		for (int i = 0; i < ventas.size(); i++) {
			if (ventas.get(i).getFecha().equals(fecha) && ventas.get(i).getNumeroCaja().equals(numeroCaja)) {

				aux.add(ventas.get(i).getVector());
			}
		}
		return aux;

	}

	// Buscar Caja

	public Caja buscarCaja(String numeroCaja) {
		for (int i = 0; i < cajas.size(); i++) {
			Caja aux = cajas.get(i);
			if (aux.sosLaCaja(numeroCaja))
				return aux;

		}

		return null;
	}

	public CajaView buscarCajaView(String numeroCaja) {
		Caja caja = buscarCaja(numeroCaja);
		if (caja != null)
			return caja.getView();
		return null;
	}

	// Reporte Cajas Filtro

	public Vector<Vector<String>> consultarVentaFiltroCaja(LocalDate fecha, String numeroCaja, String nombreCajero) {
		Vector<Vector<String>> aux = new Vector<Vector<String>>();
		for (int i = 0; i < cajas.size(); i++) {

			float saldoInicial = cajas.get(i).getSaldoFinalEfectivo();
			float saldoFinal = cajas.get(i).getSaldoInicialEfectivo();

			if (fecha == null && numeroCaja != null && nombreCajero == null) {
				System.out.println("1 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (cajas.get(i).getNumeroCaja().equals(numeroCaja)) {
					aux.add(ventas.get(i).getVector());
				}
			}
			if (fecha == null && numeroCaja == null && nombreCajero != null) {
				System.out.println("2 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (cajas.get(i).getNombreCajero().equals(nombreCajero)) {
					aux.add(ventas.get(i).getVector());
				}
			}

			if (fecha != null && numeroCaja == null && nombreCajero == null) {
				System.out.println("3 " + " " + fecha + " " + numeroCaja + " " + nombreCajero);
				if (cajas.get(i).getFecha().equals(fecha)) {
					aux.add(ventas.get(i).getVector());
				}
			}
		}
		return aux;

	}

}
