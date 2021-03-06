package gr.hua.dit.mgp.aggregators;

import gr.hua.dit.mgp.io.LongToLongMapWritable;
import java.util.Map.Entry;
import org.apache.giraph.aggregators.BasicAggregator;

/**
 *
 * @author peustr
 */
public class LongToLongMapAggregator extends BasicAggregator<LongToLongMapWritable> {

    @Override
    public void aggregate(LongToLongMapWritable value) {
        for (Entry<Long, Long> vertex : value.getData().entrySet()) {
            getAggregatedValue().getData().put(vertex.getKey(), vertex.getValue());
        }
    }

    @Override
    public LongToLongMapWritable createInitialValue() {
        return new LongToLongMapWritable();
    }

}
