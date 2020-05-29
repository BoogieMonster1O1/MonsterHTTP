package io.github.boogiemonster1o1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Handler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) {
        String response = "<html><h1>Response</h1></html>";
        System.out.println(System.getProperty("user.dir"));
        try {
            exchange.sendResponseHeaders(200,response.getBytes().length);
            OutputStream writer = exchange.getResponseBody();
            writer.write(response.getBytes());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}