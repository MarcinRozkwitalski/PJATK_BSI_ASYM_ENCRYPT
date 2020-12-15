package EncryptionPackage.BlowFish;

import Main.Main;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

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

    private static void DoDecrypt() {
        //kod filipa
    }

    private static void DoEncrypt() {
        //kod filipa
    }

    public static void main() {
        System.out.println("1. Encrypt\n2. Decrypt\n3. Exit algorithm");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option){
            case 1:
                System.out.println("You chose encryption.");
                DoEncrypt();
                break;
            case 2:
                System.out.println("You chose decryption.");
                DoDecrypt();
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
    }
}
