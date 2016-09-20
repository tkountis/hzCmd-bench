package base;


public abstract class StrZeroAllocation extends StrKeyAllocation {

    protected String[] keys;

    public void init() throws Exception{
        super.init();

        keys = new String[keyDomain];
        for(int i=0; i<keyDomain; i++){
            keys[i]=i+"";
        }

    }

    public Object getKey(int i){
        return keys[ i ];
    }

    public Object randomKey(){
        return keys[ random.nextInt( keyDomain ) ];
    }

}