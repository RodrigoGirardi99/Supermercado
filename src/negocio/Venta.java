package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Venta {

	private LocalDate fecha;
	private String numeroCaja;
	private ArrayList<ItemVenta> items = new ArrayList<ItemVenta>();
	private String nombreCajero;
	private String codigoVenta;
	private float importeTotalVenta;
	private float importeRecibido;
	private float vuelto;
	private String estado;

	public Venta(LocalDate fecha, String numeroCaja, String nombreCajero, String codigoVenta, float importeTotalVenta,
			float importeRecibido, float vuelto, String estado) {
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.codigoVenta = codigoVenta;
		this.importeTotalVenta = importeTotalVenta;
		this.importeRecibido = importeRecibido;
		this.vuelto = vuelto;
		items = new ArrayList<ItemVenta>();
		this.estado = estado;

	}

	public Venta(LocalDate fecha, String numeroCaja, String nombreCajero, String codigoVenta, String estado) {
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.codigoVenta = codigoVenta;
		this.estado = estado;

	}

// Getters

	public LocalDate getFecha() {
		return fecha;
	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public String getNombreCajero() {
		return nombreCajero;
	}

	public float getVuelto() {
		return vuelto;
	}

	public String getCodigoVenta() {
		return codigoVenta;
	}

	public float getImporteTotalVenta() {
		return importeTotalVenta;
	}

	public float getImporteRecibido() {
		return importeRecibido;
	}

	public String getEstado() {
		return estado;
	}
// Setters 

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}

	public void setVuelto(float vuelto) {
		this.vuelto = vuelto;
	}

	public void setCodigoVenta(String codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public void setImporteTotalVenta(float importeTotalVenta) {
		this.importeTotalVenta = importeTotalVenta;
	}

	public void setImporteRecibido(float importeRecibido) {
		this.importeRecibido = importeRecibido;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

// Metodos de negocio

	public boolean sosLaVenta(String ventaBuscada) {
		if (codigoVenta.equalsIgnoreCase(ventaBuscada)) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<ItemVenta> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemVenta> items) {
		this.items = items;
	}

	public void agregarItem(Producto producto, int cantidad) {
		ItemVenta i = new ItemVenta(producto, cantidad);
		this.items.add(i);
	}

	public float CalcularTotal() {
		float total = 0;
		for (int i = 0; i < items.size(); i++) {
			total = total + items.get(i).calcularSubtotal();
		}

		return total;

	}

	public Vector<String> getVector() {

		Vector<String> datos = new Vector<String>();

		datos.add(codigoVenta);
		datos.add(CalcularTotal() + "");
		datos.add(importeRecibido + "");
		datos.add(vuelto + "");

		return datos;
	}

	public Vector<String> getVectorVenta() {

		Vector<String> datos = new Vector<String>();

		datos.add(fecha.toString());
		datos.add(codigoVenta);
		datos.add(numeroCaja);
		datos.add(nombreCajero);
		datos.add(importeTotalVenta + "");
		datos.add(importeRecibido + "");
		datos.add(vuelto + "");

		return datos;
	}

	public VentaView getView() {
		return (new VentaView(fecha, numeroCaja, nombreCajero, codigoVenta, CalcularTotal(), estado));
	}
}
