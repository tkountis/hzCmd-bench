package hz.set;

import hz.set.base.SetBench;

public class Get extends SetBench {


    public void timeStep() {
        Object val = mapKeyToValue(random.nextInt( keyDomain ));
        set.add(val);
    }

}