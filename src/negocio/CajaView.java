package negocio;

import java.time.LocalDate;

public class CajaView {
	private LocalDate fecha;
	private String numeroCaja;
	private String nombreCajero;
	private float saldoInicialEfectivo;
	private float saldoFinalEfectivo;
	private String estado;

	public CajaView(LocalDate fecha, String numeroCaja, String nombreCajero, float saldoInicialEfectivo,
			float saldoFinalEfectivo, String estado) {
		super();
		this.fecha = fecha;
		this.numeroCaja = numeroCaja;
		this.nombreCajero = nombreCajero;
		this.saldoInicialEfectivo = saldoInicialEfectivo;
		this.saldoFinalEfectivo = saldoFinalEfectivo;
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

	public float getSaldoInicialEfectivo() {
		return saldoInicialEfectivo;
	}

	public float getSaldoFinalEfectivo() {
		return saldoFinalEfectivo;
	}

	public String getEstado() {
		return estado;
	}

}
