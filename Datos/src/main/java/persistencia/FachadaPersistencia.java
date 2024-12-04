/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dao.*;
import entidades.*;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author sebastian
 */
public class FachadaPersistencia implements IPersistencia {

    /**
     * Metodo que se encarga de obtener un usuario de la base de datos
     *
     * @param matricula Matricula del usuario a obtener
     * @return Objeto de tipo Usuario con el usuario a obtener
     */
    @Override
    public Usuario obtenerUsuario(int matricula) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.obtenerUsuario(matricula);
    }

    @Override
    public String obtenerNombreRol(ObjectId rolId) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.obtenerNombreRol(rolId);
    }

    /**
     * Metodo que obtiene todos los usuarios de la base de datos
     *
     * @return Lista de objetos tipo Usuario obtenidos
     */
    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.obtenerTodosUsuarios();
    }

    @Override
    public List<Document> obtenerTodosUsuariosConRolString() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.obtenerTodosUsuariosConRolString();
    }

    /**
     * Obtiene el nombre del rol de un usuario del sistema.
     *
     * @param matricula La matricula del usuario a obtener su rol.
     * @return String con el nombre del rol del usuario
     */
    @Override
    public String obtenerRolUsuario(int matricula) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.obtenerRolUsuario(matricula);
    }

    /**
     * Metodo que agrega un usuario a la base de datos
     *
     * @param usuario Objeto de tipo usuario que se desea agregar a la base de
     * datos
     */
    @Override
    public void agregarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.agregarUsuario(usuario);
    }

    /**
     * Metodo que elimina un usuario de la base de datos
     *
     * @param usuario Objeto de tipo usuario que se desea eliminar de la base de
     * datos
     */
    @Override
    public void eliminarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.eliminarUsuario(usuario);
    }

    /**
     * Metodo que modifica un usuario de la base de datos
     *
     * @param usuario Objeto de tipo usuario que se desea modificar
     * @param usuarioModificado Objeto de tipo usuario que suplira los datos del
     * anterior
     */
    @Override
    public void modificarUsuario(Usuario usuario, Usuario usuarioModificado) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.modificarUsuario(usuario, usuarioModificado);
    }

    /**
     * Metodo que obtiene un alumno de la base de datos
     *
     * @param matricula Matricula del alumno a obtener
     * @return Objeto de tipo alumno obtenido
     */
    @Override
    public Alumno obtenerAlumno(int matricula) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.obtenerAlumno(matricula);

    }

    /**
     * Metodo que agrega un alumno a la base de datos
     *
     * @param alumno Objeto alumno a agregar a la base de datos
     */
    @Override
    public void agregarAlumno(Alumno alumno) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.agregarAlumno(alumno);
    }

    /**
     * Metodo que modifica un alumno de la base de datos
     *
     * @param alumno Objeto tipo Alumno que se desea modificar de la base de
     * datos
     * @param alumnoModificado Objeto de tipo Alumno que suplira la informacion
     * del anterior
     */
    @Override
    public void modificarAlumno(Alumno alumno, Alumno alumnoModificado) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        alumnoDAO.modificarAlumno(alumno, alumnoModificado);
    }

    /**
     * Metodo que obtiene un maestro de la base de datos
     *
     * @param matricula Matricula del maestro a obtener
     * @return Objeto tipo Maestro obtenido
     */
    @Override
    public Maestro obtenerMaestro(int matricula) {
        MaestroDAO maestroDAO = new MaestroDAO();
        return maestroDAO.obtenerMaestro(matricula);

    }

    /**
     * Metodo que agrega un maestro a la basede de datos
     *
     * @param maestro Objeto de tipo maestro a agregar en la base de datos
     */
    @Override
    public void agregarMaestro(Maestro maestro) {
        // Esta clase recibe una lista que actualmente es mock ya que no es parte de nuestro caso de uso
        MaestroDAO maestroDAO = new MaestroDAO();
        maestroDAO.agregarMaestro(maestro);
    }

    /**
     * Metodo que modifica un maestro de la base de datos
     *
     * @param maestro Objeto de tipo Maestro a modificar de la base de datos
     * @param maestroModificado Objeto de tipo Maestro que suplira la
     * informacion del anterior
     */
    @Override
    public void modificarMaestro(Maestro maestro, Maestro maestroModificado) {
        MaestroDAO maestroDAO = new MaestroDAO();
        maestroDAO.modificarMaestro(maestro, maestroModificado);
    }

    /**
     * Metodo que obtiene el evento de la base de datos
     *
     * @param evento Objeto de tipo Evento a obtener de la base de datos
     * @return Objeto tipo Evento obtenido
     */
    @Override
    public Evento obtenerEvento(Evento evento) {
        EventoDAO eventoDAO = new EventoDAO();
        return eventoDAO.obtenerEvento(evento);
    }

    @Override
    public Evento obtenerEventoPorTitulo(String titulo) {
        EventoDAO eventoDAO = new EventoDAO();
        return eventoDAO.obtenerEventoPorTitulo(titulo);
    }

    @Override
    public List<Evento> obtenerTodosLosEventos() {
        EventoDAO eventoDAO = new EventoDAO();
        return eventoDAO.obtenerTodos();
    }

    /**
     * Metodo que agrega el evento de la base de datos
     *
     * @param evento Objeto de tipo Evento a agregar en la base de datos
     */
    @Override
    public void agregarEvento(Evento evento) {
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.agregarEvento(evento);
    }

    /**
     * Metodo que modifica un evento en la base de datos
     *
     * @param evento Objeto de tipo Evento a modificar en la base de datos
     * @param eventoModificado Objeto de tipo Evento que suplira la informacion
     * del anterior
     */
    @Override
    public void modificarEvento(Evento evento, Evento eventoModificado) {
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.modificarEvento(evento, eventoModificado);
    }

    @Override
    public void eliminarEvento(Evento evento) {
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.eliminarEvento(evento);
    }

    @Override
    public List<Evento> obtenerTodosEventos() {
        EventoDAO eventoDAO = new EventoDAO();
        return eventoDAO.obtenerTodosEventos();
    }

    /**
     * Metodo que obtiene una clase de la base de datos
     *
     * @param clase Objeto de tipo Clase a obtener de la base de datos
     * @return Objeto tipo Clase obtenido
     */
    @Override
    public Clase obtenerClase(Clase clase) {
        ClaseDAO claseDAO = new ClaseDAO();
        return claseDAO.obtenerClase(clase);
    }

    @Override
    public List<Clase> obtenerTodasClases() {
        ClaseDAO claseDAO = new ClaseDAO();
        return claseDAO.obtenerTodasClases();
    }

    /**
     * Metodo que agrega una clase a la base de datos
     *
     * @param clase Objeto de tipo Clase a agregar en la base de datos
     */
    @Override
    public void agregarClase(Clase clase) {
        ClaseDAO claseDAO = new ClaseDAO();
        claseDAO.agregarClase(clase);
    }

    /**
     * Metodo que elimina una clase de la base de datos
     *
     * @param clase Objeto de tipo Clase a eliminar de la base de datos
     */
    @Override
    public void eliminarClase(Clase clase) {
        ClaseDAO claseDAO = new ClaseDAO();
        claseDAO.eliminarClase(clase);
    }

    /**
     * Metodo que modifica una clase de la base de datos
     *
     * @param clase Objeto de tipo Clase a modificar en la base de datos
     * @param claseModificada Objeto de tipo Clase que suplira la informacion
     */
    @Override
    public void modificarClase(Clase clase, Clase claseModificada) {
        ClaseDAO claseDAO = new ClaseDAO();
        claseDAO.modificarClase(clase, claseModificada);
    }

    /**
     * Metodo que obtiene una sesion de la base de datos
     *
     * @param sesion Objeto Sesion a buscar en la base de datos
     * @return Objeto Sesion obtenido
     */
    @Override
    public Sesion obtenerSesion(Sesion sesion) {
        SesionDAO sesionDAO = new SesionDAO();
        return sesionDAO.obtenerSesion(sesion);
    }

    /**
     * Agrega una nueva sesion al sistema.
     *
     * @param sesion El objeto Sesion que desea agregar.
     */
    @Override
    public void agregarSesion(Sesion sesion) {
        SesionDAO sesionDAO = new SesionDAO();
        sesionDAO.agregarSesion(sesion);
    }

    /**
     * Obtiene la lista de los alumnos y su asistencia de una sesion.
     *
     * @param sesion Sesion de la que se desea obtener esta informacion.
     * @return Sesion con la informacion de los alumnos y su asistencia.
     */
    @Override
    public List<Document> obtenerAlumnosSesion(Sesion sesion) {
        SesionDAO sesionDAO = new SesionDAO();
        return sesionDAO.obtenerSesionAlumnos(sesion);
    }

    /**
     * Metodo que obtiene un qr de la base de datos
     *
     * @param qr QR a obtener de la base de datos
     * @return QR obtenido
     */
    @Override
    public QR obtenerQR(QR qr) {
        QrDAO qrDAO = new QrDAO();
        return qrDAO.obtenerQR(qr);
    }

    /**
     * Metodo que agrega un qr a la base de datos
     *
     * @param qr QR a agregar a la base de datos
     */
    @Override
    public void agregarQR(QR qr) {
        QrDAO qrDAO = new QrDAO();
        qrDAO.agregarQR(qr);
    }

    /**
     * Guarda un QR en la base de datos.
     *
     * @param qr Objeto QR que se desea guardar.
     */
    @Override
    public void guardarQR(QR qr) {
        QrDAO qrDAO = new QrDAO();
        qrDAO.guardarQR(qr);
    }

    /**
     * Crea una nueva sesión vinculada a un QR en la base de datos.
     *
     * @param idSesion ID de la sesión.
     * @param clase Clase asociada a la sesión.
     * @param maestro Maestro asociado a la sesión.
     */
    @Override
    public void crearSesion(ObjectId idSesion, Clase clase, Maestro maestro) {
        QrDAO qrDAO = new QrDAO();
        qrDAO.crearSesion(idSesion, clase, maestro);
    }

    /**
     * Agrega un nuevo aviso a la base de datos.
     *
     * @param aviso
     */
    @Override
    public void agregarAviso(Aviso aviso) {
        AvisoDAO avisoDAO = new AvisoDAO();
        avisoDAO.agregarAviso(aviso);
    }

    /**
     * Obtiene la primer coincidencia de la base de datos.
     *
     * @param aviso
     * @return
     */
    @Override
    public Aviso obtenerAviso(Aviso aviso) {
        AvisoDAO avisoDAO = new AvisoDAO();

        return avisoDAO.obtenerAviso(aviso);
    }

    /**
     * Obtiene la lista de todos los avisos en la base de datos.
     *
     * @return
     */
    @Override
    public List<Aviso> obtenerListaAvisos() {
        AvisoDAO avisoDAO = new AvisoDAO();

        return avisoDAO.obtenerListaAvisos();
    }

    /**
     * Actualiza un aviso de la base de datos.
     *
     * @param aviso
     * @param avisoActualizado
     */
    @Override
    public void actualizarAviso(Aviso aviso, Aviso avisoActualizado) {
        AvisoDAO avisoDAO = new AvisoDAO();
        avisoDAO.actualizarAviso(aviso, avisoActualizado);
    }

    /**
     * Elimina un aviso de la base de datos.
     *
     * @param aviso
     */
    @Override
    public void eliminarAviso(Aviso aviso) {
        AvisoDAO avisoDAO = new AvisoDAO();
        avisoDAO.eliminarAviso(aviso);
    }

    /**
     * Agrega una respuesta al aviso de la base de datos.
     *
     * @param aviso
     * @param respuesta
     */
    @Override
    public void responderAviso(Aviso aviso, Map<ObjectId, String> respuesta) {
        AvisoDAO avisoDAO = new AvisoDAO();
        avisoDAO.responderAviso(aviso, respuesta);
    }

}
