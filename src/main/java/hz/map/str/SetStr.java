package hz.map.str;

import hz.map.str.base.StrMapBench;

public class SetStr extends StrMapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);

        String key = (String)getKey(k);
        String val = (String)mapKeyToValue(k);
        map.set(key, val);
    }
}