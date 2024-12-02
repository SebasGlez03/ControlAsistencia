package utilerias;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * a
 *
 * @hidden
 */
public class LectorIp {

    // Método para obtener la dirección IP local
    public static String getLocalIPAddress() {
        try {
            // Obtener la dirección IP local
            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress(); // Retornar la dirección IP en formato de cadena
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener la dirección IP local.");
            e.printStackTrace();
            return null; // Retornar null si ocurre un error
        }
    }

    public static void main(String[] args) {
        // Llamar al método para obtener la IP local
        String localIP = getLocalIPAddress();
        if (localIP != null) {
            System.out.println("La dirección IP local es: " + localIP);
        }
    }
}
