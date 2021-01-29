package hello.world.workflows;

import hello.world.tasks.HelloWorldService;
import io.infinitic.workflows.AbstractWorkflow;

public class HelloWorldImpl extends AbstractWorkflow implements HelloWorld {
    private final HelloWorldService helloWorldService = task(HelloWorldService.class);

    @Override
    public String greet(String name) {
        String str = helloWorldService.sayHello(name);
        String greeting =  helloWorldService.addEnthusiasm(str);
        inline(() -> { System.out.println(greeting); return null; });

        return greeting;
    }
}
