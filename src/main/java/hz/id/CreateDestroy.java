package hz.id;

import com.hazelcast.core.IdGenerator;
import hz.id.base.IdGenBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateDestroy extends IdGenBench {
    public void timeStep() {
        IdGenerator id = hzInstance.getIdGenerator("" + random.nextInt());
        id.destroy();
    }
}
