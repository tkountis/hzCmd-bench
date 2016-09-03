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
import com.hazelcast.core.TransactionalMap;
import com.hazelcast.transaction.TransactionContext;
import com.hazelcast.transaction.TransactionException;
import hz.txn.base.TxnBench;


public class GetForUpdateSet extends TxnBench {

    private int[] incCounts;
    private int[] keyBatch;

    public void init() throws Exception{
        super.init();

        incCounts = new int[keyDomain];
        keyBatch = new int[batchSize];

        IMap<Integer, Integer> map = hzInstance.getMap(name);
        for(int i=0; i<keyDomain; i++) {
            map.put(i, 0);
        }
    }

    public void timeStep() throws Exception {

        TransactionContext context = hzInstance.newTransactionContext(txnOps);
        context.beginTransaction();

        TransactionalMap<Integer, Integer> map = context.getMap(name);
        try {
            for(int i=0; i<batchSize; i++){
                int k = random.nextInt(keyDomain);
                int val = map.getForUpdate(k);
                map.set(k, ++val);
                keyBatch[i]=k;
            }
            context.commitTransaction();
            for(int i=0; i<batchSize; i++){
                incCounts[keyBatch[i]]++;
            }
        } catch (TransactionException commitException) {
            commitException.printStackTrace();
            try {
                context.rollbackTransaction();
            }catch (TransactionException rollBackException){
                rollBackException.printStackTrace();
            }
        }
    }

    public void postPhase() {
        for (int i=0; i<incCounts.length; i++) {
            IAtomicLong keyInc = hzInstance.getAtomicLong(name+i);
            keyInc.addAndGet(incCounts[i]);
        }
    }
}
