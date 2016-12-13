package hz.map.aggregate;

import com.hazelcast.aggregation.Aggregator;
import com.hazelcast.aggregation.Aggregators;
import global.AssertionException;
import hz.map.base.MapBench;

public class Count extends MapBench {

    public long total;

    private Aggregator<Object, Long> count = Aggregators.count();

    public void timeStep() throws AssertionException {
        Long aggregate = (Long) map.aggregate(count);
        if(aggregate != total){
            throw new AssertionException(aggregate +"!="+total);
        }
    }

}