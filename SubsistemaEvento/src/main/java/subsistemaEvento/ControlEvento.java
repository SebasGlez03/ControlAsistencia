/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaEvento;

import dao.EventoDAO;
import entidades.Evento;
import java.util.List;

/**
 *
 * @author limon
 */
public class ControlEvento {
    
    private EventoDAO eventoDAO;  // Instancia de EventoDAO para interactuar con la base de datos

    /**
     * Constructor de ControlEvento.
     * Inicializa el DAO de eventos.
     */
    public ControlEvento() {
        this.eventoDAO = new EventoDAO();
    }

    /**
     * Agrega un nuevo evento al sistema.
     * 
     * @param evento el evento a agregar
     */
    public void agregarEvento(Evento evento) {
        // Validaciones antes de agregar el evento
        if (evento.getTitulo() == null || evento.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del evento es obligatorio.");
        }
        if (evento.getFecha() == null) {
            throw new IllegalArgumentException("La fecha del evento es obligatoria.");
        }
        
        // Agregar el evento al repositorio (base de datos)
        eventoDAO.agregarEvento(evento);
        System.out.println("Evento agregado correctamente");
    }

    /**
     * Modifica un evento existente en el sistema.
     * 
     * @param evento el evento original
     * @param eventoModificado el evento con los nuevos datos
     */
    public void modificarEvento(Evento evento, Evento eventoModificado) {
        // Validaciones antes de modificar el evento
        if (eventoModificado.getTitulo() == null || eventoModificado.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("El título del evento es obligatorio.");
        }
        if (eventoModificado.getFecha() == null) {
            throw new IllegalArgumentException("La fecha del evento es obligatoria.");
        }

        // Modificar el evento en el repositorio (base de datos)
        eventoDAO.modificarEvento(evento, eventoModificado);
    }

    /**
     * Obtiene un evento por su título.
     * 
     * @param titulo el título del evento a buscar
     * @return el evento encontrado
     */
    public Evento obtenerEvento(String titulo) {
        Evento evento = new Evento();
        evento.setTitulo(titulo);
        
        // Obtener el evento del repositorio (base de datos)
        return eventoDAO.obtenerEvento(evento);
    }
    
}
