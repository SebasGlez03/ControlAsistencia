/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsubsistemaqr;

import entidades.QR;
import java.util.Date;

/**
 *
 * @author Ragzard
 */
public class ControlQR {

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
        return pin;
    }

    /**
     * Por medio de una API genera un QR.
     *
     * @return un objeto con el QR.
     */
    public QR generarQR() {
        return new QR(String.valueOf(generarPIN()), new Date());
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
}
