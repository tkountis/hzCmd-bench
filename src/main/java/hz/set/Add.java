package hz.set;

import hz.set.base.SetBench;

public class Add extends SetBench {

    public void timeStep() {
        Object val = mapKeyToValue(random.nextInt( keyDomain ));
        set.add(val);
    }

}