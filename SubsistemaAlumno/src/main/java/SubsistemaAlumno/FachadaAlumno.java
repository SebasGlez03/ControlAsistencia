/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SubsistemaAlumno;

import dto.AlumnoDTO;
import dto.UsuarioDTO;
import entidades.Usuario;
import persistencia.IPersistencia;

/**
 *
 * @author joel_
 */
public class FachadaAlumno implements IAlumno {

    private IPersistencia persistenciaDAO;

    private ControlAlumno controlAlumno = new ControlAlumno();

    public FachadaAlumno(IPersistencia persistenciaDAO) {
        this.persistenciaDAO = persistenciaDAO;
    }

    @Override
    public void EscanearQR() {
    }

    @Override
    public void BuscarAlumno() {
    }

    @Override
    public AlumnoDTO obtenerTipoUsuarioAlumno(UsuarioDTO usuario) {
        return controlAlumno.obtenerTipoUsuario(usuario);
    }

}
