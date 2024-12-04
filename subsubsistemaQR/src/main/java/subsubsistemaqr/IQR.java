/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface IQR {

    /**
     * Devuelve un QR generado a partir de un PIN y una Fecha.
     *
     * @return
     */
    public QR generarQR();

    /**
     * Metodo que obtiene la ID de la sesion creada por el QR
     *
     * @return ID de la sesion creada
     */
    public ObjectId obtenerIdSesion();

    /**
     * Genera un nuevo QR validando que no sea igual al qr anterior.
     *
     * @param qr
     * @return
     */
    public QR actualizarQR(QR qr);

    /**
     * Valida que el pin introducido sea igual al del QR.
     *
     * @param pin
     * @param qr
     * @return true : false
     */
    public boolean escanearQR(int pin, QR qr);

    /**
     * Metodo que obtiene la ubicacion de el QR generado
     *
     * @return direccion de tipo String del QR generado
     */
    public String obtenerPathQR();

    /**
     * Metodo que obtiene el pin de el QR generado
     *
     * @return pin generado del QR
     */
    public int obtenerPIN();

    /**
     * Genera un QR y crea una sesión vinculada.
     *
     * @param clase La clase asociada a la sesión.
     * @param maestro El maestro asociado a la sesión.
     * @return El QR generado.
     */
    public QR generarQR(Clase clase, Maestro maestro);
    
    /**
     * Agrega un alumno a la lista de asistencia basado en el PIN de un QR.
     *
     * @param alumno Alumno que se agregará a la lista de asistencia.
     * @param pin PIN del QR para encontrar la sesión.
     * @return boolean Verdadero si la operación fue exitosa, falso en caso
     * contrario.
     */
    public boolean agregarAlumnoASesion(Alumno alumno, String pin);
    
    /**
     * Busca un QR por PIN y determina el estado de asistencia basado en la
     * fecha de creación.
     *
     * @param pin PIN del QR.
     * @return Estado de asistencia (1: PRESENTE, 2: RETARDO).
     * @throws IllegalArgumentException Si el QR no existe o el tiempo excede el
     * límite.
     */
    public int determinarEstadoAsistencia(String pin) throws IllegalArgumentException;
    
    /**
     * Método para obtener el ID de la sesión a partir del PIN.
     *
     * @param pin El PIN del QR.
     * @return El ObjectId de la sesión correspondiente.
     * @throws IllegalArgumentException Si no se encuentra el QR o el PIN no es
     * válido.
     */
    public ObjectId obtenerIdSesionDesdeQR(String pin);
    
    /**
     * Método que agrega un alumno a la lista de asistencia de una sesión.
     *
     * @param idSesion El ObjectId de la sesión donde se va a agregar al alumno.
     * @param alumno El objeto Alumno que contiene la información del alumno.
     */
    public void agregarAlumnoASesion(ObjectId idSesion, Alumno alumno);
}
