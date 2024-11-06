/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaUsuario;

import dto.AlumnoDTO;
import dto.MaestroDTO;
import dto.UsuarioDTO;
import entidades.Alumno;
import entidades.Maestro;
import mock.BaseDatosMock;

/**
 *
 * @author PC
 */
public class FachadaUsuario implements IUsuario {

    BaseDatosMock bd = new BaseDatosMock();
    ControlUsuario controlUsuario = new ControlUsuario();

    //private IPersistencia persistenciaDAO;
    /**
     * Constructor de la clase que implementa la conexion con la clase de
     * persistencia de datos.
     *
     * @param persistenciaDAO conexion con los datos de la base de datos
     */
//    public FachadaUsuario(IPersistencia persistenciaDAO) {
//        //this.persistenciaDAO = persistenciaDAO;
//    }
    public FachadaUsuario() {
        // Esto es para la version Mock
    }

    @Override
    public boolean iniciarSesion(int id, String contrasenia) {
        return controlUsuario.iniciarSesion(id, contrasenia);
    }

    @Override
    public void agregarAlumno(AlumnoDTO alumno) {
//        try {
//            this.persistenciaDAO.agregarAlumno(convertirAlumnoDTOaEntidad(alumno));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el alumno: " + e, "Error al agregar aumno", JOptionPane.ERROR_MESSAGE);
//        }

        bd.agregarAlumno(convertirAlumnoDTOaEntidad(alumno));

    }

    @Override
    public void agregarMaestro(MaestroDTO maestro) {
        bd.agregarMaestro(convertirMaestroDTOaEntidad(maestro));
    }

    @Override
    public void eliminarAlumno(AlumnoDTO alumno) {
        bd.eliminarAlumno(convertirAlumnoDTOaEntidad(alumno));
    }

    @Override
    public void eliminarMaestro(MaestroDTO maestro) {
        bd.eliminarMaestro(convertirMaestroDTOaEntidad(maestro));
    }

    @Override
    public void modificarAlumno(AlumnoDTO alumno, AlumnoDTO alumnoModificado) {
        bd.modificarAlumno(convertirAlumnoDTOaEntidad(alumno),
                convertirAlumnoDTOaEntidad(alumnoModificado));
    }

    @Override
    public void modificarMaestro(MaestroDTO maestro, MaestroDTO maestroModificado) {
        bd.modificarMaestro(convertirMaestroDTOaEntidad(maestro),
                convertirMaestroDTOaEntidad(maestroModificado));
    }

    @Override
    public void agregarClaseAlumno() {

    }

    // Se le agrego que reciba un maestro al cual le va a agregar su clase y un
    // string con el nombre de la materia a agregar
    @Override
    public void agregarClaseMaestro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Metodo que convierte un AlumnoDTO a un AlumnoEntidad
     *
     * @param dto AlumnoDTO que se transformara a AlumnoEntidad
     * @return Alumno de tipo Entidad
     */
    public Alumno convertirAlumnoDTOaEntidad(AlumnoDTO dto) {

        Alumno alumno = new Alumno();

        alumno.setId(dto.getId());
        alumno.setNombre(dto.getNombre());
        alumno.setApellidoPaterno(dto.getApellidoPaterno());
        alumno.setApellidoMaterno(dto.getApellidoMaterno());
        alumno.setCorreo(dto.getCorreo());
        alumno.setContrasenia(dto.getContrasenia());
        alumno.setSemestre(dto.getSemestre());
        alumno.setPromedio(dto.getPromedio());

        return alumno;
    }

    /**
     * Metodo que convierte un MaestroDTO a un MaestroEntidad
     *
     * @param dto MaestroDTO que se transfotrma a MaestroEntidad
     * @return Maestro de tipo Entidad
     */
    public Maestro convertirMaestroDTOaEntidad(MaestroDTO dto) {

        Maestro maestro = new Maestro();

        maestro.setId(dto.getId());
        maestro.setNombre(dto.getNombre());
        maestro.setApellidoPaterno(dto.getApellidoPaterno());
        maestro.setApellidoMaterno(dto.getApellidoMaterno());
        maestro.setCorreo(dto.getCorreo());
        maestro.setContrasenia(dto.getContrasenia());
        maestro.setMaterias(dto.getMaterias());

        return maestro;

    }

}
