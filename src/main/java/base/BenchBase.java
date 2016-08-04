package base;

import remote.bench.Bench;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static remote.main.Utils.instantiate;
import static utils.Utils.dymanicValues;

public abstract class BenchBase implements Bench{

    public int seed=0;
    protected Random random;
    protected List<byte[]> valueSet;

    public String name;
    public int keyDomain = Integer.MAX_VALUE;
    public int valueSetSize=1;
    public int valueSize=0;
    public int valueMinSize=1;
    public int valueMaxSize=1;

    public String ignore=null;
    private List<Class> ignoreClasses = null;

    public void init() throws Exception{

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

        if( ignore!=null){
            ignoreClasses = new ArrayList<Class>();
            for (String s : ignore.split(":")) {
                Class c = instantiate(s, Class.class);
                ignoreClasses.add(c);
            }
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


    public List<Class> ignore(){
        return ignoreClasses;
    }
}