package hello.world;

import io.infinitic.dashboard.DashboardServer;

public class Dashboard {
    public static void main(String[] args) {
        // get name of config file
        if (args.length>0) {
            String file = args[0];
            // start server
            DashboardServer.fromConfigFile(file).start();
        } else {
            throw new RuntimeException("Please provide a DashboardConfig configuration file");
        }
    }
}
