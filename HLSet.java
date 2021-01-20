import java.util.*;
public class HLSet extends HLObject{
    public HLSet(){
        Set_obj  = new ArrayList<HLObject>();
    }
    ArrayList<HLObject> Set_obj;
    public ArrayList<HLObject> getSet_obj(){
        return Set_obj;
    }
    public int intType()
    {
        return HLType.SET;
    }
    public boolean setcomp(HLObject a, HLObject b){
        HLSet temp1 = (HLSet) a;
        HLSet temp2 = (HLSet) b;
        //System.out.println(a.toString());
        //System.out.println(b.toString());
        if (temp1.getSet_obj().size() != temp2.getSet_obj().size()){
            //System.out.println("here");
            return false;}
        else{
            int res = 0;
            for (int i = 0; i < temp1.getSet_obj().size(); i++) {
                for (int j = 0; j < temp2.getSet_obj().size(); j++) {
                    if (temp1.getSet_obj().get(i).intType()!=HLType.SET && temp1.getSet_obj().get(i).intType() == temp2.getSet_obj().get(j).intType()){
                        if (temp1.getSet_obj().get(i).intType()==HLType.NUM && ((HLNumber) temp1.getSet_obj().get(i)).getValue() == ((HLNumber) temp2.getSet_obj().get(j)).getValue())
                            res++;
                        else if (temp1.getSet_obj().get(i).intType()==HLType.STR && ((HLString) temp1.getSet_obj().get(i)).getValue().equals(((HLString) temp2.getSet_obj().get(j)).getValue()))
                            res++;

                    }
                    else if (temp1.getSet_obj().get(i).intType() == temp2.getSet_obj().get(j).intType()){
//                        System.out.println(res);
//                        System.out.println(temp1.getSet_obj().get(i).toString());
//                        System.out.println(temp2.getSet_obj().get(j).toString());
                        if (setcomp(temp1.getSet_obj().get(i), temp2.getSet_obj().get(j))){
                            res++;
                        }}
                }
            }
            //System.out.println(res);
            if (res == temp1.getSet_obj().size())
                return true;
        }
        return false;
    }

    public HLObject add(HLObject inp){
        for (int i = 0; i < Set_obj.size(); i++) {
            //System.out.println(i);
            if ( inp.intType()!=HLType.SET && inp.intType() == Set_obj.get(i).intType() ){
//                System.out.println(inp.intType());
//                System.out.println(Set_obj.get(i).intType());
                if (inp.intType()==HLType.NUM && ((HLNumber) inp).getValue() == ((HLNumber) Set_obj.get(i)).getValue() ){
                    return null;
                } else if (inp.intType()==HLType.STR && ((HLString) inp).getValue().equals(((HLString) Set_obj.get(i)).getValue()) ){
                    return null;
                }
            } else if(inp.intType() == Set_obj.get(i).intType()){
               // System.out.println("no");
                if (setcomp(inp, Set_obj.get(i)))
                    return null;
            }
        }
        Set_obj.add(inp);
        return this;
    }

    public HLSet union(HLObject inp){
        HLSet temp = (HLSet) inp;
        HLSet res = new HLSet();
        for (int i = 0; i < Set_obj.size(); i++) {
            res.add(Set_obj.get(i));
        }
        for (int i = 0; i < temp.getSet_obj().size(); i++) {
            res.add(temp.getSet_obj().get(i));
        }
        Set_obj = res.getSet_obj();
        return res;
    }

    public HLSet diff(HLObject inp){
        HLSet temp = (HLSet) inp;
        HLSet res = new HLSet();
        for (int i = 0; i < Set_obj.size(); i++) {
            int mark = 0;
            for (int j = 0; j < temp.getSet_obj().size(); j++) {
                if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType() && Set_obj.get(i).intType()==HLType.NUM){
                     if (((HLNumber) temp.getSet_obj().get(j)).getValue()== ((HLNumber) Set_obj.get(i)).getValue()){
                         mark++;
                     }
                }else if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType() && Set_obj.get(i).intType()==HLType.STR){
                        if (((HLString) temp.getSet_obj().get(j)).getValue().equals(((HLString) Set_obj.get(i)).getValue())){
                            mark++;
                        }
                }else if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType()) {
                    if (setcomp(temp.getSet_obj().get(j), Set_obj.get(i))){
                        mark++;
                    }
                }

            }
            if (mark==0)
                res.add(Set_obj.get(i));
        }
        Set_obj = res.getSet_obj();
        return res;
    }

    public HLSet intersec(HLObject inp){
        HLSet temp = (HLSet) inp;
        HLSet res = new HLSet();
        for (int i = 0; i < Set_obj.size(); i++) {
            int mark = 0;
            for (int j = 0; j < temp.getSet_obj().size(); j++) {
                if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType() && Set_obj.get(i).intType()==HLType.NUM){
                    if (((HLNumber) temp.getSet_obj().get(j)).getValue()== ((HLNumber) Set_obj.get(i)).getValue()){
                        mark++;
                    }
                }else if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType() && Set_obj.get(i).intType()==HLType.STR){
                    if (((HLString) temp.getSet_obj().get(j)).getValue().equals(((HLString) Set_obj.get(i)).getValue())){
                        mark++;
                    }
                }else if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType()) {
                    if (setcomp(temp.getSet_obj().get(j), Set_obj.get(i))){
                        mark++;
                    }
                }

            }
            if (mark!=0)
                res.add(Set_obj.get(i));
        }
        Set_obj = res.getSet_obj();
        return res;
    }

    public int numset(HLObject inp){
        HLSet temp = (HLSet) inp;
        HLSet res = new HLSet();
        int mark = 0;
        for (int i = 0; i < Set_obj.size(); i++) {
            for (int j = 0; j < temp.getSet_obj().size(); j++) {
                if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType() && Set_obj.get(i).intType()==HLType.NUM){
                    if (((HLNumber) temp.getSet_obj().get(j)).getValue()== ((HLNumber) Set_obj.get(i)).getValue()){
                        mark++;
                    }
                }else if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType() && Set_obj.get(i).intType()==HLType.STR){
                    if (((HLString) temp.getSet_obj().get(j)).getValue().equals(((HLString) Set_obj.get(i)).getValue())){
                        mark++;
                    }
                }else if (temp.getSet_obj().get(j).intType() == Set_obj.get(i).intType()) {
                    if (setcomp(temp.getSet_obj().get(j), Set_obj.get(i))){
                        mark++;
                    }
                }

            }
        }
        return mark;
    }

    public boolean inset(HLObject inp){
        for (int i = 0; i < Set_obj.size(); i++) {
            if (inp.intType() == Set_obj.get(i).intType() && Set_obj.get(i).intType()==HLType.NUM){
                if (((HLNumber) inp).getValue()== ((HLNumber) Set_obj.get(i)).getValue()){
                    return true;
                }
            }else if (inp.intType() == Set_obj.get(i).intType() && Set_obj.get(i).intType()==HLType.STR){
                if (((HLString) inp).getValue().equals(((HLString) Set_obj.get(i)).getValue())){
                   return true;
                }
            }else if (inp.intType() == Set_obj.get(i).intType()) {
                if (setcomp(inp, Set_obj.get(i))){
                    return true;
                }
            }

        }
        return false;
    }


    public String toString(){
        String res="{";
        if(Set_obj.size()>0){
        for (int i = 0; i < Set_obj.size()-1; i++) {
            res = res.concat((Set_obj.get(i)).toString());
            res = res.concat(", ");
        }
        res = res.concat(Set_obj.get(Set_obj.size()-1).toString());}
        res = res.concat("}");
        return res;
    }

    public int card(){
        return Set_obj.size();
    }

}

