package com.games.resources.websocket;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by prakash.vijay on 05/03/17.
 */
@ServerEndpoint(value = "/chat")
public class ChatTestResource {

    @OnOpen
    public void register(final Session session) {
        session.getAsyncRemote().sendText("welcome");
    }

    @OnMessage
    public void myMessage(final Session session, String message) {
        session.getOpenSessions().stream().forEach(session1 -> session1.getAsyncRemote().sendText(message.toUpperCase()));
    }
}
