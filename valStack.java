public class valStack {
    public int type;
    public HLObject value;
    public ASTbody body;
    public ASTparam_decls params;


    public valStack(int type, HLObject value){
        this.type = type;
        this.value = value;
    }

    public valStack(int type, ASTbody body, ASTparam_decls params){
        this.type = type;
        this.body = body;
        this.params = params;
    }
}
