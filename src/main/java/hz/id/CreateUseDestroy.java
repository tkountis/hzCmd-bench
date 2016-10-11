package hz.id;

import com.hazelcast.core.IdGenerator;
import hz.id.base.IdGenBench;

/**
 * Created by danny on 12/05/2016.
 */
public class CreateUseDestroy extends IdGenBench {

    public int max=10;

    public void timeStep() {
        IdGenerator id = hzInstance.getIdGenerator(name + random.nextInt(max));
        id.newId();
        id.destroy();
    }
}
