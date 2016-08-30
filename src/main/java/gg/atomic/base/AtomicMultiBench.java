package gg.atomic.base;

import base.BasicBenchBase;
import org.apache.ignite.Ignite;

import java.util.Random;


public abstract class AtomicMultiBench extends BasicBenchBase {

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
}