package hz.map;


import hz.map.base.MapBench;

public class GetCheck extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object obj = map.get(k);

        if(obj==null){
            throw new IllegalStateException("DATA LOSS! for key "+k);
        }
    }

    public void cleanup() {
        System.out.println("map "+map.getName()+" size="+map.size());
        super.cleanup();
    }
}