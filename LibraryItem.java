public abstract class LibraryItem{
    private String itemID;
    private String title;
    private int publicationYear;
    private String publisher;

    public LibraryItem(String itemID , String title , int publicationYear , String publisher){
    this.itemID = itemID;
    this.title = title;
    this.publicationYear = publicationYear;
    this.publisher = publisher;
    }

public String getitemID(){
return itemID;
}

public void setitemID(String itemID){
this.itemID = itemID;
}

public String gettitle(){
    return title;
    }
    
    public void settitle(String title){
    this.title = title;
    }

    public int getpublicationYear(){
        return publicationYear;
        }
        
        public void setpublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
        }

        public String getpublisher(){
            return publisher;
            }
            
            public void setpublisher(String publisher){
            this.publisher = publisher;
            }
}