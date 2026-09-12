package LibraryLendingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;
        while (running) {
            System.out.println("===== Library Lending System =====");
            System.out.println("1. Add Item");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. List Catalog");
            System.out.println("6. Report");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addItemMenu(scanner, library);
                    break;
                case 2:
                    addMemberMenu(scanner, library);
                    break;
                case 3:
                    borrowItemMenu(scanner, library);
                    break;
                case 4:
                    returnItemMenu(scanner, library);
                    break;
                case 5:
                    library.listCatalog();
                    break;
                case 6:
                    library.printReport();
                    break;
                case 7:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
    }

    private static void addItemMenu(Scanner scanner, Library library) {
        System.out.println("Choose type: 1-Book 2-Magazine 3-DVD");
        int type;
        try {
            type = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        try {
            System.out.print("Title: ");
            String title = scanner.nextLine();

            if (type == 1) {
                System.out.print("Author: ");
                String author = scanner.nextLine();
                System.out.print("Pages: ");
                int pages = Integer.parseInt(scanner.nextLine());
                library.addItem(new Book(title, author, pages));
            } else if (type == 2) {
                System.out.print("Issue number: ");
                int issueNumber = Integer.parseInt(scanner.nextLine());
                library.addItem(new Magazine(title, issueNumber));
            } else if (type == 3) {
                System.out.print("Runtime minutes: ");
                int runtime = Integer.parseInt(scanner.nextLine());
                library.addItem(new DVD(title, runtime));
            } else {
                System.out.println("Invalid type.");
                return;
            }
            System.out.println("Item added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        } catch (IllegalArgumentException e) {
            System.out.println("Could not add item: " + e.getMessage());
        }
    }

    private static void addMemberMenu(Scanner scanner, Library library) {
        try {
            System.out.print("Member id: ");
            String memberId = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Max allowed: ");
            int maxAllowed = Integer.parseInt(scanner.nextLine());

            library.addMember(new Member(memberId, name, maxAllowed));
            System.out.println("Member added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
        } catch (IllegalArgumentException e) {
            System.out.println("Could not add member: " + e.getMessage());
        }
    }

    private static void borrowItemMenu(Scanner scanner, Library library) {
        System.out.print("Member id: ");
        String memberId = scanner.nextLine();
        System.out.print("Item id: ");
        String itemId = scanner.nextLine();

        try {
            library.borrowItem(memberId, itemId);
            System.out.println("Borrowed " + itemId + " to " + memberId + ".");
        } catch (LibraryException e) {
            System.out.println("Could not borrow: " + e.getMessage());
        }
    }

    private static void returnItemMenu(Scanner scanner, Library library) {
        System.out.print("Member id: ");
        String memberId = scanner.nextLine();
        System.out.print("Item id: ");
        String itemId = scanner.nextLine();

        try {
            library.returnItem(memberId, itemId);
            System.out.println("Returned " + itemId + " from " + memberId + ".");
        } catch (LibraryException e) {
            System.out.println("Could not return: " + e.getMessage());
        }

    }
}
