package gg.atomic.base;

import base.BasicBenchBase;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteAtomicLong;

import java.util.List;
import java.util.Random;


public abstract class AtomicBench extends BasicBenchBase {

    protected Ignite ignite;
    protected IgniteAtomicLong atomic;

    public String name;
    protected Random random = new Random();

    public void setVendorObject(Object vendorObject) { ignite = (Ignite) vendorObject; }

    public void init() {
        atomic = ignite.atomicLong(name, 0, true);
    }

    public boolean isSelfDetermined() {
        return false;
    }

    public boolean isRunning() {
        return false;
    }


    public List<Class> ignore(){
        return null;
    }
}