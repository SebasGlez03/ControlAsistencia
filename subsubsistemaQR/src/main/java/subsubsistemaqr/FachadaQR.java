/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsubsistemaqr;

import entidades.Clase;
import entidades.Maestro;
import entidades.QR;
import org.bson.types.ObjectId;

/**
 *
 * @author Ragzard
 */
public class FachadaQR implements IQR {

    ControlQR cQR = new ControlQR();

    /**
     * Devuelve un QR generado a partir de un PIN y una Fecha.
     *
     * @return
     */
    @Override
    public QR generarQR() {

        return cQR.generarQR();

    }
    
    /**
     * Metodo que obtiene la ID de la sesion creada por el QR
     *
     * @return ID de la sesion creada
     */
    @Override
    public ObjectId obtenerIdSesion(){
        return cQR.getSesionIdGenerada();
    }

    /**
     * Genera un nuevo QR validando que no sea igual al qr anterior.
     *
     * @param qr
     * @return
     */
    @Override
    public QR actualizarQR(QR qr) {
        String pin = generarQR().getContenido();

        if (pin.equals(qr.getContenido())) {
            actualizarQR(qr);
        } else {
            qr.setContenido(pin);
        }

        return qr;
    }

    /**
     * Valida que el pin introducido sea igual al del QR.
     *
     * @return true : false
     */
    @Override
    public boolean escanearQR(int pin, QR qr) {
        return (String.valueOf(pin).equals(qr.getContenido()));
    }

    @Override
    public String obtenerPathQR() {
        return cQR.getTempFilePath();
    }

    @Override
    public int obtenerPIN() {
        return cQR.getPin();
    }

    /**
     * Genera un QR y crea una sesión vinculada.
     *
     * @param clase La clase asociada a la sesión.
     * @param maestro El maestro asociado a la sesión.
     * @return El QR generado.
     */
    @Override
    public QR generarQR(Clase clase, Maestro maestro) {
        return cQR.generarQR(clase, maestro);
    }

}
