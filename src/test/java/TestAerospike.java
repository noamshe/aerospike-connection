import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAerospike extends BaseTest {

  @Test
  public void test1() {
    assertTrue(true);
    Key key = new Key("test", "demo", "putgetkey");
    Bin bin1 = new Bin("bin1", "value1");
    Bin bin2 = new Bin("bin2", "value2");
    Bin bin3 = new Bin("bin3", "value-bla");

    // Write a record
    AerospikeClientFactory.getInstance().getClient().put(null, key, bin1, bin2, bin3);

    // Read a record
    Record record = AerospikeClientFactory.getInstance().getClient().get(null, key);

    assertEquals(record.bins.size(), 3);

    AerospikeClientFactory.getInstance().getClient().close();
  }
}
