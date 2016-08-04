package hz.map.predicate.base;

import hz.map.base.MapBench;


public abstract class PredicateBase extends MapBench {

    public double minSalary=1.0;
    public double maxSalary=1000.0;
    public double range = 50.0;
    public boolean index=true;
    public boolean ordered=true;

    public void init() throws Exception{
        super.init();
        if(index){
            map.addIndex("salary", ordered);
        }
    }

}