package client.configuration;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Configuration_json {
    public static Record_config init(){
        try{
            Gson gson = new Gson();
            JsonReader reader;
            reader = new JsonReader(new FileReader("./configuration_json.json"));
            return gson.fromJson(reader, Record_config.class);
        }catch (FileNotFoundException e){
            return null;
        }
    }
}
