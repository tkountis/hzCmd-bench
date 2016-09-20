package base;

import java.util.Random;

import static utils.Utils.randInt;

public abstract class ZeroAllocation extends BasicBenchBase {

    public int seed=0;
    protected Random random;
    protected static Integer[] keys;
    protected static byte[][] valueSet;

    public String name;
    public int keyDomain = 1000000;
    public int valueSetSize=1;
    public int valueSize=0;
    public int valueMinSize=1;
    public int valueMaxSize=1;

    public void init() throws Exception{
        super.init();

        if(seed==0){
            random = new Random();
        }else{
            random = new Random(seed);
        }

        if(valueSize!=0) {
            valueMinSize=valueSize;
            valueMaxSize=valueSize;
        }

        if(valueSet==null) {
            valueSet = new byte[valueSetSize][];
            for (int i = 0; i < valueSetSize; i++) {
                valueSet[i] = new byte[ randInt(random, valueMinSize, valueMaxSize) ];
            }
        }

        if(keys==null){
            keys = new Integer[keyDomain];
            for(int i=0; i<keyDomain; i++){
                keys[i]=new Integer(i);
            }
        }

    }

    public Object getKey(int i){
        return keys[ i ];
    }

    public Object randomKey(){
        return keys[ random.nextInt() % keyDomain ];
    }

    public Object mapKeyToValue(int key){
        return valueSet[key%valueSetSize];
    }

    @Override
    public String toString() {
        return "BenchBase{" +
                "seed=" + seed +
                ", name='" + name + '\'' +
                ", keyDomain=" + keyDomain +
                ", valueSetSize=" + valueSetSize +
                ", valueSize=" + valueSize +
                ", valueMinSize=" + valueMinSize +
                ", valueMaxSize=" + valueMaxSize +
                '}';
    }
}