package hz.set;

import hz.set.base.SetBench;

public class AddInt extends SetBench {

    public void timeStep() {
        getRandomSet().add(random.nextInt( keyDomain ));
    }

}