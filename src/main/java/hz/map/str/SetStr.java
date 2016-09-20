package hz.map.str;

import hz.map.base.MapBench;

public class SetStr extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);

        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        map.set(""+key, ""+val);
    }
}