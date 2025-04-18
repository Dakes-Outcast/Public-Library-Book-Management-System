public class Book extends LibraryItem
{
    private String author;
    private String genre;
    private int pageCount;
    public Book(String itemID, String title, String publisher, int publicationYear, 
                String author, String genre, int pageCount)
    {
        super(itemID, title, publisher, publicationYear);
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
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
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
}