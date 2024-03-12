/**
 * 
 */
package com.learnvertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 12-Mar-2024
 */
public class HelloVerticle extends AbstractVerticle {

	@Override
	public void start(Promise<Void> future) {
		// instantiate the object of the Router class to create router
		Router router = Router.router(vertx);

		// At every path and HTTP method for all incoming requests mount the handler
		router.route().handler(context -> {
			// Find the address of the request by using request(), connection() and
			// remoteAddress() method
			String address = context.request().connection().remoteAddress().toString();

			// Find the "name" query parameter from the queryParams() by using get() method
			MultiMap queryParams = context.queryParams();
			String name = queryParams.contains("name") ? queryParams.get("name") : "unknown";
			// write information in JSON format as a response
			context.json(new JsonObject().put("name", name).put("address", address).put("message",
					"Hello " + name + " connected from " + address));
		});

		// use createHttpServer() method to create Http server
		vertx.createHttpServer()
				// use router to handle each upcoming request
				.requestHandler(router)
				// use listen() method to start listening
				.listen(8888)
				// using actualPort() method of server to print port
				.onSuccess(server -> System.out.println("HTTP server started on port " + server.actualPort()));
	}

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new HelloVerticle());
	}

	@Override
	public void stop() {
		System.out.println("Shutting down application");
	}

}
