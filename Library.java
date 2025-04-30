/**
 * Library class representing a physical library with a collection of items.
 * Handles operations like adding, removing, displaying and searching for books.
 */
public class Library 
{
    private String name;     // Name of the library
    private String location; // Physical location of the library
    private Utility Utility; // Utility object for managing library operations

    /**
     * Gets the utility object that manages the library's collection.
     * 
     * @return The Utility object
     */
    public Utility getUtility() 
    {
        return Utility;
    }
    
    /**
     * Constructor to create a new Library object.
     * 
     * @param name The name of the library
     * @param location The physical address/location of the library
     */
    public Library(String name, String location) 
    {
        this.name = name;
        this.location = location;
        this.Utility = new Utility();
    }

    /**
     * Gets the name of the library.
     * 
     * @return The library name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Gets the location of the library.
     * 
     * @return The library location
     */
    public String getLocation()
    {
        return location;
    }

    /**
     * Adds a new item to the library collection.
     * 
     * @param item The LibraryItem to add
     */
    public void addItem(LibraryItem item) 
    {
        Utility.addItem(item);
    }

    /**
     * Removes an item from the library collection.
     * 
     * @param item The LibraryItem to remove
     */
    public void removeItem(LibraryItem item) 
    {
        Utility.removeItem(item);
    }

    /**
     * Displays all books available in the library.
     * If no books are available, it shows an appropriate message.
     */
    public void displayAllBooks()
    {
        java.util.ArrayList<Book> books = Utility.getAllBooks();
        if (books.isEmpty()) 
        {
            System.out.println("No books available in the library.");
            return;
        } 
        
        System.out.println("Books available in the library:");
        for (Book book : books) 
        {
            System.out.println(book.getItemDetails());
        }
    }

    /**
     * Searches for books by title.
     * Displays all matching books or an error message if none found.
     * 
     * @param searchTerm The title to search for
     */
    public void searchBooks(String searchTerm)
    {
        try
        {
             java.util.ArrayList<LibraryItem> titleresults = Utility.titleSearch(searchTerm);
             if (titleresults.isEmpty()) 
             {
                throw new ItemNotFoundException("No books found with the title: " + searchTerm);
             }  
             {
                System.out.println("Books found with the title: " + searchTerm);
                for (LibraryItem item : titleresults) 
                {
                    System.out.println(item.getItemDetails());
                }
             }
        }
        catch(ItemNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Finds and displays a book by its ID.
     * 
     * @param bookID The ID of the book to find
     */
    public void findBookByID(int bookID)
    {
       try { 
           LibraryItem item = Utility.findBookByID(bookID);
           if(!(item instanceof Book))
           {
               System.out.println("Item with ID: " + bookID + "is not a book");
               return;
           }
           Book book = (Book) item;
           System.out.println("Book found with ID: ");
           System.out.println(book.getItemDetails());

       } catch (ItemNotFoundException e)
       {
           System.out.println(e.getMessage());
       }
    }

    /**
     * Creates a loan for a book.
     * 
     * @param bookID The ID of the book to loan
     * @param dueDate The due date for returning the book
     */
    public void loanBook(int bookID, String dueDate)
    {
        try
        {
            LibraryItem item = Utility.findBookByID(bookID);

            if (!(item instanceof Book))
            {
                System.out.println("Book with ID " + bookID + "is not a book");
                return;
            }

            Book book = (Book) item;

            Loan loan = new Loan(book, dueDate);
            Utility.addLoan(loan);

            System.out.println("Book successfully loaned");
            System.out.println(loan);
        }
        catch(ItemNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Processes the return of a borrowed book.
     * 
     * @param bookID The ID of the book being returned
     */
    public void returnBook(int bookID)
    {
        try
        {
            Utility.returnBook(bookID);
            System.out.println("Book with ID " + bookID + "has been returned successfully");
        }
        catch (ItemNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

   
}
