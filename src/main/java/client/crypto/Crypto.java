package client.crypto;

import client.WebSocket_client;
import client.interfaces.Interface_taux;
import com.google.gson.Gson;

import java.net.URI;

public class Crypto extends WebSocket_client implements Interface_taux {
    String taux = "1.052";
    public Crypto(URI serverUri) {
        super(serverUri);
    }
    public void decodage(String json){
        Record_crypto response = new Gson().fromJson(json, Record_crypto.class);
        if(response.bitcoin()!=null){
            //System.out.println("bitcoin : " + response.bitcoin());
            System.out.println("bitcoin : " + String.format("%.4f",Double.parseDouble(response.bitcoin())/Double.parseDouble(taux)));
        }
        if(response.ethereum()!=null){
            //System.out.println("ethereum : " + response.ethereum());
            System.out.println("ethereum : " + String.format("%.4f",Double.parseDouble(response.ethereum())/Double.parseDouble(taux)));
        }
    }

    @Override
    public void envoi(String taux) {
        this.taux = taux;
    }
}
