package EncryptionPackage.BlowFish;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

/* Source: https://www.youtube.com/watch?v=IhaQqbX6kLA&ab_channel=ProfessorSaad
   Solved: Filip Trojanowski s20088
* */

public class BlowFish {

    /**
     *
     * @param input Message read from user which will be encrypted and decrypted
     */
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
            System.err.println("Error:"+exception.toString());
        }
    }
    public static void main(){
        System.out.println("Give some text");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        BlowFishTest(input);
    }
}
