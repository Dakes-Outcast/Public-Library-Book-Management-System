public class Utility

{
    private java.util.Arraylist<LibraryItem> items;

    public Utility()
    {
        this.items = new java.util.ArrayList<>();
    }

    public void addItem(LibraryItem item)
    {
        items.add(item);
    }

    public void removeItem(LibraryItem item)
    {
        items.remove(item);
    }      

    public java.util.ArrayList<LibraryItem> titleSearch(String title)
    {
        java.util.ArrayList<LibraryItem> results = new java.util.ArrayList<>();
        for (LibraryItem item : items)
        {
            if (item.getTitle().equalsIgnoreCase(title))
            {
                results.add(item);
            }
        }
        return results;
    } 

    public java.util.ArrayList<LibraryItem> sorter()
    
    {
        java.util.ArrayList<LibraryItem> results = new java.util.ArrayList<>(items);
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

    public LibraryItem searchbyID(int itemID)
    {
        ArrayList<LibraryItem> sortedItems = sorter();

        int left = 0 ;
        int right = sortedItems.size() - 1;
        while(left<=right)
        {
            int mid = left/(right-left)/2;

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
    }

    public void addLoan(loan loan)
    {
        loans.add(loan);
        Book book = loan.getBook();
     }
    public void returnbook(int bookID)
    {
        LibraryItem item = searchbyID(bookID);
        if (item instanceof Book)
        {
            Book book = (Book) item;
            for(Loan loan : loans)
            {
                if(loan.getBook().getItemID() == bookID)
                {
                    System.out.println("Book returned successfully.");
                }
            
            }  

        }
    }   
    public java.util.ArrayList<Book> getAllBooks()
    {
        java.util.ArrayList<Book> books = new java.util.ArrayList<>();
        for (LibraryItem item : items)
        {
            if (item instanceof Book)
            {
                books.add((Book) item);
            }
        }
        return books;
    }
}