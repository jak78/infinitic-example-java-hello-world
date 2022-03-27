package hello.world;

import hello.world.workflows.HelloWorld;
import io.infinitic.common.clients.InfiniticClient;
import io.infinitic.factory.InfiniticClientFactory;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        try(InfiniticClient client = InfiniticClientFactory.fromConfigFile("infinitic.yml")) {
            // create a stub from HelloWorld interface
            HelloWorld helloWorld = client.newWorkflow(HelloWorld.class);

            int i = 0;
            while (i < 10) {
                // asynchronous dispatch of a workflow
                String strI = String.valueOf(i);
                client.dispatchAsync(helloWorld::greet, strI)
                        .thenApply( (deferred) ->  {
                            System.out.println("Workflow " + HelloWorld.class.getName() + " " + deferred.getId() + " (" + strI + ") dispatched!");

                            return null;
                        })
                        .exceptionally( (error) -> {
                            System.err.println("Failed to dispatch (" + strI + "): "  + error.toString());

                            return null;
                        });
                i++;
            }
        }
    }
}
