package EncryptionPackage.BlowFish;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.*;

public class BlowFish {
//    byte[] skey = new byte[1000];
//    String skeyString;
//    static byte[] rav;
//    String inputMessage, encryptedData, decryptedMessage;
//
//    public BlowFish() {
//        try{
//            generateSymmetricKey();
//            inputMessage = JOptionPane.showInputDialog(null,"Enter message to encrypt");
//            byte[] ibyte = inputMessage.getBytes();
//            byte[] ebyte = encrypt(rav,ibyte);
//            String encryptedData = new String(ebyte);
//            System.out.println("Encrypted message : " + encryptedData);
//            JOptionPane.showMessageDialog(null,"Encrypted Data " + "\n" + encryptedData);
//
//            byte[] dbyte = decrypt(rav, ebyte);
//            String decryptedMessage = new String(dbyte);
//            System.out.println("Decrypted message : " + decryptedMessage);
//
//            JOptionPane.showMessageDialog(null,"Decrypted Data : " + "\n" + decryptedMessage);
//        }catch (Exception exception){
//            System.out.println(exception);
//        }
//
//        void generateSymmetricKey();
//        int num = r.nextInt(10000);
//    }
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
