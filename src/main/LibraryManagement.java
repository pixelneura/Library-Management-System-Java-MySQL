package main;

import java.util.Scanner;
import dao.LibraryDAO;

public class LibraryManagement {
    public static void main(String[] args) throws Exception {
        LibraryDAO dao = new LibraryDAO();
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            System.out.println("\n===== Library Management =====");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. View Books");
            System.out.println("5. View Issued Books");
            System.out.println("6. Exit");
            System.out.println("Enter Choice:");

            switch (sc.nextInt()) {
                case 1: dao.addBook(); break;
                case 2: dao.updateBook(); break;
                case 3: dao.deleteBook(); break;
                case 4: dao.viewBooks(); break;
                case 5: dao.issuedBooks(); break;
                case 6: flag = false; System.out.println("Thank you!"); break;
                default: System.out.println("Invalid Choice!"); break;
            }
        }
    }
}
