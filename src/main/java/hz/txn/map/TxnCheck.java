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

package hz.txn.map;

import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IMap;
import global.AssertionException;
import hz.txn.base.TxnBench;


public class TxnCheck extends TxnBench {

    private boolean running=true;
    private IMap<Integer, Integer> map;

    public void init() throws Exception{
        super.init();
        map = hzInstance.getMap(name);
    }

    public void timeStep() throws AssertionException {

        String errorStr = new String();
        for(int i=0; i<keyDomain; i++) {
            IAtomicLong expectedIncs = hzInstance.getAtomicLong(name+i);
            int val = map.get(i);

            if(val != expectedIncs.get()){
                errorStr += expectedIncs.getName()+" "+expectedIncs.get()+" != "+map.getName()+"["+i+"] "+val+"\n";
            }
        }
        if(errorStr.length()!=0){
            throw new AssertionException(errorStr);
        }

        running=false;
    }

    public void cleanup() {

    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}
