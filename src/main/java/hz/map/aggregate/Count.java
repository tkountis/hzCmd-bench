package hz.map.aggregate;

import com.hazelcast.aggregation.Aggregator;
import com.hazelcast.aggregation.Aggregators;
import global.AssertionException;
import hz.map.base.MapBench;

public class Count extends MapBench {

    public long count;

    private Aggregator<Object, Long>  count_aggregator = Aggregators.count();

    public void timeStep() throws AssertionException {
        Long aggregate = (Long) map.aggregate(count_aggregator);
        if(aggregate != count){
            throw new AssertionException(aggregate +"!="+count);
        }
    }

}