package EncryptionPackage.Asymetric;


import java.security.*;
import java.util.Scanner;

/*
links of used sources :
https://www.tutorialspoint.com/java_cryptography/java_cryptography_keypairgenerator.htm

Solution for DSA algorithm, the purpose of this algorithm was to create public and private key.
We have only done signature in this algorithm because we can not do encryption and decryption.

Solved by: Filip Trojanowski s20088 & Marcin Rozkwitalski s19826

 */

public class DSA{

    public static void main() throws Exception{

        //Accepting text from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text (DSA)");
        String msg = sc.nextLine();

        //Creating KeyPair generator object
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

    }
}