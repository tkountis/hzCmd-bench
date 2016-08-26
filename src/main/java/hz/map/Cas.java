package hz.map;

import hz.map.base.MapBench;

public class Cas extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        int value;
        do {
            value = (Integer) map.get(k);
        }while (! map.replace(k, value, ++value) );
    }

}