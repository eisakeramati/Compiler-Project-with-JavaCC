/**
 * HLType manages types in HL
 * @author Sophie Quigley
 */
public abstract class HLType
{
  public static int VOID = -1;
  public static int OBJ = HLTreeConstants.JJTOBJTYPE;
  public static int NUM = HLTreeConstants.JJTNUMTYPE;
  public static int STR = HLTreeConstants.JJTSTRTYPE;
  public static int SET = HLTreeConstants.JJTSETTYPE;
 
 // Returns the type of a type declaration 
  public static int intType(SimpleNode typedecl)
    {
    switch(typedecl.getId()) {
    case HLTreeConstants.JJTOBJTYPE:
    case HLTreeConstants.JJTNUMTYPE:
    case HLTreeConstants.JJTSTRTYPE:
    case HLTreeConstants.JJTSETTYPE:
      return typedecl.getId();
    default:
      return VOID;
    }      
    }
}