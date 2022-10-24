package negocio;

public class ProveedorView {
	private String cuit;
	private String razonSocial;
	private String domicilio;
	private String telefono;
	private String mail;
	private String estado;

	// Constructor
	public ProveedorView(String cuit, String razonSocial, String domicilio, String telefono, String mail,
			String estado) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.estado = estado;
	}

	public String getCuit() {
		return cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

	public String getEstado() {
		return estado;
	}

}
