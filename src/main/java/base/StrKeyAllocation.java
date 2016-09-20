package base;

import java.util.Random;

import static utils.Utils.generateString;
import static utils.Utils.randInt;

public abstract class StrKeyAllocation extends BasicBenchBase {

    public int seed=0;
    protected Random random;
    protected String[] valueSet;

    public String name;
    public int keyDomain = Integer.MAX_VALUE;
    public int valueSetSize=1;
    public int valueSize=1;
    public int valueMinSize=0;
    public int valueMaxSize=0;

    public void init() throws Exception{
        super.init();

        if(seed==0){
            random = new Random();
        }else{
            random = new Random(seed);
        }

        valueSet = new String[valueSetSize];
        for (int i = 0; i < valueSetSize; i++) {

            if(valueMinSize==0 || valueMaxSize==0){
                valueSet[i] = generateString(random, valueSize);
            }else {
                valueSet[i] = generateString(random, randInt(random, valueMinSize, valueMaxSize));
            }
        }
    }

    public Object getKey(int i){
        return i+"";
    }

    public Object randomKey(){
        return random.nextInt( keyDomain )+"";
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