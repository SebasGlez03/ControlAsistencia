/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsubsistemaqr;

import entidades.Clase;
import entidades.Maestro;
import entidades.QR;

/**
 *
 * @author Ragzard
 */
public interface IQR {

    /**
     * Devuelve un QR generado a partir de un PIN y una Fecha.
     *
     * @return
     */
    public QR generarQR();

    /**
     * Genera un nuevo QR validando que no sea igual al qr anterior.
     *
     * @param qr
     * @return
     */
    public QR actualizarQR(QR qr);

    /**
     * Valida que el pin introducido sea igual al del QR.
     *
     * @param pin
     * @param qr
     * @return true : false
     */
    public boolean escanearQR(int pin, QR qr);

    /**
     * Metodo que obtiene la ubicacion de el QR generado
     *
     * @return direccion de tipo String del QR generado
     */
    public String obtenerPathQR();
    
    /**
     * Metodo que obtiene el pin de el QR generado
     * @return pin generado del QR
     */
    public int obtenerPIN();
    
    /**
     * Genera un QR y crea una sesión vinculada.
     *
     * @param clase La clase asociada a la sesión.
     * @param maestro El maestro asociado a la sesión.
     * @return El QR generado.
     */
    public QR generarQR(Clase clase, Maestro maestro);
}
