package rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;


public class ServerStartup {
    public ServerStartup() {
    }

    public void startServer() {
        try {
            URI BASE_URI = new URI("http://localhost:8080/rest");
            ResourceConfig rc = new ResourceConfig().packages( "rest" );
            HttpServer server = JdkHttpServerFactory.createHttpServer(BASE_URI,rc);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
