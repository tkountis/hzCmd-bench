package hz.set;

import com.hazelcast.core.ISet;
import global.AssertionException;
import hz.set.base.SetBench;

public class SizeCheck extends SetBench {

    public int size=0;

    public void timeStep() throws AssertionException{

        for (ISet set : sets) {
            if(set.size()!=size){
                throw new AssertionException("map "+set.getName()+" size "+set.size()+" != expected "+size);
            }
        }
        setRunning(false);
    }

}