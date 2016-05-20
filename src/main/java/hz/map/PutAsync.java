package hz.map;

import hz.map.base.MapBench;

public class PutAsync extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        map.putAsync(k, v);
    }

}