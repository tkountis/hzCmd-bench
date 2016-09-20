package base;


public abstract class ZeroAllocation extends KeyAllocation {

    protected Integer[] keys;

    public void init() throws Exception{
        super.init();

        keys = new Integer[keyDomain];
        for(int i=0; i<keyDomain; i++){
            keys[i]=new Integer(i);
        }

    }

    public Object getKey(int i){
        return keys[ i ];
    }

    public Object randomKey(){
        return keys[ random.nextInt( keyDomain ) ];
    }

}