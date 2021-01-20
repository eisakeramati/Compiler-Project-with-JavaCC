public class HLNumber extends HLObject{

    public HLNumber(int val){
        value = val;
        super.flag_print =0;
    }
    protected int value;
    public int intType()
    {
        return HLType.NUM;
    }
    public HLObject add(HLNumber operand)
    {
        //HLNumber temp = ((HLNumber) operand).value;
        value = value + operand.getValue();
        return this;
    }
    public String toString()
    {
        if (flag_print==0){
        return String.valueOf(value);}
        else {
            return String.valueOf(value)+"\n";
        }
    }

    public int getValue(){
        return value;
    }
    public void setValue(int a){
        value = a;
    }

    public HLObject sub(HLNumber operand)
    {
        value = value - operand.getValue();
        return this;
    }
    public HLObject mul(HLNumber operand)
    {
        value = value * operand.getValue();
        return this;
    }

    public HLObject div(HLNumber operand)
    {
        value = value / operand.getValue();
        return this;
    }

    public HLObject mod(HLNumber operand)
    {
        value = value % operand.getValue();
        return this;
    }
}
