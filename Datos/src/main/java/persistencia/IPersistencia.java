/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.*;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Interfaz IPersistencia que define los métodos para realizar operaciones de
 * persistencia sobre los objetos Usuario.
 *
 * @author sebastian
 */
public interface IPersistencia {

    /**
     * Obtiene un usuario del sistema.
     *
     * @param matricula la matricula del usuario a obtener.
     * @return Objeto de tipo Usuario con la informacion del usuario a obtener
     */
    public Usuario obtenerUsuario(int matricula);

    /**
     * Obtiene el rol del usuario en forma de String para mostrarlo
     *
     * @param rolId El id del rol a obtener su nombre
     * @return Nombre del rol en forma de string obtenido
     */
    public String obtenerNombreRol(ObjectId rolId);

    /**
     * Metodo que obtiene todos los usuarios de la base de datos
     *
     * @return Lista de objetos tipo Usuario obtenidos
     */
    public List<Usuario> obtenerTodosUsuarios();

    /**
     * Metodo que obtiene todos los usuarios con su rol de forma String de la
     * base de datos
     *
     * @return Lista de documentos obtenidos
     */
    public List<Document> obtenerTodosUsuariosConRolString();

    /**
     * Obtiene el nombre del rol de un usuario del sistema.
     *
     * @param matricula La matricula del usuario a obtener su rol.
     * @return String con el nombre del rol del usuario
     */
    public String obtenerRolUsuario(int matricula);

    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario el objeto Usuario que se desea agregar.
     */
    public void agregarUsuario(Usuario usuario);

    /**
     * Elimina un usuario del sistema.
     *
     * @param usuario el objeto Usuario que se desea eliminar.
     */
    public void eliminarUsuario(Usuario usuario);

    /**
     * Modifica los datos de un usuario en el sistema.
     *
     * @param usuario el objeto Usuario que se desea modificar.
     * @param usuarioModificado el objeto Usuario con la informacion a
     * modificar.
     */
    public void modificarUsuario(Usuario usuario, Usuario usuarioModificado);

    /**
     * Obtiene un alumno del sistema.
     *
     * @param matricula Matricula del alumno a obtener.
     * @return Objeto de tipo Alumno con la informacion del Alumno a obtener
     */
    public Alumno obtenerAlumno(int matricula);

    /**
     * Agrega un nuevo alumno al sistema.
     *
     * @param alumno El objeto Alumno que se desea agregar.
     */
    public void agregarAlumno(Alumno alumno);

    /**
     * Modifica los datos de un alumno en el sistema.
     *
     * @param alumno El objeto Alumno que se desea modificar.
     * @param alumnoModificado El objeto Alumno con la informacion a modificar.
     */
    public void modificarAlumno(Alumno alumno, Alumno alumnoModificado);

    /**
     * Obtiene un maestro del sistema.
     *
     * @param matricula Matricula del maestro a obtener.
     * @return Objeto de tipo Maestro con la informacion del Maestro a obtener.
     */
    public Maestro obtenerMaestro(int matricula);

    /**
     * Agrega un nuevo maestro al sistema.
     *
     * @param maestro El objeto Maestro que se desea agregar.
     */
    public void agregarMaestro(Maestro maestro);

    /**
     * Modifica los datos de un maestro en el sistema.
     *
     * @param maestro El objeto Maestro que se desea modificar.
     * @param maestroModificado El objeto Maestro con la informacion a
     * modificar.
     */
    public void modificarMaestro(Maestro maestro, Maestro maestroModificado);

    /**
     * Obtiene un evento específico.
     *
     * @param evento Objeto de tipo Evento a buscar.
     * @return El objeto Evento encontrado o null si no existe.
     */
    Evento obtenerEvento(Evento evento);

    /**
     * Obtiene un evento por su título.
     *
     * @param titulo El título del evento a buscar.
     * @return El objeto Evento encontrado o null si no existe.
     */
    Evento obtenerEventoPorTitulo(String titulo);

    /**
     * Obtiene todos los eventos.
     *
     * @return Una lista con todos los objetos Evento en la base de datos.
     */
    List<Evento> obtenerTodosLosEventos();

    /**
     * Agrega un nuevo evento a la base de datos.
     *
     * @param evento El objeto Evento a agregar.
     */
    void agregarEvento(Evento evento);

    /**
     * Modifica un evento existente en la base de datos.
     *
     * @param evento El evento a modificar.
     * @param eventoModificado El objeto Evento con la información actualizada.
     */
    void modificarEvento(Evento evento, Evento eventoModificado);

    void eliminarEvento(Evento evento);

    public List<Evento> obtenerTodosEventos();

    /**
     * Obtiene una clase del sistema.
     *
     * @param clase El objeto Clase que se desea obtener.
     * @return Objeto del tipo Clase con la informacion de la clase a obtener.
     */
    public Clase obtenerClase(Clase clase);

    /**
     * Metodo que obtiene ua clase de la base de datos mediante su ObjectId
     *
     * @param claseId ObjectID de la clase a obtener de la base de datos
     * @return Objeto tipo Clase obtenido
     */
    public Clase obtenerClasePorID(ObjectId claseId);

    /**
     * Obtiene la lista de todas las clases del sistema
     *
     * @return Lista con objetos tipo Clase de todas las clases
     */
    public List<Clase> obtenerTodasClases();

    /**
     * Agrega una nueva clase al sistema.
     *
     * @param clase El objeto Clase que se desea agregar.
     */
    public void agregarClase(Clase clase);

    /**
     * Elimina una clase del sistema
     *
     * @param clase El objeto Clase que se desea eliminar.
     */
    public void eliminarClase(Clase clase);

    /**
     * Modifica los datos de una clase en el sistema.
     *
     * @param clase El objeto Clase que se desea modificar.
     * @param claseModificada El objeto Clase con la informacion a modificar.
     */
    public void modificarClase(Clase clase, Clase claseModificada);

    /**
     * Obtiene una sesion del sistema.
     *
     * @param sesion El objeto Sesion que se desea obtener.
     * @return Objeto del tipo Sesion con la informacion a obtener.
     */
    public Sesion obtenerSesion(Sesion sesion);

    /**
     * Metodo que obtiene la sesion de la base de datos mediante un ObjectId
     *
     * @param sesion ObjectId de la sesion a buscar en la base de datos
     * @return Objeto Sesion obtenido
     */
    public Sesion obtenerSesion(ObjectId sesion);

    /**
     * Agrega una nueva sesion al sistema.
     *
     * @param sesion El objeto Sesion que desea agregar.
     */
    public void agregarSesion(Sesion sesion);

    /**
     * Obtiene la lista de los alumnos y su asistencia de una sesion.
     *
     * @param sesion Sesion de la que se desea obtener esta informacion.
     * @return Sesion con la informacion de los alumnos y su asistencia.
     */
    public List<Document> obtenerAlumnosSesion(Sesion sesion);

    public List<Alumno> obtenerSesionAlumnosNoDocumento(Sesion sesion); //asdasdadasasddadasasddadasasddadasasddadasasddadasasd

    /**
     * Metodo que obtiene un qr de la base de datos
     *
     * @param qr QR a obtener de la base de datos
     * @return QR obtenido
     */
    public QR obtenerQR(QR qr);

    /**
     * Metodo que agrega un qr a la base de datos
     *
     * @param qr QR a agregar a la base de datos
     */
    public void agregarQR(QR qr);

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
     * Guarda un QR en la base de datos.
     *
     * @param qr Objeto QR que se desea guardar.
     */
    public void guardarQR(QR qr);

    /**
     * Crea una nueva sesión vinculada a un QR en la base de datos.
     *
     * @param idSesion ID de la sesión.
     * @param clase Clase asociada a la sesión.
     * @param maestro Maestro asociado a la sesión.
     */
    public void crearSesion(ObjectId idSesion, Clase clase, Maestro maestro);

    /**
     * Obtiene la lista de materias impartidas por un maestro con sus nombres e
     * IDs.
     *
     * @param matricula Matricula del maestro.
     * @return Lista de objetos Clase que contienen el ID y nombre de las
     * materias.
     */
    public List<Clase> obtenerMateriasConNombresPorMaestro(int matricula);

    /**
     * Agrega un Aviso a la base de datos.
     *
     * @param aviso
     */
    public void agregarAviso(Aviso aviso);

    /**
     * Obtiene el aviso del parametro de la base de datos.
     *
     * @param aviso
     * @return
     */
    public Aviso obtenerAviso(Aviso aviso);

    /**
     * Obtiene la lista de todos los avisos de la base de datos.
     *
     * @return
     */
    public List<Aviso> obtenerListaAvisos();

    /**
     * Actualiza un aviso de la base de datos
     *
     * @param aviso aviso que se quiere actualizar.
     * @param avisoActualizado
     */
    public void actualizarAviso(Aviso aviso, Aviso avisoActualizado);

    /**
     * Elimina un aviso de la base de datos.
     *
     * @param aviso
     */
    public void eliminarAviso(Aviso aviso);

    /**
     * Agrega una respuesta a un aviso.
     *
     * @param aviso
     * @param respuesta
     */
    public void responderAviso(Aviso aviso, Map<ObjectId, String> respuesta);

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
