package hz.set;

import com.hazelcast.core.ISet;
import hz.set.base.SetBench;

public class FillInt extends SetBench {

    private int k=0;

    public void timeStep() {
        for (ISet set : sets) {
            set.add(k);
        }
        k++;
    }

    public boolean isRunning() {
        return k<keyDomain;
    }
}