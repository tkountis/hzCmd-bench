package base;

import java.util.List;
import java.util.Random;

import static utils.Utils.dymanicValues;

public abstract class BenchBase extends BasicBenchBase {

    public int seed=0;
    protected Random random;
    protected List<byte[]> valueSet;

    public String name;
    public int keyDomain = Integer.MAX_VALUE;
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
        valueSet = dymanicValues(random, valueSetSize, valueMinSize, valueMaxSize);
    }

    public Object mapKeyToValue(int key){
        return valueSet.get( key % valueSetSize );
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