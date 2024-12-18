/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaMaestro;

import dto.MaestroDTO;
import entidades.Clase;
import java.util.List;

/**
 *
 * @author limon
 */
public interface IMaestro {

    public void mostrarQR();

    public boolean validarMaestro();

    /**
     * Obtiene un maestro del sistema.
     *
     * @param matricula Matricula del maestro a obtener
     * @return Objeto MaestroDTO obtenido
     */
    public MaestroDTO obtenerMaestro(int matricula);

    /**
     * Agrega un nuevo maestro al sistema.
     *
     * @param maestro Maestro a agregar en el sistema.
     */
    public void agregarMaestro(MaestroDTO maestro);

    /**
     * Elimina un maestro del sistema.
     *
     * @param maestro Maestro a eliminar en el sistema.
     */
    public void eliminarMaestro(MaestroDTO maestro);

    /**
     * Modifica un maestro del sistema.
     *
     * @param maestro Maestro a modificar en el sistema.
     * @param maestroModificado Maestro con la nueva informacion a agregar.
     */
    public void modificarMaestro(MaestroDTO maestro, MaestroDTO maestroModificado);

    /**
     * Obtiene la lista de clases que imparte el maestro
     *
     * @param matricula Matricula del maestro
     * @return Lista de clases que imparte el maestro
     */
    public List<Clase> obtenerMateriasImpartidasMaestro(int matricula);

}
