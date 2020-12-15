package Main;

/*

Programming language: Java
Chosen Algorithms: AES, BlowFish, DES

Authors: Filip Trojanowski s20088 and Marcin Rozkwitalski s19826

 */

import EncryptionPackage.AES.Aes;
import EncryptionPackage.BlowFish.BlowFish;
import EncryptionPackage.Des.Des;
import EncryptionPackage.Des.DesString;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("BSI - Ćwiczenia 07 - Grupa 502c - Algorithms task by s20088 and s19826");
        Main.TaskOptions();
    }

    public static void TaskOptions(){
        Aes aes = new Aes();
        BlowFish blowFish = new BlowFish();
        DesString desString = new DesString();

        System.out.println("1. AES\n2. BlowFish\n3. DES\n4. Exit program");
        System.out.print("Choose your algorithm: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You chose AES algorithm.");
                aes.main();
                break;
            case 2:
                System.out.println("You chose BlowFish algorithm.");
                blowFish.main();
                break;

            case 3:
                System.out.println("You chose DES algorithm.");
                desString.main();
                break;

            case 4:
                System.out.println("You are leaving the program.\nBye bye!");
                break;

            default:
                System.out.println("This option doesn't exist.");
                System.out.println("Please choose new option.");
                Main.TaskOptions();
        }
        // DES na input text
//        System.out.println("Input some text (DES):\n");
//        String input = scanner.nextLine();
//        encryptionOfString(input);

        // Blowfish na input text
//        System.out.println("Input some text (Blowfish):\n");
//        input = scanner.nextLine();
//        BlowFishTest(input);

        // DES na plikach
//        System.out.println("\n");
//        desFileEncryption();



    }

}
