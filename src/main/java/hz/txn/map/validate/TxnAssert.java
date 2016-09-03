/*
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package hz.txn.map.validate;

import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IMap;
import global.AssertionException;
import hz.txn.base.TxnBench;


public class TxnAssert extends TxnBench {

    private boolean running=true;
    private IMap<Integer, Integer> map;

    public void init() throws Exception{
        super.init();
        map = hzInstance.getMap(name);
    }

    public void timeStep() throws AssertionException {

        for(int i=0; i<keyDomain; i++) {
            IAtomicLong expectedIncs = hzInstance.getAtomicLong(name+i);

            if( expectedIncs.get() != map.get(i) ){
                throw new AssertionException(expectedIncs.getName()+" "+expectedIncs.get()+" != "+map.getName()+".get("+i+") "+map.get(i)+"\n");
            }
        }

        running=false;
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}
