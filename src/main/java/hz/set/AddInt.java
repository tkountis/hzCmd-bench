package hz.set;

import hz.set.base.SetBench;

public class AddInt extends SetBench {

    public void timeStep() {
        set.add(random.nextInt( keyDomain ));
    }

}