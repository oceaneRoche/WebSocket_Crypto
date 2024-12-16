package client.trade;

import client.WebSocket_client;
import client.interfaces.Interface_taux;
import com.google.gson.Gson;

import java.net.URI;

public class Trade extends WebSocket_client {
    private Interface_taux interface_taux;
    public Trade(URI serverUri) {
        super(serverUri);
    }
    public void setInterface_taux(Interface_taux interface_taux) {
        this.interface_taux = interface_taux;
    }
    public void decodage(String json){
        Record_trade response = new Gson().fromJson(json, Record_trade.class);
        //System.err.println("taux de change" + response.p());
        System.err.println("""
                --------------------------------------------
                TAUX DE CHANGE EURO -> DOLLAR US: %s
                --------------------------------------------
                """.formatted(response.p()));
    }
}
