/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaEvento;

import entidades.Evento;

/**
 *
 * @author limon
 */
public class FachadaEvento implements IEvento{

    private IEvento controlEvento;  // Interfaz IEvento que puede ser implementada por ControlEvento

    @Override
    public void agregarEvento(Evento evento) {
        controlEvento.agregarEvento(evento);
    }

    @Override
    public void modificarEvento(Evento evento, Evento eventoModificado) {
        controlEvento.modificarEvento(evento, eventoModificado);
    }

    @Override
    public Evento obtenerEvento(String titulo) {
        return controlEvento.obtenerEvento(titulo);
    }
    
    
    
}
