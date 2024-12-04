/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaEvento;

import dto.EventoDTO;
import entidades.Evento;
import java.util.List;

/**
 *
 * @author limon
 */
public class FachadaEvento implements IEvento{

    private ControlEvento controlEvento = new ControlEvento();; // Interfaz IEvento que puede ser implementada por ControlEvento
    
    @Override
    public void agregarEvento(EventoDTO evento) {
        controlEvento.agregarEvento(evento);
    }

    @Override
    public void modificarEvento(EventoDTO evento, EventoDTO eventoModificado) {
        controlEvento.modificarEvento(evento, eventoModificado);
    }

    @Override
    public EventoDTO obtenerEvento(String titulo) {
        return controlEvento.obtenerEvento(titulo);
    }
    public void eliminarEvento(EventoDTO evento) {
          controlEvento.eliminarEvento(evento);
    }

    @Override
    public List<Evento> obtenerListaEventos() {
       return controlEvento.obtenerListaEventos();
    }
    
    
}
