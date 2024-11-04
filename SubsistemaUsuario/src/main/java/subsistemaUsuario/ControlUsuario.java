package subsistemaUsuario;

import dto.AlumnoDTO;
import dto.MaestroDTO;
import dto.UsuarioDTO;

/**
 * La clase ControlUsuario se encarga de validar los datos de un usuario,
 * incluyendo el nombre, el correo electrónico y la contraseña.
 */
public class ControlUsuario {

    /**
     * Valida el nombre proporcionado.
     *
     * @param nombre El nombre a validar.
     * @throws IllegalArgumentException Si el nombre es nulo, vacío, 
     *         supera los 50 caracteres, contiene caracteres no permitidos, 
     *         o incluye números.
     */
    public void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre no puede tener más de 50 caracteres.");
        }
        if (!nombre.matches("^[\\p{L} .'-]+$")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y algunos caracteres especiales (espacio, punto, guion, apóstrofe).");
        }
        if (nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números.");
        }
    }

    /**
     * Valida el correo electrónico proporcionado.
     *
     * @param correo El correo electrónico a validar.
     * @throws IllegalArgumentException Si el correo es nulo, vacío, 
     *         supera los 50 caracteres, o no pertenece a los dominios permitidos.
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
     * @throws IllegalArgumentException Si la contraseña es nula, vacía, 
     *         tiene menos de 5 caracteres o más de 50 caracteres.
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
     * @throws IllegalArgumentException Si algún atributo del usuario es inválido.
     */
    public void validarUsuario(UsuarioDTO usuario) {
        // Aquí puedes implementar la validación de otros atributos del usuario si es necesario
        validarNombre(usuario.getNombre());
        validarCorreo(usuario.getCorreo());
        validarContrasenia(usuario.getContrasenia());
    }
    
    
    public void obtenerTipoDeUsuario(UsuarioDTO usuario){
        AlumnoDTO alumno = new AlumnoDTO();
        MaestroDTO maestro = new MaestroDTO();
        
        if (usuario.getId() == alumno.getId()){
            System.out.println("Regresa un alumno");
        } else if (usuario.getId() == maestro.getId()){
            
        } else{
            System.out.println("nuase nada");
        }
        
        /*
        Se necesita realizar un modo en el que se revise toda la lista de alumnos y de maestro para verificar que
        en toda la lista de alumnos/maestros existe algun id que sea igual al que se recibe del usuario.
        */
        
        
    
    }
}
