package hz.set;

import com.hazelcast.core.ISet;
import hz.set.base.SetBench;

public class CreateUseDestroy extends SetBench {

    public int max=10;

    public void timeStep() {
        ISet set = hzInstance.getSet(name+random.nextInt(max));
        Object val = mapKeyToValue(random.nextInt( keyDomain ));
        set.add(val);
        set.destroy();
    }
}
