public class Book extends LibraryItem
{
    private String author;
    private String genre;
    private int pageCount;
    public Book(String auther, String genre, int pageCount){
        super(itemID, title, publisher, publicationYear, price);
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
    }
    public String getAuther() {
        return author;
    }
    public void setAuther(String auther) {
        this.author = auther;
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