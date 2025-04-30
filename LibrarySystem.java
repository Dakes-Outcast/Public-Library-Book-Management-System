import java.util.Scanner;

/**
 * Main class for the Library Management System.
 * Provides user interface and menu options for library operations.
 */
public class LibrarySystem{
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input
    private static Library library; // The main library object
    private static final String managerPassword = "RedMoon20"; // Password for manager mode
    private static final int max_login_attempts = "3"; // Maximum login attempts for manager mode    
    /**
     * Main method - entry point of the application.
     * 
     * @param args Command line arguments (not used)
     */

     private static int Intnum()
     {
        int num = 0;
        boolean valid = false;
        while (!valid) {
            try {
                num = scanner.nextInt();
                valid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return num;
     }
    public static void main(String[] args) {
        // Initialize the library with name and location
        library = new Library("City Central Library", "123 Main Street");
        
        // Add sample books to the library
        StartingLibrary();
        
        // Display welcome message
        System.out.println("\t\t\t========================================\t\t\t");
        System.out.println(" \t\t\tWELCOME TO LIBRARY MANAGEMENT SYSTEM\t\t\t");
        System.out.println("\t\t\t========================================\t\t\t");
        
        // Start the main menu
        mainMenu();
    }
    
    /**
     * Creates initial sample books in the library.
     */
    private static void StartingLibrary() {
        // Create sample books
        Book book1 = new Book(231, "Nancy Drew", "K. Paul", 2006, "Carolyn keene", "Crime");
        Book book2 = new Book(232, "A study in Scarlett", "Ward, Lock & Co.", 1887, "Arthur Conan Doyle", "Mystery");
        Book book3 = new Book(233, "Polar Opposites", "Johnson Production Group", 2023, "Aubrey Graham", "soul");
        Book book4 = new Book(234, "A court of thorns and roses" , "Monica Patter", 2024 , "Sam Patterson", "Romance");
        Book book5 = new Book(235, "Hello Kitty" , "Bronze", 2004 , "Ella Carpenter" , "Love");
        Book book6 = new Book(236, "The Conjuring" , "Jeff Bezos" , 2013 , "Elon Musk", "Horror");
        Book book7 = new Book(562, "Secret Service", "Harvey Burns", 1990, "Linkletter Smith", "Crime");
        Book book8 = new Book(432, "Jane Eye", "Willow Pince", 2001, "Bruce Manhaken", "Horror");
        Book book9 = new Book(165, "Illusion", "Pat McCaffe", 2013, "Brooke Williams", "Fiction");
        Book book10 = new Book(700,"The Adventures of Tom Sawyer", "American Publishing Company", 1876, "Mark Twain", "Adventure");
        Book book11 = new Book(351,"The Great Gatsby", "Scribner", 1925, "F. Scott Fitzgerald", "Classic");
        Book book12 = new Book(234,"Things Fall Apart","Heinemann",1958,"Chinua Achebe", "Historical fiction");
        // Add books to the library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);
        library.addItem(book5);
        library.addItem(book6);
        library.addItem(book7);
        library.addItem(book8); 
        library.addItem(book9);
        library.addItem(book10);
        library.addItem(book11);
        library.addItem(book12);
        
    }
    
    /**
     * Displays and handles the main menu options.
     */
    private static void mainMenu() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n\t\t\t===== MAIN MENU =====\t\t\t");
            System.out.println("\t\t\t1. Manager Mode\t\t\t");
            System.out.println("\t\t\t2. User Mode\t\t\t");
            System.out.println("\t\t\t0. Exit\t\t\t");
            System.out.print("\t\t\tEnter your choice:  ");
            
            int choice = Intnum(); // Get user choice
            
            switch (choice) {
                case 1:
                    if (authentication()){managerMenu(); // Enter manager mode if authenticated
                    } else {
                        System.out.println("Invalid password. Access denied.");
                    }
                    break;
                case 2:
                    userMenu(); // Enter user mode
                    break;
                case 0:
                    exit = true; // Exit the application
                    System.out.println("Thank you for using the library system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    // The new authentication method
private static boolean authentication() {
    System.out.println("\n===== MANAGER AUTHENTICATION =====");
    int attempts = 0;
    
    while (attempts < max_login_attempts) {
        System.out.print("Enter manager password (attempt " + (attempts + 1) + 
                         " of " + max_login_attempts + "): ");
        scanner.nextLine(); // Clear input buffer
        String password = scanner.nextLine();
        
        if (password.equals(managerPassword)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Incorrect password.");
            attempts++;
        }
    }
    
    System.out.println("Maximum login attempts exceeded. Access denied.");
    return false;
}

    /**
     * Displays and handles the manager menu options.
     * Provides administrative functions for library management.
     */
    private static void managerMenu() {
        boolean exit = false;
        
        System.out.println("\n===== MANAGER MODE =====");
        System.out.println("Welcome, Library Manager!");
        
        while (!exit) {
            System.out.println("\n===== MANAGER MENU =====");
            System.out.println("1. Add new book");
            System.out.println("2. Delete book");
            System.out.println("3. Edit book");
            System.out.println("4. View all books");
            System.out.println("5. Search books by title");
            System.out.println("6. Find book by ID");
            System.out.println("0. Return to main menu");
            System.out.print("Enter your choice: ");
            
            int choice = Intnum(); // Get user choice
            
            switch (choice) {
                case 1:
                    addBook(); // Add a new book
                    break;
                case 2:
                    deleteBook(); // Delete an existing book
                    break;
                case 3:
                    editBook(); // Edit book details
                    break;
                case 4:
                    library.displayAllBooks(); // Display all books
                    break;
                case 5:
                    searchBooksByTitle(); // Search books by title
                    break;
                case 6:
                    findBookById(); // Find a book by ID
                    break;
                case 0:
                    exit = true; // Return to main menu
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Displays and handles the user menu options.
     * Provides functions for library patrons.
     */
    private static void userMenu() {
        boolean exit = false;
        
        System.out.println("\n===== USER MODE =====");
        System.out.println("Welcome, Library User!");
        
        while (!exit) {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. View all books");
            System.out.println("2. Search books by title");
            System.out.println("3. Find book by ID");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("0. Return to main menu");
            System.out.print("Enter your choice: ");
            
            int choice = Intnum(); // Get user choice
            
            switch (choice) {
                case 1:
                    library.displayAllBooks(); // Display all books
                    break;
                case 2:
                    searchBooksByTitle(); // Search books by title
                    break;
                case 3:
                    findBookById(); // Find a book by ID
                    break;
                case 4:
                    borrowBook(); // Borrow a book
                    break;
                case 5:
                    returnBook(); // Return a borrowed book
                    break;
                case 0:
                    exit = true; // Return to main menu
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Handles adding a new book to the library.
     * Prompts for all required book details.
     */
    private static void addBook() {
        System.out.println("\n--- ADD NEW BOOK ---");
        
        System.out.print("Enter book ID: ");
        int itemID = Intnum();
        
        scanner.nextLine(); // Clear input buffer
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        
        System.out.print("Enter publication year: ");
        int pubYear = Intnum(); // Get publication year
        // Validate publication year
        
        scanner.nextLine(); // Clear input buffer
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        
        // Create and add the new book
        Book newBook = new Book(itemID, title, publisher, pubYear, author, genre);
        library.addItem(newBook);
        
        System.out.println("Book added successfully!");
    }
    
    /**
     * Handles deleting a book from the library.
     * Prompts for the book ID and removes if found.
     */
    private static void deleteBook() {
        System.out.println("\n--- DELETE BOOK ---");
        System.out.print("Enter the ID of the book to delete: ");
        int bookID = Intnum(); // Get book ID
        
        try {
            LibraryItem item = findBook(bookID);
            library.removeItem(item);
            System.out.println("Book with ID " + bookID + " has been removed successfully.");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Handles editing book details.
     * Allows updating title, publisher, publication year, author, and genre.
     */
    private static void editBook() {
        System.out.println("\n--- EDIT BOOK ---");
        System.out.print("Enter the ID of the book to edit: ");
        int bookID = Intnum(); // Get book ID
        
        try {
            LibraryItem item = findBook(bookID);
            Book book = (Book) item;
            
            scanner.nextLine(); // Clear input buffer
            
            // Display current details and prompt for new values
            System.out.println("Current book details:");
            System.out.println(book.getItemDetails());
            System.out.println("\nEnter new details (leave blank to keep current value):");
            
            // Update title if provided
            System.out.print("Title [" + book.getTitle() + "]: ");
            String title = scanner.nextLine();
            if (!title.isEmpty()) {
                book.setTitle(title);
            }
            
            // Update publisher if provided
            System.out.print("Publisher [" + book.getPublisher() + "]: ");
            String publisher = scanner.nextLine();
            if (!publisher.isEmpty()) {
                book.setPublisher(publisher);
            }
            
            // Update publication year if provided
            System.out.print("Publication Year [" + book.getPublicationYear() + "]: ");
            String pubYearStr = scanner.nextLine();
            if (!pubYearStr.isEmpty()) {
                try {
                    int pubYear = Integer.parseInt(pubYearStr);
                    book.setPublicationYear(pubYear);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year format. Publication year not updated.");
                }
            }
            
            // Update author if provided
            System.out.print("Author [" + book.getAuthor() + "]: ");
            String author = scanner.nextLine();
            if (!author.isEmpty()) {
                book.setAuthor(author);
            }
            
            // Update genre if provided
            System.out.print("Genre [" + book.getGenre() + "]: ");
            String genre = scanner.nextLine();
            if (!genre.isEmpty()) {
                book.setGenre(genre);
            }
            
            System.out.println("Book updated successfully!");
            System.out.println("Updated book details:");
            System.out.println(book.getItemDetails());
            
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Handles searching for books by title.
     */
    private static void searchBooksByTitle() {
        System.out.println("\n--- SEARCH BOOKS BY TITLE ---");
        System.out.print("Enter the title to search for: ");
        scanner.nextLine(); // Clear buffer
        String title = scanner.nextLine();
        
        library.searchBooks(title);
    }
    
    /**
     * Handles finding a book by its ID.
     */
    private static void findBookById() {
        System.out.println("\n--- FIND BOOK BY ID ---");
        System.out.print("Enter book ID: ");
        int bookID = Intnum(); // Get book ID
        
        library.findBookByID(bookID);
    }
    
    /**
     * Handles borrowing a book.
     * Prompts for book ID and due date.
     */
    private static void borrowBook() {
        System.out.println("\n--- BORROW A BOOK ---");
        System.out.print("Enter book ID: ");
        int bookID = Intnum(); // Get book ID
        
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        
        library.loanBook(bookID, dueDate);
    }
    
    /**
     * Handles returning a borrowed book.
     */
    private static void returnBook() {
        System.out.println("\n--- RETURN A BOOK ---");
        System.out.print("Enter book ID: ");
        int bookID = scanner.nextInt();
        
        library.returnBook(bookID);
    }
    
    /**
     * Helper method to find a book by ID.
     * 
     * @param bookID The ID of the book to find
     * @return The found LibraryItem
     * @throws ItemNotFoundException If the book is not found
     */
    private static LibraryItem findBook(int bookID) throws ItemNotFoundException {
        try {
            // Access the books through the library's utility
            for (Book book : library.getUtility().getAllBooks()) {
                if (book.getItemID() == bookID) {
                    return book;
                }
            }
            
            throw new ItemNotFoundException("Book with ID " + bookID + " not found");
        } catch (Exception e) {
            throw new ItemNotFoundException("Book with ID " + bookID + " not found");
        }
    }
    
}