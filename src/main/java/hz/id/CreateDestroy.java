package hz.id;

import hz.id.base.IdGenBench;
import hz.lock.base.LockBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends IdGenBench {
    public void timeStep() {
        id = hzInstance.getIdGenerator("" + random.nextInt());
        id.destroy();
    }
}
