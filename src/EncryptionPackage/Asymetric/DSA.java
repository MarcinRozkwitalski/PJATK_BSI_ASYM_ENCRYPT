package EncryptionPackage.Asymetric;

import java.security.*;
import java.util.Scanner;
import javax.crypto.Cipher;
/*
links of used sources :
https://www.tutorialspoint.com/java_cryptography/java_cryptography_keypairgenerator.htm
*
*
*
* */
public class DSA{
    public static void main() throws Exception{

        /**
         * Accepting text from user
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text (DSA)");
        String msg = sc.nextLine();

        /**
         * Creating KeyPair generator object
         */
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        //Initializing the key pair generator
        keyPairGen.initialize(1024);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the private key from the key pair
        PrivateKey privateKey = pair.getPrivate();

        //Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();

        System.out.println("Keys generated");
        System.out.println("Private key : " + privateKey);
        System.out.println("Public key : " + publicKey);

        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        //Initialize the signature
        sign.initSign(privateKey);
        byte[] bytes = msg.getBytes();

        //Adding data to the signature
        sign.update(bytes);

        //Calculating the signature
        byte[] signature = sign.sign();

        //Printing the signature
        System.out.println("Digital signature for given text: " + new String(signature, "UTF8"));

        //Initializing the signature
        sign.initVerify(publicKey);
        sign.update(bytes);

        //Verifying the signature
        boolean bool = sign.verify(signature);

        if(bool) {
            System.out.println("Signature verified");
        } else {
            System.out.println("Signature failed");
        }

// NOT WORKING FOR DSA ....
//        //Creating a Cipher object
//        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//
//        //Initializing a Cipher object
//        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
//
//        //Adding data to the cipher
//        byte[] input = "Welcome to Tutorialspoint".getBytes();
//        cipher.update(input);
//
//        //encrypting the data
//        byte[] cipherText = cipher.doFinal();
//        System.out.println(new String(cipherText, "UTF8"));
    }
}