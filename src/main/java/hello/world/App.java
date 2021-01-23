package hello.world;

import io.infinitic.pulsar.InfiniticWorker;

public class App {
    public static void main(String[] args) {
        InfiniticWorker.fromFile("infinitic.yml").start();
    }
}
