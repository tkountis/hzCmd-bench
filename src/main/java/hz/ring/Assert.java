package hz.ring;

import com.hazelcast.core.IAtomicLong;
import com.hazelcast.ringbuffer.Ringbuffer;
import global.AssertionException;
import hz.ring.base.RingBench;

public class Assert extends RingBench {

    public void timeStep() throws AssertionException {

        for (int i = 0; i < rings.length; i++) {
            Ringbuffer ringBuffer = getRingBuffer(i);

            IAtomicLong add = hzInstance.getAtomicLong(ringBuffer.getName()+"-add");
            IAtomicLong read  = hzInstance.getAtomicLong(ringBuffer.getName()+"-read");

            System.out.println(add.getName() + "=" + add.get() + " != " + read.getName() + "=" + read.get());
        }

        for (int i = 0; i < rings.length; i++) {
            Ringbuffer ringBuffer = getRingBuffer(i);
            IAtomicLong add = hzInstance.getAtomicLong(ringBuffer.getName()+"-add");
            IAtomicLong read  = hzInstance.getAtomicLong(ringBuffer.getName()+"-read");

            if(add.get() != read.get()){
                throw new AssertionException(add.getName()+"="+add.get()+" != "+read.getName()+"="+read.get());
            }
        }
        setRunning(false);
    }

}