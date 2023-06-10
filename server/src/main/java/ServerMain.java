import com.sun.net.httpserver.HttpServer;
import flights.Flight;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import rest.ServerStartup;
import soap.ReservationBookingPublisher;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ServerMain {

	public static void main(String[] args) {

		// SOAP
		ReservationBookingPublisher publisher = new ReservationBookingPublisher();
		publisher.publish();

		// REST
		ServerStartup serverStartup = new ServerStartup();
		serverStartup.startServer();
	}

}