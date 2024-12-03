package subsistemaEvento;

import dto.EventoDTO;
import entidades.Evento;
import java.util.List;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/**
 * Controla las operaciones relacionadas con los eventos, incluyendo agregar, modificar y obtener eventos.
 */
public class ControlEvento {
    
    private EventoDTO evento;  // Instancia de EventoDAO para interactuar con la base de datos
    IPersistencia datos = new FachadaPersistencia();
    
    /**
     * Constructor de ControlEvento.
     * Inicializa el DAO de eventos.
     */
    public ControlEvento() {
    }

    public ControlEvento(EventoDTO evento) {
        this.evento = evento;
    }

    /**
     * Agrega un nuevo evento al sistema.
     * 
     * @param evento el evento a agregar
     */
    public void agregarEvento(EventoDTO evento) {
        Evento eventoAgregar = convertirAlumnoDTOaEntidad(evento);

        datos.agregarEvento(eventoAgregar);
    }

    /**
     * Modifica un evento existente en el sistema.
     * 
     * @param evento el evento original
     * @param eventoModificado el evento con los nuevos datos
     */
    public void modificarEvento(EventoDTO evento, EventoDTO eventoModificado) {
       // Informacion del alumno
        Evento eventoModificar = convertirAlumnoDTOaEntidad(evento);

        // Informacion del alumno con la nueva informacion
        Evento eventoInfoModi = convertirAlumnoDTOaEntidad(eventoModificado);

        datos.modificarEvento(eventoModificar, eventoInfoModi);
    }

    /**
     * Obtiene un evento por su título.
     * 
     * @param titulo el título del evento a buscar
     * @return el evento encontrado, o null si no se encuentra
     */
    public EventoDTO obtenerEvento(String titulo) {
        Evento eventoObtenido = datos.obtenerEventoPorTitulo(titulo);
        EventoDTO evento = new EventoDTO();

        evento.setTitulo(eventoObtenido.getTitulo());
        evento.setDescripcion(eventoObtenido.getDescripcion());
        evento.setFechaInicio(eventoObtenido.getFechaInicio());
        evento.setFechaFinal(eventoObtenido.getFechaFinal());
        evento.setHoraInicio(eventoObtenido.getHoraInicio());
        evento.setHoraFinal(eventoObtenido.getHoraFinal());
        evento.setCampus(eventoObtenido.getCampus());
        evento.setCategoria(eventoObtenido.getCategoria());


        return evento;
    }
    
      /**
     * Elimina un evento del sistema.
     * 
     * @param titulo el título del evento a eliminar
     * @return true si el evento fue eliminado correctamente, false si no se encuentra
     */
    public void eliminarEvento(EventoDTO evento) {
        Evento eventoEliminar = convertirAlumnoDTOaEntidad(evento);

        datos.eliminarEvento(eventoEliminar);
    }
    
    public List<Evento> obtenerListaEventos() {
        IPersistencia datos = new FachadaPersistencia();

        return datos.obtenerTodosEventos();
    }
    public Evento convertirAlumnoDTOaEntidad(EventoDTO dto) {

            Evento evento = new Evento();

            evento.setTitulo(dto.getTitulo());
            evento.setDescripcion(dto.getDescripcion());
            evento.setFechaInicio(dto.getFechaInicio());
            evento.setFechaFinal(dto.getFechaFinal());
            evento.setHoraInicio(dto.getHoraInicio());
            evento.setHoraFinal(dto.getHoraFinal());
            evento.setCampus(dto.getCampus());
            evento.setCategoria(dto.getCategoria());


            return evento;
    }
}
