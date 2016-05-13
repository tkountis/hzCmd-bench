package hz.map;

import hz.map.base.MapBench;

public class SetRemove extends MapBench {

    public void timeStep() {
        int k = random.nextInt();
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        map.set(k, v);
        map.remove(k);
    }
}