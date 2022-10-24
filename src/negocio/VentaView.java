package negocio;

import java.time.LocalDate;

public class VentaView {

	private LocalDate fecha;
	private String numeroCaja;
	private String nombreCajero;
	private String codigoVenta;
	private float importeTotalVenta;
	private String estado;

	public VentaView(LocalDate fecha, String numeroCaja, String nombreCajero, String codigoVenta,
			float importeTotalVenta, String estado) {
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.codigoVenta = codigoVenta;
		this.importeTotalVenta = importeTotalVenta;
		this.estado = estado;

	}

	public VentaView(LocalDate fecha, String numeroCaja, String nombreCajero, String codigoVenta, String estado) {
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.codigoVenta = codigoVenta;
		this.estado = estado;

	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public String getNombreCajero() {
		return nombreCajero;
	}

	public String getCodigoVenta() {
		return codigoVenta;
	}

	public float getImporteTotalVenta() {
		return importeTotalVenta;
	}
	
	public String getEstado() {
		return estado;
	}

}

