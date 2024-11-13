
import entidades.Usuario;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class Prueba {

    public static void main(String[] args) {
        Usuario usuario = new Usuario(1234456, "Pedro", "Perez", "Martinez", "pedro@gmail.com", "contrasenia");

        IPersistencia bd = new FachadaPersistencia();
        
        bd.agregarUsuario(usuario);

        System.out.println(bd.obtenerUsuario(usuario).toString());
    }

}
