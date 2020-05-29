package io.github.boogiemonster1o1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonsterHTTP {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(80),0);
            server.createContext("/",new Handler());
            server.setExecutor(null);
            server.start();
            Logger log = Logger.getAnonymousLogger();
            log.log(Level.INFO,"Started Server on port 80");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Handler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) {
            String response = "<html><h1>Response</h1></html>";
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

}
