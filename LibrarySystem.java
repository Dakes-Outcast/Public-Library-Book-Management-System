import java.util.Scanner;
public class LibrarySystem{
    private static Scanner scanner = new Scanner(System.in);
    private static Library library;
    
    public static void main(String[] args) {

        library = new Library("City Central Library", "123 Main Street");
        
        StartingLibrary();
        
    
        System.out.println("========================================");
        System.out.println(" WELCOME TO LIBRARY MANAGEMENT SYSTEM ");
        System.out.println("========================================");
        
        mainMenu();

    }
    
    private static void StartingLibrary() {
        
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        
        Library.addItem(book1);
        Library.addItem(book2);
        Library.addItem(book3);
    }
    
    private static void mainMenu() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Manager Mode");
            System.out.println("2. User Mode");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    managerMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thank you for using the library system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
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
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    Library.displayAllBooks();
                    break;
                case 5:
                    searchBooksByTitle();
                    break;
                case 6:
                    findBookById();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
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
            System.out.println("6. View my loans");
            System.out.println("0. Return to main menu");
            System.out.print("Enter your choice: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    Library.displayAllBooks();
                    break;
                case 2:
                    searchBooksByTitle();
                    break;
                case 3:
                    findBookById();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    Library.displayLoans(true);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void addBook() {
        System.out.println("\n--- ADD NEW BOOK ---");
        
        System.out.print("Enter book ID: ");
        int itemID = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        
        System.out.print("Enter publication year: ");
        int pubYear = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        
        Book newBook = new Book(itemID, title, publisher, pubYear, author, genre);
        library.addItem(newBook);
        
        System.out.println("Book added successfully!");
    }
    
    private static void deleteBook() {
        System.out.println("\n--- DELETE BOOK ---");
        System.out.print("Enter the ID of the book to delete: ");
        int bookID = getIntInput();
        
        try {
            LibraryItem item = findBookByID(bookID);
            Library.removeItem(item);
            System.out.println("Book with ID " + bookID + " has been removed successfully.");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void editBook() {
        System.out.println("\n--- EDIT BOOK ---");
        System.out.print("Enter the ID of the book to edit: ");
        int bookID = scanner.nextInt();
        
        try {
            LibraryItem item = findBookByID(bookID);
            Book book = (Book) item;
            
            scanner.nextLine();
            
            System.out.println("Current book details:");
            System.out.println(book.getItemDetails());
            System.out.println("\nEnter new details (leave blank to keep current value):");
            
            System.out.print("Title [" + book.getTitle() + "]: ");
            String title = scanner.nextLine();
            if (!title.isEmpty()) {
                book.setTitle(title);
            }
            
            System.out.print("Publisher [" + book.getPublisher() + "]: ");
            String publisher = scanner.nextLine();
            if (!publisher.isEmpty()) {
                book.setPublisher(publisher);
            }
            
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
            
            System.out.print("Author [" + book.getAuthor() + "]: ");
            String author = scanner.nextLine();
            if (!author.isEmpty()) {
                book.setAuthor(author);
            }
            
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
    
    private static void searchBooksByTitle() {
        System.out.println("\n--- SEARCH BOOKS BY TITLE ---");
        System.out.print("Enter the title to search for: ");
        scanner.nextLine(); // Clear buffer
        String title = scanner.nextLine();
        
        Library.searchBooks(title);
    }
    
    private static void findBookById() {
        System.out.println("\n--- FIND BOOK BY ID ---");
        System.out.print("Enter book ID: ");
        int bookID = getIntInput();
        
        Library.findBookByID(bookID);
    }
    
    private static void borrowBook() {
        System.out.println("\n--- BORROW A BOOK ---");
        System.out.print("Enter book ID: ");
        int bookID = getIntInput();
        
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        
        Library.loanBook(bookID, dueDate);
    }
    
    private static void returnBook() {
        System.out.println("\n--- RETURN A BOOK ---");
        System.out.print("Enter book ID: ");
        int bookID = getIntInput();
        
        Library.returnBook(bookID);
    }
    
    private static LibraryItem findBookByID(int bookID) throws ItemNotFoundException {
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
    
    /*private static int getIntInput() {
        int input = 0;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                input = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        
        return input;
    }*/
}
