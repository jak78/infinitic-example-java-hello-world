package hello.world;

import hello.world.workflows.HelloWorld;
import io.infinitic.client.Deferred;
import io.infinitic.client.InfiniticClient;
import io.infinitic.factory.InfiniticClientFactory;

public class Client {
    public static void main(String[] args) {
        try(InfiniticClient client = InfiniticClientFactory.fromConfigFile("infinitic.yml")) {
            // create a stub from HelloWorld interface
            HelloWorld helloWorld = client.newWorkflow(HelloWorld.class);

            int i = 0;
            while (i < 100) {
                // asynchronous dispatch of a workflow
                Deferred<String> deferred = client.dispatch(helloWorld::greet, String.valueOf(i));

                System.out.println("workflow " + HelloWorld.class.getName() + " " + deferred.getId() + " dispatched!");

                i++;
            }
        }
    }
}
