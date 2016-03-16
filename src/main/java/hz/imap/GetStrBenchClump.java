package hz.imap;

import com.hazelcast.core.IMap;
import vendor.hz.HzBench;

public class GetStrBenchClump extends HzBench {

    private IMap map;
    public String name;

    public int keyDomain = 10000;
    public int valueSize = 10;

    public byte[] value;

    private int getCount=1;

    public void setup(){
        value = new byte[valueSize];
        map = hzInstance.getMap(name);

        for(int i =0 ;i<keyDomain; i++){
            map.set("" + i, "" + value);
        }
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);

        if(k%2==0){
            getCount=3;
        }else{
            getCount=1;
        }

        for(int i=0; i<getCount; i++){
            map.get(""+k);
        }
    }
}