/*    EvaluationException
/**
 * This exception is thrown when an evaluation error is encountered.
 * or when a return statement is evaluated.
 * This exception should be subclassed for the return statement.
 */
public class EvaluationException extends Exception {


	// Generic constructor
	public EvaluationException() {
		super();
	}
	
	// Generic evaluation error
	public EvaluationException(String msg) {
		super( msg );
	}

	// Undefined operation evaluation error
	public EvaluationException(String operation, String type) {
		super(operation + " is undefined in " + type);
	}

	// Incompatible types evaluation error.
	public EvaluationException(String operation, Object op1, Object op2) {
		super("Incompatible types in "+ op1 + operation + op2);
	}

	public EvaluationException(String kind, String t1, String t2, String t3, String t4, int i) {
		super(kind+" error: Incompatible types for operands,"+t1+" and "+t2+", for operator "+kind+". use the same type " +
				"of HLObjects for the operands. " + t3+" "+kind+" >"+t4+";<");
	}


	public EvaluationException(String kind, String iden, String t1, String t2, String t3) {
		super(kind + ": Incompatible types for identifier "+ iden +", type expected: " + t2+", type found: "+t1+"."+" Either" +
				" redeclare the variable with the new type ("+t1.substring(2,5)+" "+iden+";) or change the assignment."+iden +" = >"+t3+";<");
	}

	public EvaluationException(String iden, String type, int tt){
		super("undefined function: the identifier, "+ iden+" used as a function name is not a function. "+iden+
				" is a "+type+". The function is either not defined or has a different name. >"+iden+"([PARAMS]);<");
	}

	public EvaluationException(String iden, int num1, int num2){
		super("wrong number of input parameters: function, "+ iden+" expects "+String.valueOf(num1)+" input parameters but received "+
				String.valueOf(num2)+" parameters.");
	}

	public EvaluationException(String kind, String iden, String t1, String t2, String t3, int a, int b) {
		super("Wrong type for input parameter: for parameter "+ iden+" in function"+ kind +" expected type is " + t1+", type found: "+t2+"."+" Either" +
				" change the variable's type in the function parameters ("+t2.substring(2,5)+" "+iden+") or change the input."+" >"+t3+"<");
	}

}
