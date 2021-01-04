package EncryptionPackage.AES;

/*
Source: https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
Solved: Marcin Rozkwitalski s19826
 */

import Main.Main;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Aes {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    /**
     * Creates secret key depending on given key
     * @param myKey key given by user
     */
    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Encrypts given string
     * @param strToEncrypt string which will be encrypted
     * @param secret secret key given by user
     * @return returns encoded string
     */
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    /**
     * Decrypts given string
     * @param strToDecrypt string which will be decrypted
     * @param secret secret key given by user
     * @return returns decrypted string of encrypted string
     */
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void DoEncrypt() throws Exception {
        final String secretKey = "ssshhhhhhhhhhh!!!!";
        System.out.print("Input text to encrypt: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String encryptedString = Aes.encrypt(input, secretKey) ;
        System.out.print("Encrypted text: " + encryptedString + "\n");
        main();
    }

    public static void DoDecrypt() throws Exception {
        final String secretKey = "ssshhhhhhhhhhh!!!!";
        System.out.print("Input text to decrypt: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String decryptedString = Aes.decrypt(input, secretKey) ;
        System.out.print("Decrypted text: " + decryptedString + "\n");
        main();
    }

    public static void main() throws Exception {
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
                System.out.println("You are leaving AES algorithm.");
                break;
            default:
                System.out.println("This option doesn't exist.");
                System.out.println("Please choose new option.");
                main();
        }
    }
}