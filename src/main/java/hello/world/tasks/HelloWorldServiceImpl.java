package hello.world.tasks;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello(String name) {

        return "Hello " + ((name == null) ? "World" : name);
    }

    @Override
    public String addEnthusiasm(String str) {

        return str + "!";
    }

    public Float getRetryDelay() {

        return 5F;
    }
}