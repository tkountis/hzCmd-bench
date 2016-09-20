package hz.map;

import hz.map.base.MapBench;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PutAllStatic extends MapBench {

    public int mapCount =2;
    public int batchSize=100;
    private List<Map> putAllMaps = new ArrayList<Map>();

    public void init() throws Exception{
        super.init();

        for (int i = 0; i< mapCount; i++){
            Map m = new HashMap();
            for(int batch=0; batch<batchSize; batch++) {

                int k = random.nextInt(keyDomain);
                Object key = getKey(k);
                while(m.containsKey(key)){
                    k = random.nextInt(keyDomain);
                    key = getKey(k);
                }

                Object val = mapKeyToValue(k);
                m.put(key, val);
            }
            putAllMaps.add(m);
        }
    }


    public void timeStep() {
        map.putAll(getMap());
    }

    private Map getMap(){
        return putAllMaps.get(random.nextInt(mapCount));
    }
}