package gg.atomic.base;

import org.apache.ignite.Ignite;
import remote.bench.Bench;

import java.util.List;
import java.util.Random;


public abstract class AtomicMultiBench implements Bench {

    public String name;
    public int    atomicCount=100000;
    protected Ignite ignite;
    protected Random random = new Random();

    public void setVendorObject(Object vendorObject) { ignite = (Ignite) vendorObject; }

    public void init() {
        for(int i=0; i<atomicCount; i++){
            ignite.atomicLong(i+name, 0, true);
        }
    }

    public void cleanup() {
        for(int i=0; i<atomicCount; i++){
            ignite.atomicLong(i+name, 0, true).close();
        }
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