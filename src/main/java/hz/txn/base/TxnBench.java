package hz.txn.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.transaction.TransactionOptions;

import static com.hazelcast.transaction.TransactionOptions.TransactionType.ONE_PHASE;
import static com.hazelcast.transaction.TransactionOptions.TransactionType.TWO_PHASE;


public abstract class TxnBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected TransactionOptions txnOps;
    public int phase=1;
    public int batchSize=1;


    public void init() throws Exception{
        super.init();

        if(phase==1) {
            txnOps = new TransactionOptions().setTransactionType(ONE_PHASE);
        }else{
            txnOps = new TransactionOptions().setTransactionType(TWO_PHASE);
        }
        System.out.println(txnOps);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }
}