package hz.map;

import hz.map.base.MapBench;

public class GetStrClump extends MapBench {

    public double repeatProb=0.3;
    public int repeatGet=3;

    public void timeStep() {
        int k = random.nextInt(keyDomain);

        if(random.nextDouble() < repeatProb){
            for(int i=0; i<repeatGet; i++){
                map.get(""+k);
            }
        }else{
            map.get(""+k);
        }
    }
}