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
        try
        {
             java.util.ArrayList<LibraryItem> titleresults = utility.titleSearch(searchTerm);
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
            System.out.println(e.getMessage);

        }

    }
    public void findBookbyID(int bookID)
    {
        Book book = (Book) item;
        System.out.println("Book found with ID: ");
        System.out.println(book.getItemDetails());
    }


    public void loanBook(int bookID, String dueDate)
    {
        try
        {
            LibraryItem item = utility.findItemByID(bookID);

            if (!(Item instanceof Book))
            {
                System.out.printin("Book with ID " + bookID + "is not a book");
                return;
            }

            Book book = (Book) item;
            if(book.isLaoned)
            {
                System.out.println("Book wih ID " + bookID +  " is already on loan");
                return;
            }

            Loan loan = new Loan(book, dueDate);
            utility.addLoan(loan);

            System.out.println("Book successfully loaned");
            System.out.println(loan);
        }
        catch(ItemNotFoundException e)
        {
            System.out.println(e.getMessage);
        }
    }

    public void returnBook(int bookID)
    {
        try
        {
            utility.returnBook(bookID);
            System.out.println("Book with ID " + bookID + "has been returned successfully");
        }
        catch (ItemNotFoundException e)
        {
            System.out.println(e.getMessage);
        }
    }

    public void findBookByID(int bookID)
    {
        try
        {
            LibraryItem item = utility.findItemByID(bookID);

            if(!(item instanceof Book))
            {
                System.out.println("Item with ID: " + bookID + "is not a book");
                return;
            }

            Book book = (Book) item;
            System.out.println("Book found :")
            System.out.println(e.getMessage)
        }
        catch (ItemNotFoundException e)
        {
            System.out.println(e.getMessage);
        }
    }
}
