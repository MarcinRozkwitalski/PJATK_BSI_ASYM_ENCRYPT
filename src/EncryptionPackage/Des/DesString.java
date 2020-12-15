package EncryptionPackage.Des;

import Main.Main;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
/* Source: https://gist.github.com/ufologist/5581496
   Solved: Filip Trojanowski s20088
* */

public class DesString {
    private Cipher encryptCipher = null;
    private Cipher decryptCipher = null;

    public DesString(SecretKey key) throws Exception {
        encryptCipher = Cipher.getInstance("DES");
        decryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    public DesString() {

    }

    public String DoEncrypt (String unencryptedString) throws Exception  {
        byte[] unencryptedByteArray = unencryptedString.getBytes(StandardCharsets.UTF_8);

        // Encrypt
        byte[] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);

        // Encode bytes to base64 to get a string
        byte [] encodedBytes = Base64.getEncoder().encode(encryptedBytes);

        return new String(encodedBytes);
    }

    public String DoDecrypt(String encryptedString) throws Exception {
        // Encode bytes to base64 to get a string
        byte [] decodedBytes = Base64.getDecoder().decode(encryptedString.getBytes());

        // Decrypt
        byte[] unencryptedByteArray = decryptCipher.doFinal(decodedBytes);

        // Decode using utf-8
        return new String(unencryptedByteArray, StandardCharsets.UTF_8);
    }



    public static void main() {
        try {
            //Generate the secret key
            String password = "1234abcd";
            DESKeySpec key = new DESKeySpec(password.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

            DesString crypt = new DesString(keyFactory.generateSecret(key));

            System.out.println("1. Encrypt\n2. Decrypt\n3. Exit algorithm");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("You chose encryption.");
                    String unencryptedString = scanner.next();
                    String encryptedString = crypt.DoEncrypt(unencryptedString);
                    System.out.println("Encrypted String:"+encryptedString);
                    main();
                    break;
                case 2:
                    System.out.println("You chose decryption.");
                    encryptedString = scanner.next();
                    unencryptedString = crypt.DoDecrypt(encryptedString);
                    System.out.println("UnEncrypted String:"+unencryptedString);
                    main();
                    break;
                case 3:
                    System.out.println("You are leaving BlowFish algorithm.");
                    Main.TaskOptions();
                    break;
                default:
                    System.out.println("This option doesn't exist.");
                    System.out.println("Please choose new option.");
                    main();
            }

        } catch (Exception e) {
            System.err.println("Error:"+e.toString());
        }

    }
}
