/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubsistemaAlumno;
import dto.AlumnoDTO;
import persistencia.IPersistencia;
/**
 *
 * @author joel_
 */
public class FachadaAlumno implements IAlumno{
    private IPersistencia persistenciaDAO;

    public FachadaAlumno(IPersistencia persistenciaDAO) {
        this.persistenciaDAO=persistenciaDAO;
    }
    
    @Override
    public void EscanearQR(){}      
    @Override
    public void BuscarAlumno(){}
    
}
