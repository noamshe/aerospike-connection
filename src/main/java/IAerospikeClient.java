import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.listener.WriteListener;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;

public interface IAerospikeClient {
  void put(WritePolicy policy, WriteListener listener, Key key, Bin... bins) throws AerospikeException;
  void put(WritePolicy policy , Key key, Bin... bins) throws AerospikeException;
  Record get(Policy policy, Key key) throws AerospikeException;
  void close();
}
