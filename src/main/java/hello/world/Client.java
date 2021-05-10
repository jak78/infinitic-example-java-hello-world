package hello.world;

import hello.world.workflows.HelloWorld;
import io.infinitic.client.InfiniticClient;
import io.infinitic.pulsar.PulsarInfiniticClient;

public class Client {
    public static void main(String[] args) {
        InfiniticClient client = PulsarInfiniticClient.fromConfigFile("infinitic.yml");
        String name = args.length>0 ? args[0] : "World";

        // create a stub from HelloWorld interface
        HelloWorld helloWorld = client.newWorkflow(HelloWorld.class);

        // asynchronous dispatch of a workflow
        client.async(helloWorld, w -> w.greet("async " + name));

        System.out.println("workflow " + HelloWorld.class.getName() + " dispatched!");
    }
}
