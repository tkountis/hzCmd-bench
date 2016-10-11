package hz.list;

import com.hazelcast.core.IList;
import hz.list.base.ListBench;

public class CreateUseDestroy extends ListBench {

    public int max=10;

    public void timeStep() {
        IList list = hzInstance.getList(name+random.nextInt(max));
        Object val = mapKeyToValue(random.nextInt( keyDomain ));
        list.add(val);
        list.destroy();
    }
}
