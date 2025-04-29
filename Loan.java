
       public class Loan {
        private Book book; // Composed Book object
        private String dueDate;
        
    
        // Constructor with Book composition
        public Loan(Book book, String dueDate) {
            this.book = book;
            this.dueDate = dueDate;
            
        }
    
        // Getters and Setters
        public Book getBook() {
            return book;
        }
    
        public void setBook(Book book) {
            this.book = book;
        }
    

    
        public String getDueDate() {
            return dueDate;
        }
    
        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }
    
        
        // Method to display all loaned books
        
    
        @Override
        public String toString() {
            return "Loan Details:\n" +
                   "Book: " + book.getTitle() + " by " + book.getAuthor() + "\n" +
                   "Due Date: " + dueDate + "\n" 
                  
        }
    }
