package subsistemaUsuario;

import SubsistemaAlumno.ControlAlumno;
import dto.AlumnoDTO;
import dto.UsuarioDTO;
import entidades.Maestro;
import entidades.Usuario;
import mock.BaseDatosMock;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

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

    public String obtenerTipoDeUsuario(UsuarioDTO usuario) {
        
    BaseDatosMock bd = new BaseDatosMock(); // Instanciamos la base de datos mock

    // Verificar si el usuario es un Alumno usando ControlAlumno
    ControlAlumno controlAlumno = new ControlAlumno();
    AlumnoDTO alumnoDTO = controlAlumno.obtenerTipoUsuario(usuario);

    if (alumnoDTO != null) {
        return "Alumno"; // Si se encuentra al alumno, retorna "Alumno"
    }

    // Verificar si el usuario es un Maestro
    for (Maestro maestro : bd.getMaestros()) {
        if (usuario.getMatricula() == maestro.getMatricula()) { // Verifica que el id coincida con el maestro
            return "Maestro"; // Si es un maestro, retorna "Maestro"
        }
    }

    return "Desconocido"; // Si no se encuentra el usuario en ninguna de las listas, retorna "Desconocido"
}

    // Se agrego con el paquete de pruebas de base de datos mock
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
    
    public Usuario getUsuario(int id){
        IPersistencia datos = new FachadaPersistencia();
        
        return datos.obtenerUsuario(id);
        
       
    }

}
