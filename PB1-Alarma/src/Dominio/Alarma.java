package Dominio;


public class Alarma {
	
	private String nombre;
	private Sensor[] sensores;
	private String codigoConfig;
	private String codigoAct;
	private Boolean estado;
	
	public Alarma(String nombre, int tamano, String codigo){
		this.nombre=nombre;
		this.sensores= new Sensor[tamano];
		this.codigoConfig = codigo;
		this.codigoAct = "ACTIVAR";
		this.estado=false;
		}
	
	public boolean registrarSensores(int idSensor, String nombreSensor, Zona zonaElegida) {
		Sensor sensor = new Sensor (idSensor, zonaElegida, nombreSensor);
		for (int i = 0; i < sensores.length; i++) {
			if ( sensores[i]== null ) {
					sensores[i]= sensor;
				return true;
			}
		}
		return false;
	}
	
	public void activarDesactivar(){
		this.estado = !this.estado;
	}
	
	public static Boolean validarCodigoConfiguracion(String codigo) {
		if( codigo.length()  >=4  && (codigo.toUpperCase().charAt(0) =='C')  ){
			return true;
		}
		return false;
	}

	public boolean validarCodigoConfiguracionIngresoTeclado(String codigo) {
		if (codigo.equals(codigoConfig)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarCodigoActivacionIngresoTeclado(String codigo) {
		if (codigo.equals(this.codigoAct)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean habilitarSensorPorId(int id) {
		for (int i = 0; i < sensores.length; i++) {
			if (sensores[i]!=null &&  sensores [i].getId() == id) {
				sensores[i].setEstado();	
				return true;
			}
		} return false;
	}

	
	public void habilitarSensoresZona(Zona zonaHabilitar) {
		for (int i = 0; i < sensores.length; i++) {
			if (sensores[i] !=null && sensores[i].getZona().equals(zonaHabilitar)) {
				sensores[i].setEstadoHabilitado();
			}
		}
		
	}

	
	public Sensor obtenerSensorPorID (int id) {
		Sensor sensorADevolver= null;
		for (int i = 0; i < sensores.length; i++) {
			if ( sensores[i] != null && sensores[i].getId()==id)  {
				sensorADevolver = sensores[i];
			}
		} return sensorADevolver;
	}
	
	public Sensor obtenerSensorPorNombre(String nombreSensor) {
		Sensor sensorADevolver= null;
		for (int i = 0; i < sensores.length; i++) {
			if ( sensores[i] != null &&  sensores[i].getNombre().equalsIgnoreCase(nombreSensor) ) {
				sensorADevolver = sensores[i];
				break;
			}
		
		} return sensorADevolver;
	}

	public Sensor[] obtenerSensoresDeshabilitadosZona(Zona zona) {
		Sensor sensoresDeshabilitados[] = new Sensor [sensores.length];
		
		for (int i = 0; i < sensores.length; i++) {
			for (int j = 0; j < sensoresDeshabilitados.length; j++) {

				if (sensores[i] != null && sensores[i].getZona().equals(zona) && sensoresDeshabilitados[j]==null ) {
					sensoresDeshabilitados[j] = sensores[i];
				}
			}
		} return sensoresDeshabilitados;
		
	}

	
	public Sensor[] getSensores() {
		return sensores;
	}

	public void setSensores(Sensor[] sensores) {
		this.sensores = sensores;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	} 

	public boolean verificarSensoresActivados() {
		boolean returno = true;
		for (int i = 0; i < sensores.length; i++) {
			if ( sensores[i] != null && sensores[i].getEstado() ==false ) {
				returno = false;
			} 
		} return returno;
	}

	@Override
	public String toString() {
		return "Alarma nombre " + nombre + ", codigo config " + codigoConfig
				+ ", codigo act " + codigoAct + ", estado " + estado ;
	}
	
	
}
