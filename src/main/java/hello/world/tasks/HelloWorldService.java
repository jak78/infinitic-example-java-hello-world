package hello.world.tasks;

import io.infinitic.annotations.Name;

@Name(name = "HelloWorldService")
public interface HelloWorldService {
    String sayHello(String name);

    String addEnthusiasm(String str);
}