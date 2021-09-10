package hello.world.workflows;

import hello.world.tasks.HelloWorldService;
import io.infinitic.workflows.Workflow;

public class HelloWorldImpl extends Workflow implements HelloWorld {
    private final HelloWorldService helloWorldService = newTask(HelloWorldService.class);

    @Override
    public String greet(String name) {
        String str = helloWorldService.sayHello(name);

        String greeting = helloWorldService.addEnthusiasm(str);

        inline(() -> println(greeting));

        return greeting;
    }

    private String println(String msg) {
        System.out.println(msg);

        return msg;
    }
}
