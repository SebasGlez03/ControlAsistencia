/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsubsistemaqr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import entidades.Alumno;
import entidades.Clase;
import entidades.Maestro;
import entidades.QR;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;
import persistencia.FachadaPersistencia;
import persistencia.IPersistencia;

/**
 *
 * @author Ragzard
 */
public class ControlQR {
    
    private String tempFilePath;
    private int pin;
    private ObjectId sesionIdGenerada;
    IPersistencia datos = new FachadaPersistencia();
    
    public String getTempFilePath() {
        return tempFilePath;
    }
    
    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }
    
    public int getPin() {
        return pin;
    }
    
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * Genera un PIN aleatorio de 4 digitos
     *
     * @return el PIN generado
     */
    public int generarPIN() {
        int pin = (int) ((Math.random() * 10));
        
        for (int i = 0; i < 3; i++) {
            pin = adjuntarNumerosEnteros(pin, (int) ((Math.random() * 10)));
        }
        
        setPin(pin);
        return pin;
    }

    /**
     * Por medio de una API genera un QR.
     *
     * @return un objeto con el QR.
     */
    public QR generarQR() {
        String contenido = transformarIntAString(generarPIN());
        Date fechaCreacion = new Date();
        
        try {
            String QRtext = contenido + "  |  " + transformarDateAString(fechaCreacion);
            Path tempFile = Files.createTempFile("CodigoQR", ".jpg");
            String tempFilePath = tempFile.toAbsolutePath().toString();
            setTempFilePath(tempFilePath);
            
            BitMatrix matrix = new MultiFormatWriter().encode(QRtext, BarcodeFormat.QR_CODE, 295, 295);
            
            MatrixToImageWriter.writeToPath(matrix, "jpg", tempFile);
            
            System.out.println("Codigo QR generado correctamente en la direccion: " + tempFile);
        } catch (WriterException we) {
            System.out.println("Ocurrio un error al generar el QR: " + we.getMessage());
        } catch (IOException ioe) {
            System.out.println("Ocurrio un error al generar el QR: " + ioe.getMessage());
        }
        
        return new QR(contenido, fechaCreacion);
    }
    
    public ObjectId getSesionIdGenerada() {
        return sesionIdGenerada;
    }
    
    public void setSesionIdGenerada(ObjectId sesionIdGenerada) {
        this.sesionIdGenerada = sesionIdGenerada;
    }

    /**
     * Genera un QR y crea una sesión vinculada.
     *
     * @param clase La clase asociada a la sesión.
     * @param maestro El maestro asociado a la sesión.
     * @return El QR generado.
     */
    public QR generarQR(Clase clase, Maestro maestro) {
        String contenido = transformarIntAString(generarPIN());
        Date fechaCreacion = new Date();
        ObjectId idSesion = new ObjectId(); // Generar el ObjectId que compartirá QR y sesión

        try {
            // Generar el código QR
            String QRtext = contenido + "  |  " + transformarDateAString(fechaCreacion);
            Path tempFile = Files.createTempFile("CodigoQR", ".jpg");
            String tempFilePath = tempFile.toAbsolutePath().toString();
            setTempFilePath(tempFilePath);
            
            BitMatrix matrix = new MultiFormatWriter().encode(QRtext, BarcodeFormat.QR_CODE, 295, 295);
            MatrixToImageWriter.writeToPath(matrix, "jpg", tempFile);
            
            System.out.println("Código QR generado correctamente en la dirección: " + tempFile);

            // Crear el QR y la sesión en la base de datos
            QR qr = new QR(contenido, fechaCreacion);
            qr.setIdSesion(idSesion);
            setSesionIdGenerada(idSesion);
            datos.guardarQR(qr); // Guardar el QR
            datos.crearSesion(idSesion, clase, maestro); // Crear la sesión

            return qr;
        } catch (WriterException we) {
            System.out.println("Ocurrió un error al generar el QR: " + we.getMessage());
        } catch (IOException ioe) {
            System.out.println("Ocurrió un error al generar el QR: " + ioe.getMessage());
        }
        
        return null;
    }

    /**
     * Metodo que valida el escaneo del QR
     *
     * @param pin pin del que se va a leer
     * @return true si el pin es correcto, falso si el campo esta vacio o el pin
     * es incorrecto
     */
    public boolean escanearQR(int pin) {
        if (pin == getPin()) {
            JOptionPane.showMessageDialog(null, "Se ha registrado su asistencia", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        if (String.valueOf(pin).equals("")) {
            JOptionPane.showMessageDialog(null, "Ingresa el codigo en el campo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (String.valueOf(pin).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa el codigo en el campo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Pin no valido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Verifica que el QR cumpla con el formato correcto.
     *
     * @param qr
     * @return
     */
    public boolean validarQR(QR qr) {
        return true;
    }

    /**
     * Une dos numeros enteros.
     *
     * @param base
     * @param num2
     * @return
     */
    private int adjuntarNumerosEnteros(int base, int num2) {
        String cadena = String.valueOf(base) + String.valueOf(num2);
        
        return Integer.parseInt(cadena);
    }

    /**
     * Transforma el contenido del QR a un valor String
     *
     * @param contenido Informacion que contiene el QR
     * @return La informacion del contenido en formato String
     */
    public String transformarIntAString(int contenido) {
        return String.valueOf(contenido);
    }

    /**
     * Transforma el contendio del QR a un valor String
     *
     * @param fecha Fecha en la que se genero el QR
     * @return Fecha en la que se genero el QR en formato String
     */
    public String transformarDateAString(Date fecha) {
        return String.valueOf(fecha);
    }

    /**
     * Agrega un alumno a la lista de asistencia basado en el PIN de un QR.
     *
     * @param alumno Alumno que se agregará a la lista de asistencia.
     * @param pin PIN del QR para encontrar la sesión.
     * @return boolean Verdadero si la operación fue exitosa, falso en caso
     * contrario.
     */
    public boolean agregarAlumnoASesion(Alumno alumno, String pin) {
        return datos.agregarAlumnoASesion(alumno, pin);
    }

    /**
     * Busca un QR por PIN y determina el estado de asistencia basado en la
     * fecha de creación.
     *
     * @param pin PIN del QR.
     * @return Estado de asistencia (1: PRESENTE, 2: RETARDO).
     * @throws IllegalArgumentException Si el QR no existe o el tiempo excede el
     * límite.
     */
    public int determinarEstadoAsistencia(String pin) throws IllegalArgumentException {
        return datos.determinarEstadoAsistencia(pin);
    }

    /**
     * Método para obtener el ID de la sesión a partir del PIN.
     *
     * @param pin El PIN del QR.
     * @return El ObjectId de la sesión correspondiente.
     * @throws IllegalArgumentException Si no se encuentra el QR o el PIN no es
     * válido.
     */
    public ObjectId obtenerIdSesionDesdeQR(String pin) {
        return datos.obtenerIdSesionDesdeQR(pin);
    }

    /**
     * Método que agrega un alumno a la lista de asistencia de una sesión.
     *
     * @param idSesion El ObjectId de la sesión donde se va a agregar al alumno.
     * @param alumno El objeto Alumno que contiene la información del alumno.
     */
    public void agregarAlumnoASesion(ObjectId idSesion, Alumno alumno) {
        datos.agregarAlumnoASesion(idSesion, alumno);
    }
    
}
