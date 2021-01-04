package EncryptionPackage.Asymetric;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Scanner;

public class RSA {
    public static void main(String args[]) throws Exception{

        /**
         * Accepting text from user
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text");
        String msg = sc.nextLine();

        /**
         * Creating a Signature object
         */
        Signature sign = Signature.getInstance("SHA256withRSA");

        /**
         * Creating KeyPair generator object
         */
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        /**
         * Initializing the key pair generator
         */
        keyPairGen.initialize(2048);

        /**
         * Generate the pair of keys
         */
        KeyPair pair = keyPairGen.generateKeyPair();

        /**
         * Getting the public key from the key pair
         */
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        System.out.println("Keys generated");
        System.out.println("Private key : \n" + privateKey);
        System.out.println("Public key : \n" + publicKey);

        /**
         * Creating a Cipher object
         */
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        /**
         * Initializing a Cipher object
         */
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        /**
         * Add data to the cipher
         */
        byte[] input = msg.getBytes();
        cipher.update(input);

        /**
         * encrypting the data
         */
        byte[] cipherText = cipher.doFinal();
        System.out.println( "Encrypted text with public key : \n" + new String(cipherText, "UTF8"));

        /**
         * Initializing the same cipher for decryption
         */
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        /**
         * Decrypting the text
         */
        byte[] decipheredText = cipher.doFinal(cipherText);
        System.out.println("Decrypted text with private key : \n" + new String(decipheredText));
    }
}