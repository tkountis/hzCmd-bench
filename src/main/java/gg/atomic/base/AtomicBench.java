package gg.atomic.base;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicLong;
import remote.bench.Bench;

import java.util.Random;


public abstract class AtomicBench implements Bench {

    protected Ignite ignite;
    protected IgniteAtomicLong atomic;

    public String name;
    protected Random random = new Random();

    public void setVendorObject(Object vendorObject) { ignite = (Ignite) vendorObject; }

    public void init() {
        atomic = ignite.atomicLong(name, 0, true);
    }

    public void cleanup() {
        System.out.println("atomic "+atomic.name()+" val="+atomic.get());
        atomic.close();
    }

    public boolean isSelfDetermined() {
        return false;
    }

    public boolean isRunning() {
        return false;
    }
}