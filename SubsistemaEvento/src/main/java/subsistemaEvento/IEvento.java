/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaEvento;

import dto.EventoDTO;
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
    public void agregarEvento(EventoDTO evento);

    /**
     * Modifica un evento existente en el sistema.
     * 
     * @param evento el evento original
     * @param eventoModificado el evento con los nuevos datos
     */
    public void modificarEvento(EventoDTO evento, EventoDTO eventoModificado);


    public EventoDTO obtenerEvento(String titulo);
    
    public void eliminarEvento(EventoDTO evento);
    
    public List<Evento> obtenerListaEventos();
    
}
