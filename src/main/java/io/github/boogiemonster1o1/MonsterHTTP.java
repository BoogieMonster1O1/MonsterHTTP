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

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author BoogieMonster1O1
 * This is the main class. The HTTP Server starts from here. This is just an implementation of {@link com.sun.net.httpserver.HttpServer} <br>
 * Nothing too fancy going on
 */
public class MonsterHTTP {
    /**
     * @author BoogieMonster1O1
     * @param args Nothing but a required parameter
     * This main method starts the server in a <code>try..catch</code> block to avoid errors
     */
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
            server.createContext("/", new Handler());
            server.setExecutor(null);
            server.start();
            Logger log = Logger.getAnonymousLogger();
            log.log(Level.INFO, "Started Server on port 80");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
