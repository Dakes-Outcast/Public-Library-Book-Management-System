/**
 * Loan class representing a book loan transaction in the library.
 * Contains information about the borrowed book and due date.
 */
public class Loan {
    private Book book;     // The book being loaned
    private String dueDate; // Due date for returning the book
    
    /**
     * Constructor to create a new Loan object.
     * 
     * @param book The Book object being loaned
     * @param dueDate The due date for returning the book (format: YYYY-MM-DD)
     */
    public Loan(Book book, String dueDate) {
        this.book = book;
        this.dueDate = dueDate;
    }

    /**
     * Gets the book associated with this loan.
     * 
     * @return The Book object
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book associated with this loan.
     * 
     * @param book The Book object to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Gets the due date for returning the book.
     * 
     * @return The due date string
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date for returning the book.
     * 
     * @param dueDate The due date to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Returns a string representation of the loan details.
     * 
     * @return Formatted string with loan information
     */
    @Override
    public String toString() {
        return "Loan Details:\n" +
               "Book: " + book.getTitle() + " by " + book.getAuthor() + "\n" +
               "Due Date: " + dueDate + "\n";
    }
}