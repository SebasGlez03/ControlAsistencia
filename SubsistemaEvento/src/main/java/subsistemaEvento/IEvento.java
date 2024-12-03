/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaEvento;

import entidades.Evento;
import java.util.List;

/**
 *
 * @author limon
 */
public interface IEvento {
    
    /**
     * Agrega un nuevo evento al sistema.
     * 
     * @param evento el evento a agregar
     */
    void agregarEvento(Evento evento);

    /**
     * Modifica un evento existente en el sistema.
     * 
     * @param evento el evento original
     * @param eventoModificado el evento con los nuevos datos
     */
    void modificarEvento(Evento evento, Evento eventoModificado);

    /**
     * Obtiene un evento por su título.
     * 
     * @param titulo el título del evento a buscar
     * @return el evento encontrado
     */
    Evento obtenerEvento(String titulo);
    
    boolean eliminarEvento(String titulo);
    
    public List<Evento> obtenerListaEventos();
    
}
