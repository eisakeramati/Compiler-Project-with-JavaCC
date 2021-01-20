/**
 * HLObject is a superclass for HLNumber, HLString, and HLSet
 * @author Sophie Quigley
 */
public class HLObject extends Object{
/**
 * Returns type of HLObject to be used in ISA conditions
 * @return Type of HLObject
 */
  protected int flag_print;
  public void setFlag_print(){
    flag_print = 1;
  }
  public int getFlag_print(){
    return flag_print;
  }
  public int intType()
    {
    return HLType.OBJ;
    }
/**
 * Creates String representation of HLObject
 * @return String representation of HLObject
 */
  public String toString()
    {
    return null;
    }
/**
 * Negate HLObject
 * @return -HLObject
 */
  public HLObject negate()
    {
    return null;
    }
/**
 * Add operand to HLObject
 * @param operand
 * @return HLObject + operand
 */
  public HLObject add(HLObject operand)
    {
    return null;
    }
/**
 * Subtract operand from HLObject
 * @param operand
 * @return HLObject - operand
 */
  public HLObject sub(HLObject operand)
    {
    return null;
    }
/**
 * Multiplies HLObject by operand
 * @param operand
 * @return HLObject * operand
 * @param operand
 * @return 
 */
  public HLObject mul(HLObject operand)
    {
    return null;
    }
/**
 * Calculates quotient of HLObject divided by operand 
 * @param operand
 * @return quotient of HLObject / operand
 */
  public HLObject div(HLObject operand)
    {
    return null;
    }
/**
 * Calculates remainder of HLObject divided by operand 
 * @param operand
 * @return remainder of HLObject / operand
 */
  public HLObject mod(HLObject operand)
    {
    return null;
    }

}