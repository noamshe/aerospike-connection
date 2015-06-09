import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.listener.WriteListener;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;

import java.util.HashMap;
import java.util.Map;

public class MockAerospikeClient implements IAerospikeClient {

  Map<Key, Bin[]> data = new HashMap();

  @Override
  public void put(WritePolicy policy, WriteListener listener, Key key, Bin... bins) throws AerospikeException {

  }

  @Override
  public void put(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
    data.put(key, bins);
  }

  @Override
  public Record get(Policy policy, Key key) throws AerospikeException {
    /*
    Map<String, Object> bins = new HashMap();
    bins.put("3_7776777", 1);
    bins.put("4_7776777", 1);
    bins.put("5_7776777", 1);
    bins.put("6_7776777", 0);
    List<Map<String, Object>> duplicates = new ArrayList();
    Record record = new Record(bins, 1, -1);
    */

    Map<String, Object> result = new HashMap();
    for (Bin bin : data.get(key)) {
      result.put(bin.name, bin.value);
    }

    return new Record(result, 1, -1);
  }

  @Override
  public void close() {

  }
}
