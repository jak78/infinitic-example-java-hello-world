package hello.world;

import hello.world.workflows.HelloWorld;
import io.infinitic.pulsar.InfiniticClient;
import javax.annotation.Nullable;

public class Client {
    public static void main(String[] args) {
        InfiniticClient client = InfiniticClient.fromFile("infinitic.yml");
        @Nullable String name = args.length>0 ? args[0] : null;
        client.startWorkflowAsync(
                HelloWorld.class,
                w -> w.greet(name)
        ).join();

        client.close();
    }
}
