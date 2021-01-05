package EncryptionPackage.Asymetric;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Scanner;

/*

Source for RSA: https://www.tutorialspoint.com/java_cryptography/java_cryptography_decrypting_data.htm
Source for salting and hashing: https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/

Solution for RSA algorithm, the purpose of this algorithm was to create public and private key.
We have done following in this algorithm: encryption, decryption, salting and hashing.

Solved by: Filip Trojanowski s20088 & Marcin Rozkwitalski s19826

 */

public class RSA {
    public static void main() throws Exception{

        //Accepting text from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text (RSA)");
        String msg = sc.nextLine();

        byte[] salt = getSalt();
        System.out.println("Salt: " + salt);
        String securePassword = getSecurePassword(msg, salt);
        System.out.println("Hashed password: " + securePassword);

        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withRSA");

        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generate the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        System.out.println("Keys generated");
        System.out.println("Private key : \n" + privateKey);
        System.out.println("Public key : \n" + publicKey);

        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        //Add data to the cipher
        byte[] input = msg.getBytes();
        cipher.update(input);

        //encrypting the data
        byte[] cipherText = cipher.doFinal();
        System.out.println( "Encrypted text with public key : \n" + new String(cipherText, "UTF8"));

        //Initializing the same cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        //Decrypting the text
        byte[] decipheredText = cipher.doFinal(cipherText);
        System.out.println("Decrypted text with private key : \n" + new String(decipheredText));

    }

    /**
     * Message that will be hashed
     * @param passwordToHash Message that will be hashed
     * @param salt Random generated salt from getSalt() method
     * @return Returns hashed message
     */
    private static String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * Adds salt
     * @return Returns random salt that we generated
     * @throws NoSuchAlgorithmException It checks if exact algorithm exists
     * @throws NoSuchProviderException It checks if exact provider exists
     */
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

}