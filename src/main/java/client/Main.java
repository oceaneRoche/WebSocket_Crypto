package client;

import client.configuration.Configuration_json;
import client.configuration.Record_config;
import client.crypto.Crypto;
import client.trade.Trade;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    static Crypto webSocket_client_crypto;
    static Trade webSocket_client_trade;
    public static void main(String[] args) throws URISyntaxException {
        Record_config config = Configuration_json.init();

        webSocket_client_trade = new Trade(new URI(config.trade()));
        webSocket_client_trade.connect();

        webSocket_client_crypto = new Crypto(new URI(config.crypto()));
        webSocket_client_crypto.connect();

        webSocket_client_trade.setInterface_taux(webSocket_client_crypto);
    }
}