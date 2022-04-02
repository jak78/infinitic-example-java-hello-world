package hello.world;

import io.infinitic.dashboard.DashboardServer;

public class Dashboard {
    public static void main(String[] args) {
        // start server on port defined in infinitic.yml
        DashboardServer.fromConfigResource( "/infinitic.yml").start();
    }
}
