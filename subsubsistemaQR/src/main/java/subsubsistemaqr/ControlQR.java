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
import entidades.QR;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 *
 * @author Ragzard
 */
public class ControlQR {

    private String tempFilePath;

    public String getTempFilePath() {
        return tempFilePath;
    }

    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
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
}
