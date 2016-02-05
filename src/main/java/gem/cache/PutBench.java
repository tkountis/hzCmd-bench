package gem.cache;

import com.gemstone.gemfire.cache.Region;
import gem.GemBench;
import java.util.List;
import static utils.Utils.dymanicValues;

public class PutBench extends GemBench {

    Region region;
    public String name;
    public int keyDomain = Integer.MAX_VALUE;

    public int valueSetSize=1000;
    public int valueMinSize=250;
    public int valueMaxSize=6000;

    public List<byte[]> value;

    public void setup(){
        value = dymanicValues(valueSetSize, valueMinSize, valueMaxSize);

        region = gemFireCache.getRegion(name);
    }

    @Override
    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = value.get(idx);
        region.put(k, v);
    }
}