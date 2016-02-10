package gem.cache;

import com.gemstone.gemfire.cache.Region;
import vendor.gem.GemBench;

public class GetBench extends GemBench {

    Region region;
    public String name;
    public int keyDomain = 10000;
    public int valueSize = 10;

    public byte[] value;

    public void setup(){
        value = new byte[valueSize];
        region = gemFireCache.getRegion(name);

        for(int i =0 ;i<keyDomain; i++){
            region.put(i, value);
        }
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        region.get(k);
    }
}