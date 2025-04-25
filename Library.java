public class Library 
{
    private String name;
    private String location;
    private Utility Utility;

    public Library(String name, String location) 
    {
        this.name = name;
        this.location = location;
        this.Utility = new Utility();
    }

    public String getName() 
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }

    public void addItem(LibraryItem item) 
    {
        Utility.addItem(item);
    }

    public void removeItem(LibraryItem item) 
    {
        Utility.removeItem(item);
    }

    public void displayAllBooks()
    {
        java.util.ArrayList<Book> books = utility.getAllBooks();
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

    public void searchBooks(String searchTerm)
    {
        java.util.ArrayList<LibraryItem> titleresults = utility.titleSearch(searchTerm);
        if (titleresults.isEmpty()) 
        {
            System.out.println("No books found with the title: " + searchTerm);
            return;
        }  
        {
            System.out.println("Books found with the title: " + searchTerm);
            for (LibraryItem item : titleresults) 
            {
                System.out.println(item.getItemDetails());
            }
        }

    }
    
}