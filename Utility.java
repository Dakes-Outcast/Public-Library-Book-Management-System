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

    public java.util.ArrayList<LibraryItem
}