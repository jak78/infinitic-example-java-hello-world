package hello.world;

import io.infinitic.pulsar.PulsarInfiniticAdmin;

public class Setup {
    public static void main(String[] args) {
        PulsarInfiniticAdmin infiniticAdmin = PulsarInfiniticAdmin.fromConfigFile("infinitic.yml");

        infiniticAdmin.setupPulsar();
        infiniticAdmin.close();
    }
}
