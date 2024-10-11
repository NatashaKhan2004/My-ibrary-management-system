import java.util.Scanner;

public class mylibrarysystem {

    
    static int[] bookIds = new int[100];  
    static String[] bookTitles = new String[100];
    static String[] bookAuthors = new String[100];
    static boolean[] isBorrowed = new boolean[100];  
    static int bookCount = 0;  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Initializing choice 
        int choice = 0;

        
        while (choice != 5) {
            
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add New Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Generate Report of Borrowed Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println();

            
            if (choice == 1) {
                addNewBook(sc);
            } else if (choice == 2) {
                borrowBook(sc);
            } else if (choice == 3) {
                returnBook(sc);
            } else if (choice == 4) {
                generateReport();
            } else if (choice == 5) {
                System.out.println("Exiting the system...");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    
    public static void addNewBook(Scanner sc) {
        if (bookCount >= 100) {
            System.out.println("Library is full, cannot add more books.");
            return;
        }

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        
        for (int i = 0; i < bookCount; i++) {
            if (bookIds[i] == id) {
                System.out.println("A book with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        
        bookIds[bookCount] = id;
        bookTitles[bookCount] = title;
        bookAuthors[bookCount] = author;
        isBorrowed[bookCount] = false; 
        bookCount++;

        System.out.println("Book added successfully.");
    }

    
    public static void borrowBook(Scanner sc) {
        System.out.print("Enter Book ID to borrow: ");
        int id = sc.nextInt();
        
        for (int i = 0; i < bookCount; i++) {
            if (bookIds[i] == id) {
                if (!isBorrowed[i]) {
                    isBorrowed[i] = true; 
                    System.out.println("You have successfully borrowed the book: " + bookTitles[i]);
                } else {
                    System.out.println("This book is already borrowed.");
                }
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    
    public static void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        
        for (int i = 0; i < bookCount; i++) {
            if (bookIds[i] == id) {
                if (isBorrowed[i]) {
                    isBorrowed[i] = false;  // Mark as available
                    System.out.println("You have successfully returned the book: " + bookTitles[i]);
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    
    public static void generateReport() {
        System.out.println("List of borrowed books:");
        boolean anyBorrowed = false;
        
        for (int i = 0; i < bookCount; i++) {
            if (isBorrowed[i]) {
                System.out.println("Book ID: " + bookIds[i] + ", Title: " + bookTitles[i] + ", Author: " + bookAuthors[i]);
                anyBorrowed = true;
            }
        }

        if (!anyBorrowed) {
            System.out.println("No books are currently borrowed.");
        }
    }
}
