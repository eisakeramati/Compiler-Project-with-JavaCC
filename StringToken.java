/**
 * Describes STRING tokens
  Copyright Sophie Quigley, October 2018.
 This file can only be used in CPS710 Assignments in F2018, but not used, distributed or posted in any other way.
 */

public class StringToken extends Token {

  /**
   * The String value of the token is also stored for STRING tokens
   */
  public String value;
  
  public String toString()
  {
  	return value.toString();
  }

  public Object getValue()
  {
	  return value;
  }
 
  public StringToken(String image)
  {
    this.kind = HLConstants.STRING  ;
    this.image = image;
    CalculateValue();
  }
  private void CalculateValue()
  {
	  StringBuffer buffer;
	  int i;

	  /* First remove quotes surrounding the string */
	  value = image.substring(1,image.length()-1);
	  if (value.length() == 0)	return;

	  /* Now convert to a StringBuffer to be able to convert characters */
	  buffer = new StringBuffer(value);

	  /* Now search stringbuffer forward */
	  for (i=buffer.indexOf("\\"); i!=-1 && i<buffer.length(); i=buffer.indexOf("\\",++i) )
	  {
		  switch(buffer.charAt(i+1))
		  {
		  case '\\':
		  case '"':
			  buffer = buffer.deleteCharAt(i);
			  break;
		  case 't':
			  buffer = buffer.replace(i,i+2,"\t");
			  break;
		  case 'n':
			  buffer = buffer.replace(i,i+2,"\n");
			  break;
		  }
	  }

	  value = new String(buffer);
  }

}
