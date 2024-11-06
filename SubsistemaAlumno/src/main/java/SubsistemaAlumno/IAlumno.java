/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SubsistemaAlumno;

import dto.AlumnoDTO;
import dto.UsuarioDTO;

/**
 *
 * @author joel_
 */
public interface IAlumno {

    /**
     * escanea un codigoQR en el sistema
     */
    public void EscanearQR();

    /**
     * busca a un Alumno en el sistema
     */
    public void BuscarAlumno();

    /**
     * Metodo que obtiene el tipo del usuario Alumno
     *
     * @param usuario Usuario para verificar cn el alumno
     * @return Tipo de usuario alumno;
     */
    public AlumnoDTO obtenerTipoUsuarioAlumno(UsuarioDTO usuario);
}
