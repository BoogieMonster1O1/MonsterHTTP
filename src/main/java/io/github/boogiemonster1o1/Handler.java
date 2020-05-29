/*
 * Copyright 2020 BoogieMonster1O1
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.boogiemonster1o1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author BoogieMonster1O1
 * This class handles the http request by returning an html string.
 */
public class Handler implements HttpHandler {
    /**
     * @param exchange Handles the transfer of data
     * @author BoogieMonster1O1
     * This method is the overriden method from the {@code HttpHandler}<br>
     * A single html string is returned by this method to the user when a request is made to the server<br>
     * Instead of using a hardcoded html string, a file can be read into a list which can then be converted into a string, which can be used as a much better response.
     */
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