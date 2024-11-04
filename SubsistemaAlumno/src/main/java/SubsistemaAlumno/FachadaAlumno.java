/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubsistemaAlumno;
import dto.AlumnoDTO;
/**
 *
 * @author joel_
 */
public class FachadaAlumno implements IAlumno{
    private AlumnoDTO alumnoDTO;

    public FachadaAlumno() {
    }

    public FachadaAlumno(AlumnoDTO alumnoDTO) {
        this.alumnoDTO = alumnoDTO;
    }
    
    @Override
    public void EscanearQR(){}
    @Override
    public void RegistrarAlumno(){}
    @Override
    public void EditarAlumno(){}
    @Override
    public void EliminarAlumno(){}    
    @Override
    public void BuscarAlumno(){}
    
}
