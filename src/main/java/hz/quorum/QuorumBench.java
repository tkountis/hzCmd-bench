package hz.quorum;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.quorum.Quorum;
import com.hazelcast.quorum.QuorumService;


public abstract class QuorumBench extends BenchBase {

    protected HazelcastInstance hzInstance;
    protected QuorumService quorumService;
    protected Quorum quorum;


    public void init() throws Exception{
        super.init();
        quorumService = hzInstance.getQuorumService();
        quorum = quorumService.getQuorum(name);
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

}