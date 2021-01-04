package Main;

/*
 
Programming language: Java
Chosen Algorithms: AES, BlowFish, DES

Authors: Filip Trojanowski s20088 and Marcin Rozkwitalski s19826

 */

import EncryptionPackage.AES.Aes;
import EncryptionPackage.Asymetric.DSA;
import EncryptionPackage.Asymetric.RSA;
import EncryptionPackage.BlowFish.BlowFish;
import EncryptionPackage.Des.DesString;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("BSI - Ćwiczenia 07 - Grupa 502c - Algorithms task by s20088 and s19826");
        Main.TaskOptions();
    }

    public static void TaskOptions() {
        boolean status = true;
        Scanner scanner = new Scanner(System.in);
        while (status) {
            try {
                System.out.println("1. AES\n2. BlowFish\n3. DES\n4. RSA\n5. DSA\n6. Exit program");
                System.out.print("Choose your algorithm: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You chose AES algorithm.");
                        Aes.main();
                        break;
                    case 2:
                        System.out.println("You chose BlowFish algorithm.");
                        BlowFish.main();
                        break;

                    case 3:
                        System.out.println("You chose DES algorithm.");
                        DesString.main();
                        break;

                    case 4:
                        System.out.println("You chose RSA algorithm.");
                        RSA.main();
                        break;

                    case 5:
                        System.out.println("");
                        DSA.main();
                        break;

                    case 6:
                        System.out.println("You are leaving the program.\nBye bye!");
                        status = false;
                        break;

                    default:
                        System.out.println("This option doesn't exist.");
                        System.out.println("Please choose new option.");
                        Main.TaskOptions();
                }
            } catch (Exception exception) {
                System.out.println("Bad input");
                scanner.next();
                continue;
            }
        }
    }

}
