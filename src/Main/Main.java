package Main;



import EncryptionPackage.Des.DesString;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import static EncryptionPackage.Des.Des.encryption;
import static EncryptionPackage.Des.DesString.encryptionOfString;

public class Main {
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        File plaintext = new File("C:\\Moje pierdoły\\Materiały_PJWSTK_semestr_5\\BSI\\PJATK_BSI_ENCRYPTION\\src\\Files\\Text.txt");
        File encrypted = new File("C:\\Moje pierdoły\\Materiały_PJWSTK_semestr_5\\BSI\\PJATK_BSI_ENCRYPTION\\src\\Files\\EncryptedText.txt");
        File decrypted = new File("C:\\Moje pierdoły\\Materiały_PJWSTK_semestr_5\\BSI\\PJATK_BSI_ENCRYPTION\\src\\Files\\DecryptedText.txt");
        try {
            encryption("12345678", Cipher.ENCRYPT_MODE, plaintext, encrypted);
            System.out.println("Encryption completed");
        }catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | IOException exception){
            exception.printStackTrace();
        }
        try {
            encryption("12345678", Cipher.DECRYPT_MODE,encrypted,decrypted);
            System.out.println("Decryption completed");
        }catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | IOException exception){
            exception.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        encryptionOfString(input);
    }
}
