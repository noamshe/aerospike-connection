import com.aerospike.client.*;
import com.aerospike.client.listener.WriteListener;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;

public class RealAerospikeClient implements IAerospikeClient {

  AerospikeClient client;

  public RealAerospikeClient() {
    client = new AerospikeClient("127.0.0.1", 3000);
  }

  @Override
  public void put(WritePolicy policy, WriteListener listener, Key key, Bin... bins) throws AerospikeException {
  }

  @Override
  public void put(WritePolicy policy, Key key, Bin... bins) throws AerospikeException {
    client.put(policy,key, bins);
  }

  @Override
  public Record get(Policy policy, Key key) throws AerospikeException {
    return client.get(policy, key);
  }

  @Override
  public void close() {
    client.close();
  }
}
