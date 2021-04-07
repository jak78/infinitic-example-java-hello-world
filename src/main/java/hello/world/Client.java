package hello.world;

import hello.world.workflows.HelloWorld;
import io.infinitic.pulsar.InfiniticClient;

import java.util.HashSet;
import java.util.Set;

public class Client {
    public static void main(String[] args) {
        InfiniticClient client = InfiniticClient.fromConfigFile("infinitic.yml");
        String name = args.length>0 ? args[0] : "World";

        // create a stub from HelloWorld interface
        HelloWorld helloWorld = client.newWorkflow(HelloWorld.class);

        // asynchronous dispatch of a workflow
        client.async(helloWorld, w -> w.greet("async " + name));

        System.out.println("workflow " + HelloWorld.class.getName() + " dispatched!");

        client.close();
    }
}
