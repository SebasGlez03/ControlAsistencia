package utilerias;

/**
 * a
 *
 * @hidden
 */
public class CaesarCipher {

    // Método para cifrar el texto
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                // Desplazar la letra y manejar el ciclo del alfabeto
                character = (char) ((character + shift - base) % 26 + base);
            }
            encrypted.append(character);
        }

        return encrypted.toString();
    }

    // Método para descifrar el texto
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); // Deshacer el cifrado usando el desplazamiento inverso
    }

    public static void main(String[] args) {
        String originalText = "Hola Mundo";
        int shift = 3; // Desplazamiento

        // Cifrar el texto
        String encryptedText = encrypt(originalText, shift);
        System.out.println("Texto original: " + originalText);
        System.out.println("Texto cifrado: " + encryptedText);

        // Descifrar el texto
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Texto descifrado: " + decryptedText);
    }
}
