// TESTHL CLASS USED TO TEST CPS710 ASSIGNMENT 6
//
class TestHL {

    private static SimpleCharStream instream;
    private static HLTokenManager scanner;
    private static HL parser;
		private static HLEval evaluator;

    public static void main(String args[]) {

		// Figure out input stream from args or stdin
		java.io.InputStream infile;
		if (args.length < 1) {
	 		infile = System.in;
		} 
		else try {  
	  		infile = new java.io.FileInputStream(args[0]);
		} catch (java.io.FileNotFoundException e) {
	   		System.out.println("File " + args[0] + " not found."); 
	   		return;
		} 

		// Create scanner, parser, and evaluator
		instream = new SimpleCharStream(infile);
		scanner = new HLTokenManager(instream);
		parser = new HL(scanner);
		evaluator = new HLEval();   

		// Call parser until EOF reached
		while (nextParse());
    }

    private static boolean nextParse() {
		SimpleNode tree;
    	Object value;

		try {
        
      ParseAbortException.ResetErrors();
			// If static scoping is implemented, also add code to reset scope stack
			
      tree = parser.start();
			if (tree == null)	return true;
			value = tree.jjtAccept(evaluator,null);
			if (value!=null)
				System.out.println(value);

		// Handle EOF and too many syntax errors
		} catch (ParseAbortException e) {
        if (e == ParseAbortException.EOF) 
          return false; // EOF: halt interpreter
	    	System.out.println(e);
                              
    // Handle syntax errors not explicitly handled in parser
    } catch (ParseException e) {
        System.out.println("Syntax error: " + e +" not handled.");
        return true;

    // Add code to handle run-time error exceptions   
    
		// Handle all other exceptions
		} catch (Exception e) {	
			System.out.println(e);
		}
		return true;
	}

}
