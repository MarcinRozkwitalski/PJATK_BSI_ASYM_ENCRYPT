package Main;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import static EncryptionPackage.BlowFish.BlowFish.BlowFishTest;
import static EncryptionPackage.Des.Des.desFileEncryption;
import static EncryptionPackage.Des.Des.encryption;
import static EncryptionPackage.Des.DesString.encryptionOfString;

/*
 Encryption:
 1. AES
 2. DES
 3. Blowfish

 Team: Filip Trojanowski and Marcin Rozkwitalski


*
* */

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // DES na input text
        System.out.println("Input some text (DES):\n");
        String input = scanner.nextLine();
        encryptionOfString(input);

        // Blowfish na input text
        System.out.println("Input some text (Blowfish):\n");
        input = scanner.nextLine();
        BlowFishTest(input);

        // DES na plikach
        System.out.println("\n");
        desFileEncryption();
    }

}
