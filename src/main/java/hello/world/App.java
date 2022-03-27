package hello.world;

import io.infinitic.factory.InfiniticWorkerFactory;
import io.infinitic.workers.InfiniticWorker;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        try(InfiniticWorker worker = InfiniticWorkerFactory.fromConfigFile("infinitic.yml")) {
            worker.start();
        }
    }
}
