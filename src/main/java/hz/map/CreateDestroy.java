package hz.map;

import hz.lock.base.LockBench;
import hz.map.base.MapBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends MapBench {
    public void timeStep() {
        map = hzInstance.getMap("" + random.nextInt());
        map.destroy();
    }

    public void cleanup() { }
}
