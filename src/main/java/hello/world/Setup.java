package hello.world;

import io.infinitic.pulsar.PulsarInfiniticAdmin;
import org.apache.pulsar.client.admin.PulsarAdmin;
import org.apache.pulsar.client.api.PulsarClientException;

public class Setup {
    public static void main(String[] args) throws PulsarClientException {
        PulsarAdmin admin = PulsarAdmin
                .builder()
                .serviceHttpUrl("http://localhost:8080")
                .build();

        PulsarInfiniticAdmin infiniticAdmin = new PulsarInfiniticAdmin(
                admin,
                "infinitic",
                "dev",
                null
        );
        infiniticAdmin.setupPulsar();
        infiniticAdmin.close();
    }
}
