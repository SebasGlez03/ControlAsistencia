/*
 * La clase AlumnoDTO extiende de la clase UsuarioDTO, lo que significa que hereda todos los atributos
 * y métodos de la clase base. Además, esta clase añade dos atributos específicos: semestre y promedio,
 * que representan el semestre actual del alumno y su promedio académico respectivamente.
 */
package dtos;

/**
 * Clase AlumnoDTO que representa a un alumno y extiende de la clase UsuarioDTO
 */
public class AlumnoDTO extends UsuarioDTO{
    
    // Atributo que almacena el semestre actual del alumno
    private int semestre;
    
    // Atributo que almacena el promedio académico del alumno
    private float promedio;

    // Constructor por defecto
    public AlumnoDTO() {
    }

    /**
     * Constructor con parámetros que permite inicializar los atributos semestre y promedio
     * @param semestre El semestre actual del alumno
     * @param promedio El promedio académico del alumno
     */
    public AlumnoDTO(int semestre, float promedio) {
        this.semestre = semestre;
        this.promedio = promedio;
    }
    
    /**
     * Obtiene el semestre actual del alumno
     * @return semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre del alumno
     * @param semestre El semestre a establecer
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene el promedio académico del alumno
     * @return promedio
     */
    public float getPromedio() {
        return promedio;
    }

    /**
     * Establece el promedio académico del alumno
     * @param promedio El promedio a establecer
     */
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" + "semestre=" + semestre + ", promedio=" + promedio + '}';
    }
     
}
