/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Maestro;
import entidades.Usuario;
import java.util.List;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para el
 * maestro. Hereda de UsuarioDTO y se utiliza para transportar datos del maestro
 * entre diferentes capas de la aplicación.
 *
 * @author PC
 */
public class MaestroDTO extends UsuarioDTO {

    private List<String> materias; // Lista de materias que el maestro imparte

    /**
     * Constructor vacío para la clase MaestroDTO.
     */
    public MaestroDTO() {
    }

    /**
     * Constructor que inicializa el DTO a partir de un objeto Usuario y un
     * objeto Maestro.
     *
     * @param usuario Objeto Usuario del cual se obtienen los datos básicos
     * @param maestro Objeto Maestro del cual se obtienen las materias que
     * imparte
     */
    public MaestroDTO(Usuario usuario, Maestro maestro) {
        super.setMatricula(usuario.getMatricula());
        super.setNombre(usuario.getNombre());
        super.setApellidoPaterno(usuario.getApellidoPaterno());
        super.setApellidoMaterno(usuario.getApellidoMaterno());
        super.setCorreo(usuario.getCorreo());
        super.setContrasenia(usuario.getContrasenia());
        super.setRol(usuario.getRol());
        this.materias = maestro.getMaterias();
    }

    /**
     * Constructor que inicializa el DTO a partir de un objeto Maestro.
     *
     * @param maestro Objeto Maestro del cual se obtienen las materias que
     * imparte
     */
    public MaestroDTO(Maestro maestro) {
        this.materias = maestro.getMaterias();
    }

    /**
     * Constructor que inicializa la lista de materias del maestro.
     *
     * @param materias Lista de materias que el maestro imparte
     */
    public MaestroDTO(List<String> materias) {
        this.materias = materias;
    }

    /**
     * Obtiene la lista de materias que imparte el maestro.
     *
     * @return Lista de materias del maestro
     */
    public List<String> getMaterias() {
        return materias;
    }

    /**
     * Establece la lista de materias que imparte el maestro.
     *
     * @param materias Lista de materias del maestro
     */
    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }
}
