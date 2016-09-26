package hz.set;

import hz.set.base.SetBench;

public class FillInt extends SetBench {

    private int k=0;

    public void timeStep() {
        set.add(k);
        k++;
    }

    public boolean isRunning() {
        return k<keyDomain;
    }
}