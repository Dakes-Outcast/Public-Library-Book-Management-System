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
        java.util.ArrayList<Library> results = new java.util.ArrayList<>(items);
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
}