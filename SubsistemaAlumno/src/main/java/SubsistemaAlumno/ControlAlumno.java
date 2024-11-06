/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubsistemaAlumno;
import dto.AlumnoDTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author joel_
 */
public class ControlAlumno {
    private AlumnoDTO alumno;

    public ControlAlumno() {
    }

    public ControlAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }
    
    /**
     * Metodo que valida que el alumno esta registrado en un semestre que este
     * dentro de los parametros
     * @param alumnoDTO
     * @return 
     */
    public int validarSemestre(AlumnoDTO alumnoDTO){
        int semestre= alumnoDTO.getSemestre();
        
        if(semestre<=0){
            throw new IllegalArgumentException("Valor invalido");
        }else{
            return semestre;
        }        
    }
    /**
     * metodo que valida que el alumno tiene registrada una calificacion que
     * esta dentro de los parámetros
     * @param alumnoDTO
     * @return 
     */
    public float validadPromedio(AlumnoDTO alumnoDTO){
        float prom = alumnoDTO.getSemestre();
        
        if(prom<0||prom>10){
            throw new IllegalArgumentException("Valor invalido");
        }else{
            return prom;
        }
    }
    /**
     * Metodo que verifica que un alumno es legitimo apartir del ID
     * @param alumnoDTO
     * @return 
     */
    public AlumnoDTO validarAlumno(AlumnoDTO alumnoDTO){
        String id = Integer.toString(alumnoDTO.getId());
        if(!id.matches("^00000[1-9]{6}&")){
            throw new IllegalArgumentException("ID invalida");
        }else{
            return alumnoDTO;
        }
    }
    /**
     * Metodo que busca a un alumno
     * @param alumnoDTO 
     */
    public void BuscarAlumno(AlumnoDTO alumnoDTO){
        String id =Integer.toString(alumnoDTO.getId());
        
        if(!id.matches("^00000[1-9]{6}&")){
            throw new IllegalArgumentException("El Alumno no existe");
        }else{
            System.out.println(alumnoDTO.getNombre()+" "+
                    alumnoDTO.getApellidoPaterno()+" "+alumnoDTO.getApellidoMaterno());
            System.out.println(alumnoDTO.getId());
            System.out.println(alumnoDTO.getSemestre());
        }
    }
}
