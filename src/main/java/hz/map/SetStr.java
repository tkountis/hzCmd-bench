package hz.map;

import hz.map.base.MapBench;

public class SetStr extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        Object v = valueSet.get(idx);
        map.set(""+k, ""+v);
    }
}