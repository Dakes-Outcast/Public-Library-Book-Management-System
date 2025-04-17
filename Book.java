public class Book extends LibraryItem
{
    private String auther;
    private String genre;
    private int pageCount;
    public Book(String auther, String genre, int pageCount){
        super(itemID, title, publisher, yearPublished, price);
        this.auther = auther;
        this.genre = genre;
        this.pageCount = pageCount;
    }
    public String getAuther() {
        return auther;
    }
    public void setAuther(String auther) {
        this.auther = auther;
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