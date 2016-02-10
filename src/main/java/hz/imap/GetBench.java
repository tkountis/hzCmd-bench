package hz.imap;

import com.hazelcast.core.IMap;
import vendor.hz.HzBench;

public class GetBench extends HzBench {

    private IMap map;
    public String name;

    public int keyDomain = 10000;
    public int valueSize = 10;

    public byte[] value;

    public void setup(){
        value = new byte[valueSize];
        map = hzInstance.getMap(name);

        for(int i =0 ;i<keyDomain; i++){
            map.put(i, value);
        }
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        map.get(k);
    }
}