import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseTest {

  @Before
  public void setUp() throws Exception {

    MockAerospikeClient mockClient = new MockAerospikeClient();
    AerospikeClientFactory mockAerospikeClientFactory = mock(AerospikeClientFactory.class);
    when(mockAerospikeClientFactory.getClient()).thenReturn(mockClient);
    AerospikeClientFactory.factoryInstance = mockAerospikeClientFactory;
  }
}
