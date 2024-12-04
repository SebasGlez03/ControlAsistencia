/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsubsistemaqr;

import entidades.Alumno;
import entidades.Clase;
import entidades.Maestro;
import entidades.QR;
import org.bson.types.ObjectId;

/**
 *
 * @author Ragzard
 */
public class FachadaQR implements IQR {
    
    ControlQR cQR = new ControlQR();

    /**
     * Devuelve un QR generado a partir de un PIN y una Fecha.
     *
     * @return
     */
    @Override
    public QR generarQR() {
        
        return cQR.generarQR();
        
    }

    /**
     * Metodo que obtiene la ID de la sesion creada por el QR
     *
     * @return ID de la sesion creada
     */
    @Override
    public ObjectId obtenerIdSesion() {
        return cQR.getSesionIdGenerada();
    }

    /**
     * Genera un nuevo QR validando que no sea igual al qr anterior.
     *
     * @param qr
     * @return
     */
    @Override
    public QR actualizarQR(QR qr) {
        String pin = generarQR().getContenido();
        
        if (pin.equals(qr.getContenido())) {
            actualizarQR(qr);
        } else {
            qr.setContenido(pin);
        }
        
        return qr;
    }

    /**
     * Valida que el pin introducido sea igual al del QR.
     *
     * @return true : false
     */
    @Override
    public boolean escanearQR(int pin, QR qr) {
        return (String.valueOf(pin).equals(qr.getContenido()));
    }
    
    @Override
    public String obtenerPathQR() {
        return cQR.getTempFilePath();
    }
    
    @Override
    public int obtenerPIN() {
        return cQR.getPin();
    }

    /**
     * Genera un QR y crea una sesión vinculada.
     *
     * @param clase La clase asociada a la sesión.
     * @param maestro El maestro asociado a la sesión.
     * @return El QR generado.
     */
    @Override
    public QR generarQR(Clase clase, Maestro maestro) {
        return cQR.generarQR(clase, maestro);
    }

    /**
     * Agrega un alumno a la lista de asistencia basado en el PIN de un QR.
     *
     * @param alumno Alumno que se agregará a la lista de asistencia.
     * @param pin PIN del QR para encontrar la sesión.
     * @return boolean Verdadero si la operación fue exitosa, falso en caso
     * contrario.
     */
    @Override
    public boolean agregarAlumnoASesion(Alumno alumno, String pin) {
        return cQR.agregarAlumnoASesion(alumno, pin);
    }

    /**
     * Busca un QR por PIN y determina el estado de asistencia basado en la
     * fecha de creación.
     *
     * @param pin PIN del QR.
     * @return Estado de asistencia (1: PRESENTE, 2: RETARDO).
     * @throws IllegalArgumentException Si el QR no existe o el tiempo excede el
     * límite.
     */
    @Override
    public int determinarEstadoAsistencia(String pin) throws IllegalArgumentException {
        return cQR.determinarEstadoAsistencia(pin);
    }

    /**
     * Método para obtener el ID de la sesión a partir del PIN.
     *
     * @param pin El PIN del QR.
     * @return El ObjectId de la sesión correspondiente.
     * @throws IllegalArgumentException Si no se encuentra el QR o el PIN no es
     * válido.
     */
    @Override
    public ObjectId obtenerIdSesionDesdeQR(String pin) {
        return cQR.obtenerIdSesionDesdeQR(pin);
    }

    /**
     * Método que agrega un alumno a la lista de asistencia de una sesión.
     *
     * @param idSesion El ObjectId de la sesión donde se va a agregar al alumno.
     * @param alumno El objeto Alumno que contiene la información del alumno.
     */
    @Override
    public void agregarAlumnoASesion(ObjectId idSesion, Alumno alumno) {
        cQR.agregarAlumnoASesion(idSesion, alumno);
    }
    
}
