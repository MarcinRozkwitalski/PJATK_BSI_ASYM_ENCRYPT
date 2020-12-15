package EncryptionPackage.BlowFish;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class BlowFish {
    public static void BlowFishTest(String input){
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("BlowFish");
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("BlowFish");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[] text = input.getBytes();
            System.out.println("Text: " + new String(text));
            byte[] textEncrypted = cipher.doFinal(text);
            System.out.println("Text Encrypted: " + new String(textEncrypted));
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] textDecrypted = cipher.doFinal(textEncrypted);
            System.out.println("Text Decrypted: " + new String(textDecrypted));

        }catch (Exception exception){

        }
    }
}
