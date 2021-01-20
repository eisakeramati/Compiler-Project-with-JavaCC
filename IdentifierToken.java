/**
 * Describes IDENTIFER tokens
 Copyright Sophie Quigley, October 2018.
 This file can only be used in CPS710 Assignments in F2018, but not used, distributed or posted in any other way.
 */

public class IdentifierToken extends Token {

  /**
   * The integer value of the token is also stored for INTEGER tokens
   */
  public String value;
  
   /* toString() generates string directly from value instead of image
   * to get rid of leading zeroes.
   */
  public String toString()
  {
  	return value.toString();
  }

  public Object getValue()
  {
	return value;
  }
 
  public IdentifierToken(String image)
  {
    this.kind = HLConstants.IDENTIFIER  ;
    this.image = image;
   	value = image;
  }

}
