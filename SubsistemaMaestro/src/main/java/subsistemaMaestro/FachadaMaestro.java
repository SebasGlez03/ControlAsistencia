/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaMaestro;

import entidades.Maestro;
import mock.BaseDatosMock;
import subsistemaMaestro.ControlMaestro;
import dao.*;

/**
 *
 * @author limon
 */
public class FachadaMaestro implements IMaestro {

    private Maestro maestro; // Instancia de Maestro a gestionar

    /**
     * Constructor que inicializa la Fachada con una instancia de Maestro
     * @param maestro Instancia del maestro a gestionar
     */
    public FachadaMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    /**
     * Muestra el código QR del maestro.
     * Este método podría contener la lógica para generar y mostrar un código QR.
     */
    @Override
    public void mostrarQR() {
        // Aquí iría la lógica para generar y mostrar el QR del maestro
        System.out.println("Mostrando código QR para el maestro: " + maestro.getNombre());
    }

    /**
     * Valida la información del maestro, como su identificación y credenciales.
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
     * Realiza la búsqueda de información del maestro.
     * Este método podría contener la lógica para buscar información en una base de datos.
     * @param s
     */
    @Override
    public void buscarMaestro(String s) {
        
        ControlMaestro cm = new ControlMaestro(maestro);
        System.out.println("Buscando información del maestro: ");
        
        cm.buscarMaestro(s);
    }

    /**
     * Realiza un registro del maestro a la base de datos
     */
    @Override
    public void registrarMaestro() {
        
        //luego me corrigen, atte: joel
        UsuarioDAO udao= new UsuarioDAO();
        MaestroDAO mdao= new MaestroDAO();
        
        udao.agregarUsuario(maestro);
        mdao.agregarMaestro(maestro);
    }

    @Override
    public void editarMaestro() {
        Maestro newMaestro;
        
        MaestroDAO mdao = new MaestroDAO();
        
        //mdao.modificarMaestro(maestro, newMaestro);
    }
 
    
}
