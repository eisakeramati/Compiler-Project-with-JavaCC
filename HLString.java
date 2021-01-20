public class HLString extends HLObject{
    public HLString(String val){
        value = val;
        super.flag_print=0;
    }
    protected String value;
    public int intType()
    {
        return HLType.STR;
    }
    public HLObject add(HLObject operand)
    {
        //HLNumber temp = ((HLNumber) operand).value;
        value = value.concat(operand.toString());
        return this;
    }
    public String toString()
    {   if (flag_print==0){
        return value;}
        else {
            return value+"\n";
    }
    }

    public String getValue(){
        return value;
    }
}
