# Alarma en Java (Español)
## Simulador de software para una central de alarma.  <br>
Consignas: 
● Para la creación de la alarma se debe ingresar por teclado:
○ Nombre.
○ Cantidad de sensores que se pueden agregar.
○ Código de configuración (alfanumérico), el cual debe respetar el siguiente
formato:
■ Primera letra ‘C’.
■ Longitud mínima 4 dígitos (con la letra ‘C’ incluida).

El menú principal de la misma solicita el ingreso por teclado de un código. 

Se verifica si es un código de configuración o un código de activación/desactivación.

Cuando es un código de configuración, se mostrará un menú de configuración. 
○ Registrar sensor. Para ello se deberá solicitar el ingreso por teclado de:
- ID: identificador único.
- Nombre: texto.
- Zona: ENTRADA, PUERTA_TRASERA, INTERIOR.
- Estado: siempre que se agrega está habilitado.
- Habilitar o deshabilitar sensor. Para ello se deberá ingresar el ID del
sensor.
- Habilitar todos los sensores de una zona determinada.
- Obtener un sensor por su nombre.
- Obtener todos los sensores deshabilitados de una zona determinada.

En caso de que el código sea de activación/desactivación, la alarma
cambiará su estado, si es que cumple con los siguientes requisitos: 

○ Si la alarma está desactivada y todos los sensores están habilitados, la
misma pasará a estar activa. En caso que no se cumplan las validaciones
anteriores, la alarma quedará desactivada.
○ Si la alarma está activada, pasará a estar desactivada.



# Project-Alarm-Java-English
The software for an alarm center.
● To create the alarm, you must enter by keyboard:
○ Name.
○ Number of sensors that can be added.
○ Configuration code (alphanumeric), which must respect the following
Format:
■ First letter 'C'.
■ Minimum length 4 digits (with the letter 'C' included).

Its main menu requests the keyboard entry of a code.

It checks whether it is a setup code or an activation/deactivation code.

When it is a setup code, a setup menu will be displayed.
○ Register sensor. To do this, you must request the keyboard entry of:
- ID: unique identifier.
- Name: text.
- Area: ENTRANCE, REAR_DOOR, INTERIOR.
- State: whenever it is added it is enabled.
- Enable or disable sensor. To do this, you must enter the ID of the
sensor.
- Enable all sensors in a given area.
- Get a sensor by name.
- Get all disabled sensors in a given area.

In case the code is activation/deactivation, the alarm
will change your status, if you meet the following requirements:

○ If the alarm is disabled and all sensors are enabled, the
it will become active. In case the validations are not fulfilled
above, the alarm will be disabled.
○ If the alarm is activated, it will become deactivated.
