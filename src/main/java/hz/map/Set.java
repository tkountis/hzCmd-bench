package hz.map;

import hz.map.base.MapBench;

public class Set extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        map.set(k, v);
    }
}