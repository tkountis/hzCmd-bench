package hz.repmap;

import hz.repmap.base.RepMapBench;

public class Put extends RepMapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int idx = random.nextInt(valueSetSize);
        byte[] v = valueSet.get(idx);
        map.put(k, v);
    }

}