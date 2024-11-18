/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsubsistemaqr;

import entidades.QR;

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
    
    

}
