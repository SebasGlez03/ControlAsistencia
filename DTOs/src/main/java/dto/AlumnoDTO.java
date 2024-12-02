/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Alumno;
import entidades.Usuario;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para el
 * alumno. Hereda de UsuarioDTO y se utiliza para transportar datos del alumno
 * entre diferentes capas de la aplicación.
 *
 * @author PC
 */
public class AlumnoDTO extends UsuarioDTO {

    private int semestre; // Semestre actual del alumno
    private float promedio; // Promedio académico del alumno
    private String estadoAsistencia; // Estado de la asistencia del alumno (Presente, Retraso)

    /**
     * Constructor vacío para la clase AlumnoDTO.
     */
    public AlumnoDTO() {
    }

    /**
     * Constructor que inicializa el DTO a partir de un objeto Usuario y un
     * objeto Alumno.
     *
     * @param usuario Objeto Usuario del cual se obtienen los datos básicos
     * @param alumno Objeto Alumno del cual se obtienen el semestre y promedio
     */
    public AlumnoDTO(Usuario usuario, Alumno alumno) {
        super.setMatricula(usuario.getMatricula());
        super.setNombre(usuario.getNombre());
        super.setApellidoPaterno(usuario.getApellidoPaterno());
        super.setApellidoMaterno(usuario.getApellidoMaterno());
        super.setCorreo(usuario.getCorreo());
        super.setContrasenia(usuario.getContrasenia());
        super.setRol(usuario.getRol());
        this.semestre = alumno.getSemestre();
        this.promedio = alumno.getPromedio();
        this.estadoAsistencia = alumno.getEstadoAsistencia();
    }

    /**
     * Constructor que inicializa el DTO a partir de un objeto Alumno.
     *
     * @param alumno Objeto Alumno del cual se obtienen el semestre y promedio
     */
    public AlumnoDTO(Alumno alumno) {
        this.semestre = alumno.getSemestre();
        this.promedio = alumno.getPromedio();
    }

    /**
     * Constructor que inicializa el semestre y el promedio del alumno.
     *
     * @param semestre Semestre actual del alumno
     * @param promedio Promedio académico del alumno
     */
    public AlumnoDTO(int semestre, float promedio) {
        this.semestre = semestre;
        this.promedio = promedio;
    }

    /**
     * Obtiene el semestre actual del alumno.
     *
     * @return Semestre actual del alumno
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre actual del alumno.
     *
     * @param semestre Semestre actual del alumno
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene el promedio académico del alumno.
     *
     * @return Promedio académico del alumno
     */
    public float getPromedio() {
        return promedio;
    }

    /**
     * Establece el promedio académico del alumno.
     *
     * @param promedio Promedio académico del alumno
     */
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    /**
     * Obtiene el estado de la asistencia del alumno
     *
     * @return Estado de la asistencia obtenido
     */
    public String getEstadoAsistencia() {
        return estadoAsistencia;
    }

    /**
     * Establece el estado de la asistencia del alumno
     *
     * @param estadoAsistencia Estado de la asistencia a establecer
     */
    public void setEstadoAsistencia(String estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

}
