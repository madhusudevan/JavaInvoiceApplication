package InvoiceApplication;

import org.h2.tools.Server;

public class H2Console {
    public static void main(String[] args) {
        try {
            Server server = Server.createWebServer(
                "-web", "-webAllowOthers", 
                "-tcp", "-tcpAllowOthers", 
                "-browser"
            ).start();
            System.out.println("✅ H2 Web Console started at: " + server.getURL());
            System.out.println("🌐 Open this in browser → http://localhost:8082");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
