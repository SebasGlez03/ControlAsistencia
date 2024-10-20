/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlAlumno;

import dtos.AlumnoDTO;

/**
 *
 * @author PC
 */
public class ControlAlumno {
    
    private AlumnoDTO alumno;
    
    /**
     * Valida si el semestre de un alumno es válido. El semestre debe ser un número positivo.
     * @param semestre El semestre a validar
     * @return true si el semestre es válido, false en caso contrario
     */
    public static boolean validarSemestre(int semestre) {
        return semestre > 0;
    }

    /**
     * Valida si el promedio de un alumno es válido. El promedio debe estar en el rango de 0.0 a 10.0.
     * @param promedio El promedio a validar
     * @return true si el promedio es válido, false en caso contrario
     */
    public static boolean validarPromedio(float promedio) {
        return promedio >= 0.0 && promedio <= 10.0;
    }

    /**
     * Valida un objeto AlumnoDTO verificando tanto el semestre como el promedio.
     * @param alumno El objeto AlumnoDTO a validar
     * @return true si todos los atributos son válidos, false si alguno no lo es
     */
    public static boolean validarAlumno(AlumnoDTO alumno) {
        return validarSemestre(alumno.getSemestre()) && validarPromedio(alumno.getPromedio());
    }
    
}
