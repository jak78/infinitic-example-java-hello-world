package hello.world;

import hello.world.workflows.HelloWorld;
import io.infinitic.client.Deferred;
import io.infinitic.client.InfiniticClient;
import io.infinitic.factory.InfiniticClientFactory;

public class Client {
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : "World";

        try(InfiniticClient client = InfiniticClientFactory.fromConfigFile("infinitic.yml")) {
            // create a stub from HelloWorld interface
            HelloWorld helloWorld = client.newWorkflow(HelloWorld.class);

            // asynchronous dispatch of a workflow
            Deferred<String> deferred = client.async(helloWorld, w -> w.greet(name));

            System.out.println("workflow " + HelloWorld.class.getName() + " " + deferred.getId() + " dispatched!");
        }
    }
}
