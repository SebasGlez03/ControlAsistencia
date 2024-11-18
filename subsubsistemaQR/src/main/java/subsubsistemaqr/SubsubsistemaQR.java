/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package subsubsistemaqr;

import entidades.QR;
import java.util.Date;

/**
 *
 * @author Ragzard
 */
public class SubsubsistemaQR {

    public static void main(String[] args) {
        IQR iQR = new FachadaQR();
        Date fecha = new Date();
        QR qrTest = new QR("1234", fecha);
        String basePath = System.getProperty("user.dir");

//        System.out.println("---[ GENERAR QR ]---");
//
//        System.out.println(iQR.generarQR().getContenido());
//
//        System.out.println("---[ ESCANEAR QR ]---");
//        System.out.println(iQR.escanearQR(1234, qrTest));
//
//        System.out.println("---[ ACTUALIZAR QR ]---");
//
//        System.out.println("QR por actualizar: " + qrTest.getContenido());
//        iQR.actualizarQR(qrTest);
//        System.out.println("QR actualizado: " + iQR.actualizarQR(qrTest).getContenido());

        
        iQR.generarQR();
        System.out.println("El QR se genero en la direccion: " + iQR.obtenerPathQR());

    }
}
