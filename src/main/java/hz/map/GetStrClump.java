package hz.map;

import hz.map.base.MapBench;

public class GetStrClump extends MapBench {

    public int repeatGet=3;
    private int getCount=1;

    public void init() {
        super.init();

        for(int i =0 ;i<keyDomain; i++){
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            map.put(""+i, ""+v);
        }
    }

    public void timeStep() {
        int k = random.nextInt(keyDomain);

        if(k%2==0){
            getCount=repeatGet;
        }else{
            getCount=1;
        }

        for(int i=0; i<getCount; i++){
            map.get(""+k);
        }
    }
}