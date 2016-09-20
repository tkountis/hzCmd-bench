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

    private IMap<Integer, Integer> map;

    public void init() throws Exception{
        super.init();
        map = hzInstance.getMap(name);
    }

    public void timeStep() throws AssertionException {

        for(int i=0; i<keyDomain; i++) {
            System.out.println(infoFor(i));
        }

        for(int i=0; i<keyDomain; i++) {
            IAtomicLong expectedIncs = getAtomic(i);
            if( expectedIncs.get() != map.get(getKey(i)) ){
                throw new AssertionException(infoFor(i));
            }
        }
        setRunning(false);
    }

    public IAtomicLong getAtomic(int i){
        return hzInstance.getAtomicLong(name+i);
    }

    public String infoFor(int i){
        IAtomicLong expectedIncs = getAtomic(i);
        return "atomic["+expectedIncs.getName()+"="+expectedIncs.get()+"]"+" != "+"map["+map.getName()+".get("+i+")="+map.get(getKey(i))+"]";
    }
}
