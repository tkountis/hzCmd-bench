package hz.map;

import hz.map.base.MapBench;

public class ContainsVal extends MapBench {

    public void timeStep() {
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet[idx];
        map.containsValue(v);
    }
}