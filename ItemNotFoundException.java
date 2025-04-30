/**
 * Custom exception class for handling cases when a library item is not found.
 * Extends the standard Exception class.
 */
public class ItemNotFoundException extends Exception
{
   /**
    * Constructor for creating a new ItemNotFoundException.
    * 
    * @param message The error message explaining why the item was not found
    */
   public ItemNotFoundException (String message)
    {
        super(message); 
    }
}