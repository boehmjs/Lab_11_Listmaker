import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class MenuDrivenListManager {

    // Scanner for user input (static so all methods can use the same instance)
    private static Scanner scanner = new Scanner(System.in);
    // ArrayList to store the items
    private static ArrayList<String> itemList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Menu Driven List Manager!");

        // The main program loop
        while (true) {
            displayMenu();
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (quitProgramConfirmation()) {
                        System.out.println("Goodbye!");
                        // Exit the application
                        return;
                    }
                    break;
                default:
                    System.out.println("\n--- Invalid command. Please enter A, D, I, P, or Q. ---\n");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=====================================");
        System.out.println("Command Options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print (display) the list");
        System.out.println("Q - Quit the program");
        System.out.println("=====================================");
        System.out.print("Enter your choice: ");
    }

    private static void addItem() {
        System.out.print("Enter item to add to the end of the list: ");
        String item = scanner.nextLine().trim();
        if (!item.isEmpty()) {
            itemList.add(item);
            System.out.println("Item added successfully.");
        } else {
            System.out.println("Item cannot be empty.");
        }
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printList(); // Show current indices
        System.out.print("Enter the index (0, 1, 2...) of the item to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim());
            if (index >= 0 && index < itemList.size()) {
                String removedItem = itemList.remove(index);
                System.out.println("Removed: " + removedItem);
            } else {
                System.out.println("Error: Index is out of bounds.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer index.");
        }
    }

    private static void insertItem() {
        System.out.print("Enter item to insert: ");
        String item = scanner.nextLine().trim();
        if (item.isEmpty()) {
            System.out.println("Item cannot be empty.");
            return;
        }

        System.out.print("Enter position (index) to insert at: ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim());
            // Check if index is valid for insertion (must be between 0 and current size inclusive)
            if (index >= 0 && index <= itemList.size()) {
                itemList.add(index, item);
                System.out.println("Item inserted at index " + index + " successfully.");
            } else {
                System.out.println("Error: Index is out of bounds for insertion.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer index.");
        }
    }

    private static void printList() {
        System.out.println("\n--- Current List Contents ---");
        if (itemList.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println("[" + i + "] " + itemList.get(i));
            }
        }
        System.out.println("-----------------------------\n");
    }

    private static boolean quitProgramConfirmation() {
        System.out.print("Are you sure you want to quit? (Y/N): ");
        String confirmation = scanner.nextLine().trim().toUpperCase();
        return confirmation.equals("Y");
    }
}