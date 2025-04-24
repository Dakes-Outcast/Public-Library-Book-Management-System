public class Book extends LibraryItem
{
    private String author;
    private String genre;
    
    public Book(String itemID, String title, String publisher, int publicationYear, 
                String author, String genre)
    {
        super(itemID, title, publisher, publicationYear);
        this.author = author;
        this.genre = genre;
        
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    } 
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public String getItemDetails()
    {
        return String.format("Book ID: %s\nTitle: %s\nPublisher: %s\nPublication Year: %d\nAuthor: %s\nGenre: %s\n",
                getItemID(), getTitle(), getpublisher(), getpublicationYear(), author, genre);
    }
}