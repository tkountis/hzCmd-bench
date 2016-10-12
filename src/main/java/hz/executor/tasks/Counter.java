package hz.executor.tasks;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * Created by hazelcast on 12/10/16.
 */
public class Counter implements Callable<Integer>, Serializable{

    int count=0;

    public Integer call() throws Exception {
        return ++count;
    }
}
