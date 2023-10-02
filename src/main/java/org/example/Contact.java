package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    static int countCont = 0;
    static ArrayList<ArrayList<String>> ContList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void menu() {
        System.out.print("Options:\n1. Add Contact\n2. List Contacts\n3. Edit Contact\n4. Delete Contact\n5. Quit\nEnter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                AddCont();
                break;
            case 2:
                ListCont();
                break;
            case 3:
                EditCont();
                break;
            case 4:
                DeleteCont();
                break;
            case 5:
                QuitProg();
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    private static void QuitProg() {
        System.out.println("Bye bye");


    }


    private static void AddCont() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNum = scanner.nextLine();

        ArrayList<String> contact = new ArrayList<>();
        contact.add(name);
        contact.add(surname);
        contact.add(phoneNum);

        ContList.add(contact);
        countCont++;

        menu();
    }

    private static void ListCont() {
        if (countCont == 0) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < ContList.size(); i++) {
                ArrayList<String> contact = ContList.get(i);
                System.out.println("Contact " + (i + 1));
                System.out.println("Name: " + contact.get(0));
                System.out.println("Surname: " + contact.get(1));
                System.out.println("Phone number: " + contact.get(2));
                System.out.println();
            }
        }

        menu();
    }

    private static void EditCont() {
        System.out.print("Which contact do you want to edit?(num 1, 2, 3 etc.): ");
        int i = scanner.nextInt();

        ArrayList<String> contact = ContList.get(i - 1);
        System.out.println("Editing contact " + i + ":");
        System.out.print("Enter new name: ");
        contact.set(0, scanner.nextLine());

        System.out.print("Enter new surname: ");
        contact.set(1, scanner.nextLine());

        System.out.print("Enter new phone number: ");
        contact.set(2, scanner.nextLine());

        System.out.println("Contact " + i + " updated successfully.");
        menu();




    }

    private static void DeleteCont() {
        System.out.print("Enter the contact number to delete: ");
        int contactNumber = scanner.nextInt();
        scanner.nextLine();

        ContList.remove(contactNumber - 1);
        countCont--;

        System.out.println("Contact " + contactNumber + " deleted successfully.");
        menu();


    }



}
