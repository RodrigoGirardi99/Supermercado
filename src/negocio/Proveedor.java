package negocio;

public class Proveedor {
	private String cuit;
	private String razonSocial;
	private String domicilio;
	private String telefono;
	private String mail;
	private String estado;

	// Constructor
	public Proveedor(String cuit, String razonSocial, String domicilio, String telefono, String mail, String estado) {
		super();
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.estado = estado;
	}

// Getters y Setters

	public void setCuit(String cuit) {
		this.cuit = cuit;
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

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

// Metodos de negocio

	public boolean sosElProveedor(String cuitBuscado) {
		if (cuit.equalsIgnoreCase(cuitBuscado)) {
			return true;
		} else {
			return false;
		}
	}

	public ProveedorView getView() {
		return (new ProveedorView(cuit, razonSocial, domicilio, telefono, mail, estado));
	}
}
