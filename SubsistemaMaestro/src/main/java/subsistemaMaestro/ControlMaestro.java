/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaMaestro;

import dto.MaestroDTO;
import entidades.Clase;
import entidades.Maestro;
import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/**
 *
 * @author limon
 */
/**
 * Clase ControlMaestro Esta clase permite realizar operaciones relacionadas con
 * el control de clases impartidas por un maestro, incluyendo la asignacion y
 * remocion de clases, evaluacion de alumnos y busqueda de maestros
 */
public class ControlMaestro {

    private Maestro maestro; // Instancia de Maestro que se va a controlar
    IPersistencia datos = new FachadaPersistencia();

    /**
     * Constructor por omision
     */
    public ControlMaestro() {

    }

    /**
     * Constructor que inicializa ControlMaestro con una instancia de Maestro
     *
     * @param maestro Instancia de Maestro a controlar
     */
    public ControlMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    /**
     * Asigna una clase al maestro Verifica que la materia no sea nula ni vacia
     * y que sea una materia valida
     *
     * @param materia Nombre de la materia a impartir
     * @throws IllegalArgumentException si la materia es nula o vacia o ya esta
     * en la lista de materias del maestro
     */
    public void impartirClase(String materia) {
        if (materia == null || materia.isEmpty()) {
            throw new IllegalArgumentException("La materia no puede ser nula o vacia");
        }
        if (maestro.getMaterias().contains(materia)) {
            throw new IllegalArgumentException("La materia ya esta asignada al maestro");
        }
        maestro.getMaterias().add(materia); // Agrega la materia a la lista
        System.out.println("Clase de " + materia + " impartida");
    }

    /**
     * Metodo que obtiene un maestro del sistema
     *
     * @param matricula Matricula del maestro a obtener
     * @return Objeto MaestroDTO obtenido
     */
    public MaestroDTO obtenerMaestro(int matricula) {
        Maestro maestroObtenido = datos.obtenerMaestro(matricula);
        MaestroDTO maestro = new MaestroDTO();

        maestro.setMatricula(maestroObtenido.getMatricula());
        maestro.setNombre(maestroObtenido.getNombre());
        maestro.setApellidoPaterno(maestroObtenido.getApellidoPaterno());
        maestro.setApellidoMaterno(maestroObtenido.getApellidoMaterno());
        maestro.setCorreo(maestroObtenido.getCorreo());
        maestro.setContrasenia(maestroObtenido.getContrasenia());
        maestro.setRol(maestroObtenido.getRol());
        maestro.setMaterias(maestroObtenido.getMaterias());

        return maestro;

    }

    /**
     * Metodo que agrega un maestro al sistema
     *
     * @param maestro Objeto MaestroDTO a agregar
     */
    public void agregarMaestro(MaestroDTO maestro) {
        Maestro maestroAgregar = convertirMaestroDTOaEntidad(maestro);

        datos.agregarMaestro(maestroAgregar);
    }

    /**
     * Metodo que elimina un maestro del sistema
     *
     * @param maestro Objeto MaestroDTO a eliminar
     */
    public void eliminarMaestro(MaestroDTO maestro) {
        Maestro maestroEliminar = convertirMaestroDTOaEntidad(maestro);

        datos.eliminarUsuario(maestroEliminar);
    }

    /**
     * Metodo que modifica un maestro de la base de datos
     *
     * @param maestro Objeto MaestroDTO a modificar
     * @param maestroModificado Objeto MaestroDTO con la informacion a suplir
     */
    public void modificarMaestro(MaestroDTO maestro, MaestroDTO maestroModificado) {
        Maestro maestroModificar = convertirMaestroDTOaEntidad(maestro);
        Maestro maestroInfoMod = convertirMaestroDTOaEntidad(maestroModificado);

        datos.modificarMaestro(maestroModificar, maestroInfoMod);
    }
    
    /**
     * Obtiene la lista de clases que imparte el maestro
     *
     * @param matricula Matricula del maestro
     * @return Lista de clases que imparte el maestro
     */
    public List<Clase> obtenerMateriasImpartidasMaestro(int matricula){
        return datos.obtenerMateriasConNombresPorMaestro(matricula);
    }

    /**
     * Metodo que convierte un MaestroDTO a un MaestroEntidad
     *
     * @param dto MaestroDTO que se transfotrma a MaestroEntidad
     * @return Maestro de tipo Entidad
     */
    public Maestro convertirMaestroDTOaEntidad(MaestroDTO dto) {

        Maestro maestro = new Maestro();

        maestro.setMatricula(dto.getMatricula());
        maestro.setNombre(dto.getNombre());
        maestro.setApellidoPaterno(dto.getApellidoPaterno());
        maestro.setApellidoMaterno(dto.getApellidoMaterno());
        maestro.setCorreo(dto.getCorreo());
        maestro.setContrasenia(dto.getContrasenia());
        maestro.setRol(dto.getRol());
        maestro.setMaterias(dto.getMaterias());

        return maestro;

    }

}
