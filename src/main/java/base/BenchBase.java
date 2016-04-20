package base;

import remote.bench.Bench;
import java.util.List;
import java.util.Random;
import static utils.Utils.dymanicValues;

public abstract class BenchBase implements Bench{

    protected Random random = new Random();
    protected List<byte[]> valueSet;

    public String name;
    public int keyDomain = Integer.MAX_VALUE;
    public int valueSetSize=1000;
    public int valueSize=0;
    public int valueMinSize=1;
    public int valueMaxSize=10000;

    public void init() {
        if(valueSize==0){
            valueSet = dymanicValues(1, valueSize, valueSize);
        }else{
            valueSet = dymanicValues(valueSetSize, valueMinSize, valueMaxSize);
        }
    }


    public boolean isSelfDetermined() {
        return false;//will be run with a time limit
    }

    public boolean isRunning() {
        return false;//if isSelfDetermined true,  then should timeStep be called again ?
    }
}