package Main;



import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static EncryptionPackage.Des.Des.encryption;

public class Main {
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        File plaintext = new File("C:\\Moje pierdoły\\Materiały_PJWSTK_semestr_5\\BSI\\PJATK_BSI_ENCRYPTION\\src\\Files\\text.txt");
        File encrypted = new File("C:\\Moje pierdoły\\Materiały_PJWSTK_semestr_5\\BSI\\PJATK_BSI_ENCRYPTION\\src\\Files\\NewText.txt");

        try {
            encryption("12345678", Cipher.ENCRYPT_MODE, plaintext, encrypted);
            System.out.println("Encryption completed");
        }catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | IOException exception){
            exception.printStackTrace();
        }
    }
}
