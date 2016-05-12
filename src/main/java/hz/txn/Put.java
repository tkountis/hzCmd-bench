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

package hz.txn;

import base.BenchBase;
import com.hazelcast.core.TransactionalMap;
import com.hazelcast.transaction.TransactionContext;
import com.hazelcast.transaction.TransactionOptions;
import hz.txn.base.TxnBench;

import java.util.Map;

import static com.hazelcast.transaction.TransactionOptions.TransactionType.TWO_PHASE;

/**
 * Hazelcast benchmark that performs transactional put operations.
 */
public class Put extends TxnBench {

    public void timeStep() throws Exception {

        TransactionContext context = hzInstance.newTransactionContext(txnOps);

        context.beginTransaction();

        TransactionalMap map = context.getMap(name);
        try {
            int k = random.nextInt(keyDomain);
            int idx = random.nextInt(valueSetSize);
            byte[] v = valueSet.get(idx);
            map.put(k, v);

            context.commitTransaction();
        }
        catch (Exception e) {
            e.printStackTrace();

            context.rollbackTransaction();
        }
    }

}
