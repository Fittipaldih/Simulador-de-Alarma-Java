package Dominio;


public class Sensor {
	
	private Boolean estado;
	private int id;
	private String nombre;
	private Zona zona ;
	
	public Sensor(int id, Zona zona, String nombre) {
		this.estado = true;
		this.id = id;
		this.nombre = nombre;
		this.zona = zona;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado() {
		this.estado =! estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public void setEstadoHabilitado() {
		this.estado = true;
	}

	@Override
	public String toString() {
		String imprimirEstado ;
		if ( estado == false) {
			imprimirEstado = "esta deshabilitado";
		}
		else {
			imprimirEstado  = "esta activado";
		}
		return "El sensor  " + imprimirEstado + ", su id es " + id + ", el nombre " + nombre + ", y la zona " + zona;
	}
	
	
	
}
