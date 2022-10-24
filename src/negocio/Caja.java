package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class Caja {
	private LocalDate fecha;
	private String numeroCaja;
	private String nombreCajero;
	private float saldoInicialEfectivo;
	private float saldoFinalEfectivo;
	private ArrayList<Venta> ventas;
	private String estado;

	public Caja(LocalDate fecha, String numeroCaja, String nombreCajero, float saldoInicialEfectivo,
			float saldoFinalEfectivo, String estado) {
		super();
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.saldoInicialEfectivo = saldoInicialEfectivo;
		this.saldoFinalEfectivo = saldoFinalEfectivo;
		this.ventas = new ArrayList<Venta>();
		this.estado = estado;
	}

// Getters

	public LocalDate getFecha() {
		return fecha;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public float getSaldoFinalEfectivo() {
		return saldoFinalEfectivo;
	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public String getNombreCajero() {
		return nombreCajero;
	}

	public float getSaldoInicialEfectivo() {
		return saldoInicialEfectivo;
	}

	public String getEstado() {
		return estado;
	}

// Setters

	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setSaldoInicialEfectivo(float saldoInicialEfectivo) {
		this.saldoInicialEfectivo = saldoInicialEfectivo;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public void setSaldoFinalEfectivo(float saldoFinalEfectivo) {
		this.saldoFinalEfectivo = saldoFinalEfectivo;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Metodos de negocio

	public boolean sosLaCaja(String numeroCajaN) {
		if (numeroCaja.equalsIgnoreCase(numeroCajaN)) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Venta> getInformeConsultaVenta() {
		return ventas;
	}

	public Vector<String> getVectorTest() {

		Vector<String> datos = new Vector<String>();

		return datos;
	}

	public CajaView getView() {
		return (new CajaView(fecha, numeroCaja, nombreCajero, saldoInicialEfectivo, saldoFinalEfectivo, estado));
	}

	public Vector<Vector<String>> getVector() {

		Vector<Vector<String>> VentasView = new Vector<Vector<String>>();
		for (Venta venta : ventas) {
			VentasView.add(venta.getVector());
		}

		return VentasView;
	}

	public Vector<Vector<String>> getVectorVenta() {

		Vector<Vector<String>> VentasView = new Vector<Vector<String>>();
		for (Venta venta : ventas) {
			VentasView.add(venta.getVectorVenta());
		}

		return VentasView;
	}

}
