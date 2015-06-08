public class AerospikeClientFactory {

  private IAerospikeClient client;

  public static AerospikeClientFactory factoryInstance = new AerospikeClientFactory();

  public static AerospikeClientFactory getInstance() {
    return factoryInstance;
  }

  public IAerospikeClient getClient() {
    return client;
  }

  public AerospikeClientFactory() {
    // factory decision mock or real
    client = new RealAerospikeClient();
  }
}
