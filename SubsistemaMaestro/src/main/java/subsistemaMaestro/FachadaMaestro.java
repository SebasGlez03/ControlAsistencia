/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaMaestro;

import entidades.Maestro;
import dto.MaestroDTO;
import entidades.Clase;
import java.util.List;

/**
 *
 * @author limon
 */
public class FachadaMaestro implements IMaestro {

    private Maestro maestro; // Instancia de Maestro a gestionar
    ControlMaestro controlMaestro = new ControlMaestro();

    /**
     * Constructor por omision
     */
    public FachadaMaestro() {

    }

    /**
     * Constructor que inicializa la Fachada con una instancia de Maestro
     *
     * @param maestro Instancia del maestro a gestionar
     */
    public FachadaMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    /**
     * Muestra el código QR del maestro. Este método podría contener la lógica
     * para generar y mostrar un código QR.
     */
    @Override
    public void mostrarQR() {
        // Aquí iría la lógica para generar y mostrar el QR del maestro
        System.out.println("Mostrando código QR para el maestro: " + maestro.getNombre());
    }

    /**
     * Valida la información del maestro, como su identificación y credenciales.
     *
     * @return true si la validación es exitosa, false en caso contrario
     */
    @Override
    public boolean validarMaestro() {
        // Aquí iría la lógica para validar al maestro (ejemplo, revisar credenciales)
        if (maestro.getNombre() != null && !maestro.getNombre().isEmpty()) {
            System.out.println("Validación exitosa para el maestro: " + maestro.getNombre());
            return true;
        }
        System.out.println("Error: La validación del maestro ha fallado.");
        return false;
    }

    /**
     * Metodo que obtiene un maestro de la base de datos
     *
     * @param matricula Matricula del maestro a obtener
     * @return Objeto MaestroDTO obtenido
     */
    @Override
    public MaestroDTO obtenerMaestro(int matricula) {
        return controlMaestro.obtenerMaestro(matricula);
    }

    /**
     * Metodo que agrega un maestro a la base de datos
     *
     * @param maestro Objeto MaestroDTO a agregar a la base de datos
     */
    @Override
    public void agregarMaestro(MaestroDTO maestro) {
        controlMaestro.agregarMaestro(maestro);
    }

    /**
     * Metodo que elimina un maestro de la base de datos
     *
     * @param maestro Obketo MaestroDTO a eliminar de la base de datos
     */
    @Override
    public void eliminarMaestro(MaestroDTO maestro) {
        controlMaestro.eliminarMaestro(maestro);
    }

    /**
     * Metodo que modifica un maestro de la base de datos
     *
     * @param maestro Objeto MaestroDTO a modificar
     * @param maestroModificado Objeto MaestroDTO con la informacion a suplir
     */
    @Override
    public void modificarMaestro(MaestroDTO maestro, MaestroDTO maestroModificado) {
        controlMaestro.modificarMaestro(maestro, maestroModificado);
    }

    @Override
    public List<Clase> obtenerMateriasImpartidasMaestro(int matricula) {
        return controlMaestro.obtenerMateriasImpartidasMaestro(matricula);
    }

}
