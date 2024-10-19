/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author limon
 */
public class AlumnoDTO extends UsuarioDTO{
    
    private int semestre;
    private float promedio;

    public AlumnoDTO() {
    }

    public AlumnoDTO(int semestre, float promedio) {
        this.semestre = semestre;
        this.promedio = promedio;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
     
}
