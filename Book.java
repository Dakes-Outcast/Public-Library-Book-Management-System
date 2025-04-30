/**
 * Book class representing a book in the library system.
 * Extends LibraryItem with additional book-specific attributes.
 */
public class Book extends LibraryItem
{
    private String author; // Author of the book
    private String genre; // Genre/category of the book
    
    /**
     * Constructor to create a new Book object.
     * 
     * @param itemID The unique identifier for the book
     * @param title The title of the book
     * @param publisher The publisher of the book
     * @param publicationYear The year the book was published
     * @param author The author of the book
     * @param genre The genre/category of the book
     */
    public Book(int itemID, String title, String publisher, int publicationYear, 
                String author, String genre)
    {
        super(itemID, title, publisher, publicationYear);
        this.author = author;
        this.genre = genre;
        
    }
    
    /**
     * Gets the author of the book.
     * 
     * @return The author's name
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Sets the author of the book.
     * 
     * @param author The author's name to set
     */
    public void setAuthor(String author) {
        this.author = author;
    } 
    
    /**
     * Gets the genre of the book.
     * 
     * @return The book's genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * Sets the genre of the book.
     * 
     * @param genre The genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    /**
     * Overrides the abstract method from LibraryItem.
     * Formats and returns detailed information about the book.
     * 
     * @return Formatted string with all book details
     */
    @Override
    public String getItemDetails()
    {
        return String.format("Book ID: %s\nTitle: %s\nPublisher: %s\nPublication Year: %d\nAuthor: %s\nGenre: %s\n",
                getItemID(), getTitle(), getPublisher(), getPublicationYear(), author, genre);
    }
}
