package EncryptionPackage.Des;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DesString {
    public DesString() {
    }

    public static void encryptionOfString(String input){
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[] text = input.getBytes();
            System.out.println("Text in bytes: " + text);
            System.out.println("Text: " + new String(text));
            byte[] textEncrypted = cipher.doFinal(text);
            System.out.println("Text in bytes: " + textEncrypted);
            System.out.println("Text Encrypted: " + new String(textEncrypted));
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] textDecrypted = cipher.doFinal(textEncrypted);
            System.out.println("Text Decrypted: " + new String(textDecrypted));

        }catch (Exception exception){

        }

    }
}
