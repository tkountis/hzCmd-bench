package base;

import remote.bench.Bench;
import java.util.List;
import java.util.Random;
import static utils.Utils.dymanicValues;

public abstract class BenchBase implements Bench{


    public int seed=0;
    protected Random random;
    protected List<byte[]> valueSet;

    public String name;
    public int keyDomain = Integer.MAX_VALUE;
    public int valueSetSize=1000;
    public int valueSize=0;
    public int valueMinSize=1;
    public int valueMaxSize=10000;

    public void init() {

        if(seed==0){
            random = new Random();
        }else{
            random = new Random(seed);
        }

        if(valueSize==0){
            valueSet = dymanicValues(random, valueSetSize, valueMinSize, valueMaxSize);
        }else{
            valueSet = dymanicValues(random, 1, valueSize, valueSize);
            valueSetSize=1;
        }
    }

    public Object mapKeyToValue(int key){
        return valueSet.get( key % valueSetSize );
    }

    public boolean isSelfDetermined() {
        return false;
    }

    public boolean isRunning() {
        return false;
    }
}