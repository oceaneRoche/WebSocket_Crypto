package client;

import client.interfaces.Interface_decodage;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocket_client extends WebSocketClient implements Interface_decodage {
    public WebSocket_client(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("connexion en websocket établie");
    }

    @Override
    public void onMessage(String s) {
        decodage(s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }

    @Override
    public void decodage(String json) {

    }
}
