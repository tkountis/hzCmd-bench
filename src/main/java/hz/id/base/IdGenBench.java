package hz.id.base;

import base.BenchBase;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IdGenerator;
import remote.bench.Bench;

import java.util.Random;

public abstract class IdGenBench implements Bench {

    public String name;
    protected HazelcastInstance hzInstance;
    protected IdGenerator id;
    protected Random random = new Random();

    public void init() {
        id = hzInstance.getIdGenerator(name);
    }

    public void cleanup() {
        System.out.println("atomic "+id.getName()+" "+id);
        id.destroy();
    }

    public void setVendorObject(Object o) {
        hzInstance = (HazelcastInstance)o;
    }

    public boolean isSelfDetermined() {
        return false;
    }

    public boolean isRunning() {
        return false;
    }
}