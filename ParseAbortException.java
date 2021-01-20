/*    ParseAbortException
/**
 * This exception is thrown to abort parsing when too many parse errors have been encountered
 * or when EOF is reached.
 */
public class ParseAbortException extends ParseException {
	
    // MAXERRORS is the maximum number of attempts at error recovery for each statement or expression parsed
    private static final int MAXERRORS = 3;
    
    // error_count counts attempts at error recovery
    private static int error_count = 0;

    // ResetErrors resets error_count to 0 when parsing is restarted
    public static void ResetErrors()
        {
        error_count = 0;
        }

      // AnyErrors returns true iff the parser encountered any errors
    public static boolean AnyErrors() 
        {
        return error_count != 0;
        }
  
    // IncrementErrors increments error counter 
    // and throws a ParseAbortException if too many errors are encountered.
    public static void IncrementErrors() throws ParseAbortException
        {
        error_count++;
        if (error_count == MAXERRORS)
            throw TOOMANYERRORS;
        }
  
  	// Only two instances of this class needs to be created:
  	// They will be used when there are too many syntax errors,
  	// or when EOF is reached
  	public static ParseAbortException TOOMANYERRORS = 
      new ParseAbortException(MAXERRORS + " syntax errors found.  Parsing failed.");
  	public static ParseAbortException EOF = 
      new ParseAbortException("End of File reached");

  	private ParseAbortException(String msg) 
      {
  		super	(	msg );
  	  }

}
