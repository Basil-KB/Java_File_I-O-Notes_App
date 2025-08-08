package com;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoteManager noteManager = new NoteManager("notes.txt");
        int choice;

        while (true) {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Write a Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Clear Notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
           
            try {
               choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    noteManager.writeNote(scanner);
                    break;
                case 2:
                    noteManager.readNotes();
                    break;
                case 3:
                    noteManager.eraseNotes();
                    break;
                case 4:
                    System.out.println("Exiting Notes App. Goodbye!");
                   return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
