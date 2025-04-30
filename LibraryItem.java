/**
 * Abstract base class for all library items.
 * Provides common attributes and behaviors for different types of library items.
 */
public abstract class LibraryItem{
    private int itemID;           // Unique identifier for the item
    private String title;         // Title of the item
    private int publicationYear;  // Year when the item was published
    private String publisher;     // Publisher of the item

    /**
     * Constructor to create a new LibraryItem.
     * 
     * @param itemID The unique identifier for the item
     * @param title The title of the item
     * @param publisher The publisher of the item
     * @param publicationYear The year when the item was published
     */
    protected LibraryItem(int itemID , String title , String publisher, int publicationYear){
        this.itemID = itemID;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
    }

    /**
     * Gets the item's unique identifier.
     * 
     * @return The item ID
     */
    public int getItemID(){
        return itemID;
    }

    /**
     * Sets the item's unique identifier.
     * 
     * @param itemID The ID to set
     */
    public void setItemID(int itemID){
        this.itemID = itemID;
    }

    /**
     * Gets the title of the item.
     * 
     * @return The item title
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * Sets the title of the item.
     * 
     * @param title The title to set
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Gets the publication year of the item.
     * 
     * @return The publication year
     */
    public int getPublicationYear(){
        return publicationYear;
    }
    
    /**
     * Sets the publication year of the item.
     * 
     * @param publicationYear The publication year to set
     */
    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }

    /**
     * Gets the publisher of the item.
     * 
     * @return The publisher
     */
    public String getPublisher(){
        return publisher;
    }
    
    /**
     * Sets the publisher of the item.
     * 
     * @param publisher The publisher to set
     */
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    /**
     * Abstract method that must be implemented by subclasses.
     * Provides formatted details about the specific library item.
     * 
     * @return A formatted string with item details
     */
    public abstract String getItemDetails();
}