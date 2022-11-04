package Interfaz;

import java.util.Scanner;

import Dominio.*;

public class MainAlarma {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		Alarma alarma =	crearAlarma();
		
		menuInicial(alarma);
	}
	
	private static Alarma crearAlarma(){
		
		
		System.out.println("Ingrese nombre de la alarma");
		String nombre = teclado.next();
				
		System.out.println("Ingrese cantidad sensores max que tendra");
		Integer cantidadSensores = teclado.nextInt();
		
		String codigoConfig;
		do { 
		System.out.println("Ingrese codigo de configuracion valido (Debe empezar con C y tener 4 digitos min)");
		
		codigoConfig = teclado.next();
		
		 Alarma.validarCodigoConfiguracion(codigoConfig);
		
		} while (!Alarma.validarCodigoConfiguracion(codigoConfig));
		
		Alarma alarma = new Alarma (nombre, cantidadSensores, codigoConfig);
		System.out.println("Alarma creada con exito");
		return alarma;
	}

	private static void menuInicial(Alarma alarma) {
		String codigoIngresado;
		
		do {
			System.out.println("Ingrese codigo de la alarma Activacion o Configuracion:");
			codigoIngresado  = teclado.next();
			 if ( alarma.validarCodigoConfiguracionIngresoTeclado(codigoIngresado) ) {
				menuConfiguracion(alarma);
			} if (alarma.validarCodigoActivacionIngresoTeclado(codigoIngresado) ) {
				menuActivacion(alarma);
			} else {
				System.out.println("El codigo ingresado es invalido, intente nuevamente");
			}
		}while(alarma.validarCodigoConfiguracionIngresoTeclado(codigoIngresado) || alarma.validarCodigoActivacionIngresoTeclado(codigoIngresado));
		
	}

	private static void menuActivacion(Alarma alarma) {
		
		
		if (alarma.getEstado()) {
			alarma.setEstado(false);
			System.out.println("ALARMA DESACTIVADA");
		}
		
		else if (alarma.getEstado()==false && alarma.verificarSensoresActivados()) {
			alarma.setEstado(true);
			System.out.println("ALARMA ACTIVADA");
		} 
		
		else if (alarma.getEstado()==false && alarma.verificarSensoresActivados() == false) {
			
			System.out.println("NO SE PUEDE ACTIVAR, VERIFIQUE LOS SENSORES");
		} 
		
		menuInicial(alarma);
	}

	private static void menuConfiguracion(Alarma alarma) {
	int opcion;
		do {
			System.out.println("1 Registrar sensor\n"
					  + "2 Habilitar o deshabilitar sensor\n"
					  + "3 Habilitar sensores de una zona determinada\n"
					  + "4 Obtener sensor por su nombre\n"
					  + "5 Obtener sensores deshabilitados de una zona\n"
					  + "6 VOLVER MENU PRINCIPAL");
	 opcion = teclado.nextInt();
	
	switch (opcion) {
	case 1 : 
		menuRegistrarSensor(alarma);
		break;
	case 2:
		menuHabilitarDeshSensorPorId(alarma);
		break;
	case 3:
		menuHabilitarSensoresDeUnaZona(alarma);
		break;
	case 4: 
		menuObtenerSensorPorNombre(alarma);
		break;
	case 5:
		menuObtenerSensoresDeshabilitadosZona(alarma);
		break;
	case 6: 
		menuInicial(alarma);
	default:
		System.out.println("Opcion incorrecta");
		break;
	
	}
		} while (opcion!= 6);

	}
	
	private static void menuObtenerSensoresDeshabilitadosZona(Alarma alarma) {
		Zona zona = seleccionarZona();
		Sensor sensores[] = new Sensor[alarma.getSensores().length];
		sensores = alarma.obtenerSensoresDeshabilitadosZona(zona);
		for (int i = 0; i < sensores.length; i++) {
			if ( sensores[i] != null ) {
			System.out.println(sensores[i]);
			} else {
				System.out.println("No hay sensores deshabilitados en esta zona");
			}
		}
	}

	private static void menuObtenerSensorPorNombre(Alarma alarma) {
		System.out.println("Ingrese nombre sensor a buscar");
		String nombreSensor = teclado.next();
		Sensor sensorAImprimir = alarma.obtenerSensorPorNombre(nombreSensor);
		if (sensorAImprimir!= null ) {
		System.out.println(sensorAImprimir);
		}
		else {
			System.out.println("Sensor no encontrado");
		}
	}

	private static void menuHabilitarSensoresDeUnaZona(Alarma alarma) {
		Zona zonaAHabilitar = seleccionarZona();
		
		alarma.habilitarSensoresZona(zonaAHabilitar);
		
	}

	private static void menuRegistrarSensor (Alarma alarma) {
		System.out.println("Ingrese ID unico");
		int idSensor = teclado.nextInt();
		
		System.out.println("Ingrese nombre del sensor");
		String nombreSensor = teclado.next();
		
		Zona zonaElegida= seleccionarZona();
		
		if ( alarma.registrarSensores(idSensor, nombreSensor, zonaElegida)) {
		System.out.println("Sensor creado exitosamente");
		} else {
			System.out.println("No se pudo registrar sensor");
			}
		}
	
	private static Zona seleccionarZona() {

		System.out.println("Seleccione \n 1 entrada \n 2 puerta trasera \n 3 interior");

		int zonaTeclado  = teclado.nextInt();
		Zona zonaElegida = Zona.values() [ zonaTeclado - 1 ];
		
		return zonaElegida;
	}

	private static void menuHabilitarDeshSensorPorId(Alarma alarma) {
		System.out.println("Ingrese ID sensor ");
		int id = teclado.nextInt();
		if ( alarma.habilitarSensorPorId(id)) {
		System.out.println("Modificado correctamente");
			Sensor sensor = alarma.obtenerSensorPorID(id);
			if (sensor != null ) {
				System.out.println( sensor);
			}
			
		}else {
			System.out.println("No se pudo encontrar el sensor");
		}
		
	}
}
