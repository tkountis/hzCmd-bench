package hz.map;


import hz.map.base.MapBench;

public class Get extends MapBench {

    public void init() {
        super.init();

        for(int i =0 ;i<keyDomain; i++){
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            map.put(i, v);
        }
    }

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        map.get(k);
    }
}