package hello.world;


import io.infinitic.pulsar.PulsarInfiniticWorker;

public class App {
    public static void main(String[] args) {
        PulsarInfiniticWorker.fromConfigFile("infinitic.yml").start();
    }
}
