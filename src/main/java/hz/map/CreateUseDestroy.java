package hz.map;

import hz.map.base.MapBench;


public class CreateUseDestroy extends MapBench {

    public int max=10;

    public void timeStep() {
        map = hzInstance.getMap(name + random.nextInt(max));
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        Object val = mapKeyToValue(k);
        map.put(key, val);
        map.get(key);
        map.destroy();
    }
}
