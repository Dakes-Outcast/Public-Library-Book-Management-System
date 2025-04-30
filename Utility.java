import java.util.ArrayList;

/**
 * Utility class that provides helper methods for library operations.
 * Manages collections of library items and loans.
 */
public class Utility
{
    private java.util.ArrayList<LibraryItem> items; // Collection of all library items
    private java.util.ArrayList<Loan> loans; // Collection of all active loans

    /**
     * Constructor to create a new Utility object.
     * Initializes empty collections for items and loans.
     */
    public Utility()
    {
        this.items = new java.util.ArrayList<>();
        this.loans = new java.util.ArrayList<>();
    }

    /**
     * Adds a new item to the library collection.
     * 
     * @param item The LibraryItem to add
     */
    public void addItem(LibraryItem item)
    {
        items.add(item);
    }

    /**
     * Removes an item from the library collection.
     * 
     * @param item The LibraryItem to remove
     */
    public void removeItem(LibraryItem item)
    {
        items.remove(item);
    }      

    /**
     * Searches for items by title.
     * 
     * @param title The title to search for
     * @return ArrayList of items matching the title
     */
    public java.util.ArrayList<LibraryItem> titleSearch(String title)
    {
        ArrayList<LibraryItem> results = new java.util.ArrayList<>();
        for (LibraryItem item : items)
        {
            if (item.getTitle().equalsIgnoreCase(title))
            {
                results.add(item);
            }
        }
        return results;
    } 

    /**
     * Sorts items by ID using Selection Sort algorithm.
     * 
     * @return Sorted ArrayList of library items
     */
    public java.util.ArrayList<LibraryItem> Selectionsorter()
    {
        ArrayList<LibraryItem> results = new java.util.ArrayList<>(items);
        int n = results.size();
        for(int i = 0; i < n-1; i++)
        {
            int minIndex = i;
            for (int j=i+1; j< n; j++)
            {
                if(results.get(j).getItemID()<results.get(minIndex).getItemID())
                {
                    minIndex = j;
                }            
            }
            if (minIndex !=i)
            {
                LibraryItem temp= results.get(i);
                results.set(i,results.get(minIndex));
                results.set(minIndex, temp);
            }
        }
        return results;
    }
    
    /**
     * Sorts books by publication year using Insertion Sort algorithm.
     * 
     * @param books ArrayList of books to sort
     */
    public void InsertionSorter(ArrayList<Book> books)
    {
        for(int i = 1; i < books.size(); i++)
        {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && books.get(j).getPublicationYear() > key.getPublicationYear())
            {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }

    /**
     * Finds a book by its ID using Binary Search algorithm.
     * Requires items to be sorted first.
     * 
     * @param itemID The ID of the book to find
     * @return The found LibraryItem
     * @throws ItemNotFoundException If no book with the given ID is found
     */
    public LibraryItem findBookByID(int itemID) throws ItemNotFoundException
    {
        ArrayList<LibraryItem> sortedItems = Selectionsorter();

        int left = 0;
        int right = sortedItems.size() - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2; // Bug fix: incorrect calculation

            if(sortedItems.get(mid).getItemID() == itemID)
            {
                return sortedItems.get(mid);
            }
            else if (sortedItems.get(mid).getItemID() < itemID)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        throw new ItemNotFoundException("Book with ID " + itemID + " not found");
    }

    /**
     * Adds a new loan to the loans collection.
     * 
     * @param loan The Loan object to add
     */
    public void addLoan(Loan loan)
    {
        loans.add(loan);
        Book book = loan.getBook();
    }
    
    /**
     * Processes the return of a borrowed book.
     * 
     * @param bookID The ID of the book being returned
     * @throws ItemNotFoundException If the book is not found or is not a Book instance
     */
    public void returnBook(int bookID) throws ItemNotFoundException
    {
        LibraryItem item = findBookByID(bookID);
        if (!(item instanceof Book)) // Bug fix: logic error
        {
            throw new ItemNotFoundException("Item with ID: " + bookID + " is not a book");
        }
        
        Book book = (Book) item;

        for(Loan loan : loans)
        {
            if(loan.getBook().getItemID() == bookID)
            {
                System.out.println("Book returned successfully.");
                return; // Bug fix: missing return after successful match
            }
        }
    }  
    
    /**
     * Gets all books in the library and sorts them by publication year.
     * 
     * @return ArrayList of all books
     */
    public java.util.ArrayList<Book> getAllBooks()
    {
        ArrayList<Book> books = new java.util.ArrayList<>();
        for (LibraryItem item : items)
        {
            if (item instanceof Book)
            {
                books.add((Book) item);
            }
        }
        InsertionSorter(books);
        return books;
    }
}