package subsistemaUsuario;

import dto.*;
import entidades.*;
import java.util.List;
import persistencia.*;

/**
 * La clase ControlUsuario se encarga de validar los datos de un usuario,
 * incluyendo el nombre, el correo electrónico y la contraseña.
 */
public class ControlUsuario {

    /**
     * Valida el nombre proporcionado.
     *
     * @param nombre El nombre a validar.
     * @throws IllegalArgumentException Si el nombre es nulo, vacío, supera los
     * 50 caracteres, contiene caracteres no permitidos, o incluye números.
     */
    public void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre no puede tener más de 50 caracteres.");
        }
        if (!nombre.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios.");
        }
        if (nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números.");
        }
    }

    /**
     * Valida el correo electrónico proporcionado.
     *
     * @param correo El correo electrónico a validar.
     * @throws IllegalArgumentException Si el correo es nulo, vacío, supera los
     * 50 caracteres, o no pertenece a los dominios permitidos.
     */
    public void validarCorreo(String correo) {
        if (correo == null || correo.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede estar vacío.");
        }
        if (correo.length() > 50) {
            throw new IllegalArgumentException("El correo no puede tener más de 50 caracteres.");
        }
        if (!correo.matches("^[\\w.%+-]+@(gmail\\.com|yahoo\\.com|potros\\.itson\\.edu\\.mx)$")) {
            throw new IllegalArgumentException("El correo debe ser de los dominios @gmail.com, @yahoo.com o @potros.itson.edu.mx.");
        }
    }

    /**
     * Valida la contraseña proporcionada.
     *
     * @param contrasenia La contraseña a validar.
     * @throws IllegalArgumentException Si la contraseña es nula, vacía, tiene
     * menos de 5 caracteres o más de 50 caracteres.
     */
    public void validarContrasenia(String contrasenia) {
        if (contrasenia == null || contrasenia.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
        if (contrasenia.length() < 5) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 5 caracteres.");
        }
        if (contrasenia.length() > 50) {
            throw new IllegalArgumentException("La contraseña no puede tener más de 50 caracteres.");
        }
    }

    /**
     * Valida un objeto Usuario completo.
     *
     * @param usuario El usuario a validar.
     * @throws IllegalArgumentException Si algún atributo del usuario es
     * inválido.
     */
    public void validarUsuario(UsuarioDTO usuario) {
        // Aquí puedes implementar la validación de otros atributos del usuario si es necesario
        validarNombre(usuario.getNombre());
        validarCorreo(usuario.getCorreo());
        validarContrasenia(usuario.getContrasenia());
    }

    /**
     * Metodo que inicia sesion
     *
     * @param id ID del usuario que inicia sesion
     * @param contrasenia Contrasenia del usuario que inicia sesion
     * @return True si el usuario se valida correctamente, falso en caso
     * contrario
     */
    public boolean iniciarSesion(int id, String contrasenia) {
        //BaseDatosMock bd = new BaseDatosMock();
        IPersistencia datos = new FachadaPersistencia();

        validarContrasenia(contrasenia);

        Usuario usuario = datos.obtenerUsuario(id);
        String contraseniaUsuario = usuario.getContrasenia();

        return prueba(contraseniaUsuario, contrasenia);

    }

    public boolean prueba(String contraseniaDAO, String contraseniaEnviada) {
        if (contraseniaDAO.equals(contraseniaEnviada)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que obtiene un usuario
     *
     * @param id Id del usuario a obtener
     * @return Objeto usuario obtenido
     */
    public Usuario getUsuario(int id) {
        IPersistencia datos = new FachadaPersistencia();

        return datos.obtenerUsuario(id);

    }

    /**
     * Metodo que obtiene el nombre del rol del usuario
     *
     * @param id Id del usuario a obtener su rol
     * @return Nombre del rol del usuario
     */
    public String getRolUsuario(int id) {
        IPersistencia datos = new FachadaPersistencia();

        return datos.obtenerRolUsuario(id);
    }

    /**
     * Metodo que agrega un usuario a la base de datos
     *
     * @param usuario Objeto usuario a agregar
     */
    public void agregarUsuario(Usuario usuario) {
        IPersistencia datos = new FachadaPersistencia();

        datos.agregarUsuario(usuario);
    }

    /**
     * Metdo que elimina un usuario de la base de datos
     *
     * @param usuario Objeto usuario a eliminar
     */
    public void eliminarUsuario(Usuario usuario) {
        IPersistencia datos = new FachadaPersistencia();

        datos.eliminarUsuario(usuario);
    }

    /**
     * Metodo que modifica el usuario de la base de datos
     *
     * @param usuario Objeto usuario que se va a modificar
     * @param usuarioModificado Objeto usuario con la informacion nueva a
     * agregar
     */
    public void modificarUsuario(Usuario usuario, Usuario usuarioModificado) {
        IPersistencia datos = new FachadaPersistencia();

        datos.modificarUsuario(usuario, usuarioModificado);
    }

    /**
     * Metodo que obtiene todos los usuarios de la base de datos
     *
     * @return Lista de todos los usuarios de la base de datos
     */
    public List<Usuario> obtenerListaUsuarios() {
        IPersistencia datos = new FachadaPersistencia();

        return datos.obtenerTodosUsuarios();
    }

}
